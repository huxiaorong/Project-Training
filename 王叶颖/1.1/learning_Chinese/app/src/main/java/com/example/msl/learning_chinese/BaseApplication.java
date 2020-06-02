package com.example.msl.learning_chinese;

import android.app.Application;

public class BaseApplication extends Application {
    private boolean mIsNightMode;



    public boolean isNightMode() {

        return mIsNightMode;

    }



    public void setIsNightMode(boolean isNightMode) {

        if (mIsNightMode == isNightMode)

            return;

        mIsNightMode = isNightMode;

    }

}

