package com.example.datn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_quyen")
public class Quyen {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_quyen")
        private int idQuyen;
        @ColumnInfo(name = "ten_quyen")
        private String tenQuyen;
        public Quyen(){

        }
        @Ignore
        public Quyen( String tenQuyen) {

        this.tenQuyen = tenQuyen;
        }

// Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

public int getIdQuyen() {
        return idQuyen;
        }

public void setIdQuyen(int idQuyen) {
        this.idQuyen = idQuyen;
        }

public String getTenQuyen() {
        return tenQuyen;
        }

public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
        }
}
