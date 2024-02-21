package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.datn.model.DatVe;

import java.util.List;
@Dao
public interface DatVeDAO {
    @Insert
    void insert(DatVe... veXes);
    @Query("select * from table_dat_ve")
    List<DatVe> getAll();
    @Query("select * from table_dat_ve where id_ve_xe = :id")
    DatVe getDatVeById(String id);
    @Query("select * from table_dat_ve where id_thanh_vien = :id")
    List<DatVe> getVeXeById(int id);
    @Query("select * from table_dat_ve where id_chuyen_xe = :id")
    List<DatVe> getVeByIdChuyenXe(int id);
    @Update
    void update(DatVe datVe);
    @Delete
    void delete(DatVe datVe);
    @Query("select sum(so_luong_ve) from table_dat_ve where id_chuyen_xe = :id group by id_chuyen_xe")
    int tongSoLuongVe(int id);
    @Query("select sum(so_luong_ve) from table_dat_ve where id_thanh_vien = :id group by id_thanh_vien")
    int tongSoLuongVeTheoNguoiDung(int id);
}
