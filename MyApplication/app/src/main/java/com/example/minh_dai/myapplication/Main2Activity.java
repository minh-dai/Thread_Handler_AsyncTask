package com.example.minh_dai.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button btnkhong,btnco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_main2);

        btnco = findViewById(R.id.btnCo);
        btnkhong = findViewById(R.id.btnKhong);

        btnkhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // this.setFinishOnTouchOutside(false);
                finish();
            }
        });
    }
}
