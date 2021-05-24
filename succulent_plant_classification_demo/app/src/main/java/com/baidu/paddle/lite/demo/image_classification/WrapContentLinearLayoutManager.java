package com.baidu.paddle.lite.demo.image_classification;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


public class WrapContentLinearLayoutManager extends GridLayoutManager {
    public WrapContentLinearLayoutManager(Context context, int spanCount) {
        super(context,spanCount);
    }



    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

