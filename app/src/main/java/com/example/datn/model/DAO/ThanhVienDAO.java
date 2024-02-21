package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.datn.model.ThanhVien;

import java.util.List;
@Dao
public interface ThanhVienDAO {
    @Insert
    void insertAll(ThanhVien... thanhVien);

    @Delete
    void delete(ThanhVien thanhVien);

    @Update
    int updateThanhVien(ThanhVien thanhVien);

    @Update
    void update(ThanhVien thanhVien);

    @Query("select * from table_thanhvien")
    List<ThanhVien> getAll();

    @Query("select* from table_thanhvien where id_quyen = :id")
    List<ThanhVien> getThanhVienByIdQuyen(int id);

    @Query("SELECT EXISTS(SELECT 1 FROM table_thanhvien WHERE ten_dang_nhap = :tenDangNhap " +
            "OR email = :email OR so_dien_thoai = :soDienThoai)")
    boolean isThanhVienExist(String tenDangNhap, String email, String soDienThoai);

    @Query("SELECT id_quyen FROM table_thanhvien WHERE ten_dang_nhap = :tenDangNhap")
    int getQuyenByUserName(String tenDangNhap);

    @Query("SELECT * FROM table_thanhvien WHERE email = :inputEmail LIMIT 1")
    ThanhVien getThanhVienByEmail(String inputEmail);
    @Query("SELECT * FROM table_thanhvien WHERE ten_dang_nhap = :username LIMIT 1")
    ThanhVien getThanhVienByUserName(String username);

    @Query("SELECT * FROM table_thanhvien WHERE id_thanh_vien = :id LIMIT 1")
    ThanhVien getThanhVienById(int id);
}
