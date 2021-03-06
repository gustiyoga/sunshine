package com.yopie.sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse{

	@SerializedName("city")
	private City city;

	@SerializedName("cnt")
	private int cnt;

	@SerializedName("cod")
	private String cod;

	@SerializedName("message")
	private double message;

	@SerializedName("list")
	private List<ListForecast> list;

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setCnt(int cnt){
		this.cnt = cnt;
	}

	public int getCnt(){
		return cnt;
	}

	public void setCod(String cod){
		this.cod = cod;
	}

	public String getCod(){
		return cod;
	}

	public void setMessage(double message){
		this.message = message;
	}

	public double getMessage(){
		return message;
	}

	public void setList(List<ListForecast> list){
		this.list = list;
	}

	public List<ListForecast> getList(){
		return list;
	}

	@Override
 	public String toString(){
		return 
			"ApiResponse{" + 
			"city = '" + city + '\'' + 
			",cnt = '" + cnt + '\'' + 
			",cod = '" + cod + '\'' + 
			",message = '" + message + '\'' + 
			",list = '" + list + '\'' + 
			"}";
		}
}