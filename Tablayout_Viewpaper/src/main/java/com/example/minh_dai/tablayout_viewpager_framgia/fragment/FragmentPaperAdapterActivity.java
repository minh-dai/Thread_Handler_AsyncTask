package com.example.minh_dai.tablayout_viewpager_framgia.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.minh_dai.tablayout_viewpager_framgia.fragment.ContractFragment;
import com.example.minh_dai.tablayout_viewpager_framgia.fragment.HomeFragment;
import com.example.minh_dai.tablayout_viewpager_framgia.fragment.SettingsFragment;

public class FragmentPaperAdapterActivity extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentPaperAdapterActivity(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;

    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ContractFragment();
            case 2:
                return new SettingsFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Contract";
            case 2:
                return "Setting";
            default: return null;
        }
    }
}
