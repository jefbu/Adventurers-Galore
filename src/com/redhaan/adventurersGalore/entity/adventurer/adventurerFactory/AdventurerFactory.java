package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Arrays;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.personality.PersonalityTrait;
import com.redhaan.adventurersGalore.entity.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.town.Towns;

public class AdventurerFactory {

	private Adventurer adventurer;

	private JobFactory jobFactory = new JobFactory();
	private LevelFactory levelFactory = new LevelFactory();
	private RaceFactory raceFactory = new RaceFactory();
	private NameFactory nameFactory = new NameFactory();
	private WeaponFactory weaponFactory = new WeaponFactory();
	private TattooFactory tattooFactory = new TattooFactory();
	private AffinityFactory affinityFactory = new AffinityFactory();

	public AdventurerFactory() { }

	public Adventurer createRandomAdventurer() {

		createAdventurer(rollTier());
		return adventurer;

	}

	public Adventurer createTieredAdventurer(int tier) {
		createAdventurer(tier);
		return adventurer;
	}

	private void createAdventurer(int tier) {

		adventurer = new Adventurer();
		adventurer.tier = tier;

		adventurer.race = raceFactory.setRace(adventurer.tier);
		adventurer.job = jobFactory.setJob(adventurer.race, adventurer.getLevel());
		adventurer.icon = adventurer.job.icon;
		//adventurer.levelupPercentages = levelFactory.setLevelPercentages(adventurer);

		Random random = new Random();
		adventurer.gender = "Male";
		if (random.nextBoolean()) {
			adventurer.gender = "Female";
		}
		adventurer.name = nameFactory.rollName(adventurer.race, adventurer.gender);
		adventurer.age = rollAge();

		adventurer.weapon = weaponFactory.rollAdventurerStartingWeapon(adventurer.tier, adventurer.maxStats.PHY, adventurer.job);
		adventurer.armour = new ReinforcedLeather();
		
		createBaseStats();
		createDerivateStats();
		
		int level = levelFactory.setBaseLevel(adventurer.tier);
		for (int i = 0; i < level; i++) {
			adventurer.levelUp();
		}

		rollHomeTown();
		rollPersonality();

		
		adventurer.tattooSlots = tattooFactory.rollTattooSlots(adventurer.tier, adventurer.tattooSlots);
		adventurer.tattoos = tattooFactory.rollTattoos(adventurer.tattooSlots);
		adventurer.affinities = affinityFactory.rollAffinities(adventurer.tier, adventurer.race, adventurer.job);
		

	}

