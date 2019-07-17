package com.avaj.towers;

import com.avaj.singleton.WeatherProvider;
import com.avaj.aircrafts.Coordinates;

public class WeatherTower extends Tower{

	public String getWeather(Coordinates coordinates){
		return(WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather(){
		this.conditionsChanged();
	}
}