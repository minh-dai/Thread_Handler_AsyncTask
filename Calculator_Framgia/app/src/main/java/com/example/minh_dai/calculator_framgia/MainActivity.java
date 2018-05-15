package com.example.minh_dai.calculator_framgia;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtKQ,txt0,txt1,txt2,txt3,txt4
            ,txt5,txt6,txt7,txt8,txt9,txtCham
            ,txtNhan,txtChia,txtChiaDu,txtCong
            ,txtTru,txtBang,txtAC,txtAm;

    private double  mTong = 0;
    private String s="";
    private ArrayList<Double> mArrayNumBer;
    private ArrayList<String> mArrayString;
    private boolean check = false;
    private SharedPreferences sharedPreferences ;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        CLickButton();

    }

    private void CLickButton() {

        txt0.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        txt5.setOnClickListener(this);
        txt6.setOnClickListener(this);
        txt7.setOnClickListener(this);
        txt8.setOnClickListener(this);
        txt9.setOnClickListener(this);

        txtCong.setOnClickListener(this);
        txtTru.setOnClickListener(this);
        txtNhan.setOnClickListener(this);
        txtChia.setOnClickListener(this);
        txtChiaDu.setOnClickListener(this);

        txtAC.setOnClickListener(this);
        txtCham.setOnClickListener(this);
        txtAm.setOnClickListener(this);

        txtBang.setOnClickListener(this);
        txtKQ.setOnClickListener(this);
    }

    private void initView() {

        txt0 = findViewById(R.id.txt0);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);

        txtCong = findViewById(R.id.txtCong);
        txtTru = findViewById(R.id.txtTru);
        txtNhan = findViewById(R.id.txtNhan);
        txtChia = findViewById(R.id.txtChia);
        txtChiaDu = findViewById(R.id.txtChiaDu);

        txtAm = findViewById(R.id.txtAm);
        txtBang= findViewById(R.id.txtBang);
        txtAC = findViewById(R.id.txtAC);
        txtCham = findViewById(R.id.txtCham);

        txtKQ = findViewById(R.id.txtNumber);

        txtKQ.setText("");
        sharedPreferences =
                getSharedPreferences("minh_dai", Context.MODE_PRIVATE);


        String kq = sharedPreferences.getString("last","");
        if (kq != ""){
            txtKQ.setText(kq);
            mTong = Double.parseDouble(kq);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt0:
                reValuse("0");
                break;

            case R.id.txt1:
                reValuse("1");
                break;
            case R.id.txt2:
                reValuse("2");
                break;

            case R.id.txt3:

                reValuse("3");
                break;
            case R.id.txt4:
                reValuse("4");
                break;

            case R.id.txt5:
                reValuse("5");
                break;
            case R.id.txt6:
                reValuse("6");
                break;

            case R.id.txt7:
                reValuse("7");
                break;
            case R.id.txt8:
                reValuse("8");
                break;

            case R.id.txt9:
                reValuse("9");
                break;
            case R.id.txtCham:
                txtKQ.setText(txtKQ.getText()+".");
                break;

            /*case R.id.txtAm:
                txtKQ.setText(txtKQ.getText()+"-");
                break;*/

            case R.id.txtCong:
                if (mTong > 0){
                    txtKQ.setText(mTong+"+");
                    check = true;
                }else {
                    txtKQ.setText(txtKQ.getText() + "+");
                    check = false;
                }
                break;
            case R.id.txtTru:
                if (mTong > 0){
                    txtKQ.setText(mTong+"-");
                    check = true;
                }else {
                    txtKQ.setText(txtKQ.getText() + "-");
                    check = false;
                }
                break;

            case R.id.txtNhan:
                if (mTong > 0){
                    txtKQ.setText(mTong+"*");
                    check = true;
                }else {
                    txtKQ.setText(txtKQ.getText() + "*");
                    check = false;
                }
                break;
            case R.id.txtChia:
                if (mTong > 0){
                    txtKQ.setText(mTong+"/");
                    check = true;
                }else {
                    txtKQ.setText(txtKQ.getText() + "/");
                    check = false;
                }
                break;

            case R.id.txtChiaDu:
                if (mTong > 0){
                    txtKQ.setText(mTong+"%");
                    check = true;
                }else {
                    txtKQ.setText(txtKQ.getText() + "%");
                    check = false;
                }
                break;

            case R.id.txtAC:
                String s = txtKQ.getText().toString().trim();
                if (s.length() > 0)
                    TruAC();
                else
                    check=false;
                break;

            case R.id.txtBang:
                    String kq = txtKQ.getText() + " = ";
                    txtKQ.setText(kq.trim());
                    int firtBang = txtKQ.getText().toString().indexOf("=");
                    int lastBang = txtKQ.getText().toString().lastIndexOf("=");
                    if (firtBang == lastBang ) {
                        TinhTong();
                    }else {
                        TruAC();
                       // removeCharAt(txtKQ.getText()+"", firtBang); 9+3*6-5=23
                    }
                    check = false;
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemClear:
                txtKQ.setText("");
                onCLickClear();
                break;
            case R.id.itemSave:
                onCLickSave();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void onCLickClear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void onCLickSave() {

        editor = sharedPreferences.edit();
        editor.putString("last" , mTong + "");
        editor.apply();

        Toast.makeText(MainActivity.this, "Da Luu :"
                + sharedPreferences.getString("last","0"),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void reValuse(String so) {
        if (mTong > 0 && !check) {
            txtKQ.setText(so);
            mTong = 0;
        } else {
            txtKQ.setText(txtKQ.getText() + so);
        }
    }


    private void TruAC() {
        String s = txtKQ.getText().toString().trim();
        txtKQ.setText(removeCharAt(s, s.length()-1));
    }

    private String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    private void TinhTong() {

        s = txtKQ.getText().toString().trim();

        mArrayNumBer = new ArrayList<>();
        mArrayString = new ArrayList<>();

        addNumBer(s);
        addString(s);

        if (mArrayString.size() >= mArrayNumBer.size()){
            txtKQ.setText("");
            Toast.makeText(MainActivity.this , "Lỗi định dạng" , Toast.LENGTH_SHORT).show();
        }else {


            Tong();
        }
    }


    private void Tong(){

        // nhân chia trước , cộng trừ sau :))

        for(int i=0; i<mArrayString.size(); ++i){
            boolean a = setValue(i,mArrayString.get(i));
            if (a)
                --i;
        }

        for(int i=0; i<mArrayString.size(); ++i){
            boolean a =setValue(mArrayString.get(i),i);
            if(a)
                --i;
        }

        String kq = txtKQ.getText()+" "+mArrayNumBer.get(0);
        txtKQ.setText(kq);
        int d = kq.indexOf("=");
        mTong = Double.parseDouble(kq.substring(d+2 , kq.length()));
    }

    private boolean setValue(@NonNull int i, @NonNull String dau){
        double a=-1;
        if (dau.equals("*")) {
            a = mArrayNumBer.get(i) * mArrayNumBer.get(i + 1);
        }else if (dau.equals("/")) {
            a = mArrayNumBer.get(i) / mArrayNumBer.get(i + 1);
        }else if (dau.equals("%")){
            a = mArrayNumBer.get(i) % mArrayNumBer.get(i + 1);
        }

        if(a!=-1) {
            mArrayNumBer.set(i, a);
            mArrayNumBer.remove(i + 1);
            mArrayString.remove(i);
            return true;
        }
        return false;
    }

    private boolean setValue(@NonNull String dau,@NonNull int i){

        double a=0;
        if (dau.equals("+")){
            a = mArrayNumBer.get(i) + mArrayNumBer.get(i + 1);
        }else if (dau.equals("-")){
            a = mArrayNumBer.get(i) - mArrayNumBer.get(i + 1);
        }

        if (a!=0) {
            mArrayNumBer.set(i, a);
            mArrayNumBer.remove(i + 1);

            mArrayString.remove(i);
            return true;
        }
        return false;
    }

    private void addString(@NonNull String s){

        for (int i=0; i<s.length(); ++i){
            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%'){
                mArrayString.add(s.charAt(i) + "");
            }
        }

    }

    private void addNumBer(@NonNull String s){
        String number = "";
        for (int i=0; i<s.length()-1; ++i){

            char c = s.charAt(i);
            if (c >= '0' && c<='9' || c=='.'){
                number += c + "";
            }
            else{
                if (number != "")
                    mArrayNumBer.add(Double.parseDouble(number));
                number = "";
            }
            if (i==s.length()-1 && number != "")
                mArrayNumBer.add(Double.parseDouble(number));
        }
    }


}
