package com.kuaibo.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kuaibo.commonlib.base.BaseFragment;

import java.util.List;

/**
 * 通用ViewPager FragmentAdapter
 * Created by 一锅子鱼 on 2018/4/6.
 */

public class CommonFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList;

    public CommonFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return android.support.v4.view.PagerAdapter.POSITION_NONE;
    }

}
