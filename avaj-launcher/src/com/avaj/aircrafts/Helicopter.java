package com.avaj.aircrafts;

import com.avaj.towers.*;

class Helicopter extends Aircraft {

	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates){
		this.name = name;
		
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {

	}

}