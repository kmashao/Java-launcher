package com.avaj.singleton;

import com.avaj.aircrafts.*;

public class WeatherProvider {

	static private WeatherProvider weatherProvider;
	static private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	static public WeatherProvider getProvider() {
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {

		int seed = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
		String weather_ = weather[seed % 4];
		return (weather_);
	}

}