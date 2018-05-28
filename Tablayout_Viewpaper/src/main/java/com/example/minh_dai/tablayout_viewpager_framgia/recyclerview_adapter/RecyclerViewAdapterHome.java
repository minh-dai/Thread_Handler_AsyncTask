package com.example.minh_dai.tablayout_viewpager_framgia.recyclerview_adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.minh_dai.tablayout_viewpager_framgia.R;
import com.example.minh_dai.tablayout_viewpager_framgia.model.SinhVien;
import com.example.minh_dai.tablayout_viewpager_framgia.util.onListenPassData;

import java.util.List;

public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.ViewHodel> {

    private List<SinhVien> mList;
    private Context mContext;
    private onListenPassData passData;

    public RecyclerViewAdapterHome(List<SinhVien> mList, Context context) {
        this.mList = mList;
        mContext = context;
    }

    public void setPassData(onListenPassData passData) {
        this.passData = passData;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_home, parent, false);
        return new ViewHodel(view);
    }

    public void addSinhVien(SinhVien sv){
        mList.add(sv);
        notifyDataSetChanged();
    }

    public void addAll(List<SinhVien> list){
        mList = list;
        notifyDataSetChanged();;
    }

    public List<SinhVien> getList(){
        return mList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.txtTuoi.setText(mList.get(position).getTuoi());
        holder.txtTen.setText(mList.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTen,txtTuoi;

        public ViewHodel(View itemView) {
            super(itemView);

            txtTen = itemView.findViewById(R.id.txtTen);
            txtTuoi = itemView.findViewById(R.id.txtTuoi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            final Dialog dialog = new Dialog(mContext);
            dialog.setContentView(R.layout.custom_dialog_edit_sinhvien);
            dialog.setTitle("Them Sinh Vien");
            Button btnOk, btnCanecl;
            final EditText edtTen,edtTuoi;

            btnOk = dialog.findViewById(R.id.btnOK);
            btnCanecl = dialog.findViewById(R.id.btnCancel);
            edtTen = dialog.findViewById(R.id.edtTenSV);
            edtTuoi = dialog.findViewById(R.id.edtTuoiSV);

            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtTen.getText().toString().length() >  0
                            && edtTuoi.getText().toString().length() >0) {

                        SinhVien sinhVien = new SinhVien(edtTen.getText().toString(),edtTuoi.getText().toString() );
                        passData.passdata(sinhVien);
                        dialog.dismiss();
                    }
                }
            });

            btnCanecl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }
    }
}
