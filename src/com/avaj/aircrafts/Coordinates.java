package com.avaj.aircrafts;

public class Coordinates {

	private int height;
	private int longitude;
	private int latitude;

	Coordinates(int longitude_, int latitude_, int height_) {
		
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
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getHeight() {
		return height;
	}
}