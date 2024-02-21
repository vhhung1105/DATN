package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.datn.model.TrangThai;

import java.util.List;
@Dao
public interface TrangThaiDAO {
    @Insert
    void insert(TrangThai... trangThais);

    @Query("select ten_trang_thai from table_trang_thai where id_trang_thai = :id ")
    String getTenTrangThaiById(int id);

    @Query("select * from table_trang_thai")
    List<TrangThai> getAll();
    @Query("select ten_trang_thai from table_trang_thai")
    List<String> getListTenTrangThai();
}
