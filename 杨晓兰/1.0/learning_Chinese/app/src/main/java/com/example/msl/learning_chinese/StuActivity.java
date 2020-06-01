package com.example.msl.learning_chinese;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StuActivity extends Activity implements SpeechSynthesizerListener {

    private static final String TAG = "StuActivity";

    private TextView wTxt;
    private TextView pTxt;
    private Button btn_speak;

    private SpeechSynthesizer mSpeechSynthesizer;//百度语音合成客户端
    private String mSampleDirPath;
    private static final String SAMPLE_DIR_NAME = "baiduTTS";
    private static final String SPEECH_FEMALE_MODEL_NAME = "bd_etts_common_speech_f7_mand_eng_high_am-mgc_v3.6.0_20190117.dat";
    private static final String SPEECH_MALE_MODEL_NAME = "bd_etts_common_speech_m15_mand_eng_high_am-mgc_v3.6.0_20190117.dat";
    private static final String TEXT_MODEL_NAME = "bd_etts_common_text_txt_all_mand_eng_middle_big_v3.4.2_20190710.dat";
    private static final String LICENSE_FILE_NAME = "temp_license_2016-04-05";
    private static final String APP_ID = "20133708";//请更换为自己创建的应用
    private static final String API_KEY = "2Z0NUbYAGDkfR1Fs8SRZz5Y5";//请更换为自己创建的应用
    private static final String SECRET_KEY = "92C7Aj8vji69yWPqrtScRFf8DveYe6Yn";//请更换为自己创建的应用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);
        wTxt=findViewById(R.id.words);
        pTxt=findViewById(R.id.pinyin);

        int id=1;//getIntent().getExtras().getInt("id");

        initData(id);
    }

    //调用接口获取数据
    public void initData(int id) {
        String baseUrl = "http://192.168.1.4:8080/daystu-java/words?";
        String url=baseUrl+"id="+id;
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message msg = new Message();
                msg.what = ERROR;
                msg.obj = "网络请求失败";
                mHandler.sendMessage(msg);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String info = response.body().string();//获取服务器返回的json格式数据
                    JSONObject jsonObject = JSON.parseObject(info);//获得一个JsonObject的对象
                    int code = jsonObject.getObject("code", Integer.class);
                    if (200 == code)//如果code等于200，则说明存在该用户，而且服务器还返回了该用户的信息
                    {
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        Message msg=new Message();
                        msg.what=SUCCESS;
                        msg.obj=jsonArray;
                        mHandler.sendMessage(msg);
                    }else{
                        String message = jsonObject.getObject("message", String.class);
                        Message msg = new Message();
                        msg.what = ERROR;
                        msg.obj = message;
                        mHandler.sendMessage(msg);
                    }
                }
            }
        });
    }

    private static int SUCCESS=0x123;
    private static int ERROR=0x124;

    //Handler方式实现子线程和主线程间的通信
    Handler mHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (SUCCESS == msg.what) {
                JSONArray jsonArray = (JSONArray) msg.obj;
                     JSONObject obj = jsonArray.getJSONObject(0);
                    Words w = new Words();
                    w.setId(obj.getInteger("id"));
                    w.setWords(obj.getString("words"));
                    w.setRadiopath(obj.getString("radiopath"));
                    setdis(w);
            } else if (ERROR==msg.what)
            {
                String info= (String) msg.obj;
                Toast.makeText(StuActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void setdis(Words w){
        wTxt.setText(w.getWords());
        String pinyin=new Cn2Spell().getSelling(w.getWords());
        pTxt.setText(pinyin);

        initialEnv();
        initialTts();
        initView();
    }

    @Override
    protected void onDestroy() {
        this.mSpeechSynthesizer.release();//释放资源
        super.onDestroy();
    }

    private void initView() {
        btn_speak = (Button) findViewById(R.id.btn);
        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpeechSynthesizer.speak(pTxt.getText().toString());
            }
        });
    }

    /**
     * 初始化语音合成客户端并启动
     */
    private void initialTts() {
        //获取语音合成对象实例
        this.mSpeechSynthesizer = SpeechSynthesizer.getInstance();
        //设置Context
        this.mSpeechSynthesizer.setContext(this);
        //设置语音合成状态监听
        this.mSpeechSynthesizer.setSpeechSynthesizerListener(this);
        //文本模型文件路径 (离线引擎使用)
        this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, mSampleDirPath + "/"
                + TEXT_MODEL_NAME);
        //声学模型文件路径 (离线引擎使用)
        this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, mSampleDirPath + "/"
                + SPEECH_FEMALE_MODEL_NAME);
        //本地授权文件路径,如未设置将使用默认路径.设置临时授权文件路径，LICENCE_FILE_NAME请替换成临时授权文件的实际路径，
        //仅在使用临时license文件时需要进行设置，如果在[应用管理]中开通了离线授权，
        //不需要设置该参数，建议将该行代码删除（离线引擎）
