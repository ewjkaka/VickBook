package com.vickbook.activity;

import android.app.Activity;
import android.os.Bundle;

import com.vickbook.R;

import butterknife.ButterKnife;

/**
 * Created by jianghao on 2017/12/11.
 */

public class AddEventsActivity extends Activity {

    boolean isCreate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
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

    }
}
