package com.example.minh_dai.tablayout_viewpager_framgia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SinhVien  implements Parcelable{

    private String mTen;
    private String mTuoi;

    public SinhVien(String Ten, String Tuoi) {
        this.mTen = Ten;
        this.mTuoi = Tuoi;
    }

    protected SinhVien(Parcel in) {
        mTen = in.readString();
        mTuoi = in.readString();
    }

    public static final Creator<SinhVien> CREATOR = new Creator<SinhVien>() {
        @Override
        public SinhVien createFromParcel(Parcel in) {
            return new SinhVien(in);
        }

        @Override
        public SinhVien[] newArray(int size) {
            return new SinhVien[size];
        }
    };

    public String getTen() {
        return mTen;
    }

    public void setTen(String mTen) {
        this.mTen = mTen;
    }

    public String getTuoi() {
        return mTuoi;
    }

    public void setTuoi(String mTuoi) {
        this.mTuoi = mTuoi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTen);
        dest.writeString(mTuoi);
    }
}
