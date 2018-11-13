package com.example.a1.ret;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity2 extends AppCompatActivity {

    @BindView(R.id.cityNameTextView) TextView cityNameTextView ;
    @BindView(R.id.tempTextView)TextView tempTextView;
    @BindView(R.id.conditionTextView)TextView conditionTextView;
    @BindView(R.id.dateTextView)TextView dateTextView;
    @BindView(R.id.sunriseTextView)TextView sunriseTextView;
    @BindView(R.id.sunsetTextView)TextView  sunsetTextView;
    @BindView(R.id.conditionImageView)ImageView conditionImageView;

    @BindView(R.id.recycler) RecyclerView recyclerView;
    private ForecastAdapter forecastAdapter;
    Example h;
    List<Forecast> forecats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        Log.d("result","getParcelableExtra");
        String name = (String)getIntent().getStringExtra("nameOfCity");
//        String values[] = name.split(",");
//        Log.d("result",values[0] + " " +values[1]);
//        name = values[0] + "," + values[1];
        Log.i("res", name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Example> call = api.getExample();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if(response.isSuccessful()){

                    h = response.body();
                    //----------------------------iamge im the main Actvityy-----------------------------//
                    String name = "icon_" + (String) h.getEllement().getResults().getChannel().getItem().getCondition().getCode();
                    int drawableResourceId = getResources().getIdentifier(name, "drawable", getPackageName());
                    Glide.with(getApplicationContext()).load(drawableResourceId).into(conditionImageView);

                    //--------------------------editing information in main activity
                    int tempreature = Integer.parseInt(h.getEllement().getResults().getChannel().getItem().getCondition().getTemp());
                    tempreature = ((tempreature-32)*5)/9;
                    cityNameTextView.setText(h.getEllement().getResults().getChannel().getLocation().getCity());
                    tempTextView.setText(Integer.toString(tempreature)+ "°C");
                    conditionTextView.setText(h.getEllement().getResults().getChannel().getItem().getCondition().getText());
                    dateTextView.setText(h.getEllement().getResults().getChannel().getItem().getCondition().getDate());
                    sunriseTextView.setText(h.getEllement().getResults().getChannel().getAstronomy().getSunrise());
                    sunsetTextView.setText(h.getEllement().getResults().getChannel().getAstronomy().getSunset());
                    Log.i("result", h.getEllement().getResults().getChannel().getItem().getForecast().get(0).getDay());

                   //---------------------------recycler view editing
                    forecastAdapter = new ForecastAdapter(h.getEllement().getResults().getChannel().getItem().getForecast(),getApplicationContext());
                    recyclerView.setAdapter(forecastAdapter);

                }else {
                    Log.i("ERRROR", "ERRORR");
                }

            }


            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("result","");
            }
        });

    }
}
