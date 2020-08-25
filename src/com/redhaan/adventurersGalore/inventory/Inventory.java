package com.redhaan.adventurersGalore.inventory;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.item.Item;

public class Inventory {
	
	public static int beastBlood = 0;
	public static int fangs = 0;
	public static int pelts = 0;
	public static int lesses = 0;
	public static int hides = 0;
	
	public static ArrayList<Item> armours;
	public static ArrayList<Item> weapons;
	
	public static boolean weaponChange;
	public static boolean armourChange;
	
	public Inventory() {
		
		armours = new ArrayList<Item>();
		weapons = new ArrayList<Item>();
		
		weaponChange = false;
		armourChange = false;
		
	}
	
	
	
	
	public static void update(ArrayList<Item> loot) {
		
		
		for (int i = 0; i < loot.size(); i++) {
			
			switch(loot.get(i).ID) {
				
			case 11: fangs++; break;
			case 12: hides++; break;
			case 13: pelts++; break;
			
			case 21: beastBlood++; break;
			case 22: lesses++; break;
			
			case 3: armours.add(loot.get(i)); break;
			
			case 4: weapons.add(loot.get(i)); break;
				
			}
						
		}
		
		
		
		
	}
	
}
