package com.example.a1.ret;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nameOfCity) EditText nameOfCityEditText;
    @BindView(R.id.conditionImageView)ImageView conditionImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        ButterKnife.bind(this);
        int drawableResourceId = this.getResources().getIdentifier("icon_18", "drawable", this.getPackageName());

        Drawable res = getResources().getDrawable(drawableResourceId);
        conditionImageView.setImageDrawable(res);
    }

    public void onClick(View view){

        String name = String.valueOf(nameOfCityEditText.getText());

        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra("nameOfCity", name);
        Log.d("result", "second");
        startActivity(intent);
    }

}
