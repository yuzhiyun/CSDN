package com.yuzhiyun.csdn.control.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yuzhiyun.csdn.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuzhiyun on 2016-10-01.
 */
abstract public class BaseActivity extends AppCompatActivity {

    Context context;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        setLayoutView();
        ButterKnife.bind(this);
        initToolbar();
        initOther();
    }


    void initToolbar() {
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected abstract void setLayoutView();

    protected abstract void initOther();
}
