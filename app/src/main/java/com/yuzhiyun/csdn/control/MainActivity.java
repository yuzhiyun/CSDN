package com.yuzhiyun.csdn.control;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.yuzhiyun.csdn.R;
import com.yuzhiyun.csdn.control.base.BaseActivity;
import com.yuzhiyun.csdn.model.ContentAdapter;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btnFirst)
    Button btnFirst;

    @Bind(R.id.btnSecond)
    Button btnSecond;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initOther() {
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager.setAdapter(new ContentAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (0 == position)
                    btnFirst();
                else
                    btnSecond();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.btnFirst)
    public void btnFirst() {
        btnFirst.setTextColor(getResources().getColor(R.color.colorPrimary));
//        btnFirst.setBackgroundColor(Color.WHITE);
        btnFirst.setBackgroundResource(R.drawable.order_btn_white);

        btnSecond.setTextColor(Color.WHITE);
        btnSecond.setBackgroundResource(R.drawable.order_btn_colorprimary);

        viewPager.setCurrentItem(0);
    }

    @OnClick(R.id.btnSecond)
    public void btnSecond() {
        btnSecond.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnSecond.setBackgroundResource(R.drawable.order_btn_white);

        btnFirst.setTextColor(Color.WHITE);
        btnFirst.setBackgroundResource(R.drawable.order_btn_colorprimary);

        viewPager.setCurrentItem(1);
    }


}
