package com.kuaibo.mine;

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

public class MineFragment extends BaseFragment{

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    public MineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine, container, false);

        return view;
    }


}
