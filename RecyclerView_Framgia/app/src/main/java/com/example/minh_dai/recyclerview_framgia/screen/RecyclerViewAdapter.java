package com.example.minh_dai.recyclerview_framgia.screen;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh_dai.recyclerview_framgia.R;
import com.example.minh_dai.recyclerview_framgia.model.SinhVien;
import com.example.minh_dai.recyclerview_framgia.util.PassData;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<SinhVien> mList;
    private Context mContext;

    private EditText mEdtName, mEdtTuoi;
    private Button btnOK, btnCancel;
    private PassData passData;
    private int lastPosition = -1;

    public RecyclerViewAdapter(List<SinhVien> mList, Context context) {
        this.mList = mList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_sinhvien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mMaSV.setText(mList.get(position).getMaSV());
        holder.mName.setText(mList.get(position).getName());
        holder.mTuoi.setText(mList.get(position).getTuoi() + "");

        setAnimation(holder.itemView, position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public void setData(List<SinhVien> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public void editSinhVien(int position, SinhVien sinhVien) {
        if (mList.size() > 0) {
            mList.get(position).setName(sinhVien.getName());
            mList.get(position).setTuoi(sinhVien.getTuoi());
            notifyItemChanged(position);
        }
    }

    public void deleteSinhVien(int i) {
        if (mList.size() > 0) {
            mList.remove(i);
            notifyItemRemoved(i);
        }
    }

    public void addSinhVien(SinhVien sinhVien) {
        mList.add(sinhVien);
        notifyItemInserted(mList.size() - 1);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        private ImageView mImgSinhVien;
        private TextView mName, mTuoi, mMaSV;

        public ViewHolder(View itemView) {
            super(itemView);

            this.mImgSinhVien = itemView.findViewById(R.id.imgSinhVien);
            this.mName = itemView.findViewById(R.id.txtTen);
            this.mMaSV = itemView.findViewById(R.id.txtMaSV);
            this.mTuoi = itemView.findViewById(R.id.txtTuoi);

            //itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        /*@Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Toast.makeText(mContext, mList.get(position).getMaSV(), Toast.LENGTH_SHORT).show();
        }*/


        @Override
        public boolean onLongClick(View v) {
            int position = getLayoutPosition();
            showChangeLangDialog(position);
            return true;
        }
    }

    public void showChangeLangDialog(final int position) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.dialog_edit, null);
        dialogBuilder.setView(dialogView);

        mEdtName = dialogView.findViewById(R.id.edtTen);
        mEdtTuoi = dialogView.findViewById(R.id.edtTuoi);

        btnOK = dialogView.findViewById(R.id.btnOK);
        btnCancel = dialogView.findViewById(R.id.btnCancel);

        final AlertDialog alertDialog = dialogBuilder.create();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEdtTuoi.getText().toString().length() > 0 && mEdtName.getText().toString().length() > 0) {
                    SinhVien sinhVien = new SinhVien(mEdtName.getText().toString()
                            , Integer.parseInt(mEdtTuoi.getText().toString()), "");

                    passData = (PassData) mContext;
                    passData.passDataChange(position, sinhVien);
                    alertDialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }


}