//        this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE, mSampleDirPath + "/"
//                + LICENSE_FILE_NAME);
        //请替换为语音开发者平台上注册应用得到的App ID (离线授权)
        this.mSpeechSynthesizer.setAppId(APP_ID);
        // 请替换为语音开发者平台注册应用得到的apikey和secretkey (在线授权)
        this.mSpeechSynthesizer.setApiKey(API_KEY, SECRET_KEY);
        //发音人（在线引擎），可用参数为0,1,2,3。。。
        //（服务器端会动态增加，各值含义参考文档，以文档说明为准。0--普通女声，1--普通男声，2--特别男声，3--情感男声。。。）
        this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
        // 设置Mix模式的合成策略
        this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_DEFAULT);

// 引擎初始化tts接口
//        mSpeechSynthesizer.initTts(TtsMode.MIX);
    }
    @Override
    public void onSynthesizeStart(String s) {
        //监听到合成开始
        Log.i(TAG, ">>>onSynthesizeStart()<<< s: " + s);
    }

    @Override
    public void onSynthesizeDataArrived(String s, byte[] bytes, int i,int j) {
        //监听到有合成数据到达
        Log.i(TAG, ">>>onSynthesizeDataArrived()<<< s: " + s);
    }

    @Override
    public void onSynthesizeFinish(String s) {
        //监听到合成结束
        Log.i(TAG, ">>>onSynthesizeFinish()<<< s: " + s);
    }

    @Override
    public void onSpeechStart(String s) {
        //监听到合成并开始播放
        Log.i(TAG, ">>>onSpeechStart()<<< s: " + s);
    }

    @Override
    public void onSpeechProgressChanged(String s, int i) {
        //监听到播放进度有变化
        Log.i(TAG, ">>>onSpeechProgressChanged()<<< s: " + s);
    }

    @Override
    public void onSpeechFinish(String s) {
        //监听到播放结束
        Log.i(TAG, ">>>onSpeechFinish()<<< s: " + s);
    }

    @Override
    public void onError(String s, SpeechError speechError) {
        //监听到出错
        Log.i(TAG, ">>>onError()<<< description: " + speechError.description + ", code: " + speechError.code);
    }

    private void initialEnv() {
        if (mSampleDirPath == null) {
            String sdcardPath = Environment.getExternalStorageDirectory().toString();
            mSampleDirPath = sdcardPath + "/" + SAMPLE_DIR_NAME;
        }
        File file = new File(mSampleDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        copyFromAssetsToSdcard(false, SPEECH_FEMALE_MODEL_NAME, mSampleDirPath + "/" + SPEECH_FEMALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, SPEECH_MALE_MODEL_NAME, mSampleDirPath + "/" + SPEECH_MALE_MODEL_NAME);
        copyFromAssetsToSdcard(false, TEXT_MODEL_NAME, mSampleDirPath + "/" + TEXT_MODEL_NAME);
        copyFromAssetsToSdcard(false, LICENSE_FILE_NAME, mSampleDirPath + "/" + LICENSE_FILE_NAME);
    }

    /**
     * 将工程需要的资源文件拷贝到SD卡中使用（授权文件为临时授权文件，请注册正式授权）
     *
     * @param isCover 是否覆盖已存在的目标文件
     * @param source
     * @param dest
     */
    public void copyFromAssetsToSdcard(boolean isCover, String source, String dest) {
        File file = new File(dest);
        if (isCover || (!isCover && !file.exists())) {
            InputStream is = null;
            FileOutputStream fos = null;
            try {
                is = getResources().getAssets().open(source);
                String path = dest;
                fos = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = is.read(buffer, 0, 1024)) >= 0) {
                    fos.write(buffer, 0, size);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
