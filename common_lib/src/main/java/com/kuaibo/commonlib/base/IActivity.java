package com.kuaibo.commonlib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

/**
 * 带侧滑回退基类Activity
 * Created by 一锅子鱼 on 2018/4/8.
 */

public abstract class IActivity extends IBaseActivity implements SwipeBackActivityBase {

    //侧滑返回
    public SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //初始化侧滑返回
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        initSwipeBackLayout();
        super.onCreate(savedInstanceState);
    }

    /**
     * 侧滑返回API
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

    /**
     * 默认设置左滑回退
     */
    private void initSwipeBackLayout() {
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        }
    }
}
