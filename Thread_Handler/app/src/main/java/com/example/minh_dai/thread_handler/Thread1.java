package com.example.minh_dai.thread_handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class Thread1 extends Thread {

    private Handler mHandler,handler;

    public Thread1(Handler handler) {
        this.mHandler = handler;
    }

    @Override
    public void run() {
        Looper.prepare();

        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 20)
                {
                    Message message = new Message();
                    message.what = 5;
                    message.arg1 = 200;
                    mHandler.sendMessage(message);
                    Log.d("ahihi", "r1: " + msg.arg1);
                }
            }
        };

        for(int i=0; i<10; ++i) {
            Message message = new Message();
            message.what = 101;
            message.arg1 = i;
            mHandler.sendMessage(message);
            try {
                Thread1.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mHandler.sendEmptyMessage(100);

        Looper.loop();
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
