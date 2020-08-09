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
		
		case Squire: adventurer.job = Job.knight; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.knight.jobBonusStats.HP - Job.squire.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.knight.jobBonusStats.MP - Job.squire.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.knight.jobBonusStats.PHY - Job.squire.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.knight.jobBonusStats.AGI - Job.squire.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.knight.jobBonusStats.MAG - Job.squire.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.knight.jobBonusStats.DEX - Job.squire.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.knight.jobBonusStats.INT - Job.squire.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.knight.jobBonusStats.PRC - Job.squire.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.knight.jobBonusStats.move - Job.squire.jobBonusStats.move;
		break;
		
		case Knight: adventurer.job = Job.paladin; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.paladin.jobBonusStats.HP - Job.knight.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.paladin.jobBonusStats.MP - Job.knight.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.paladin.jobBonusStats.PHY - Job.knight.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.paladin.jobBonusStats.AGI - Job.knight.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.paladin.jobBonusStats.MAG - Job.knight.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.paladin.jobBonusStats.DEX - Job.knight.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.paladin.jobBonusStats.INT - Job.knight.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.paladin.jobBonusStats.PRC - Job.knight.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.paladin.jobBonusStats.move - Job.knight.jobBonusStats.move;		
		break;
		
		case Thief: adventurer.job = Job.knave; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.knave.jobBonusStats.HP - Job.thief.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.knave.jobBonusStats.MP - Job.thief.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.knave.jobBonusStats.PHY - Job.thief.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.knave.jobBonusStats.AGI - Job.thief.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.knave.jobBonusStats.MAG - Job.thief.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.knave.jobBonusStats.DEX - Job.thief.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.knave.jobBonusStats.INT - Job.thief.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.knave.jobBonusStats.PRC - Job.thief.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.knave.jobBonusStats.move - Job.thief.jobBonusStats.move;
		break;
		
		case Knave: adventurer.job = Job.catBurglar; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.catBurglar.jobBonusStats.HP - Job.knave.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.catBurglar.jobBonusStats.MP - Job.knave.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.catBurglar.jobBonusStats.PHY - Job.knave.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.catBurglar.jobBonusStats.AGI - Job.knave.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.catBurglar.jobBonusStats.MAG - Job.knave.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.catBurglar.jobBonusStats.DEX - Job.knave.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.catBurglar.jobBonusStats.INT - Job.knave.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.catBurglar.jobBonusStats.PRC - Job.knave.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.catBurglar.jobBonusStats.move - Job.knave.jobBonusStats.move;
		break;
		
		
		case Mage: adventurer.job = Job.magus; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.magus.jobBonusStats.HP - Job.mage.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.magus.jobBonusStats.MP - Job.mage.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.magus.jobBonusStats.PHY - Job.mage.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.magus.jobBonusStats.AGI - Job.mage.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.magus.jobBonusStats.MAG - Job.mage.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.magus.jobBonusStats.DEX - Job.mage.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.magus.jobBonusStats.INT - Job.mage.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.magus.jobBonusStats.PRC - Job.mage.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.magus.jobBonusStats.move - Job.mage.jobBonusStats.move;
		break;
		
		case Magus: adventurer.job = Job.archMage; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.archMage.jobBonusStats.HP - Job.magus.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.archMage.jobBonusStats.MP - Job.magus.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.archMage.jobBonusStats.PHY - Job.magus.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.archMage.jobBonusStats.AGI - Job.magus.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.archMage.jobBonusStats.MAG - Job.magus.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.archMage.jobBonusStats.DEX - Job.magus.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.archMage.jobBonusStats.INT - Job.magus.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.archMage.jobBonusStats.PRC - Job.magus.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.archMage.jobBonusStats.move - Job.magus.jobBonusStats.move;
		break;
		
		case Barbarian: adventurer.job = Job.berserker; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.berserker.jobBonusStats.HP - Job.barbarian.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.berserker.jobBonusStats.MP - Job.barbarian.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.berserker.jobBonusStats.PHY - Job.barbarian.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.berserker.jobBonusStats.AGI - Job.barbarian.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.berserker.jobBonusStats.MAG - Job.barbarian.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.berserker.jobBonusStats.DEX - Job.barbarian.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.berserker.jobBonusStats.INT - Job.barbarian.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.berserker.jobBonusStats.PRC - Job.barbarian.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.berserker.jobBonusStats.move - Job.barbarian.jobBonusStats.move;
		break;
		
		case Berserker: adventurer.job = Job.redMist; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.redMist.jobBonusStats.HP - Job.berserker.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.redMist.jobBonusStats.MP - Job.berserker.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.redMist.jobBonusStats.PHY - Job.berserker.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.redMist.jobBonusStats.AGI - Job.berserker.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.redMist.jobBonusStats.MAG - Job.berserker.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.redMist.jobBonusStats.DEX - Job.berserker.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.redMist.jobBonusStats.INT - Job.berserker.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.redMist.jobBonusStats.PRC - Job.berserker.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.redMist.jobBonusStats.move - Job.berserker.jobBonusStats.move;
		break;
		
		case Archer: adventurer.job = Job.hunter; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.hunter.jobBonusStats.HP - Job.archer.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.hunter.jobBonusStats.MP - Job.archer.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.hunter.jobBonusStats.PHY - Job.archer.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.hunter.jobBonusStats.AGI - Job.archer.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.hunter.jobBonusStats.MAG - Job.archer.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.hunter.jobBonusStats.DEX - Job.archer.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.hunter.jobBonusStats.INT - Job.archer.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.hunter.jobBonusStats.PRC - Job.archer.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.hunter.jobBonusStats.move - Job.archer.jobBonusStats.move;
		break;
		
		case Hunter: adventurer.job = Job.sniper; adventurer.icon = adventurer.job.icon; 
			adventurer.maxStats.HP = adventurer.maxStats.HP + Job.sniper.jobBonusStats.HP - Job.hunter.jobBonusStats.HP;
			adventurer.maxStats.MP = adventurer.maxStats.MP + Job.sniper.jobBonusStats.MP - Job.hunter.jobBonusStats.MP;
			adventurer.maxStats.PHY = adventurer.maxStats.PHY + Job.sniper.jobBonusStats.PHY - Job.hunter.jobBonusStats.PHY;
			adventurer.maxStats.AGI = adventurer.maxStats.AGI + Job.sniper.jobBonusStats.AGI - Job.hunter.jobBonusStats.AGI;
			adventurer.maxStats.MAG = adventurer.maxStats.MAG + Job.sniper.jobBonusStats.MAG - Job.hunter.jobBonusStats.MAG;
			adventurer.maxStats.DEX = adventurer.maxStats.DEX + Job.sniper.jobBonusStats.DEX - Job.hunter.jobBonusStats.DEX;
			adventurer.maxStats.INT = adventurer.maxStats.INT + Job.sniper.jobBonusStats.INT - Job.hunter.jobBonusStats.INT;
			adventurer.maxStats.PRC = adventurer.maxStats.PRC + Job.sniper.jobBonusStats.PRC - Job.hunter.jobBonusStats.PRC;
			adventurer.maxStats.move = adventurer.maxStats.move + Job.sniper.jobBonusStats.move - Job.hunter.jobBonusStats.move;
		break;
			
		default: System.out.println("Error at Job Change"); break;
		
		}
		
		
	}

}
