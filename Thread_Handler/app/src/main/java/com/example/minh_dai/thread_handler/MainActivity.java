package com.example.minh_dai.thread_handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    private EditText edt1, edt2;
    private TextView txt;
    private Button btn;
    private Thread1 thread1;
    private MyTask myTask;
    private ArrayList<Integer> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initHandler();
        thread1 = new Thread1(mHandler);
        thread1.start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Message message = new Message();
                message.what = 20;
                message.arg1=100;
                thread1.getHandler().sendMessage(message);
            //    Log.d("start", "start: " + message.arg1);
                if (edt1.getText().toString() != "" && edt2.getText().toString() != ""){
                    arrayList.add(Integer.parseInt(edt1.getText().toString()));
                    arrayList.add(Integer.parseInt(edt2.getText().toString()));
                    myTask.execute(arrayList);
                    //myTask.executeOnExecutor()
                }

            }
        });

    }
    private void initView() {
        edt1 = findViewById(R.id.editText);
        edt2 = findViewById(R.id.editText2);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.textView);
        arrayList = new ArrayList<>();
        myTask = new MyTask(txt);
    }

    private void initHandler() {
        mHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        return;
                    case 5:
                        Toast.makeText(MainActivity.this, "da nhan", Toast.LENGTH_SHORT).show();
                        return;
                    default:
                        break;
                }
            }
        };
    }

}
