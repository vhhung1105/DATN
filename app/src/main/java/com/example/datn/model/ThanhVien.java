package com.example.datn.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_thanhvien"
        ,foreignKeys = @ForeignKey(entity = Quyen.class, parentColumns = "id_quyen", childColumns = "id_quyen"),
        indices = {@Index(name = "index_id_quyen", value = "id_quyen")}
)
public class ThanhVien implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_thanh_vien")
    private int id;
    @ColumnInfo(name = "ten_dang_nhap")
    @NonNull
    private String tenDangNhap;
    @ColumnInfo(name = "ho_thanh_vien")
    private String ho;
    @ColumnInfo(name = "ten_thanh_vien")
    private String ten;
    @ColumnInfo(name = "mat_khau")
    @NonNull
    private String matKhau;
    private String avatar;
    @ColumnInfo(name = "id_quyen")
    private int idQuyenThanhVien;
    @ColumnInfo(name = "ngay_sinh")
    private String ngaySinh;
    private String email;
    @ColumnInfo(name = "so_dien_thoai")
    private String soDienThoai;
    @ColumnInfo(name = "ngay_tao")
    private String ngayTao;
    @ColumnInfo(name = "ngay_cap_nhat")
    private String ngayCapNhat;

    public ThanhVien(){

    }

    @Ignore
    public ThanhVien( String tenDangNhap, String ho, String ten, String matKhau, String avatar, int idQuyenThanhVien, String email, String soDienThoai, String ngayTao, String ngayCapNhat) {

        this.tenDangNhap = tenDangNhap;
        this.ho = ho;
        this.ten = ten;
        this.matKhau = matKhau;
        this.avatar = avatar;
        this.idQuyenThanhVien = idQuyenThanhVien;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }
    @Ignore
    public ThanhVien( String tenDangNhap, String ho, String ten, String avatar,  String email, String soDienThoai) {

        this.tenDangNhap = tenDangNhap;
        this.ho = ho;
        this.ten = ten;
        this.avatar = avatar;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }
    @Ignore
    public ThanhVien(String tenDangNhap){
        this.tenDangNhap = tenDangNhap;
    }
    @Ignore
    public ThanhVien(String tenDangNhap,String email){
        this.tenDangNhap = tenDangNhap;
        this.email = email;
    }



    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public int getIdQuyenThanhVien() {
        return idQuyenThanhVien;
    }

    public void setIdQuyenThanhVien(int idQuyenThanhVien) {
        this.idQuyenThanhVien = idQuyenThanhVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getHoTen() {
        if (ho == null && ten == null) {
            return "Ẩn Danh";
        } else if (ho == null) {
            return ten;
        } else if (ten == null) {
            return ho;
        } else {
            return ho + " " + ten;
        }
    }

    // Setter để thiết lập "Ẩn Danh" nếu họ và tên đều trống
    public void setHoTen(String ho, String ten) {
        if (ho == null && ten == null) {
            this.ho = "Ẩn Danh";
            this.ten = null;
        } else {
            this.ho = ho;
            this.ten = ten;
        }
    }
}
