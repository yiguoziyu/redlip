package com.kuaibo.anchor;

import android.support.annotation.Keep;
import android.view.View;

import com.kuaibo.commonlib.base.BaseFragment;
import com.kuaibo.commonlib.base.IViewDelegate;


@Keep
public class MyViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return AnchorExhibitionFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
