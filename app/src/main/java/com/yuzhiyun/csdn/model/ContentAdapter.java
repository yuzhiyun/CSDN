package com.yuzhiyun.csdn.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuzhiyun.csdn.control.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-01.
 */
public class ContentAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public ContentAdapter(FragmentManager fm) {

        super(fm);
        fragmentList.add(new BlankFragment("第一个"));
        fragmentList.add(new BlankFragment("第二个"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
