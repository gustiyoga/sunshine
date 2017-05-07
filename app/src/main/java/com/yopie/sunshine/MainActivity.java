package com.yopie.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yopie.sunshine.adapter.ListForecastAdapter;
import com.yopie.sunshine.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    ListForecastAdapter adapter;
    private List<DummyForecast> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupRecyclerview();
    }

    public void getDummyData(){
        for (int i = 0; i < 20; i++) {
            DummyForecast dummyForecast = new DummyForecast("Sunday", "Sunny", 25 + i, 20 + i);
            listData.add(dummyForecast);
        }
    }

    private void setupRecyclerview(){
        adapter = new ListForecastAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        getDummyData();
    }
}
