package com.kuaibo.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kuaibo.commonlib.base.BaseActivity;
import com.kuaibo.commonlib.base.BaseFragment;
import com.kuaibo.commonlib.base.ClassUtils;
import com.kuaibo.commonlib.base.IViewDelegate;
import com.kuaibo.commonlib.base.ViewManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager mainViewpager;
    private BottomNavigationView mainBottomNavigationView;
    private CommonFragmentAdapter commonFragmentAdapter;
    private List<BaseFragment> fragmentList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mainViewpager = findViewById(R.id.main_viewpager);
        mainBottomNavigationView = findViewById(R.id.main_bottomNavigationView);
        setSwipeBackEnable(false);
    }

    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        mainBottomNavigationView.setOnNavigationItemSelectedListener(this);
        initViewPager();
    }

    private void initViewPager() {
        fragmentList = ViewManager.getInstance().getAllFragment();
//        BaseFragment newsFragment = getNewsFragment();//主动寻找
//        fragmentList.add(newsFragment);
        commonFragmentAdapter = new CommonFragmentAdapter(getSupportFragmentManager(), fragmentList);
        mainViewpager.setAdapter(commonFragmentAdapter);

    }


    /**
     * 在News模块中寻找实现的Fragment
     *
     * @return Fragment
     */
    private BaseFragment getNewsFragment() {
        BaseFragment newsFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.kuaibo.anchor");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            newsFragment = viewDelegates.get(0).getFragment("");
        }
        return newsFragment;
    }

    private void navigation() {
        //跳转到直播界面
        ARouter.getInstance().build("/liveim/live").navigation();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.navigation_home) {
            mainViewpager.setCurrentItem(0);
            return true;
        } else if (i == R.id.navigation_dashboard) {
            mainViewpager.setCurrentItem(1);
            return true;
        } else if (i == R.id.navigation_notifications) {
            mainViewpager.setCurrentItem(2);
            return true;
        }
        return false;
    }
}
