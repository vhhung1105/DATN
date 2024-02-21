package com.example.datn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_loaixe"
)
public class LoaiXe implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_loai_xe")
    private int idLoaiXe;
    @ColumnInfo(name = "ten_loai_xe")
    private String tenLoaiXe;
    @ColumnInfo(name = "so_luong_ghe")
    private int soLuongGhe;
    public LoaiXe(){

    }
    @Ignore
    public LoaiXe( String tenLoaiXe, int soLuongGhe) {

        this.tenLoaiXe = tenLoaiXe;
        this.soLuongGhe = soLuongGhe;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public int getId() {
        return idLoaiXe;
    }
}
