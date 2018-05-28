package com.example.minh_dai.tablayout_viewpager_framgia.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minh_dai.tablayout_viewpager_framgia.R;
import com.example.minh_dai.tablayout_viewpager_framgia.model.SinhVien;
import com.example.minh_dai.tablayout_viewpager_framgia.recyclerview_adapter.RecyclerViewAdapterContract;
import com.example.minh_dai.tablayout_viewpager_framgia.recyclerview_adapter.RecyclerViewAdapterHome;

import java.util.ArrayList;
import java.util.List;

public class ContractFragment extends Fragment {

    private List<SinhVien> mList;
    private RecyclerViewAdapterContract mAdapterContract;
    private RecyclerView mRecyclerView;
    private View view;

    public ContractFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        initList();

        mAdapterContract = new RecyclerViewAdapterContract();
    }

    private void initList() {
        for (int i=0; i<20; ++i){
            SinhVien sv= new SinhVien("Ten "+ i+1, "Tuoi: "+i);
            mList.add(sv);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_contract, container , false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recyclerview_contract);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapterContract.setAllData(mList);

        mRecyclerView.setAdapter(mAdapterContract);
    }
}
