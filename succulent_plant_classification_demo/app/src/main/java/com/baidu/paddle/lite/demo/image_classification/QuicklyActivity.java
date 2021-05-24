package com.baidu.paddle.lite.demo.image_classification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QuicklyActivity extends BaseActivity {

    private List<BotanyBean> mList = new ArrayList<>();
    private MyRecyclerAdapter adapter;

    private RecyclerView  recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mList = removeRepeatDriver(ConstantList.getAllQuickly());
        Log.e("!!!!", mList.toString());
        recyclerview = findViewById(R.id.recyclerview);
        //设置布局管理器
        recyclerview.setLayoutManager(new WrapContentLinearLayoutManager(QuicklyActivity.this, 3));
        adapter = new MyRecyclerAdapter(mList, 1,this);
        recyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(QuicklyActivity.this, SpeciesActivity.class);
                intent.putExtra("family", mList.get(position).getFamily());
                intent.putExtra("type", "quickly");
                startActivity(intent);
            }
        });

    }

    public static List<BotanyBean> removeRepeatDriver(List<BotanyBean> aDrivers){
        Set<BotanyBean> set = new TreeSet<BotanyBean>(new Comparator<BotanyBean>() {
            public int compare(BotanyBean o1, BotanyBean o2) {
                //字符串,则按照asicc码升序排列
                return o1.getFamily().compareTo(o2.getFamily());
            }
        });
        set.addAll(aDrivers);
        return new ArrayList<BotanyBean>(set);
    }

}