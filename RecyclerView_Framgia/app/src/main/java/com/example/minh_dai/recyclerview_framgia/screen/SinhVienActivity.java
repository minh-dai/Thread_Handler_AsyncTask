package com.example.minh_dai.recyclerview_framgia.screen;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.minh_dai.recyclerview_framgia.R;
import com.example.minh_dai.recyclerview_framgia.dialog.DialogAdd;
import com.example.minh_dai.recyclerview_framgia.dialog.DialogDelete;
import com.example.minh_dai.recyclerview_framgia.model.SinhVien;
import com.example.minh_dai.recyclerview_framgia.util.PassData;

import java.util.ArrayList;
import java.util.List;

public class SinhVienActivity extends AppCompatActivity implements PassData {

    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<SinhVien> mListSinhVien;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArrayList();
        initView();
    }

    private void initArrayList() {
        mListSinhVien = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            SinhVien sinhVien = new SinhVien("Sinh Vien" + i, i, "i" + i);
            mListSinhVien.add(sinhVien);
        }
    }

    private void initView() {

        mRecyclerViewAdapter = new RecyclerViewAdapter(mListSinhVien, SinhVienActivity.this);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mRecyclerView.destroyDrawingCache();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                showDialogAdd();
                return true;
            case R.id.clear:
                showDialogDelete();
                return true;
        }
        return false;
    }

    private void showDialogDelete() {
        FragmentManager fragmentManager = getFragmentManager();
        DialogDelete dialogDelete = new DialogDelete();
        dialogDelete.show(fragmentManager, "add sinh vien");
    }

    private void showDialogAdd() {
        FragmentManager fragmentManager = getFragmentManager();
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(fragmentManager, "add sinh vien");
    }

    @Override
    public void passDataDelete(String masv) {
        if (!masv.equals("")) {
            for (int i = 0; i < mListSinhVien.size(); ++i) {
                if (masv.equals(mListSinhVien.get(i).getMaSV())) {
                    mListSinhVien.remove(i);
                    mRecyclerViewAdapter.deleteSinhVien(i);
                    return;
                }
            }
        }
    }

    @Override
    public void passDataAdd(SinhVien sinhVien) {
        if (sinhVien != null) {
            for (int i = 0; i < mListSinhVien.size(); ++i) {
                if (sinhVien.getMaSV().equals(mListSinhVien.get(i).getMaSV())) {
                    Toast.makeText(SinhVienActivity.this, "Ma SV Da Ton Tai"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            mListSinhVien.add(sinhVien);
            mRecyclerViewAdapter.addSinhVien(sinhVien);
            mRecyclerView.scrollToPosition(mListSinhVien.size() - 1);
        }
    }

    @Override
    public void passDataChange(int position, SinhVien sinhVien) {
        mRecyclerViewAdapter.editSinhVien(position, sinhVien);
        mRecyclerView.scrollToPosition(position);
    }


}
