package com.example.datn.config;
public class SoLuongVeDaTaoSingleton {
    private static SoLuongVeDaTaoSingleton instance;
    private int soLuongVeDaTao;

    private SoLuongVeDaTaoSingleton() {
        if (!DataLocalManager.getIsSoLuongVeDaTao()){
            soLuongVeDaTao  = 1;
            // Khởi tạo giá trị ban đầu cho soLuongVeDaTao, có thể lấy từ cơ sở dữ liệu hoặc tập tin
            DataLocalManager.setSoLuongVeDaTao(soLuongVeDaTao);
            DataLocalManager.setIsSoLuongVeDaTao(true);
        }
        else {
            soLuongVeDaTao = DataLocalManager.getSoLuongVeDaTao();
        }

    }

    public static SoLuongVeDaTaoSingleton getInstance() {
        if (instance == null) {
            instance = new SoLuongVeDaTaoSingleton();
        }
        return instance;
    }

    public int getSoLuongVeDaTao() {
        return soLuongVeDaTao;
    }

    public void tangSoLuongVeDaTao() {
        soLuongVeDaTao++;
        DataLocalManager.setSoLuongVeDaTao(soLuongVeDaTao);
        // Lưu giá trị mới vào cơ sở dữ liệu hoặc tập tin nếu cần thiết
    }
}
