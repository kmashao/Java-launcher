package com.avaj.aircrafts;

class Coordinates{
	
	private int height;
	private int longitude;
	private int latitude;

	Coordinates(int longitude_, int latitude_, int height_){
		this.longitude = longitude_;
		this.latitude = latitude_;
		this.height = height_;
	}
	
	public int getLatitude(){
		return latitude;
	}
	public int getLongitude(){
		return longitude;
	}
	public int getHeight(){
		return height;
	}
}