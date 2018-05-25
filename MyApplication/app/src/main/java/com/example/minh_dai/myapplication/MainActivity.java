package com.example.minh_dai.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btnToast);

        Log.d("ahihi","Create");
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ShowDiaLogAlert();
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(intent);
                //btnToast.setBackgroundResource(R.color.colorAccent);

            }
        });
    }

    public void onPreExecute() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void onPostExecute(String s) {
        progressDialog.dismiss();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ahihi" , "onSaveInstanceState1");

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
/*    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag" , "onSaveInstanceState");
        outState.putBoolean(Const.CONTENT_LOADING, progressDialog.isShowing());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.getBoolean(Const.CONTENT_LOADING)) {
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.show();
    }*/

    private void ShowDiaLogAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ThangCoder.Com");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ứ chịu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Không thoát được", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        Log.d("","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("ahihi","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("ahihi","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("ahihi","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("ahihi","onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d("ahihi","onRestart");
        super.onRestart();
    }
}
