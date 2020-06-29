package com.unicomg.sharedtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.michaldrabik.classicmaterialtimepicker.CmtpTimeDialogFragment;
import com.michaldrabik.classicmaterialtimepicker.OnTime24PickedListener;
import com.michaldrabik.classicmaterialtimepicker.model.CmtpTime24;


public class MainActivity extends AppCompatActivity {
    private CmtpTimeDialogFragment timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveBtn = findViewById(R.id.saveBtn);
        timePicker = CmtpTimeDialogFragment.newInstance();
        timePicker.setInitialTime24(11, 30);
        timePicker.START_HOUR = 9;
        timePicker.END_HOUR = 14;
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.show(getSupportFragmentManager(), "Tag");
            }
        });
        timePicker.setOnTime24PickedListener(new OnTime24PickedListener() {
            @Override
            public void onTimePicked(@NonNull CmtpTime24 time) {
                Toast.makeText(MainActivity.this, String.valueOf(time.getHour()+" _ "+time.getMinute()), Toast.LENGTH_SHORT).show();
            }
        });

    }


}