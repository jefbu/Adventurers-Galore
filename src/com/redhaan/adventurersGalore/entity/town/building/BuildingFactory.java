package com.redhaan.adventurersGalore.entity.town.building;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.town.building.alchemist.Alchemist;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.BlackSmith;
import com.redhaan.adventurersGalore.entity.town.building.inn.Inn;
import com.redhaan.adventurersGalore.entity.town.building.seer.Seer;

public abstract class BuildingFactory {
	
	public static ArrayList<Building> createTownBuildings(int townSize) {
		
		ArrayList<Building> list = new ArrayList<Building>();
		
		createInns(list);
		createFarm(list);
		createAlchemist(list);
		createJeweller(list);
		createBlackSmiths(list, townSize);
		createSeer(list, townSize);
				
		
		
		return list;
		
	}
	
	
	private static void createInns(ArrayList<Building> list) { list.add(new Inn()); }
	private static void createFarm(ArrayList<Building> list) { list.add(new Farm()); }
	private static void createAlchemist(ArrayList<Building> list) { list.add(new Alchemist()); }
	private static void createJeweller(ArrayList<Building> list) { list.add(new Jeweller()); }

	private static void createBlackSmiths(ArrayList<Building> list, int townSize) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch (townSize) {
		case 1: if (roll > 80) { list.add(new BlackSmith()); } break;
		case 2: if (roll > 50) { list.add(new BlackSmith()); } break;
		case 3: if (roll > 0) { list.add(new BlackSmith()); } break;
		case 4: list.add(new BlackSmith()); break;
		default: System.out.println("error in switch blacksmith"); break;
		}
		
	}
	
	private static void createSeer(ArrayList<Building> list, int townSize) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch (townSize) {
		case 1: if (roll > 80) { list.add(new Seer()); } break;
		case 2: if (roll > 50) { list.add(new Seer()); } break;
		case 3: if (roll > 0) { list.add(new Seer()); } break;
		case 4: list.add(new BlackSmith()); break;
		default: System.out.println("error in switch blacksmith"); break;
		}
		
	}
	
	
}
