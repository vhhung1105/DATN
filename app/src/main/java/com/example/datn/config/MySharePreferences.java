package com.example.datn.config;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    private static final String SHARE_PREFERENCE_DATVE = "SHARE_PREFERENCE_DATVE";
    private Context context;
    public MySharePreferences(Context context){
        this.context = context;
    }

    public void putBooleanValue(String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public void putStringValue(String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "String");
    }

    public void putIntValue(String key, int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_DATVE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 1);
    }
}
