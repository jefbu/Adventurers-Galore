package com.redhaan.adventurersGalore.entity.adventurer;

import java.util.Random;

public abstract class LevelUpRoller {
	
	private static Random random = new Random();
	
	public static void levelUp(Adventurer adventurer) {
				
		int hpRoll = random.nextInt(100) + 1;
		if (hpRoll <= adventurer.levelupPercentages.HP) { adventurer.maxStats.HP++; }
		int mpRoll = random.nextInt(100) + 1;
		if (mpRoll <= adventurer.levelupPercentages.MP) { adventurer.maxStats.MP++; }
		int phyRoll = random.nextInt(100) + 1;
		if (phyRoll <= adventurer.levelupPercentages.PHY) { adventurer.maxStats.PHY++; }
		int agiRoll = random.nextInt(100) + 1;
		if (agiRoll <= adventurer.levelupPercentages.AGI) { adventurer.maxStats.AGI++; }
		int magRoll = random.nextInt(100) + 1;
		if (magRoll <= adventurer.levelupPercentages.MAG) { adventurer.maxStats.MAG++; }
		int dexRoll = random.nextInt(100) + 1;
		if (dexRoll <= adventurer.levelupPercentages.DEX) { adventurer.maxStats.DEX++; }
		int intRoll = random.nextInt(100) + 1;
		if (intRoll <= adventurer.levelupPercentages.INT) { adventurer.maxStats.INT++; }
		int prcRoll = random.nextInt(100) + 1;
		if (prcRoll <= adventurer.levelupPercentages.PRC) { adventurer.maxStats.PRC++; }
		int movRoll = random.nextInt(100) + 1;
		if (movRoll <= adventurer.levelupPercentages.move) { adventurer.maxStats.move++; }


		adventurer.setLevel(adventurer.getLevel() + 1);
		switch(adventurer.getLevel()) {
		case 10: jobChange(adventurer); break;
		case 20: jobChange(adventurer); break;
		default: break;
		}
		
		adventurer.currentStats.HP = adventurer.maxStats.HP;
		adventurer.currentStats.MP = adventurer.maxStats.MP;
		adventurer.currentStats.PHY = adventurer.maxStats.PHY;
		adventurer.currentStats.AGI = adventurer.maxStats.AGI;
		adventurer.currentStats.MAG = adventurer.maxStats.MAG;
		adventurer.currentStats.DEX = adventurer.maxStats.DEX;
		adventurer.currentStats.INT = adventurer.maxStats.INT;
		adventurer.currentStats.PRC = adventurer.maxStats.PRC;
		adventurer.currentStats.move = adventurer.maxStats.move;

		adventurer.calculateSecondaryStats();
		
	}
	
	
	
	private static void jobChange(Adventurer adventurer) {
		
		switch(adventurer.job.jobEnum) {
		
		case Squire: adventurer.job = Job.knight; adventurer.icon = adventurer.job.icon; break;
		case Knight: adventurer.job = Job.paladin; adventurer.icon = adventurer.job.icon; break;
		case Thief: adventurer.job = Job.knave; adventurer.icon = adventurer.job.icon; break;
		case Knave: adventurer.job = Job.catBurglar; adventurer.icon = adventurer.job.icon; break;
		case Mage: adventurer.job = Job.magus; adventurer.icon = adventurer.job.icon; break;
		case Magus: adventurer.job = Job.archMage; adventurer.icon = adventurer.job.icon; break;
		case Barbarian: adventurer.job = Job.berserker; adventurer.icon = adventurer.job.icon; break;
		case Berserker: adventurer.job = Job.redMist; adventurer.icon = adventurer.job.icon; break;
		case Archer: adventurer.job = Job.hunter; adventurer.icon = adventurer.job.icon; break;
		case Hunter: adventurer.job = Job.sniper; adventurer.icon = adventurer.job.icon; break;
			
		default: System.out.println("Error at Job Change"); break;
		
		}
		
		
	}

}
