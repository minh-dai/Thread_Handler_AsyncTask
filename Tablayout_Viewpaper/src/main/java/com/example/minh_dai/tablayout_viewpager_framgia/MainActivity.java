package com.example.minh_dai.tablayout_viewpager_framgia;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.minh_dai.tablayout_viewpager_framgia.fragment.FragmentPaperAdapterActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FragmentPaperAdapterActivity mPaperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpaper);
        mTabLayout = findViewById(R.id.tablayout);
        mPaperAdapter = new FragmentPaperAdapterActivity(getSupportFragmentManager()
                , getBaseContext());
        mViewPager.setAdapter(mPaperAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
