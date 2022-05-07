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
	public static int ivory = 10;

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
	public static int springBreeze = 10;
	public static int morningSunlight = 10;
	public static int pentupAnger = 10;
	public static int gloriousMoment = 10;
	public static int elysianFlower = 10;
	public static int wanderlust = 10;
	
	public static int snakeTongue = 4;
	public static int robinEgg = 7;
	public static int turtleShell = 7;
	public static int volcanicAsh = 6;
	public static int bile = 8;
	public static int lizardEye = 9;
	public static int ectoplasm = 11;
	public static int giantToe = 5;
	
	public static int bezoar = 6;
	public static int vampireDust = 5;
	public static int historicDocument = 7;
	public static int phoenixFeather = 4;
	public static int unicornHorn = 4;
	public static int dragonBlood = 5;
	public static int mummyWrapping = 8;
	public static int daemonHeart = 9;
	public static int manaTreeBranch = 4;

	public static ArrayList<Item> armours;
	public static ArrayList<Item> weapons;
	
	public static boolean weaponChange;
	public static boolean armourChange;
	
	public static int whitePotion = 1;
	public static int goldPotion = 1;
	public static int tealPotion = 1;
	public static int redPotion = 1;
	public static int greenPotion = 1;
	public static int bluePotion = 1;
	public static int brownPotion = 1;
	public static int purplePotion = 1;
	public static int blackPotion = 10;
	
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
	
	public static int kestrel = 0;
	public static int fox = 0;
	public static int bull = 0;
	public static int butterfly = 0;
	
	public static int cheapPearl = 0;
	public static int basicPearl = 0;
	public static int qualityPearl = 0;
	public static int flawlessPearl = 0;

	public static int cheapTopaz = 0;
	public static int basicTopaz = 0;
	public static int qualityTopaz = 0;
	public static int flawlessTopaz = 0;
	
	public static int cheapTurquoise = 0;
	public static int basicTurquoise = 0;
	public static int qualityTurquoise = 0;
	public static int flawlessTurquoise = 0;
	
	public static int cheapRuby = 0;
	public static int basicRuby = 0;
	public static int qualityRuby = 0;
	public static int flawlessRuby = 0;

	public static int cheapEmerald = 0;
	public static int basicEmerald = 0;
	public static int qualityEmerald = 0;
	public static int flawlessEmerald = 0;
	
	public static int cheapSapphire = 0;
	public static int basicSapphire = 0;
	public static int qualitySapphire = 0;
	public static int flawlessSapphire = 0;
	
	public static int cheapAmber = 0;
	public static int basicAmber = 0;
	public static int qualityAmber = 0;
	public static int flawlessAmber = 0;
	
	public static int cheapAmethyst = 0;
	public static int basicAmethyst = 0;
	public static int qualityAmethyst = 0;
	public static int flawlessAmethyst = 0;
	
	public static int cheapOnyx = 0;
	public static int basicOnyx = 0;
	public static int qualityOnyx = 0;
	public static int flawlessOnyx = 0;
	
	
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
			
			case whitePotion: whitePotion++; break;
			case goldPotion: goldPotion++; break;
			case tealPotion: tealPotion++; break;
			case redPotion: redPotion++; break;
			case greenPotion: greenPotion++; break;
			case bluePotion: bluePotion++; break;
			case brownPotion: brownPotion++; break;
			case purplePotion: purplePotion++; break;
			case blackPotion: blackPotion++; break;
			
			case ay: ay++; break;
			case bir: bir++; break;
			case cit: cit++; break;
			case dol: dol++; break;
			case fu: fu++; break;
			case ges: ges++; break;
			case hom: hom++; break;
			case il: il++; break;
			case kam: kam++; break;
			case tiy: tiy++; break;
			case var: var++; break;
			case wos: wos++; break;
			case yut: yut++; break;
			
			case kestrel: kestrel++; break;
			case fox: fox++; break;
			case bull: bull++; break;
			case butterfly: butterfly++; break;
			
			case cheapPearl: cheapPearl++; break;
			case basicPearl: basicPearl++; break;
			case qualityPearl: qualityPearl++; break;
			case flawlessPearl: flawlessPearl++; break;
			case cheapTopaz: cheapTopaz++; break;
			case basicTopaz: basicTopaz++; break;
			case qualityTopaz: qualityTopaz++; break;
			case flawlessTopaz: flawlessTopaz++; break;
			case cheapTurquoise: cheapTurquoise++; break;
			case basicTurquoise: basicTurquoise++; break;
			case qualityTurquoise: qualityTurquoise++; break;
			case flawlessTurquoise: flawlessTurquoise++; break;
			case cheapRuby: cheapRuby++; break;
			case basicRuby: basicRuby++; break;
			case qualityRuby: qualityRuby++; break;
			case flawlessRuby: flawlessRuby++; break;
			case cheapEmerald: cheapEmerald++; break;
			case basicEmerald: basicEmerald++; break;
			case qualityEmerald: qualityEmerald++; break;
			case flawlessEmerald: flawlessEmerald++; break;
			case cheapSapphire: cheapSapphire++; break;
			case basicSapphire: basicSapphire++; break;
			case qualitySapphire: qualitySapphire++; break;
			case flawlessSapphire: flawlessSapphire++; break;
			case cheapAmber: cheapAmber++; break;
			case basicAmber: basicAmber++; break;
			case qualityAmber: qualityAmber++; break;
			case flawlessAmber: flawlessAmber++; break;
			case cheapAmethyst: cheapAmethyst++; break;
			case basicAmethyst: basicAmethyst++; break;
			case qualityAmethyst: qualityAmethyst++; break;
			case flawlessAmethyst: flawlessAmethyst++; break;
			case cheapOnyx: cheapOnyx++; break;
			case basicOnyx: basicOnyx++; break;
			case qualityOnyx: qualityOnyx++; break;
			case flawlessOnyx: flawlessOnyx++; break;			
			
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
