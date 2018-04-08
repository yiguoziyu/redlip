package com.kuaibo.anchor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuaibo.commonlib.base.BaseFragment;

/**
 * Created by 一锅子鱼 on 2018/4/6.
 */

public class AnchorExhibitionFragment extends BaseFragment {
    public static AnchorExhibitionFragment newInstance() {
        return new AnchorExhibitionFragment();
    }
    public AnchorExhibitionFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anchor_exhibition, container, false);
    }
}
