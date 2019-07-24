package com.avaj.aircrafts;

import com.avaj.towers.*;

public interface Flyable{
	
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}