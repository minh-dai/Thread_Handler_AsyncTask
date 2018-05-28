package com.example.minh_dai.tablayout_viewpager_framgia.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minh_dai.tablayout_viewpager_framgia.R;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_setting, container, false);
        return view;
    }
}
