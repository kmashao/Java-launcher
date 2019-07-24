package com.avaj.simulation;

import java.io.*;

import com.avaj.aircrafts.AircraftFactory;
import com.avaj.singleton.WeatherProvider;
import com.avaj.towers.WeatherTower;

public class Simulator {

	public static int cycles;
	public static PrintWriter writer;

	public static void main(String[] args) throws Exception {

		if (args.length < 1)
			return;
		String filename = args[0];

		File simulationLog = new File("simulation.txt");

		try {
			writer = new PrintWriter(simulationLog);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return;
		}
		if (simulationLog.exists() && !simulationLog.isDirectory())
			writer.println("");

		AircraftFactory factory = new AircraftFactory();
		WeatherTower tower = new WeatherTower();

		try {
			FileInputStream fstream = new FileInputStream(filename);
			BufferedReader bRead = new BufferedReader(new InputStreamReader(fstream));

			int lineNum = 1;
			String line;
			String[] splitStr;

			while ((line = bRead.readLine()) != null) {

				if (lineNum == 1)
					try {
						cycles = Integer.parseInt(line);
						if (cycles < 0) {
							System.out.println("Cycle number must be a positive integer");
							return;
						}
					} catch (NumberFormatException e) {
						System.out.println("Cycle number must be an integer");
						return;
					} catch (Exception ex) {
						System.out.println("Error: " + ex.getMessage());
					}
				else {

					splitStr = line.split(" ");
					if (splitStr.length == 1 && splitStr[0].isEmpty()) // skip empty lines
						continue;
					if (splitStr.length != 5)
						throw new Exception("There must be 5 parameters");

					try {
						factory.newAircraft(splitStr[0], splitStr[1], Integer.parseInt(splitStr[2]),
								Integer.parseInt(splitStr[3]), Integer.parseInt(splitStr[4])).registerTower(tower);
					} catch (NumberFormatException e) {
						System.out.println("Parameters 3 - 5 must be integeres");
						return;
					} catch (Exception ex) {
						System.out.println("Error: " + ex.getMessage());
					}
				}

				lineNum++;
			}

			bRead.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		// WeatherProvider provider = WeatherProvider.getProvider();
		while (cycles > 0) {
			tower.changeWeather();
			cycles--;
		}

		writer.close();
	}

}