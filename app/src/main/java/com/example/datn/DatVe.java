package com.example.datn;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.net.ParseException;
import android.os.Bundle;

import com.example.datn.config.FunctionPublic;
import com.example.datn.model.ChuyenXe;
import com.example.datn.viewmodel.DatVeViewModel;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.datn.databinding.ActivityDatVeBinding;

import java.util.Calendar;

public class DatVe extends AppCompatActivity {
    private ActivityDatVeBinding activityDatVeBinding;
    DatVeViewModel datVeViewModel = new DatVeViewModel();

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        activityDatVeBinding = DataBindingUtil.setContentView(this, R.layout.activity_dat_ve);
        activityDatVeBinding.setDatVeViewModel(datVeViewModel);
        if (getIntent() != null) {
            ChuyenXe chuyenXe = (ChuyenXe) getIntent().getExtras().getSerializable("chuyen_xe");
            datVeViewModel.xuLyThongTin(chuyenXe, getApplicationContext());
            activityDatVeBinding.xacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showAlert(chuyenXe);
                }
            });
            ArrayAdapter<Integer> listSoLuongVe = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, datVeViewModel.setSpinner(getBaseContext(), chuyenXe));
            activityDatVeBinding.soLuongVe.setAdapter(listSoLuongVe);
            activityDatVeBinding.soLuongVe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    datVeViewModel.setSoLuongVe(String.valueOf(i + 1));
                    double tongTien = FunctionPublic.tinhTongTien(Integer.parseInt(datVeViewModel.getSoLuongVe()), chuyenXe.getGiaTien());
                    datVeViewModel.setTongTien(FunctionPublic.formatMoney(tongTien));
                }

                public void onNoThingSelected(AdapterView<?> adapterView) {

                }
            });

        }
        activityDatVeBinding.edtNgayDi.setOnClickListener(view -> {
            showDatePickerDialog();
                }
        );
        activityDatVeBinding.khuHoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    activityDatVeBinding.edtNgayVe.setVisibility(View.VISIBLE);
                } else {
                    activityDatVeBinding.edtNgayVe.setVisibility(View.GONE);
                }
            }
        });
        activityDatVeBinding.edtNgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    showNgayVePickerDialog();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatVe.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datVeViewModel.setSelectedCalendarDi(Calendar.getInstance());
                        // Xử lý ngày được chọn bởi người dùng ở đây
                        datVeViewModel.getSelectedCalendarDi().set(year, month, dayOfMonth);
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        // Hiển thị ngày đã chọn trong TextView
                        datVeViewModel.setNgayDi(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth

        );
        if (datVeViewModel.getNgayDi() != null && !datVeViewModel.getNgayDi().isEmpty()){
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            datePickerDialog.show();
        }
        else {
            Toast.makeText(this,"Vui long chon ngay di",Toast.LENGTH_SHORT).show();
        }

    }
    public void showNgayVePickerDialog() throws ParseException{
        // Lấy ngày hiện tại để hiển thị trong DatePicker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Giới hạn ngày tối đa là ngày hiện tại
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatVe.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Xử lý ngày được chọn bởi người dùng ở đây
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        // Hiển thị ngày đã chọn trong TextView
                        datVeViewModel.setNgayVe(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );

        if (datVeViewModel.getNgayDi() != null && !datVeViewModel.getNgayDi().isEmpty()){
            //Giới hạn DatePickerDialog không cho phép chọn các ngày trước ngày hôm nay
            datePickerDialog.getDatePicker().setMinDate(datVeViewModel.getSelectedCalendarDi().getTimeInMillis());
            // Hiển thị DatePickerDialog
            datePickerDialog.show();
        }
        else {
            Toast.makeText(this, "Vui lòng chọn ngày đi" , Toast.LENGTH_SHORT).show();
        }


    }
    public void showAlert(ChuyenXe chuyenXe){
        String thongTinLuongDi = "";
        String thongTinLuongVe = "";
        if (datVeViewModel.getNgayDi()==null){
            thongTinLuongDi = "Thong tin luot di: \nChua dat ngay di";
        }else {
            thongTinLuongDi = "Thong tin luot di \nTen chuyen xe: " +chuyenXe.getTenChuyen()+
                    "\nĐịa điểm đi: " + chuyenXe.getDiaDiemDi() + "\nĐịa điểm đến: " + chuyenXe.getDiaDiemDen() +
                    "\nNgày đi: " + datVeViewModel.getNgayDi() + "\nGiờ bắt đầu: " + chuyenXe.getThoiGianBatDau()+
                    "\nSố lượng vé: " + datVeViewModel.getSoLuongVe() + "\nTổng tiền: " + datVeViewModel.getTongTien();
        }
        if (datVeViewModel.getNgayVe()==null){
            thongTinLuongVe = "\n\n\nKhông có khứ hồi";
        }
        else {
            thongTinLuongVe= "\n\n\nThông tin lượt về \nTên chuyến xe: " + chuyenXe.getTenChuyen() +
                    "\nĐịa điểm đi: " + chuyenXe.getDiaDiemDen() + "\nĐịa điểm đến: " + chuyenXe.getDiaDiemDi() +
                    "\nNgày đi: " + datVeViewModel.getNgayDi() + "\nGiờ bắt đầu: " + chuyenXe.getThoiGianKetThuc()+
                    "\nSố lượng vé: " + datVeViewModel.getSoLuongVe() + "\nTổng tiền: " + datVeViewModel.getTongTien();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(DatVe.this);
        builder.setTitle("Xac nhan thong tin");
        builder.setPositiveButton("Xac nhan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (datVeViewModel.getNgayDi() == null){
                    Toast.makeText(DatVe.this,"Vui long nhap thong tin ve",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
                else {
                    datVeViewModel.LuuDatVe(getApplicationContext(),chuyenXe);
                    Toast.makeText(DatVe.this,"Dat ve thanh cong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Thoat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
