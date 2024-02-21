package com.example.datn.config;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static final String USER_NAME = "USER_NAME";
    private static final String ROLE_NAME = "ROLE_NAME";
    private static final String ID_ROLE = "ID_ROLE";
    private static final String IS_LOGIN = "IS_LOGIN";
    private static final String SO_LUONG_VE_DA_TAO = "SO_LUONG_VE_DA_TAO";
    private static final String CHECK_SO_LUONG_VE_DA_TAO = "CHECK_SO_LUONG_VE_DA_TAO";
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);
    }
    public static DataLocalManager getInstance(){
        if (instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }



    public static void setIsLogin(boolean isLogin){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(IS_LOGIN,isLogin);
    }

    public static boolean getIsLogin(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(IS_LOGIN);
    }

    public static void setIsFirst(boolean isFirst){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(PREF_FIRST_INSTALL,isFirst);
    }

    public static boolean getIsFirst(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }
    public static void setIsSoLuongVeDaTao(boolean is){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(CHECK_SO_LUONG_VE_DA_TAO,is);
    }

    public static boolean getIsSoLuongVeDaTao(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(CHECK_SO_LUONG_VE_DA_TAO);
    }
    public static void setNameUser(String name){
        DataLocalManager.getInstance().mySharePreferences.putStringValue(USER_NAME,name);

    }
    public static String getNameUser(){
        return DataLocalManager.getInstance().mySharePreferences.getStringValue(USER_NAME);

    }

    public static void setNameRole(String name){
        DataLocalManager.getInstance().mySharePreferences.putStringValue(ROLE_NAME,name);

    }
    public static String getNameRole(){
        return DataLocalManager.getInstance().mySharePreferences.getStringValue(ROLE_NAME);

    }
    public static void setIdRole(int id){
        DataLocalManager.getInstance().mySharePreferences.putIntValue(ID_ROLE,id);

    }
    public static int getIdRole(){
        return DataLocalManager.getInstance().mySharePreferences.getIntValue(ID_ROLE);

    }

    public static void setSoLuongVeDaTao(int id){
        DataLocalManager.getInstance().mySharePreferences.putIntValue(SO_LUONG_VE_DA_TAO,id);

    }
    public static int getSoLuongVeDaTao(){
        return DataLocalManager.getInstance().mySharePreferences.getIntValue(SO_LUONG_VE_DA_TAO);

    }
}
