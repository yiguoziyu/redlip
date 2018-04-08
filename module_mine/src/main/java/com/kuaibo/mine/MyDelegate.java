package com.kuaibo.mine;

import android.support.annotation.Keep;

import com.kuaibo.commonlib.base.IApplicationDelegate;
import com.kuaibo.commonlib.base.ViewManager;
import com.orhanobut.logger.Logger;


@Keep
public class MyDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(0, MineFragment.newInstance());
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
