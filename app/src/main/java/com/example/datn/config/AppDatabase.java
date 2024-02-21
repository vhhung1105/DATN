package com.example.datn.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.datn.model.ChuyenXe;
import com.example.datn.model.DAO.ChuyenXeDAO;
import com.example.datn.model.DAO.DanhGiaDAO;
import com.example.datn.model.DAO.DatVeDAO;
import com.example.datn.model.DAO.LoaiXeDAO;
import com.example.datn.model.DAO.QuyenDAO;
import com.example.datn.model.DAO.ThanhVienDAO;
import com.example.datn.model.DAO.TrangThaiDAO;
import com.example.datn.model.DanhGia;
import com.example.datn.model.DatVe;
import com.example.datn.model.LoaiXe;
import com.example.datn.model.Quyen;
import com.example.datn.model.ThanhVien;
import com.example.datn.model.TrangThai;

@Database(version = 1,
        entities = {
                ThanhVien.class,
                Quyen.class,
                ChuyenXe.class,
                LoaiXe.class,
                DanhGia.class,
                DatVe.class,
                TrangThai.class,
        }
        , exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
        public abstract ThanhVienDAO getThanhVienDAO();
        public abstract QuyenDAO getQuyenDAO();
        public abstract ChuyenXeDAO getChuyenXeDAO();
        public abstract LoaiXeDAO getLoaiXeDAO();
        public abstract DanhGiaDAO getDanhGiaDAO();
        public abstract DatVeDAO getVeXeDAO();
        public abstract TrangThaiDAO getTrangThaiDAO();
        private static AppDatabase instance;
        public static AppDatabase getInstance(Context context) {
                if (instance == null) {
                        instance = Room.databaseBuilder(context.getApplicationContext(),
                                        AppDatabase.class, "datn.db")
                                .allowMainThreadQueries()
                                .build();
                }
                return instance;
        }
}
