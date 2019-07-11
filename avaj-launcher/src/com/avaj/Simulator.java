package com.avaj;

import com.avaj.aircrafts.Aircraft;
import com.avaj.aircrafts.Coordinates;
import com.avaj.Simulator;

import java.io.*;

import com.avaj.airacrafts.AircraftFactory;

public class Simulator{

	
	static int cycles;
	static PrintWriter writer;
	
	public static void main(String[] args) {

		if (args.length < 1)
			return;
		String filename = args[0];

		File simulationLog = new File("simulation.txt");
		
		
	}
}

