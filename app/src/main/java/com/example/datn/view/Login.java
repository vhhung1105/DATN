package com.example.datn.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.datn.R;
import com.example.datn.databinding.ActivityLoginBinding;
import com.example.datn.viewmodel.AdminManagerActivity;
import com.example.datn.viewmodel.LoginViewModel;
import com.example.datn.viewmodel.UserManagerActivity;
public class Login extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    LoginViewModel loginViewModel = new LoginViewModel();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
       activityLoginBinding.setLoginViewModel(loginViewModel);


        // Xử lí button đăng nhập
        activityLoginBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                loginViewModel.handleLogin(getApplicationContext());
                if(loginViewModel.isCheck()==true)
                    chuyenTrangTheoQuyen(loginViewModel.getQuyenHienTai());
                if(loginViewModel.isCheckNull()==true)
                    showDialogSignUp();
            }
        });

        //Xử lí click lên view đặt lại mật khẩu
        activityLoginBinding.textViewResetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, ResetPassword.class);
            startActivity(intent);
            finish();
        });

        //Xóa trống tên đăng nhập
        activityLoginBinding.imgClearUserName.setOnClickListener(v -> activityLoginBinding.txtUserName.setText(""));

        //Ẩn/Hiện mật khẩu
        activityLoginBinding.imgShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.showPass(activityLoginBinding.txtPassword);
            }
        });
        //Set filter
        activityLoginBinding.txtUserName.setFilters(new InputFilter[] {filter});
        activityLoginBinding.txtPassword.setFilters(new InputFilter[] {filter});
    }

    // Hộp thoại xác nhận đăng kí
    public void showDialogSignUp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn đăng ký tài khoản mới?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Chuyển hướng đến trang đăng ký tài khoản
                Intent intent = new Intent(Login.this, SignupActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("Hủy", null);
        builder.show();
    }


    public void chuyenTrangTheoQuyen(int quyen){
        if(quyen == 1 || quyen == 2){
            Intent intent = new Intent(Login.this, AdminManagerActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(Login.this, UserManagerActivity.class);
            startActivity(intent);
            finish();
        }
    }
    InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                char c = source.charAt(i);
                if (Character.isWhitespace(c) || c == ',' || c == '.') {
                    return "";
                }
            }
            return null;
        }
    };
}