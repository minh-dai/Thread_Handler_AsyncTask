package com.example.minh_dai.shared_preferences;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String CURRENT_ID = "current_id";
    public static final String CURRENT_NAME = "current_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context mContext = this.getBaseContext();

        Shared_preference mShared_preference = Shared_preference.getInstance(mContext);

        mShared_preference.put(CURRENT_ID, 123);
        mShared_preference.put(CURRENT_NAME, "Dang Anh Quan");

        mShared_preference.get(CURRENT_ID, Integer.class);
        mShared_preference.get(CURRENT_NAME, String.class);

        Toast.makeText(this, mShared_preference.get(CURRENT_ID,Integer.class)+ "", Toast.LENGTH_SHORT).show();
    }
}
