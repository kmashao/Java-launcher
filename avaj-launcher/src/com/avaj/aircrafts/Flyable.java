package com.avaj.aircrafts;

import com.avaj.towers.WeatherTower;

interface Flyable{
	
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}