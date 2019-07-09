package com.avaj.singleton;

import com.avaj.aircrafts.*;

class WeatherProvider {

	static private WeatherProvider weatherProvider;
	static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	WeatherProvider() {
		return;
	}

	static WeatherProvider getProvider() {
		return weatherProvider;
	}

	String getCurrentWeather(Coordinates coordinates) {

	}

}