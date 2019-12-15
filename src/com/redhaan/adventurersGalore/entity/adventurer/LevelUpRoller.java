package com.redhaan.adventurersGalore.entity.adventurer;

import java.util.Random;

public abstract class LevelUpRoller {
	
	private static Random random = new Random();
	
	public static void levelUp(Adventurer adventurer) {
		
		switch(adventurer.job.jobEnum) {
		
		case Squire:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 8);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 2);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Knight:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(5) + 8);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 4);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(2) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;
		case Paladin:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 10);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 6);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;
			
		case Mage:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 4);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 4);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(2));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Magus:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 5);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 6);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(2) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;
		case ArchMage:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 6);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(5) + 6);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2) + 2);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(2) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3) + 1);
			break;
			
		case Thief:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 6);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 2);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Knave:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(5) + 6);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 3);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(2) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(2) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;
		case CatBurglar:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 8);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 4);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(2) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 2);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3) + 1);
			break;
			
		case Archer:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 6);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 2);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3));
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Hunter:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 8);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 2);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(2) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3) + 1);
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Sniper:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(3) + 10);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 6);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3) + 1);
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;
			
		case Barbarian:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(5) + 8);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3));
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(3));
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case Berserker:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(5) + 10);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3));
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(2));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(3));
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(3));
			break;
		case RedMist:
			adventurer.maxStats.HP = (adventurer.maxStats.HP + random.nextInt(5) + 12);
			adventurer.maxStats.MP = (adventurer.maxStats.MP + random.nextInt(3) + 2);
			adventurer.maxStats.PHY = (adventurer.maxStats.PHY + random.nextInt(3) + 1);
			adventurer.maxStats.AGI = (adventurer.maxStats.AGI + random.nextInt(2) + 1);
			adventurer.maxStats.MAG = (adventurer.maxStats.MAG + random.nextInt(3));
			adventurer.maxStats.DEX = (adventurer.maxStats.DEX + random.nextInt(2) + 1);
			adventurer.maxStats.PRC = (adventurer.maxStats.PRC + random.nextInt(3));
			adventurer.maxStats.INT = (adventurer.maxStats.INT + random.nextInt(2) + 1);
			break;

				
		}
		
	}

}
