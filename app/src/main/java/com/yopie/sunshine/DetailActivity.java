package com.yopie.sunshine;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yopie.sunshine.model.ListForecast;
import com.yopie.sunshine.util.SunshineWeatherUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yopie on 5/20/2017.
 */

public class DetailActivity extends AppCompatActivity{
    @BindView(R.id.detail_date) TextView tvDate;
    @BindView(R.id.detail_weather_icon) ImageView ivWeatherIcon;
    @BindView(R.id.detail_weather_description) TextView tvWeatherDesc;
    @BindView(R.id.detail_high_temperature) TextView tvHighTemp;
    @BindView(R.id.detail_low_temperature) TextView tvLowTemp;
    @BindView(R.id.detail_humidity) TextView tvHumidity;
    @BindView(R.id.detail_pressure) TextView tvPressure;
    @BindView(R.id.detail_wind) TextView tvWind;

    private ListForecast forecastData;
    private int dataPosition;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        String extraJsonData = getIntent().getStringExtra("data"); // mengambil data dari intent
        if (extraJsonData != null) {
            forecastData = gson.fromJson(extraJsonData, ListForecast.class);
            dataPosition = getIntent().getIntExtra("position", 0); // mengambil data position dr intent
            bindData();
        }
    }

    private void bindData() {
        if (dataPosition == 0) {
            //today
            tvDate.setText(forecastData.getTodayReadableTime());
        } else {
            tvDate.setText(forecastData.getReadableTime(dataPosition));
        }

        ivWeatherIcon.setImageResource(
                SunshineWeatherUtils
                        .getSmallArtResourceIdForWeatherCondition(
                                forecastData.getWeather().get(0).getId()
                        )
        );

        tvHighTemp.setText(forecastData.getTemp().getMaxTempDegree());
        tvLowTemp.setText(forecastData.getTemp().getMinTempDegree());

        tvWeatherDesc.setText(forecastData.getWeather().get(0).getDescription());
        tvHumidity.setText(forecastData.getReadableHumidity());
        tvWind.setText(forecastData.getReadableWindSpeed());
        tvPressure.setText(forecastData.getReadablePressure());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this); // jangan lupa untuk merubah manifest menambahkan parent activity pd DetailActivity
    }
}
