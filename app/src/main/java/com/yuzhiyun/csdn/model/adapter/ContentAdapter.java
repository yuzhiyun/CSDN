package com.yuzhiyun.csdn.model.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuzhiyun.csdn.control.fragment.ContentFragment;
import com.yuzhiyun.csdn.model.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-01.
 */
public class ContentAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public ContentAdapter(FragmentManager fm) {

        super(fm);
        fragmentList.add(new ContentFragment(Constant.INDEX_PAGE_1));
        fragmentList.add(new ContentFragment(Constant.INDEX_PAGE_2));
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
