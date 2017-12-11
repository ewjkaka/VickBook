package com.example.jianghao.myapplication;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {


    @BindView(R.id.cpv_calendar)
    CalendarPickerView cpvCalendar;

    boolean isCreate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
