package com.avaj.aircrafts;

import com.avaj.aircrafts.Coordinates;
import com.avaj.towers.WeatherTower;
import java.util.HashMap;
import com.avaj.Simulator;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> messages = new HashMap<String, String>();

		messages.put("RAIN", "It's raining. Better watch out for lightings.");
		messages.put("FOG", "How am I supposed to drive in this.");
		messages.put("SNOW", "OMG! Winter is coming!");
		messages.put("SUN", "Whats with this heat.");

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
		if (this.coordinates.getHeight() < 1)
			Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ")" + " landing.");
		this.weatherTower.unregister(this);
		Simulator.writer
				.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");

	}

	public void registerTower(WeatherTower weatherTower) {

		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.writer
				.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}

}