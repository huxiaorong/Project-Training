package com.example.msl.learning_chinese;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.client.TtsMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.msl.learning_chinese.MainHandlerConstant.INIT_SUCCESS;
import static com.example.msl.learning_chinese.MainHandlerConstant.PRINT;

public class TingyinxuanziActivity extends AppCompatActivity {

    private ImageView ivReturn;
    private ImageView ivSound;
    private RadioGroup radioGroup;
    private int passed;//学过的数量
    private int button;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private List<Question> qlist = new ArrayList<>();
    private OkHttpClient okHttpClient = new OkHttpClient();
    private String rsp;
    SoundPool sp;
    HashMap<Integer, Integer> hm;//声明HashMap来存放声音文件
    protected Handler mainHandler;


    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Type type = new TypeToken<List<Question>>(){}.getType();
                    qlist = new Gson().fromJson(rsp,type);
                    speak(qlist.get(0).getWord().toString());
                    rb1.setText(qlist.get(0).getAnswer1());
                    rb2.setText(qlist.get(0).getAnswer2());
                    rb3.setText(qlist.get(0).getAnswer3());
                    rb4.setText(qlist.get(0).getAnswer4());
                    passed=0;
                    break;
                case 2:
                    rb1.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 3:
                    rb2.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 4:
                    rb3.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 5:
                    rb4.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
            }
        }
    };

    protected String appId;

    protected String appKey;

    protected String secretKey;

    protected String sn; // 纯离线合成SDK授权码；离在线合成SDK免费，没有此参数

    // TtsMode.MIX; 离在线融合，在线优先； TtsMode.ONLINE 纯在线； TtsMode.OFFLINE 纯离线合成，需要纯离线SDK
    protected TtsMode ttsMode = TtsMode.ONLINE;

    protected boolean isOnlineSDK = TtsMode.ONLINE.equals(IOfflineResourceConst.DEFAULT_SDK_TTS_MODE);

    // 主控制类，所有合成控制方法从这个类开始
    protected NonBlockSyntherizer synthesizer;

    protected int descTextId = R.raw.sync_activity_description;

    private static final String TAG = "SynthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tingyinxuanzi);

        mainHandler = new Handler() {
            /*
             * @param msg
             */
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                handle(msg);
            }

        };

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        appId = Auth.getInstance(this).getAppId();
        appKey = Auth.getInstance(this).getAppKey();
        secretKey = Auth.getInstance(this).getSecretKey();
        sn = Auth.getInstance(this).getSn(); // 离线合成SDK必须有此参数；在线合成SDK免费，没有此参数
        initialTts(); // 初始化TTS引擎
        if (!isOnlineSDK) {
            Log.i("SynthActivity", "so version:" + SynthesizerTool.getEngineInfo());
        }

        initViews();
        initSoundPool();
        reviewed();

        //点击返回复习页面
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synthesizer.release();
                Constant.USER_STATUS.setTodayCount(passed);
                Intent i = new Intent();
                i.setClass(TingyinxuanziActivity.this,MainActivity.class);
                i.putExtra("id",1);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd_answer1:
                        if (qlist.get(passed).getAnswer() == 1){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(2,1);
                        }else{
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(2,2);
                        }
                        break;
                    case R.id.rd_answer2:
                        if (qlist.get(passed).getAnswer() == 2){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb2.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(3,1);
                        }else{
                            rb2.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(3,2);
                        }

                        break;
                    case R.id.rd_answer3:
                        if (qlist.get(passed).getAnswer() == 3){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb3.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(4,1);
                        }else{
                            rb3.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(4,2);
                        }
                        break;
                    case R.id.rd_answer4:
                        if (qlist.get(passed).getAnswer() == 4){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(5,1);
                        }else{
                            rb4.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(5,2);
                        }
                        break;

               }

            }
        });

    }

    public void initViews(){
        ivReturn = findViewById(R.id.iv_review_return);
        ivSound = findViewById(R.id.iv_playsound);
        radioGroup = findViewById(R.id.rg_tingyinxuanzi);
        rb1 = findViewById(R.id.rd_answer1);
        rb2 = findViewById(R.id.rd_answer2);
        rb3 = findViewById(R.id.rd_answer3);
        rb4 = findViewById(R.id.rd_answer4);
    }

    public void reviewed(){
        Request requestBlog = new Request.Builder()
                .url(Constant.BASE_URL + "tingyinshizi?userId="+Constant.USER_STATUS.getId())
                .build();
        try {
            Response response = okHttpClient.newCall(requestBlog).execute();
            rsp = response.body().string();
            Log.e("rrr", rsp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Message msg = new Message();
        msg.what = 1;
        mainHandle.sendMessage(msg);
    }

    public void setButton(int what,int tf){
        Message msg = new Message();
        msg.what = what;
        msg.arg1 = tf;
        mainHandle.sendMessageDelayed(msg,500);
    }

    private void initSoundPool() {//初始化声音池
        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);//创建SoundPool对象
        hm = new HashMap<Integer, Integer>();//创建HashMap对象
        //加载声音文件，并且设置为1号声音放入hm中
        hm.put(1, sp.load(this, R.raw.wronganswer, 1));
        hm.put(2,sp.load(this, R.raw.trueanswer,1));
    }

    private void nextQuestion(){
        if (passed == qlist.size()){
            synthesizer.release();
            sendCount();
            ReviewDialog reviewDialog = new ReviewDialog();
            reviewDialog.setCancelable(false);
            reviewDialog.show(getSupportFragmentManager(),"endTag");
        }else{
            speak(qlist.get(passed).getWord().toString());
            rb1.setText(qlist.get(passed).getAnswer1());
            rb2.setText(qlist.get(passed).getAnswer2());
            rb3.setText(qlist.get(passed).getAnswer3());
            rb4.setText(qlist.get(passed).getAnswer4());
        }
    }


    /**
     * 初始化引擎，需要的参数均在InitConfig类里
     * <p>
     * DEMO中提供了3个SpeechSynthesizerListener的实现
     * MessageListener 仅仅用log.i记录日志，在logcat中可以看见
     * UiMessageListener 在MessageListener的基础上，对handler发送消息，实现UI的文字更新
     * FileSaveListener 在UiMessageListener的基础上，使用 onSynthesizeDataArrived回调，获取音频流
     */
    protected void initialTts() {
        LoggerProxy.printable(true); // 日志打印在logcat中
        // 设置初始化参数
        // 此处可以改为 含有您业务逻辑的SpeechSynthesizerListener的实现类
        SpeechSynthesizerListener listener = new MessageListener();
        InitConfig config = getInitConfig(listener);
        synthesizer = new NonBlockSyntherizer(this, config, mainHandler); // 此处可以改为MySyntherizer 了解调用过程
    }

    /**
     * 合成的参数，可以初始化时填写，也可以在合成前设置。
     *
     * @return 合成参数Map
     */
    protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        // 以下参数均为选填
        // 设置在线发声音人： 0 普通女声（默认） 1 普通男声 3 情感男声<度逍遥> 4 情感儿童声<度丫丫>, 其它发音人见文档
        params.put(SpeechSynthesizer.PARAM_SPEAKER, "0");
        // 设置合成的音量，0-15 ，默认 5
        params.put(SpeechSynthesizer.PARAM_VOLUME, "15");
        // 设置合成的语速，0-15 ，默认 5
        params.put(SpeechSynthesizer.PARAM_SPEED, "5");
        // 设置合成的语调，0-15 ，默认 5
        params.put(SpeechSynthesizer.PARAM_PITCH, "5");

        return params;
    }

    protected InitConfig getInitConfig(SpeechSynthesizerListener listener) {
        Map<String, String> params = getParams();
        // 添加你自己的参数
        InitConfig initConfig;
        // appId appKey secretKey 网站上您申请的应用获取。注意使用离线合成功能的话，需要应用中填写您app的包名。包名在build.gradle中获取。
        if (sn == null) {
            initConfig = new InitConfig(appId, appKey, secretKey, ttsMode, params, listener);
        } else {
            initConfig = new InitConfig(appId, appKey, secretKey, sn, ttsMode, params, listener);
        }
        // 如果您集成中出错，请将下面一段代码放在和demo中相同的位置，并复制InitConfig 和 AutoCheck到您的项目中
        // 上线时请删除AutoCheck的调用
//        AutoCheck.getInstance(getApplicationContext()).check(initConfig, new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                if (msg.what == 100) {
//                    AutoCheck autoCheck = (AutoCheck) msg.obj;
//                    synchronized (autoCheck) {
//                        String message = autoCheck.obtainDebugMessage();
//                        toPrint(message); // 可以用下面一行替代，在logcat中查看代码
//                        // Log.w("AutoCheckMessage", message);
//                    }
//                }
//            }
//
//        });
        return initConfig;
    }

    /**
     * speak 实际上是调用 synthesize后，获取音频流，然后播放。
     * 获取音频流的方式见SaveFileActivity及FileSaveListener
     * 需要合成的文本text的长度不能超过1024个GBK字节。
     */
    private void speak(String text) {
        //String text = "语音";
        // 需要合成的文本text的长度不能超过1024个GBK字节。
        if (TextUtils.isEmpty(text)) {
            text = "百度语音，面向广大开发者永久免费开放语音合成技术。";
        }
        int result = synthesizer.speak(text);
        checkResult(result, "speak");
    }


    private void checkResult(int result, String method) {
        if (result != 0) {
            Log.e("1","error code :" + result + " method:" + method);
        }
    }


    @Override
    protected void onDestroy() {
        synthesizer.release();
        //sendCount();
        Constant.USER_STATUS.setTodayCount(passed);
        Log.i(TAG, "释放资源成功");
        super.onDestroy();
    }

    protected void handle(Message msg) {
        if (msg.what == INIT_SUCCESS) {
            ivSound.setEnabled(true);
            msg.what = PRINT;
        }
    }

    private void sendCount(){
        Log.e("sendCount执行","11111");
        Request requestBlog = new Request.Builder()
                .url(Constant.BASE_URL + "count?count="+passed +
                        "&userId="+Constant.USER_STATUS.getId()+"")
                .build();
        try {
            Response response = okHttpClient.newCall(requestBlog).execute();
            //rsp = response.body().string();
            //Log.e("rrr", rsp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
