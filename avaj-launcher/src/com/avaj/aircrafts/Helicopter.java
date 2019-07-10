package com.avaj.aircrafts;

import java.util.HashMap;

import com.avaj.towers.*;

class Helicopter extends Aircraft {

	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {

		super(name, coordinates);
	}

	public void updateConditions(){

		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> conditions = new Hashmap<String, String>(){{
			
			put("RAIN","It's raining. Finna get wet");
			put("FOG","Can't see shit.");
			put("SNOW","It's darn cold my finger broke off.");
			put("SUN","Ahhhh some nice sunshine.");
		}};

		if (weather.equals("SUN")){
			this.coordinates = new Coordinates(coordinates.getLongitude() + 10,
												coordinates.getLatitude() + 0,
												coordinates.getHeight() + 2
				
			);
		}
		else if (weather.equals("RAIN")){
			this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
												coordinates.getLatitude() + 0,
												coordinates.getHeight() + 0)
		}

		
	}

	public void registerTower(WeatherTower weatherTower) {

	}

}