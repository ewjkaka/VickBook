package com.vickbook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;
import com.vickbook.R;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {


    boolean isCreate = true;
    RelativeLayout rlHeaderBar;
    CalendarPickerView cpvCalendar;
    TextView tvAddEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlHeaderBar = findViewById(R.id.rl_header_bar);
        cpvCalendar = findViewById(R.id.cpv_calendar);
        tvAddEvents = findViewById(R.id.tv_add_events);
    }

    @Override
    public void onResume() {
        super.onResume();
        // 如果是第一次进入界面，则执行create()方法
        isCreate = isCreate ? create() : isCreate;
    }

    /**
     * 模拟 onCreate() 方法
     *
     * @return
     */
    private boolean create() {
        isCreate = false;
        init();
        return false;
    }

    private void init() {
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);
        Date today = new Date();
        cpvCalendar.init(lastYear.getTime(), nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);
    }
}
