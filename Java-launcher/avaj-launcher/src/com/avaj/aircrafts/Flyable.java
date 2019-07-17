package com.avaj.aircrafts;

import com.avaj.towers.WeatherTower;

public interface Flyable{
	
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}