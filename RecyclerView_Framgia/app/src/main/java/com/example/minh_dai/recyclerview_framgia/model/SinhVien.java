package com.example.minh_dai.recyclerview_framgia.model;

public class SinhVien {

    private String mName;
    private int mTuoi;
    private String mMaSV;

    public SinhVien(String mName, int mTuoi, String mMaSV) {
        this.mName = mName;
        this.mTuoi = mTuoi;
        this.mMaSV = mMaSV;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getTuoi() {
        return mTuoi;
    }

    public void setTuoi(int mTuoi) {
        this.mTuoi = mTuoi;
    }

    public String getMaSV() {
        return mMaSV;
    }

}
