package com.example.minh_dai.tablayout_viewpager_framgia.recyclerview_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minh_dai.tablayout_viewpager_framgia.R;
import com.example.minh_dai.tablayout_viewpager_framgia.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterContract extends RecyclerView.Adapter<RecyclerViewAdapterContract.ViewHodel> {

    private List<SinhVien> mList;

    public RecyclerViewAdapterContract() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_contract, parent, false);
        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.txtTen.setText(mList.get(position).getTen());
        holder.txtTuoi.setText(mList.get(position).getTuoi());
    }

    public void setAllData(@NonNull List<SinhVien> list) {
        mList= list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {

        private TextView txtTen, txtTuoi;

        public ViewHodel(View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtTenSV);
            txtTuoi = itemView.findViewById(R.id.txtTuoiSV);
        }
    }
}
