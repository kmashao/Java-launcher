package com.avaj.singleton;

import com.avaj.aircrafts.*;
import java.util.Random;

public class WeatherProvider {

	static private WeatherProvider weatherProvider = new WeatherProvider();
	static private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	static public WeatherProvider getProvider() {
		return (WeatherProvider.weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) {

		Random num = new Random();
		int seed = num.nextInt(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() * 1000);
		Random number = new Random();
		int prop = number.nextInt(seed / 20);
		while (prop > 100)
			prop = number.nextInt(seed / 10);
			
		if (prop < 26)
			return (weather[1]);
		else if (prop < 51)
			return (weather[0]);
		else if (prop < 76)
			return (weather[2]);
		else if (prop < 101)
			return (weather[3]);
		return (" ");
	}

}