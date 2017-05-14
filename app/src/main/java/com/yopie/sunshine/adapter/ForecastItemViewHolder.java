package com.yopie.sunshine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yopie.sunshine.R;
import com.yopie.sunshine.model.ListForecast;
import com.yopie.sunshine.model.WeatherItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yopie on 5/7/2017.
 */

public class ForecastItemViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.iv_weatherIcon) ImageView ivWeatherIcon;
    @BindView(R.id.tv_day) TextView tvDay;
    @BindView(R.id.tv_forecast) TextView tvForecast;
    @BindView(R.id.tv_maxTemp) TextView tvMaxTemp;
    @BindView(R.id.tv_minTemp) TextView tvMinTemp;

    public ForecastItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

//    public void bind(DummyForecast data, int position, Context context){
//        Glide
//                .with(context)
//                .load("http://openweathermap.org/img/w/" + data.getWeatherId())
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .crossFade()
//                .into(ivWeatherIcon);
//
//        tvDay.setText(data.getDay());
//        tvForecast.setText(data.getForecast());
//        tvMaxTemp.setText(String.valueOf(data.getMaxTempDegree()));
//        tvMinTemp.setText(String.valueOf(data.getMinTempDegree()));
//    }

    public void bind(ListForecast data, int position, Context context) {
        // get weather index ke 0
        WeatherItem weather = data.getWeather().get(0);

        Glide
                .with(context)
                .load("http://openweathermap.org/img/w/" + weather.getWeatherIcon())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(ivWeatherIcon);

        if (position == 0)
            tvDay.setText(data.getTodayReadableTime(position));
        else
            tvDay.setText(String.valueOf(data.getReadableTime(position)));

        tvForecast.setText(weather.getDescription());
        tvMaxTemp.setText(String.valueOf(data.getTemp().getMaxTempDegree()));
        tvMinTemp.setText(String.valueOf(data.getTemp().getMinTempDegree()));
    }
}
