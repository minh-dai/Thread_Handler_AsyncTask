package com.example.minh_dai.thread_handler;

import android.os.AsyncTask;
import android.widget.TextView;
import java.util.ArrayList;

public class MyTask extends AsyncTask<ArrayList<Integer>, Integer , Void> {

    private TextView txt;

    public MyTask(TextView txt) {
        this.txt = txt;
    }

    @Override
    protected Void doInBackground(ArrayList<Integer>... lists) {
        ArrayList<Integer> a = lists[0];
        publishProgress(a.get(0)+a.get(1));
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        txt.setText(String.valueOf(values[0]));
    }
}
