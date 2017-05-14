package com.yopie.sunshine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yopie.sunshine.R;
import com.yopie.sunshine.model.ListForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yopie on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    // buat deklarasi untuk today sama engga today
    private Context context;
    private List<ListForecast> listData = new ArrayList<>();

    // constructor
    public ListForecastAdapter(List<ListForecast> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // ntar disini isiin if dari viewType

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_forecast_item, parent, false);

        return new ForecastItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
        ListForecast data = listData.get(position);
        forecastItemViewHolder.bind(data, position, context);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    // overide getItemViewType, isiin kondisi 1 atau 0
}
