package com.kuaibo.commonlib.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.kuaibo.commonlib.util.SystemBarTintManager;


/**
 * 基类Activity，不带侧滑回退
 * Created by 一锅子鱼 on 2018/4/8.
 */

public abstract class IBaseActivity extends AppCompatActivity {

    public Context mContext;
    public Activity mActivity;
    //沉浸式管理器
    public SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局内容
        setContentView(getLayoutId());
        mContext = this;
        mActivity = this;
        //初始化沉浸式
        initSystemBarTinit();
        //内存监测
        initLeakcanary();
        //初始化布局
        initView(savedInstanceState);
        //初始化数据
        initData();
    }

    /**
     * 设置布局layout
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View控件
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 初始化沉浸式
     */
    private void initSystemBarTinit() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(Color.parseColor("#00000000"));
        }
    }


    /**
     * 设置状态栏透明状态
     */
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 设置toolbar位置
     */
    public void setTitleBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            view.measure(width, height);
//            ViewGroup.LayoutParams lp = view.getLayoutParams();
//            lp.height = view.getMeasuredHeight() + tintManager.getNavigationBarHeight();
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + tintManager.getNavigationBarHeight(),
                    view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /**
     * 内存监测leakcanary
     */
    private void initLeakcanary() {
//        RefWatcher refWatcher = MyApplication.getRefWatcher(context);
//        refWatcher.watch(this);
    }

}
