package com.example.minh_dai.calculator_framgia;

import android.icu.text.UnicodeSetSpanner;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtKQ,txt0,txt1,txt2,txt3,txt4
            ,txt5,txt6,txt7,txt8,txt9,txtCham
            ,txtNhan,txtChia,txtChiaDu,txtCong
            ,txtTru,txtBang,txtAC;

    private double number1 = 0,number2 = 0, mTong = 0;
    private String s="";
    private ArrayList<Double> mArrayNumBer;
    private ArrayList<String> mArrayString;

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

        txtBang= findViewById(R.id.txtBang);
        txtAC = findViewById(R.id.txtAC);
        txtCham = findViewById(R.id.txtCham);

        txtKQ = findViewById(R.id.txtNumber);

        txtKQ.setText("");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt0:
                    txtKQ.setText(txtKQ.getText()+"0");
                break;

            case R.id.txt1:
                txtKQ.setText(txtKQ.getText()+"1");
                break;
            case R.id.txt2:
                txtKQ.setText(txtKQ.getText()+"2");
                break;

            case R.id.txt3:
                txtKQ.setText(txtKQ.getText()+"3");
                break;
            case R.id.txt4:
                txtKQ.setText(txtKQ.getText()+"4");
                break;

            case R.id.txt5:
                txtKQ.setText(txtKQ.getText()+"5");
                break;
            case R.id.txt6:
                txtKQ.setText(txtKQ.getText()+"6");
                break;

            case R.id.txt7:
                txtKQ.setText(txtKQ.getText()+"7");
                break;
            case R.id.txt8:
                txtKQ.setText(txtKQ.getText()+"8");
                break;

            case R.id.txt9:
                txtKQ.setText(txtKQ.getText()+"9");
                break;
            case R.id.txtCham:
                txtKQ.setText(txtKQ.getText()+".");
                break;

            case R.id.txtCong:

                txtKQ.setText(txtKQ.getText()+"+");
                break;
            case R.id.txtTru:

                txtKQ.setText(txtKQ.getText()+"-");
                break;

            case R.id.txtNhan:

                txtKQ.setText(txtKQ.getText()+"*");
                break;
            case R.id.txtChia:

                txtKQ.setText(txtKQ.getText()+"/");
                break;

            case R.id.txtChiaDu:
                txtKQ.setText(txtKQ.getText()+"%");
                break;

            case R.id.txtAC:
                String s = txtKQ.getText().toString().trim();
                if (s.length() > 0)
                    TruAC();
                break;

            case R.id.txtBang:
                txtKQ.setText(txtKQ.getText()+" = ");
                TinhTong();
                break;
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

        addString(s);
        addNumBer(s);

        if (mArrayString.size() >= mArrayNumBer.size() ||
                s.charAt(0) == '+' || s.charAt(0) == '-' ||
                s.charAt(0) == '*' || s.charAt(0) == '/'){
            Toast.makeText(MainActivity.this , "Lỗi định dạng" , Toast.LENGTH_SHORT).show();
        }

        Tong();
    }

    private void Tong(){

        // nhân chia trước , cộng trừ sau :))

        while (mArrayString.size() > 0){
            tinhDau("*");
        }
        while (mArrayString.size() > 0){
            tinhDau("/");
        }
        while (mArrayString.size() > 0){
            tinhDau("%");
        }
        while (mArrayString.size() > 0){
            tinhDau("+");
        }
        while (mArrayString.size() > 0){
            tinhDau("-");
        }

        if (mArrayString.size() > 0){
            for (int i=0; i<mArrayString.size(); ++i){
                setValue(i,mArrayString.get(i));
            }
        }

        String kq = txtKQ.getText()+" "+mArrayNumBer.get(0);
        txtKQ.setText(kq);
    }

    private void tinhDau(String dau){
        for (int i=0; i<mArrayString.size(); ++i){
            if (mArrayString.get(i) == dau){
                setValue(i,dau);
            }
        }
    }

    private void setValue(@NonNull int i, @NonNull String dau){
        double a=0;
        if (dau == "*") {
            a = mArrayNumBer.get(i) * mArrayNumBer.get(i + 1);
        }else if (dau == "/") {
            a = mArrayNumBer.get(i) / mArrayNumBer.get(i + 1);
        }else if (dau == "%"){
            a = mArrayNumBer.get(i) % mArrayNumBer.get(i + 1);
        }else if (dau == "+"){
            a = mArrayNumBer.get(i) + mArrayNumBer.get(i + 1);
        }else if (dau == "-"){
            a = mArrayNumBer.get(i) - mArrayNumBer.get(i + 1);
        }

        mArrayNumBer.set(i, a);
        mArrayNumBer.remove(i+1);

        mArrayString.remove(i);
    }

    private void addString(@NonNull String s){

        for (int i=0; i<s.length(); ++i){
            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' && s.charAt(i) != '%'){
                mArrayString.add(s.charAt(i) + "");
            }
        }

    }

    private void addNumBer(@NonNull String s){
        String number = "";
        for (int i=0; i<s.length(); ++i){

            char c = s.charAt(i);
            if (s.charAt(i) != '+' && s.charAt(i) != '-' &&
                    s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '='
                    && s.charAt(i) != '%' ){
                number += s.charAt(i) + "";
            }else {
                mArrayNumBer.add(Double.parseDouble(number));
                number = "";
            }
            if (i==s.length()-1 && number != "")
                mArrayNumBer.add(Double.parseDouble(number));
        }
    }


}
