package com.avaj.towers;

import com.avaj.singleton.WeatherProvider;

public class WeatherTower{

	public String getWeather(Coordinates coordinates){
		return(WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	void changeWeather(){

	}
}