package com.example.minh_dai.tablayout_viewpager_framgia.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minh_dai.tablayout_viewpager_framgia.R;
import com.example.minh_dai.tablayout_viewpager_framgia.model.SinhVien;
import com.example.minh_dai.tablayout_viewpager_framgia.recyclerview_adapter.RecyclerViewAdapterHome;
import com.example.minh_dai.tablayout_viewpager_framgia.util.onListenPassData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements onListenPassData {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterHome mAdapterHome;
    private List<SinhVien> mList;
    private View view;

    public HomeFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mList = new ArrayList<>();
        if (mList.size() == 0) {
            initList();
        }
        mAdapterHome = new RecyclerViewAdapterHome(mList, getActivity());
        mAdapterHome.setPassData(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerviewHome);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //mAdapterHome.setAllData(mList);
        mRecyclerView.setAdapter(mAdapterHome);
    }

    private void initList() {
        for (int i = 0; i < 20; ++i) {
            SinhVien sv = new SinhVien("Ten " + i + 1, "Tuoi: " + i);
            mList.add(sv);
        }
    }


    @Override
    public void passdata(@NonNull SinhVien sv) {
        mList.add(sv);
        mAdapterHome.addAll(mList);
        mRecyclerView.scrollToPosition(mList.size() - 1);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) mList);
        outState.putBundle("bundle", bundle);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            Bundle bundle = savedInstanceState.getBundle("bundle");
            mList = bundle.getParcelableArrayList("list");
        }
    }
}
