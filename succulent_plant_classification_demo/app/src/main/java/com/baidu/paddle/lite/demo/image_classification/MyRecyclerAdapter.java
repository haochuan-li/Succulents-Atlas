package com.baidu.paddle.lite.demo.image_classification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ItemView>{
    private List<BotanyBean> list;
    Context context;
    int type;
    private MyRecyclerAdapter.OnItemClickListener onItemClickListener;

    // 定义点击回调接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

    }
    // 定义一个设置点击监听器的方法
    public void setOnItemClickListener(MyRecyclerAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public MyRecyclerAdapter(List<BotanyBean> list,int type, Context context) {
        this.list=list;
        this.context=context;
        this.type = type;
    }

    public void updateData(List<BotanyBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler, viewGroup, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(final ItemView itemView, int position) {

        BotanyBean bean = list.get(position);
        itemView.tvName.setText(type==1?bean.getFamily():bean.getName());
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(context.getResources().getAssets().open(bean.getImage()));
            itemView.ivPicture.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemView.bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    int pos = itemView.getLayoutPosition();
                    onItemClickListener.onItemClick(itemView.itemView, pos);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //viewholder
    public static class ItemView extends  RecyclerView.ViewHolder{


        private RoundedImageView ivPicture;
        private TextView tvName;
        private RelativeLayout bg;
        public ItemView(View itemView){
            super(itemView);
            ivPicture = itemView.findViewById(R.id.h_head);
            tvName = itemView.findViewById(R.id.tv_name);
            bg = itemView.findViewById(R.id.bg);
        }


    }

}