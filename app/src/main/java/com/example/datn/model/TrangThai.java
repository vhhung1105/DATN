package com.example.datn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_trang_thai")
public class TrangThai {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_trang_thai")
    private int idTrangThai;
    @ColumnInfo(name = "ten_trang_thai")
    private String tenTrangThai;

    public TrangThai() {
    }

    @Ignore
    public TrangThai(int idTrangThai, String tenTrangThai) {
        this.idTrangThai = idTrangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
