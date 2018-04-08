package com.kuaibo.commonlib.base;


import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.kuaibo.commonlib.util.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

import java.util.List;

/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * Created by 一锅子鱼 on 2018/4/6.
 */

public class BaseApplication extends DefaultApplicationLike {
    public static final String ROOT_PACKAGE = "com.kuaibo";
    private static BaseApplication sInstance;
    private List<IApplicationDelegate> mAppDelegateList;
    private Context appContext;

    public BaseApplication(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }


    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        appContext=getApplication();
        Logger.init("pattern").logLevel(LogLevel.FULL);
        Utils.init(appContext);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(appContext, IApplicationDelegate.class, ROOT_PACKAGE);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }

}
