package com.example.datn.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

import com.example.datn.R;
import com.example.datn.databinding.ActivitySignUpBinding;
import com.example.datn.viewmodel.SignupViewModel;



public class SignupActivity extends AppCompatActivity {
   ActivitySignUpBinding activitySignUpBinding;
    SignupViewModel signupViewModel = new SignupViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        activitySignUpBinding.setSignupViewModel(signupViewModel);
        activitySignUpBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signupViewModel.handleSignup(getApplicationContext());

            }
        });


        handleDeleteText();
        handleShowPassword();
    }

    private void handleShowPassword() {
        activitySignUpBinding.imgShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPass(activitySignUpBinding.txtPassword);
            }
        });
        activitySignUpBinding.imgShowPasswordAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPass(activitySignUpBinding.txtPasswordAgain);
            }
        });
    }

    private boolean showPass(EditText editText) {
        if (editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
            // Nếu đang ẩn mật khẩu, hiển thị văn bản
            editText.setTransformationMethod(null);
            return true;
        } else {
            // Nếu đang hiển thị văn bản, ẩn mật khẩu
            editText.setTransformationMethod(new PasswordTransformationMethod());
            return false;
        }
    }



    private void handleDeleteText(){
        activitySignUpBinding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignUpBinding.txtUserName);
            }
        });
        activitySignUpBinding.deleteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignUpBinding.txtName);
            }
        });
        activitySignUpBinding.deleteLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignUpBinding.txtLastName);
            }
        });
        activitySignUpBinding.deleteNumberPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignUpBinding.txtPhoneNumber);
            }
        });
        activitySignUpBinding.deleteEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignUpBinding.txtEmail);
            }
        });
    }
    private void deleteText(EditText view){
        view.setText("");
    }


}