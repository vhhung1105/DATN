package com.example.datn.config;

import java.text.SimpleDateFormat;

public class VariableGlobal {
    public static final String PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    public static final String TABLE_QUYEN = "table_quyen";
    public static final String TABLE_THANHVIEN = "table_thanhvien";
    public static final String TABLE_LOAIXE = "table_loaixe";
    public static final String TABLE_CHUYENXE = "table_chuyenxe";
    public static final String TABLE_VEXE = "table_vexe";
    public static final String TABLE_DANHGIA = "table_danhgia";

    // Tạo các hằng số cho tên cột
    public static final String COLUMN_ID_QUYEN = "id_quyen";
    public static final String COLUMN_TEN_QUYEN = "ten_quyen";

    public static final String COLUMN_ID_THANHVIEN = "id_thanh_vien";
    public static final String COLUMN_TEN_DANG_NHAP = "ten_dang_nhap";
    public static final String COLUMN_HO = "ho_thanh_vien";
    public static final String COLUMN_TEN = "ten_thanh_vien";
    public static final String COLUMN_MAT_KHAU = "mat_khau";
    public static final String COLUMN_AVATAR = "avatar";
    public static final String COLUMN_ID_QUYEN_THANHVIEN = "id_quyen";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SO_DIEN_THOAI = "so_dien_thoai";
    public static final String COLUMN_NGAY_TAO = "ngay_tao";
    public static final String COLUMN_NGAY_CAP_NHAT = "ngay_cap_nhat";

    public static final String COLUMN_ID_LOAIXE = "id_loai_xe";
    public static final String COLUMN_TEN_LOAIXE = "ten_loai_xe";
    public static final String COLUMN_SO_LUONG_GHE = "so_luong_ghe";

    public static final String COLUMN_ID_CHUYENXE = "id_chuyen_xe";
    public static final String COLUMN_TEN_CHUYEN = "ten_chuyen";
    public static final String COLUMN_HINH_ANH = "hinh_anh";
    public static final String COLUMN_THOI_GIAN_BAT_DAU = "thoi_gian_bat_dau";
    public static final String COLUMN_DIA_DIEM_DI = "dia_diem_di";
    public static final String COLUMN_DIA_DIEM_DEN = "dia_diem_den";
    public static final String COLUMN_GIA_TIEN = "gia_tien";
    public static final String COLUMN_MO_TA = "mo_ta";

    public static final String COLUMN_ID_VEXE = "id_ve_xe";
    public static final String COLUMN_ID_THANHVIEN_VEXE = "id_thanh_vien";
    public static final String COLUMN_ID_LOAIXE_VEXE = "id_loai_xe";
    public static final String COLUMN_ID_CHUYENXE_VEXE = "id_chuyen_xe";
    public static final String COLUMN_NGAY_GIO_DAT = "ngay_gio_dat";
    public static final String COLUMN_THONG_TIN_KHAC = "thong_tin_khac";

    public static final String COLUMN_ID_DANHGIA = "id_danh_gia";
    public static final String COLUMN_ID_THANHVIEN_DANHGIA = "id_thanh_vien";
    public static final String COLUMN_ID_CHUYENXE_DANHGIA = "id_chuyen_xe";
    public static final String COLUMN_DIEM_DANH_GIA = "diem_danh_gia";
    public static final String COLUMN_NHAN_XET = "nhan_xet";
}
