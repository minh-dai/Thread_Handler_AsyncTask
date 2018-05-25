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
import com.example.minh_dai.recyclerview_framgia.util.PassData;

public class DialogDelete extends DialogFragment {

    private EditText mEdtMaSV;
    private Button btnOK, btnCancel;
    private PassData passData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_delete, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEdtMaSV = view.findViewById(R.id.edtMaSV);
        btnOK = view.findViewById(R.id.btnOK);
        btnCancel = view.findViewById(R.id.btnCancel);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEdtMaSV.getText().toString().length() > 0) {
                    passData = (PassData) getActivity();
                    passData.passDataDelete(String.valueOf(mEdtMaSV.getText()));
                    getDialog().dismiss();
                }
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
