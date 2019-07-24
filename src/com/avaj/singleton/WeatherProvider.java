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

		// int seed = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
		// String weather_ = weather[seed % 4];
		// System.out.println(weather_);
		// return (weather_);
		double w = Math.random() * (( coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() ) % 21);
		int x = (int)w;

		if ( x < 5 )
			return ( weather[1] );
		if ( x < 10 )
			return ( weather[3] );
		if ( x < 15 )
			return ( weather[2] );
		if ( x < 20 )
			return ( weather[0] );
		return (" ");
	}

}