package com.example.minh_dai.shared_preferences;

import android.app.Application;

public class App extends Application {
    private static App mSelf;

    public static App self() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
    }
}
