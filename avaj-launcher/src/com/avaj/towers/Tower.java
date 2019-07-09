package com.avaj.towers;

import com.avaj.Flyable;

abstract class Tower implements Flyable{
	
	private Flyable observers = new Flyable();

	public void register(Flyable flyable){

	}

	public void unregister(Flyable flyable){

	}

	protected void conditionsChanged(){
		
	} 

}