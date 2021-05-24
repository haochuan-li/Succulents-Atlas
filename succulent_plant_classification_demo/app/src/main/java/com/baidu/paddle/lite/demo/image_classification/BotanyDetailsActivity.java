package com.baidu.paddle.lite.demo.image_classification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class BotanyDetailsActivity extends BaseActivity {

    private TextView tvName,tvType,tvIntroduce;
    private ImageView ivPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botany_details);

        tvName = findViewById(R.id.tv_name);
        tvType = findViewById(R.id.tv_type);
        tvIntroduce = findViewById(R.id.tv_introduce);
        ivPicture = findViewById(R.id.iv_picture);
        BotanyBean bean = (BotanyBean) getIntent().getSerializableExtra("item");
        tvName.setText(bean.getName());
        tvType.setText(bean.getFamily() + " " + bean.getGenus());
        tvIntroduce.setText(bean.getIntroduce());
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getResources().getAssets().open(bean.getImage()));
            ivPicture.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}