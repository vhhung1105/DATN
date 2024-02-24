package com.example.datn.viewmodel;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.datn.config.AppDatabase;
import com.example.datn.config.FunctionPublic;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.datn.BR;
import com.example.datn.config.VariableGlobal;
import com.example.datn.model.DAO.ThanhVienDAO;
import com.example.datn.model.ThanhVien;
import com.example.datn.view.Login;

import java.util.Date;

public class SignupViewModel extends BaseObservable {
private String tenDangNhap;
private String ho;
private String ten;
private String soDienThoai;
private String email;
private String password;
private String passwordAgain;
private Boolean dieuKhoan;

public void handleSignup(Context context){
    if(showRowEmpty().length() > 0 ){
        Toast.makeText(context, showRowEmpty(), Toast.LENGTH_LONG).show();
        return;
    }
    if (!FunctionPublic.isTenDangNhapValid(tenDangNhap)){
        Toast.makeText(context, "Tên đăng nhập sai định dạng, hãy viết liền không dấu", Toast.LENGTH_LONG).show();
        return;
    }

    if (!FunctionPublic.isEmailValid(email)){
        Toast.makeText(context, "Email sai định dạng, example@gmail.com", Toast.LENGTH_LONG).show();
        return;
    }

    if (!FunctionPublic.isPasswordValid(password)){
        Toast.makeText(context, "Độ dài mật khẩu phải lớn hơn hoặc bằng 5 ký tự", Toast.LENGTH_LONG).show();
        return;
    }

    if (!isPasswordAgainValid(passwordAgain)){
        Toast.makeText(context, "Nhập lại mật khẩu phải giống", Toast.LENGTH_LONG).show();
        return;
    }

    if(!dieuKhoan){
        Toast.makeText(context, "Vui lòng chấp nhận điều khoản", Toast.LENGTH_LONG).show();
        return;
    }

    ThanhVien thanhVien = new ThanhVien(tenDangNhap, ho, ten,password,null,3,email,soDienThoai, null,null);
    ThanhVienDAO appDatabase = AppDatabase.getInstance(context).getThanhVienDAO();

    if (appDatabase.isThanhVienExist(thanhVien.getTenDangNhap(), thanhVien.getEmail(), thanhVien.getSoDienThoai())){
        Toast.makeText(context, "Người dùng đã tồn tại, vui lòng kiểm tra lại: tên đăng nhập, số điện thoại, email", Toast.LENGTH_LONG).show();
        return;
    }
    Date date = new Date();
    thanhVien.setNgayTao(VariableGlobal.dateFormat.format(date));
    thanhVien.setNgayCapNhat(VariableGlobal.dateFormat.format(date));

    appDatabase.insertAll(thanhVien);
    Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_LONG).show();
    Intent newActivityIntent = new Intent(context, Login.class);
    newActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(newActivityIntent);
}



    private boolean isPasswordAgainValid(String passwordAgain){
        if (password.equals(passwordAgain)){
            return true;
        }
        else {
            return false;
        }
    }

    public String showRowEmpty(){
        String result = "";
        if (TextUtils.isEmpty(tenDangNhap)){
            result = noiChuoi("tên đăng nhập");
            return result;
        } else if (TextUtils.isEmpty(ten)){
            result = noiChuoi("tên");
            return result;
        } else if (TextUtils.isEmpty(ho)){
            result = noiChuoi("họ");
            return result;
        } else if (TextUtils.isEmpty(soDienThoai)){
            result = noiChuoi("số điện thoại");
            return result;
        } else if (TextUtils.isEmpty(email)){
            result = noiChuoi("email");
            return result;
        } else if (TextUtils.isEmpty(password)){
            result = noiChuoi("mật khẩu");
            return result;
        } else if (TextUtils.isEmpty(passwordAgain)){
            result = noiChuoi("mật khẩu nhập lại");
            return result;
        }else {
            return "";
        }
    }



    public String noiChuoi(String chuoi){
        return "Không được bỏ trống ô " + chuoi;
    }

    @Bindable
    public boolean isDieuKhoan() {
        return dieuKhoan;
    }

    public void setDieuKhoan(boolean dieuKhoan) {
        this.dieuKhoan = dieuKhoan;
        notifyPropertyChanged(BR.dieuKhoan);
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
    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
        notifyPropertyChanged(BR.ho);

    }

    @Bindable
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
        notifyPropertyChanged(BR.ten);
    }

    @Bindable
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
        notifyPropertyChanged(BR.soDienThoai);

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

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
    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
        notifyPropertyChanged(BR.passwordAgain);

}
}
