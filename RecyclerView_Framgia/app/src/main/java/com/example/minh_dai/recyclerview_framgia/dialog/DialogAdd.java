package com.example.minh_dai.recyclerview_framgia.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.minh_dai.recyclerview_framgia.R;
import com.example.minh_dai.recyclerview_framgia.model.SinhVien;
import com.example.minh_dai.recyclerview_framgia.util.PassData;

public class DialogAdd extends DialogFragment {

    private EditText mEditTextTen, mEditTextMaSV, mEditTextTuoi;
    private Button btnCancel, btnOk;
    private PassData passData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEditTextMaSV = view.findViewById(R.id.edtMaSV);
        mEditTextTen = view.findViewById(R.id.edtTen);
        mEditTextTuoi = view.findViewById(R.id.edtTuoi);

        btnCancel = view.findViewById(R.id.btnCancel);
        btnOk = view.findViewById(R.id.btnOk);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVien = new SinhVien(mEditTextTen.getText().toString()
                        , Integer.parseInt(mEditTextTuoi.getText().toString()), mEditTextMaSV.getText().toString());

                passData = (PassData) getActivity();
                passData.passDataAdd(sinhVien);
                getDialog().dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }
}
