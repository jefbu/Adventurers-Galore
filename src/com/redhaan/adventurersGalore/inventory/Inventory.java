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
	public static int springBreeze = 0;
	public static int morningSunlight = 0;
	public static int pentupAnger = 0;
	public static int gloriousMoment = 0;
	public static int elysianFlower = 0;
	public static int wanderlust = 0;

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
			case ElysianFlower: elysianFlower++; break;
			case EvilSpirit: evilSpirit++; break;
			case Fang: fang++; break;
			case GloriousMoment: gloriousMoment++; break;
			case Gold: gold++; break;
			case HeartSpirit: heartSpirit++; break;
			case Hide: hide++; break;
			case Iron: iron++; break;
			case Lesses: lesses++; break;
			case LiquidInnocence: liquidInnocence++; break;
			case LuckyClover: luckyClover++; break;
			case MorningSunlight: morningSunlight++; break;
			case NobleSpirit: nobleSpirit++; break;
			case OakWood: oakwood++; break;
			case Pelt: pelt++; break; 
			case PentUpAnger: pentupAnger++; break;
			case RationalThought: rationalThought++; break;
			case Silver: silver++; break;
			case SpiritOfMischief: spiritOfMischief++; break;
			case SpringBreeze: springBreeze++; break;
			case StolenMoonlight: stolenMoonlight++; break;
			case Tusk: tusk++; break;
			case VagrantSpirit: vagrantSpirit++; break;
			case ViolentSpirit: violentSpirit++; break;
			case Wanderlust: wanderlust++; break;
			
			default: System.out.println("error adding stuff to the loot, " + loot.get(i).name);break;
							
			}
						
		}		
				
	}
	
}
