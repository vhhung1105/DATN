package com.example.datn.config;

import android.content.Context;
import android.widget.ImageView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FunctionPublic {
    public static boolean isTenDangNhapValid(String tenDangNhap) {
        // Biểu thức chính quy kiểm tra viết liền không dấu
        String regex = "^[a-zA-Z0-9]+$";

        // Kiểm tra trường "tenDangNhap" với biểu thức chính quy
        return tenDangNhap.matches(regex);
    }

    public static boolean isEmailValid(String email) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Kiểm tra trường "email" với biểu thức chính quy
        return email.matches(regex);
    }

    public static boolean isPasswordValid(String password) {
        // Kiểm tra độ dài mật khẩu
        if (password.length() >= 5) {
            return true;
        } else {
            return false;
        }
    }



    public static String formatMoney(Double money){
        String moneyString = "";
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("#,###.##");
        moneyString = decimalFormat.format(money);
        moneyString += " VND";
        return moneyString;
    }

    public static String formatDouble(double so){
        String result = "";
        if (so >0){
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            result = decimalFormat.format(so);
        }
        else {
            result ="0";
        }

        return result;
    }

    public static double tinhTongTien(int soluongve, double giave){
        double result = soluongve * giave;
        return result;
    }
    public static Calendar convertStringToCalendar(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh'h'mm");
        try {
            Date date = sdf.parse(input);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
