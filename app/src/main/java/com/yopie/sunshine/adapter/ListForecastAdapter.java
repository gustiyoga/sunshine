package com.yopie.sunshine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yopie.sunshine.R;
import com.yopie.sunshine.model.ListForecast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Yopie on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    // buat deklarasi untuk today sama engga today
    private Context context;
    private List<ListForecast> listData = new ArrayList<>();
    private static final int TODAY_VIEW = 0;
    private static final int NEXT_DAY_ITEM = 1;

    // click listener
    private ForecastItemClickListener mForecastClickCallback;

    // constructor
    public ListForecastAdapter(List<ListForecast> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Jika view typenya adalah TODAY_VIEW maka return ViewHolder TodayForecastItemViewHolder dengan layout row_today...
        if (viewType == TODAY_VIEW){
            View todayItemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_forecast_today_item, parent, false);
            return new TodayForecastItemViewHolder(todayItemView);
        } else {
            // Jika view typenya bukan TODAY_VIEW maka return ViewHolder biasa yaitu ForecastItemViewHolder dengan layout row_forecast_item...
            View nextDayItemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_forecast_item, parent, false);
            return new ForecastItemViewHolder(nextDayItemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
//        ListForecast data = listData.get(position);
//        forecastItemViewHolder.bind(data, position, context);

        final int viewType = getItemViewType(position);
        final ListForecast data = listData.get(position);

        if (viewType == TODAY_VIEW){
            TodayForecastItemViewHolder todayForecastItemViewHolder = (TodayForecastItemViewHolder) holder; // casting view holder menjadi TodayForecastItemViewHolder
            todayForecastItemViewHolder.bind(data, position);
        } else {
            ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder; // casting view holder menjadi ForecastItemViewHolder
            forecastItemViewHolder.bind(data, position);
        }

        // holder.itemView adalah item view pada list
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mForecastClickCallback != null)
                    mForecastClickCallback.onForecastItemClick(data, position);
                else
                    Log.e(TAG, "onClick: Forecase click listener is null, " +
                            "don't forget to call adapter.setForecastItemClickListener()");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public int getItemViewType(int position) {
        // posisi 0 (item pertama), jika posisi nol maka set view type menjadi TODAY_VIEW
        if(position == 0)
            return TODAY_VIEW;
        else
            return NEXT_DAY_ITEM;
    }

    public void setForecastItemClickListener(ForecastItemClickListener clickListener) {
        if (clickListener != null)
            mForecastClickCallback = clickListener;
    }

    // Inner interface class utk click listener pada recyclerview
    public interface ForecastItemClickListener {
        void onForecastItemClick(ListForecast data, int position);
    }
}
