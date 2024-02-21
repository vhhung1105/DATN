package com.example.datn.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.datn.model.DanhGia;

import java.util.List;
@Dao
public interface DanhGiaDAO {
    @Insert
    void insert(DanhGia... danhGias);

    @Query("select * from table_danh_gia")
    List<DanhGia> getAll();

    @Query("SELECT * FROM table_danh_gia WHERE id_chuyen_xe = :idChuyenXe ORDER BY id_danh_gia DESC")
    List<DanhGia> layDanhSachDanhGiaTheoChuyenXe(int idChuyenXe);

    // Phương thức tính điểm đánh giá trung bình cho một chuyến xe dựa vào id_chuyen_xe
    @Query("SELECT AVG(diem_danh_gia) FROM table_danh_gia WHERE id_chuyen_xe = :idChuyenXe")
    double tinhDiemDanhGiaTrungBinhTheoChuyenXe(int idChuyenXe);
}
