package com.yopie.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yopie.sunshine.R;
import com.yopie.sunshine.model.DummyForecast;

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

    public void bind(final DummyForecast data){
        tvDay.setText(data.getDay());
        tvForecast.setText(data.getForecast());
        tvMaxTemp.setText(String.valueOf(data.getMaxTempDegree()));
        tvMinTemp.setText(String.valueOf(data.getMinTempDegree()));
    }
}
