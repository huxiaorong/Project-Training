package cn.edu.hebtu.software.learning_chinese;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ReviewDialog extends DialogFragment{



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 根据布局文件通过布局填充器创建View
        View view = inflater.inflate(R.layout.reviewend_dialog_layout,
                null);
        // 获取布局文件中的控件
        Button btnOk = view.findViewById(R.id.btn_ok);
        // 给按钮添加自定义的监听器
        CustomDialogListener listener
                = new CustomDialogListener();
        btnOk.setOnClickListener(listener);

        // 返回创建的View
        return view;
    }

    // 自定义一个按钮的监听器类
    private class CustomDialogListener
            implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // 让当前Dialog消失
            getDialog().dismiss();
            Intent i = new Intent();
            i.setClass(getContext(),ReviewActivity.class);
            startActivity(i);
//            if (v.getId()==R.id.btn_ok) {
//                if(checkBox.isChecked())
//                    Log.e("test", "单选按钮被选中");
//                else
//                    Log.e("test", "单选按钮未被选中");
//                getActivity().finish();
//            }
        }
    }


}
