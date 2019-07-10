package com.avaj.towers;

import java.util.ArrayList;

import com.avaj.Flyable;
import java.util.List;

abstract class Tower implements Flyable {

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {

		if (observers.contains(flyable))
			return;
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {

	}

}