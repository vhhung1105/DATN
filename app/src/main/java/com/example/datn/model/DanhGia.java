package com.example.datn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_danh_gia",
        foreignKeys = {
                @ForeignKey(entity = ThanhVien.class, parentColumns = "id_thanh_vien", childColumns = "id_thanh_vien"),
                @ForeignKey(entity = ChuyenXe.class, parentColumns = "id_chuyen_xe", childColumns = "id_chuyen_xe")
        }
        ,indices = {
        @Index(name = "index_id_thanh_vien_danh_gia", value = "id_thanh_vien"),
        @Index(name = "index_id_chuyen_xe_danh_gia", value = "id_chuyen_xe")
})
public class DanhGia {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_danh_gia")
        private int idDanhGia;
        @ColumnInfo(name = "id_thanh_vien")
        private int idThanhVienDanhGia;
        @ColumnInfo(name = "id_chuyen_xe")
        private int idChuyenXeDanhGia;
        @ColumnInfo(name = "diem_danh_gia")
        private int diemDanhGia;
        @ColumnInfo(name = "nhan_xet")
        private String nhanXet;
        @ColumnInfo(name = "thoi_gian_danh_gia")
        private String thoiGianDanhGia;
        public DanhGia(){

        }
        @Ignore
        public DanhGia(int idThanhVienDanhGia, int idChuyenXeDanhGia, int diemDanhGia, String nhanXet, String thoiGianDanhGia) {

        this.idThanhVienDanhGia = idThanhVienDanhGia;
        this.idChuyenXeDanhGia = idChuyenXeDanhGia;
        this.diemDanhGia = diemDanhGia;
        this.nhanXet = nhanXet;
        this.thoiGianDanhGia = thoiGianDanhGia;
        }

// Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

public String getThoiGianDanhGia() {
        return thoiGianDanhGia;
        }

public void setThoiGianDanhGia(String thoiGianDanhGia) {
        this.thoiGianDanhGia = thoiGianDanhGia;
        }

public int getIdDanhGia() {
        return idDanhGia;
        }

public void setIdDanhGia(int idDanhGia) {
        this.idDanhGia = idDanhGia;
        }

public int getIdThanhVienDanhGia() {
        return idThanhVienDanhGia;
        }

public void setIdThanhVienDanhGia(int idThanhVienDanhGia) {
        this.idThanhVienDanhGia = idThanhVienDanhGia;
        }

public int getIdChuyenXeDanhGia() {
        return idChuyenXeDanhGia;
        }

public void setIdChuyenXeDanhGia(int idChuyenXeDanhGia) {
        this.idChuyenXeDanhGia = idChuyenXeDanhGia;
        }

public int getDiemDanhGia() {
        return diemDanhGia;
        }

public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
        }

public String getNhanXet() {
        return nhanXet;
        }

public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
        }
}
