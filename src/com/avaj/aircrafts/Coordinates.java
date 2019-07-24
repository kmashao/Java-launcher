package com.avaj.aircrafts;

public class Coordinates {

	private int height;
	private int longitude;
	private int latitude;

	public Coordinates(int longitude_, int latitude_, int height_) {
		
		if (longitude_ < 1)
			this.longitude = 0;
		if (latitude_ < 1)
			this.latitude = 0;
		if (height_ < 1)
			this.latitude = 0;
		this.longitude = longitude_;
		this.latitude = latitude_;
		this.height = height_;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getHeight() {
		return this.height;
	}
}