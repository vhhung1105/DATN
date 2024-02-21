package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.datn.model.ChuyenXe;

import java.util.List;
@Dao
public interface ChuyenXeDAO {
    @Insert
    void insert(ChuyenXe... chuyenXe);
    @Delete
    void delete(ChuyenXe chuyenXe);
    @Update
    void updateChuyenXe(ChuyenXe chuyenXe);

    @Query("select ten_chuyen from table_chuyenxe where id_chuyen_xe = :id")
    String getTenChuyenById(int id);
    @Query("select gia_tien from table_chuyenxe where id_chuyen_xe = :id")
    double getGiaVeById(int id);

    @Query("select * from table_chuyenxe")
    List<ChuyenXe> getAll();

    @Query("select dia_diem_di from table_chuyenxe")
    List<String> getListDiaDiemDi();

    @Query("select dia_diem_den from table_chuyenxe")
    List<String> getListDiaDiemDen();
    @Query("select * from table_chuyenxe " +
            "where (:diaDiemDi is null or dia_diem_di = :diaDiemDi)" +
            "and (:diaDiemDen is null or dia_diem_den = :diaDiemDen)"+
            "and (:idLoaiXe = -1 or id_loai_xe = :idLoaiXe)"+
            "and (:gioDi is null or thoi_gian_bat_dau like '%' || :gioDi || '%')"+
            "order by thoi_gian_bat_dau")
    List<ChuyenXe> filterChuyenXe(String diaDiemDi, String diaDiemDen, int idLoaiXe,String gioDi);

    @Query("select * from table_chuyenxe where id_chuyen_xe = :id")
    ChuyenXe getChuyenXeById(int id);
}
