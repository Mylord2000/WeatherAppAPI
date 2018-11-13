package com.example.a1.ret;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.Fore>{

    List<Forecast> forecasts;
    Context cxt;
    //---------------------------------------Construcot For Adapter

    public ForecastAdapter(List<Forecast> forecasts, Context cxt) {
        this.forecasts = forecasts;
        this.cxt = cxt;
    }


    //----------------------For every Forecast
    public class Fore extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView forecastDayTextView;
        TextView forecastConditionTextView;
        TextView forecastHighTextView;
        TextView forecastLowTextView ;
        ArrayList<Forecast> forecasts;
        Context cxt;
        public Fore(View itemView, Context cxt, ArrayList<Forecast> forecasts) {
            super(itemView);
            this.forecasts = forecasts;
            this.cxt = cxt;
            itemView.setOnClickListener(this);
            forecastDayTextView = itemView.findViewById(R.id.textView);
            forecastConditionTextView = itemView.findViewById(R.id.textView3);
            forecastHighTextView = itemView.findViewById(R.id.textView4);
            forecastLowTextView = itemView.findViewById(R.id.textView5);
        }

        public void bind(int index) {
            int tempreature = Integer.parseInt(forecasts.get(index).getHigh());
            tempreature = ((tempreature-32)*5)/9;
            forecastHighTextView.setText(Integer.toString(tempreature)+ "°C");

            forecastDayTextView.setText(forecasts.get(index).getDay());

            forecastConditionTextView.setText(forecasts.get(index).getText());

            tempreature = Integer.parseInt(forecasts.get(index).getLow());
            tempreature = ((tempreature-32)*5)/9;

            forecastLowTextView.setText(Integer.toString(tempreature)+ "°C");
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Forecast forecast = this.forecasts.get(position);
            Intent intent = new Intent(this.cxt,Activity3.class);
//            intent.putExtra("day",forecast.getDay());
//            intent.putExtra("condition", forecast.getText());
//            intent.putExtra("high", forecast.getHigh());
//            intent.putExtra("low", forecast.getLow());
            intent.putExtra("forecast", forecast);
            this.cxt.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ForecastAdapter.Fore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layout = R.layout.forecasts;
        LayoutInflater  inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,parent,false);
        Fore fore = new Fore(view,cxt, (ArrayList<Forecast>) forecasts);
        return fore;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapter.Fore holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }
}