	private void createBaseStats() {

		Random random = new Random();

		adventurer.maxStats.HP = (15 + adventurer.race.raceBonusStats.HP + adventurer.job.jobBonusStats.HP + rollRandomStats()  + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.MP = (10 + adventurer.race.raceBonusStats.MP + adventurer.job.jobBonusStats.MP + rollRandomStats()  + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.PHY = (5 + adventurer.race.raceBonusStats.PHY + adventurer.job.jobBonusStats.PHY + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.AGI = (5 + adventurer.race.raceBonusStats.AGI + adventurer.job.jobBonusStats.AGI + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.MAG = (5 + adventurer.race.raceBonusStats.MAG + adventurer.job.jobBonusStats.MAG + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.DEX = (5 + adventurer.race.raceBonusStats.DEX + adventurer.job.jobBonusStats.DEX + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.PRC = (5 + adventurer.race.raceBonusStats.PRC + adventurer.job.jobBonusStats.PRC + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.INT = (5 + adventurer.race.raceBonusStats.INT + adventurer.job.jobBonusStats.INT + rollRandomStats() + rollTierBonusStats(adventurer.tier));
		adventurer.maxStats.TST = (20 + random.nextInt(21));
		adventurer.maxStats.FUN = (random.nextInt(100) + 1);
		adventurer.maxStats.move = (3 + adventurer.race.raceBonusStats.move + adventurer.job.jobBonusStats.move);

		adventurer.currentStats.HP = adventurer.maxStats.HP;
		adventurer.currentStats.MP = adventurer.maxStats.MP;
		adventurer.currentStats.PHY = adventurer.maxStats.PHY;
		adventurer.currentStats.AGI = adventurer.maxStats.AGI;
		adventurer.currentStats.MAG = adventurer.maxStats.MAG;
		adventurer.currentStats.DEX = adventurer.maxStats.DEX;
		adventurer.currentStats.PRC = adventurer.maxStats.PRC;
		adventurer.currentStats.INT = adventurer.maxStats.INT;
		adventurer.currentStats.TST = adventurer.maxStats.TST;
		adventurer.currentStats.FUN = adventurer.maxStats.FUN;
		adventurer.currentStats.move = adventurer.maxStats.move;
		
		adventurer.levelupPercentages.HP = 10 + adventurer.race.percentageStats.HP + adventurer.job.percentageStats.HP + rollTierStatBonus(adventurer.tier) + random.nextInt(11);
		adventurer.levelupPercentages.MP = 5 + adventurer.race.percentageStats.MP + adventurer.job.percentageStats.MP + rollTierStatBonus(adventurer.tier) + random.nextInt(6);
		adventurer.levelupPercentages.PHY = 10 + adventurer.race.percentageStats.PHY + adventurer.job.percentageStats.PHY + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.AGI = 10 + adventurer.race.percentageStats.AGI + adventurer.job.percentageStats.AGI + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.MAG = 10 + adventurer.race.percentageStats.MAG + adventurer.job.percentageStats.MAG + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.DEX = 10 + adventurer.race.percentageStats.DEX + adventurer.job.percentageStats.DEX + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.INT = 10 + adventurer.race.percentageStats.INT + adventurer.job.percentageStats.INT + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.PRC = 10 + adventurer.race.percentageStats.PRC + adventurer.job.percentageStats.PRC + rollTierStatBonus(adventurer.tier)+ random.nextInt(11); 
		adventurer.levelupPercentages.move = 5 + adventurer.job.percentageStats.move + random.nextInt(6); 
				

	}

	private void createDerivateStats() {

		adventurer.calculateSecondaryStats();
		
	}

	private int rollTierBonusStats(int tier) {

		Random random = new Random();
		int roll = random.nextInt(10) + 1;
		switch(tier) {
		case 0: if (roll < 8) { return 0; } else if (roll < 10) { return 1; } else { return 2; }
		case 1: if (roll < 7) { return 0; } else if (roll < 10) { return 1; } else { return 2; }
		case 2: if (roll < 6) { return 0; } else if (roll < 10) { return 1; } else { return 2; }
		case 3: if (roll < 6) { return 0; } else if (roll < 9) { return 1; } else { return 2; }
		case 4: if (roll < 5) { return 0; } else if (roll < 8) { return 1; } else { return 2; }
		default: return 0;
		}

	}

	private int rollRandomStats() {
		Random random = new Random();
		int roll = random.nextInt(10) + 1;
		switch(roll) {
		case 1: return 0;
		case 2: return 0;
		case 3: return 0;
		case 4: return 0;
		case 5: return 0;
		case 6: return 0;
		case 7: return 1;
		case 8: return 1;
		case 9: return 1;
		case 10: return 2;
		default: return 0;
		}
		
	}

	private int rollTier() {

		Random random = new Random();
		int roll = random.nextInt(100 + 1);
		if (roll < 66) {
			return 2;
		} else if (roll < 90) {
			return 3;
		} else
			return 4;

	}

	private void rollHomeTown() {

		Random random = new Random();
		int roll = random.nextInt(Towns.allTowns.size());
		adventurer.homeTown = Towns.allTowns.get(roll);
		adventurer.mapX = adventurer.homeTown.xLocations[0];
		adventurer.mapY = adventurer.homeTown.yLocations[0];

	}
	
	private void rollPersonality() {
		
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int roll = random.nextInt(4);
			switch(roll) {
			case 0: adventurer.personality.traits.add(PersonalityTrait.Cynical); break;
			case 1: adventurer.personality.traits.add(PersonalityTrait.Drunk); break;
			case 2: adventurer.personality.traits.add(PersonalityTrait.Pedantic); break;
			case 3: adventurer.personality.traits.add(PersonalityTrait.Witty); break;
			default: 	System.out.println("Error at personality trait factory");
						adventurer.personality.traits.add(PersonalityTrait.Pedantic);
						break;
			}
		}
	}
	
	private int rollAge() {
		
		Random random = new Random();
		int[] rolls = new int[3];
		rolls[0] = random.nextInt(60);
		rolls[1] = random.nextInt(60);
		rolls[2] = random.nextInt(60);
		
		Arrays.sort(rolls);		
		return rolls[0] + 16;
		
		
	}
	
	private int rollTierStatBonus(int tier) {
		
		switch (tier) {
		case 0: return 0;
		case 1: return 2;
		case 2: return 3;
		case 3: return 4;
		case 4: return 5;
		default: return 100;
		}
		
		
	}

}
