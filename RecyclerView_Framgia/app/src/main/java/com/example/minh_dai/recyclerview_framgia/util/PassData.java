package com.example.minh_dai.recyclerview_framgia.util;

import com.example.minh_dai.recyclerview_framgia.model.SinhVien;

public interface PassData {

    void passDataDelete(String masv);

    void passDataAdd(SinhVien sinhVien);

    void passDataChange(int position, SinhVien sinhVien);
}
