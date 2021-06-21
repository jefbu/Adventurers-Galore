package com.redhaan.adventurersGalore.inventory;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.item.Item;

public class Inventory {
	
	public static int antlers = 10;
	public static int beastBlood = 10;
	public static int bone = 10;
	public static int claw = 10;
	public static int coral = 10;	
	public static int fang = 10;
	public static int gold = 10;
	public static int hide = 10;
	public static int iron = 10;
	public static int lesses = 10;
	public static int oakwood = 10;
	public static int pelt = 10;
	public static int silver = 10;
	public static int tusk = 10;
	public static int wing = 10;
	public static int evilSpirit = 10;
	public static int violentSpirit = 10;
	public static int spiritOfMischief = 10;
	public static int vagrantSpirit = 10;
	public static int nobleSpirit = 10;
	public static int heartSpirit = 10;
	public static int liquidInnocence = 10;
	public static int stolenMoonlight = 10;
	public static int rationalThought = 10;
	public static int luckyClover = 10;
	public static int reforgedPlough = 10;
	public static int ivory = 10;
	public static int springBreeze = 10;
	public static int morningSunlight = 10;
	public static int pentupAnger = 10;
	public static int gloriousMoment = 10;
	public static int elysianFlower = 10;
	public static int wanderlust = 10;

	public static ArrayList<Item> armours;
	public static ArrayList<Item> weapons;
	
	public static boolean weaponChange;
	public static boolean armourChange;
	
	public static int whitePotion = 17;
	public static int goldPotion = 9;
	public static int tealPotion = 13;
	public static int redPotion = 11;
	public static int greenPotion = 14;
	public static int bluePotion = 12;
	public static int brownPotion = 10;
	public static int purplePotion = 8;
	public static int blackPotion = 9;
	
	public static int ay = 1;
	public static int bir = 1;
	public static int cit = 1;
	public static int dol = 1;
	public static int fu = 1;
	public static int ges = 1;
	public static int hom = 1;
	public static int il = 1;
	public static int kam = 1;
	public static int tiy = 1;
	public static int var = 1;
	public static int wos = 1;
	public static int yut = 1;
	
	
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
