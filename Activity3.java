package com.example.a1.ret;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity3 extends AppCompatActivity {
    TextView itemDayTextView,itemConditionTextView,itemLowTextView,itemHighTextView;
    private Forecast forecast = new Forecast();
    @BindView(R.id.forcastConditionImageView)ImageView forcastConditionImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        ButterKnife.bind(this);
        itemConditionTextView = findViewById(R.id.itemConditionTextView);
        itemDayTextView = findViewById(R.id.itemDayTextView);
        itemHighTextView = findViewById(R.id.itemHighTextView);
        itemLowTextView = findViewById(R.id.itemLowTextView);

        if (getIntent().getExtras() != null){

            forecast = getIntent().getParcelableExtra("forecast");
            itemDayTextView.setText(forecast.getDay());
            itemConditionTextView.setText(forecast.getText());

            String name = "icon_" + (String) forecast.getCode();
            int drawableResourceId = this.getResources().getIdentifier(name, "drawable", this.getPackageName());
//            Drawable res = getResources().getDrawable(drawableResourceId);
//            forcastConditionImageView.setImageDrawable(res);
//
//            int resourceId = R.mipmap.ic_launcher;

            Glide
                    .with(this)
                    .load(drawableResourceId)
                    .into(forcastConditionImageView);

            int tempreature = Integer.parseInt(forecast.getHigh());
            tempreature = ((tempreature-32)*5)/9;
            //picasso and glide
            //butterknife
            itemHighTextView.setText(Integer.toString(tempreature) + "°C");

            tempreature = Integer.parseInt(forecast.getLow());
            tempreature = ((tempreature-32)*5)/9;
            itemLowTextView.setText(Integer.toString(tempreature) + "°C");
        }

    }
}
