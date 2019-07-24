package com.avaj.aircrafts;

import com.avaj.towers.WeatherTower;
import com.avaj.aircrafts.Coordinates;
import com.avaj.Simulator;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> messages = new HashMap<String,String>();

		messages.put("RAIN", "Damn you rain! You messed up my baloon.");
		messages.put("FOG", "I cant see jackshit.");
		messages.put("SNOW", "It's snowing. We're gonna crash.");
		messages.put("SUN", " Let's enjoy the good weather and take some pics.");

		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() + 0,
					coordinates.getHeight() + 2);
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

		Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): " + messages.get(weather));
		if (this.coordinates.getHeight() == 0){

			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): landing.");
			this.weatherTower.unregister(this);
			Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "unregistered from weather tower");
		}

	}

	public void registerTower(WeatherTower weatherTower) {

		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.writer
				.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}

}