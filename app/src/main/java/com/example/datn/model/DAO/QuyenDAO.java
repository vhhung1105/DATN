package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.datn.model.Quyen;

import java.util.List;
@Dao
public interface QuyenDAO {
    @Query("SELECT ten_quyen FROM table_quyen WHERE id_quyen = :id")
    String chuyenDoiQuyenThanhVien(int id);

    @Insert
    void insert(Quyen... quyen);
    @Query("select * from table_quyen")
    List<Quyen> getAll();

    @Query("select ten_quyen from table_quyen")
    List<String> getTenQuyen();

    @Query("select id_quyen from table_quyen where ten_quyen = :tenQuyen")
    int getIdQuyen(String tenQuyen);
}
