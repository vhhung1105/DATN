package com.example.datn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "table_chuyenxe",
        foreignKeys = {
                @ForeignKey(entity = LoaiXe.class, parentColumns = "id_loai_xe", childColumns = "id_loai_xe")
        },
        indices = {
                @Index(name = "index_id_loai_xe", value = "id_loai_xe")
        }
)
public class ChuyenXe implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_chuyen_xe")
    private int idChuyenXe;
    @ColumnInfo(name = "id_loai_xe")
    private int idLoaiXe;
    @ColumnInfo(name = "ten_chuyen")
    private String tenChuyen;
    @ColumnInfo(name = "hinh_anh")
    private String hinhAnh;
    @ColumnInfo(name = "thoi_gian_bat_dau")
    private String thoiGianBatDau;
    @ColumnInfo(name = "thoi_gian_ket_thuc")
    private String thoiGianKetThuc;
    @ColumnInfo(name = "dia_diem_di")
    private String diaDiemDi;
    @ColumnInfo(name = "dia_diem_den")
    private String diaDiemDen;
    @ColumnInfo(name = "gia_tien")
    private Double giaTien;
    @ColumnInfo(name = "mo_ta")
    private  String moTa;
    public ChuyenXe(){

    }
    @Ignore
    public ChuyenXe( String tenChuyen, String hinhAnh, String thoiGianBatDau, String thoiGianKetThuc, String diaDiemDi, String diaDiemDen,Double giaTien,String moTa) {

        this.tenChuyen = tenChuyen;
        this.hinhAnh = hinhAnh;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
        this.giaTien = giaTien;
        this.moTa = moTa;
    }
    public ChuyenXe(String tenChuyen,String diaDiemDi, String diaDiemDen,String thoiGianBatDau,String thoiGianKetThuc){
        this.tenChuyen = tenChuyen;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }
    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public String getTenChuyen() {
        return tenChuyen;
    }

    public void setTenChuyen(String tenChuyen) {
        this.tenChuyen = tenChuyen;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getDiaDiemDi() {
        return diaDiemDi;
    }

    public void setDiaDiemDi(String diaDiemDi) {
        this.diaDiemDi = diaDiemDi;
    }

    public String getDiaDiemDen() {
        return diaDiemDen;
    }

    public void setDiaDiemDen(String diaDiemDen) {
        this.diaDiemDen = diaDiemDen;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }



    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChuyenXe)) return false;
        ChuyenXe chuyenXe = (ChuyenXe) o;
        return getIdLoaiXe() == chuyenXe.getIdLoaiXe() && getThoiGianBatDau().equals(chuyenXe.getThoiGianBatDau()) && getDiaDiemDi().equals(chuyenXe.getDiaDiemDi()) && getDiaDiemDen().equals(chuyenXe.getDiaDiemDen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLoaiXe(), getThoiGianBatDau(), getDiaDiemDi(), getDiaDiemDen());
    }
}
