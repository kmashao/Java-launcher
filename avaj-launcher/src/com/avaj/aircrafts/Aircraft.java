package com.avaj.aircrafts;

import com.avaj.aircrafts.Coordinates;

abstract class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	static private long idCounter;

	protected Aircraft(String name_, Coordinates coordinates_){
		this.name = name_;
		this.coordinates = coordinates_;
	}

	private long nextId(){

	}
}