package com.example.datn.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.datn.R;
import com.example.datn.databinding.ActivityMainBinding;
import com.example.datn.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    MainViewModel mainViewModel = new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMainViewModel(mainViewModel);


        mainViewModel.checkLogin(getApplicationContext());
        activityMainBinding.buttonLoginHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Login activity
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }


        });


        activityMainBinding.buttonSignupHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Login activity
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}