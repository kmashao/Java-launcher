package com.avaj.aircrafts;

import com.avaj.towers.WeatherTower;
import com.avaj.towers.Tower;

class Baloon extends Aircraft {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name_, coordinates_);
	}

	public void updateConditions() {

		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> messages = new Hashmap<String, String>() {
			{

				put("RAIN", "Damn you rain! You messed up my baloon.");
				put("FOG", "I cant see jackshit.");
				put("SNOW", "It's snowing. We're gonna crash.");
				put("SUN", " Let's enjoy the good weather and take some pics.");
			}
		};

		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() + 0,
					coordinates.getHeight() + 2

			);
		} else if (weather.equals("RAIN")) {

			this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude() + 0,
					coordinates.getHeight() + 0);

		} else if (weather.equals("SNOW")) {

			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0,
					coordinates.getHeight() - 7);

		} else if (weather.equals("FOG")) {

			this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() + 0,
					coordinates.getHeight() + 0);
		}

	}

	public void registerTower(WeatherTower weatherTower) {

		this.weatherTower = weatherTower;
		this.weatherTower.registerTower(this);
		Simulator.writer
				.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}

}