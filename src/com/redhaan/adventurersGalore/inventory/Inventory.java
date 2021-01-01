package com.redhaan.adventurersGalore.inventory;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.item.Item;

public class Inventory {
	
	public static int antlers = 30;
	public static int beastBlood = 0;
	public static int bone = 6;
	public static int claw = 11;
	public static int coral = 8;	
	public static int fang = 19;
	public static int gold = 8;
	public static int hide = 41;
	public static int iron = 11;
	public static int lesses = 0;
	public static int oakwood = 16;
	public static int pelt = 32;
	public static int silver = 9;
	public static int tusk = 4;
	public static int wing = 3;
	public static int evilSpirit = 5;
	public static int violentSpirit = 2;
	public static int spiritOfMischief = 3;
	public static int vagrantSpirit = 3;
	public static int nobleSpirit = 6;
	public static int heartSpirit = 2;
	public static int liquidInnocence = 4;
	public static int stolenMoonlight = 2;
	public static int rationalThought = 1;
	public static int luckyClover = 3;
	public static int reforgedPlough = 2;
	public static int ivory = 11;
	public static int springBreeze = 4;
	public static int morningSunlight = 5;
	public static int pentupAnger = 3;
	public static int gloriousMoment = 2;
	public static int elysianFlower = 3;
	public static int wanderlust = 6;

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
			
			case Weapon: weapons.add(loot.get(i)); break;
			case Armour: armours.add(loot.get(i)); break;
			
			case Antlers: antlers++; break;
			case BeastBlood: beastBlood++; break;
			case Bone: bone++; break;
			case Claw: claw++; break;
			case Coral: coral++; break;
			case Fang: fang++; break;
			case Gold: gold++; break;
			case Hide: hide++; break;
			case Iron: iron++; break;
			case Lesses: lesses++; break;
			case OakWood: oakwood++; break;
			case Pelt: pelt++; break; 
			case Silver: silver++; break;
			case Tusk: tusk++; break;

			default: System.out.println("error adding stuff to the loot");break;
							
			}
						
		}		
				
	}
	
}
