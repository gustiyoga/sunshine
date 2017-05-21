package com.yopie.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yopie.sunshine.R;
import com.yopie.sunshine.model.ListForecast;
import com.yopie.sunshine.model.WeatherItem;
import com.yopie.sunshine.util.SunshineWeatherUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yopie on 5/20/2017.
 */

public class TodayForecastItemViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_today_date)
    TextView tvTodayDate;
    @BindView(R.id.tv_today_weather_desc) TextView tvTodayWeatherDesc;
    @BindView(R.id.tv_today_max_temp) TextView tvTodayHighTemp;
    @BindView(R.id.tv_today_min_temp) TextView tvTodayLowTemp;
    @BindView(R.id.iv_today_weather_icon)
    ImageView ivTodayIcon;

    public TodayForecastItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ListForecast data, int position){
        if (position == 0){
            tvTodayDate.setText(data.getTodayReadableTime());
        } else {
            tvTodayDate.setText(data.getReadableTime(position));
        }

        ivTodayIcon.setImageResource(
                SunshineWeatherUtils
                        .getSmallArtResourceIdForWeatherCondition(
                                data.getWeather().get(0).getId()
                        )
        );

        WeatherItem weather = data.getWeather().get(0);

        tvTodayWeatherDesc.setText(weather.getDescription());
        tvTodayLowTemp.setText(data.getTemp().getMinTempDegree());
        tvTodayHighTemp.setText(data.getTemp().getMaxTempDegree());

    }
}
