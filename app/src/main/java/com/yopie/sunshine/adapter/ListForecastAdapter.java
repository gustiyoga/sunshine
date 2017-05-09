package com.yopie.sunshine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yopie.sunshine.R;
import com.yopie.sunshine.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yopie on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<DummyForecast> listData = new ArrayList<>();

    // constructor
    public ListForecastAdapter(List<DummyForecast> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_forecast_item, parent, false);

        return new ForecastItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
        DummyForecast data = listData.get(position);
        forecastItemViewHolder.bind(data, context);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

}
