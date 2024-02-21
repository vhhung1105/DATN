package com.example.datn.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.datn.BR;
import com.example.datn.config.AppDatabase;
import com.example.datn.config.DataLocalManager;
import com.example.datn.model.DAO.QuyenDAO;
import com.example.datn.model.DAO.ThanhVienDAO;
import com.example.datn.model.ThanhVien;

public class LoginViewModel extends BaseObservable {
    private String tenDangNhap;
    private String password;
    private int quyenHienTai;
    private boolean check = false;
    private boolean checkNull = false;

    public void handleLogin(Context context){
        if(kiemTraNhap(tenDangNhap,password)==false){
            Toast.makeText(context,"Vui lòng nhập dữ liệu",Toast.LENGTH_SHORT).show();
            return;
        }
        ThanhVienDAO thanhVienDAO = AppDatabase.getInstance(context).getThanhVienDAO();
        ThanhVien thanhVien = thanhVienDAO.getThanhVienByUserName(tenDangNhap);
        QuyenDAO quyenDao = AppDatabase.getInstance(context).getQuyenDAO();
        if(thanhVien != null){
            if(tenDangNhap.equals(thanhVien.getTenDangNhap())) {
                DataLocalManager.setNameUser(tenDangNhap);
                String select_password = thanhVien.getMatKhau();
                if (password.equals(select_password)) {
                    quyenHienTai = thanhVienDAO.getQuyenByUserName(thanhVien.getTenDangNhap());
                    String tenQuyen = quyenDao.chuyenDoiQuyenThanhVien(quyenHienTai);
                    DataLocalManager.setNameRole(tenQuyen);
                    DataLocalManager.setIdRole(quyenHienTai);
                    DataLocalManager.setIsLogin(true);
                    check = true;
                    return;
                } else {
                    Toast.makeText(context, "Kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }else{
            Toast.makeText(context, "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
            checkNull = true;
        }
    }
    // Ẩn hiện mật khẩu
    public boolean showPass(EditText editText) {
        if (editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
            // Nếu đang ẩn mật khẩu, hiển thị văn bản
            editText.setTransformationMethod(null);
            editText.setSelection(editText.getText().length());//Di chuyển con trỏ về cuối dòng
            return true;
        } else {
            // Nếu đang hiển thị văn bản, ẩn mật khẩu
            editText.setTransformationMethod(new PasswordTransformationMethod());
            editText.setSelection(editText.getText().length());//Di chuyển con trỏ về cuối dòng
            return false;
        }

    }



    //Kiểm tra nhập
    public boolean kiemTraNhap( String tenDangNhap, String password) {
        //Tên đăng nhập và mật khẩu trống
        if (TextUtils.isEmpty(tenDangNhap) || TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    @Bindable
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
        notifyPropertyChanged(BR.tenDangNhap);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    @Bindable
    public Integer getQuyenHienTai() {
        return quyenHienTai;
    }

    public void setQuyenHienTai(Integer quyenHienTai) {
        this.quyenHienTai = quyenHienTai;
        notifyPropertyChanged(BR.quyenHienTai);
    }
    @Bindable
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }

    public boolean isCheckNull() {
        return checkNull;
    }

    public void setCheckNull(boolean checkNull) {
        this.checkNull = checkNull;
    }
}
