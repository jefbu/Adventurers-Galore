package com.redhaan.adventurersGalore.inventory;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.item.Item;

public class Inventory {
	
	public static int antlers = 0;
	public static int beastBlood = 0;
	public static int bone = 0;
	public static int claw = 0;
	public static int coral = 0;	
	public static int fang = 0;
	public static int gold = 0;
	public static int hide = 0;
	public static int iron = 0;
	public static int lesses = 0;
	public static int oakwood = 0;
	public static int pelt = 0;
	public static int silver = 0;
	public static int tusk = 0;
	public static int wing = 0;
	public static int evilSpirit = 0;
	public static int violentSpirit = 0;
	public static int spiritOfMischief = 0;
	public static int vagrantSpirit = 0;
	public static int nobleSpirit = 0;
	public static int heartSpirit = 0;
	public static int liquidInnocence = 0;
	public static int stolenMoonlight = 0;
	public static int rationalThought = 0;
	public static int luckyClover = 0;
	public static int reforgedPlough = 0;
	public static int ivory = 0;

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

			default: break;
							
			}
						
		}		
				
	}
	
}
