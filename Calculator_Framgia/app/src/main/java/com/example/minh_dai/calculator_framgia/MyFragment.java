package com.example.minh_dai.calculator_framgia;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyFragment extends Fragment implements View.OnClickListener {

    private TextView txtKQ, txt0, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txtCham, txtNhan, txtChia, txtChiaDu, txtCong, txtTru, txtBang, txtAC, txtAm;

    private double mTong = 0;
    private String s = "";
    private ArrayList<Double> mArrayNumBer;
    private ArrayList<String> mArrayString;
    private boolean check = false;
    private Context mContext;
    private View view;
    private boolean checkFomat = true;
    private OnDataPass dataPasser;
    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        clickbutton();
        String s = sharedPreferences.getString("last", "0");
        if (!s.equals("0")) {
            mTong = Double.parseDouble(s);
            txtKQ.setText(String.valueOf(mTong));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        dataPasser = (OnDataPass) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences =
                mContext.getSharedPreferences("minh_dai", Context.MODE_PRIVATE);
    }

    private void initView() {

        txt0 = view.findViewById(R.id.txt0);
        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt3 = view.findViewById(R.id.txt3);
        txt4 = view.findViewById(R.id.txt4);
        txt5 = view.findViewById(R.id.txt5);
        txt6 = view.findViewById(R.id.txt6);
        txt7 = view.findViewById(R.id.txt7);
        txt8 = view.findViewById(R.id.txt8);
        txt9 = view.findViewById(R.id.txt9);

        txtCong = view.findViewById(R.id.txtCong);
        txtTru = view.findViewById(R.id.txtTru);
        txtNhan = view.findViewById(R.id.txtNhan);
        txtChia = view.findViewById(R.id.txtChia);
        txtChiaDu = view.findViewById(R.id.txtChiaDu);

        txtAm = view.findViewById(R.id.txtAm);
        txtBang = view.findViewById(R.id.txtBang);
        txtAC = view.findViewById(R.id.txtAC);
        txtCham = view.findViewById(R.id.txtCham);

        txtKQ = view.findViewById(R.id.txtNumber);

    }

    private void clickbutton() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                txtKQ.setText(txtKQ.getText() + ".");
                break;

            /*case R.id.txtAm:
                txtKQ.setText(txtKQ.getText()+"-");
                break;*/

            case R.id.txtCong:
                if (mTong > 0) {
                    txtKQ.setText(mTong + "+");
                    check = true;
                } else {
                    txtKQ.setText(txtKQ.getText() + "+");
                    check = false;
                }
                break;
            case R.id.txtTru:
                if (mTong > 0) {
                    txtKQ.setText(mTong + "-");
                    check = true;
                } else {
                    txtKQ.setText(txtKQ.getText() + "-");
                    check = false;
                }
                break;

            case R.id.txtNhan:
                if (mTong > 0) {
                    txtKQ.setText(mTong + "*");
                    check = true;
                } else {
                    txtKQ.setText(txtKQ.getText() + "*");
                    check = false;
                }
                break;
            case R.id.txtChia:
                if (mTong > 0) {
                    txtKQ.setText(mTong + "/");
                    check = true;
                } else {
                    txtKQ.setText(txtKQ.getText() + "/");
                    check = false;
                }
                break;

            case R.id.txtChiaDu:
                if (mTong > 0) {
                    txtKQ.setText(mTong + "%");
                    check = true;
                } else {
                    txtKQ.setText(txtKQ.getText() + "%");
                    check = false;
                }
                break;

            case R.id.txtAC:
                String s = txtKQ.getText().toString().trim();
                if (s.length() > 0)
                    truAC();
                else {
                    mTong = 0;
                    check = false;
                }
                break;

            case R.id.txtBang:
                tinhTong();
                check = false;
                break;
        }
    }

    private void reValuse(String so) {
        if (mTong > 0 && !check) {
            txtKQ.setText(so);
            mTong = 0;
        } else {
            txtKQ.setText(txtKQ.getText() + so);
        }
    }


    private void truAC() {
        String s = txtKQ.getText().toString().trim();
        txtKQ.setText(removeCharAt(s, s.length() - 1));
    }

    private String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    private void tinhTong() {

        s = txtKQ.getText().toString().trim();

        mArrayNumBer = new ArrayList<>();
        mArrayString = new ArrayList<>();

        addNumBer(s);
        addString(s);

        if (mArrayString.size() >= mArrayNumBer.size() || !checkFomat) {
            txtKQ.setText("");
            Toast.makeText(getActivity(), "Lỗi định dạng", Toast.LENGTH_SHORT).show();
        } else {
            tong();
        }
    }

    private void tong() {

        // nhân chia trước , cộng trừ sau :))

        for (int i = 0; i < mArrayString.size(); ++i) {
            boolean a = setValue(i, mArrayString.get(i));
            if (a)
                --i;
        }

        for (int i = 0; i < mArrayString.size(); ++i) {
            boolean a = setValue(mArrayString.get(i), i);
            if (a)
                --i;
        }


        String kq = String.valueOf(mArrayNumBer.get(0));
        txtKQ.setText(kq);
        mTong = mArrayNumBer.get(0);
        if (mTong > 0)
            dataPasser.onDataPass(String.valueOf(mTong));
    }

    private boolean setValue(@NonNull int i, @NonNull String dau) {
        double a = -1;
        if (dau.equals("*")) {
            a = mArrayNumBer.get(i) * mArrayNumBer.get(i + 1);
        } else if (dau.equals("/")) {
            a = mArrayNumBer.get(i) / mArrayNumBer.get(i + 1);
        } else if (dau.equals("%")) {
            a = mArrayNumBer.get(i) % mArrayNumBer.get(i + 1);
        }

        if (a != -1) {
            mArrayNumBer.set(i, a);
            mArrayNumBer.remove(i + 1);
            mArrayString.remove(i);
            return true;
        }
        return false;
    }

    private boolean setValue(@NonNull String dau, @NonNull int i) {

        double a = 0;
        if (dau.equals("+")) {
            a = mArrayNumBer.get(i) + mArrayNumBer.get(i + 1);
        } else if (dau.equals("-")) {
            a = mArrayNumBer.get(i) - mArrayNumBer.get(i + 1);
        }

        if (a != 0) {
            mArrayNumBer.set(i, a);
            mArrayNumBer.remove(i + 1);

            mArrayString.remove(i);
            return true;
        }
        return false;
    }

    private void addString(@NonNull String s) {

        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%') {
                mArrayString.add(s.charAt(i) + "");
            }
        }

    }

    private void addNumBer(@NonNull String s) {
        String number = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9' || c == '.') {
                number += c + "";
            } else {
                if (number != "")
                    mArrayNumBer.add(Double.parseDouble(number));
                number = "";
            }
            if (i == s.length() - 1 && number != "") {
                mArrayNumBer.add(Double.parseDouble(number));
            }

        }
    }


}
