package com.redhaan.adventurersGalore.entity.town.building;

import java.util.ArrayList;
import java.util.Random;

public abstract class BuildingFactory {
	
	public static ArrayList<Building> createTownBuildings(int townSize) {
		
		ArrayList<Building> list = new ArrayList<Building>();
		
		createInns(list);
		createBlackSmiths(list, townSize);
				
		
		
		return list;
		
	}
	
	
	private static void createInns(ArrayList<Building> list) { list.add(new Inn(0, 0)); }
	
	private static void createBlackSmiths(ArrayList<Building> list, int townSize) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch (townSize) {
		case 1: if (roll > 80) { list.add(new BlackSmith(3,0)); } break;
		case 2: if (roll > 50) { list.add(new BlackSmith(3,0)); } break;
		case 3: if (roll > 20) { list.add(new BlackSmith(3,0)); } break;
		case 4: list.add(new BlackSmith(10,8)); break;
		default: System.out.println("error in switch blacksmith"); break;
		}
		
	}
	
	
}
