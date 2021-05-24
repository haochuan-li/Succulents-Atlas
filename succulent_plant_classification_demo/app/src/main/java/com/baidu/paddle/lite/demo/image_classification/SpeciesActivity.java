package com.baidu.paddle.lite.demo.image_classification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SpeciesActivity extends BaseActivity {

    private List<BotanyBean> mList = new ArrayList<>();
    private MyRecyclerAdapter adapter;

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);

        String family = getIntent().getStringExtra("family");
        String type = getIntent().getStringExtra("type");
        if (type.equals("botany")) {
            getFamilyBotany(family);
        }else {
            getQuickly(family);
        }
        if (actionBar != null) {
            actionBar.setTitle(family);
        }
        recyclerview = findViewById(R.id.recyclerview);
        //设置布局管理器
        recyclerview.setLayoutManager(new WrapContentLinearLayoutManager(SpeciesActivity.this, 3));
        adapter = new MyRecyclerAdapter(mList, 2,this);
        recyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SpeciesActivity.this, BotanyDetailsActivity.class);
                intent.putExtra("item", mList.get(position));
                startActivity(intent);
            }
        });
    }
    private void getFamilyBotany(String family){
        List<BotanyBean> beans = ConstantList.getAllBotany();
        for (BotanyBean bean : beans) {
            if (bean.getFamily().equals(family)) {
                mList.add(bean);
            }
        }
    }
    private void getQuickly(String family){
        List<BotanyBean> beans = ConstantList.getAllQuickly();
        for (BotanyBean bean : beans) {
            if (bean.getFamily().equals(family)) {
                mList.add(bean);
            }
        }
    }
}