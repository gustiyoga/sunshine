package com.yopie.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yopie.sunshine.adapter.ListForecastAdapter;
import com.yopie.sunshine.model.DummyForecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/forecast/daily?q=Denpasar&mode=json&units=metric&cnt=17&APPID=d345e008609693cf4dee4f5245fbbf0d";

        // Persiapan the Request dengan respon JSONObject
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray listArray = response.getJSONArray("list");

                            for (int i = 0; i < listArray.length(); i++) {
                                JSONObject listObject = listArray.getJSONObject(i);

                                String dtObject = listObject.getString("dt");
                                String dayName = DateFormat.format("EEEE", Integer.parseInt(dtObject) * 1000L).toString();

                                JSONObject tempObject = listObject.getJSONObject("temp");
                                int maxTemp = tempObject.getInt("max");
                                int minTemp = tempObject.getInt("min");

                                JSONArray weatherArray = listObject.getJSONArray("weather");
                                for (int j = 0; j < weatherArray.length(); j++) {
                                    JSONObject weatherObject = weatherArray.getJSONObject(j);

                                    String mainWeather = weatherObject.getString("main");

                                    DummyForecast dummyForecast = new DummyForecast(dayName, mainWeather, maxTemp, minTemp);
                                    listData.add(dummyForecast);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //menampilkan error pada logcat
                        Log.e("Error.Response", error.getMessage());
                    }
                }
        );

        // menambahkan request ke RequestQueue
        queue.add(getRequest);
    }

    public void getDummyData(){
        for (int i = 0; i < 1; i++) {
            DummyForecast dummyForecast = new DummyForecast("Sunday", "Sunny", 25 + i, 20 + i);
            listData.add(dummyForecast);
        }
    }

    private void setupRecyclerview(){
        adapter = new ListForecastAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
//        getDummyData();
        getData();
    }
}
