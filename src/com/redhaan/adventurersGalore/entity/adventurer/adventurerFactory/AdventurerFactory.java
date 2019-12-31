package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Arrays;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.town.Towns;
import com.redhaan.adventurersGalore.entity.weapon.swords.Excalibur;

public class AdventurerFactory {

	private Adventurer adventurer;

	private JobFactory jobFactory = new JobFactory();
	private LevelFactory levelFactory = new LevelFactory();
	private RaceFactory raceFactory = new RaceFactory();
	private NameFactory nameFactory = new NameFactory();
	private WeaponFactory weaponFactory = new WeaponFactory();

	public AdventurerFactory() {

	}

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

		adventurer.setLevel(levelFactory.setBaseLevel(adventurer.tier));
		adventurer.race = raceFactory.setRace(adventurer.tier);
		adventurer.job = jobFactory.setJob(adventurer.race, adventurer.getLevel());
		adventurer.icon = adventurer.job.icon;

		Random random = new Random();
		adventurer.gender = "Male";
		if (random.nextBoolean()) {
			adventurer.gender = "Female";
		}
		adventurer.name = nameFactory.rollName(adventurer.race, adventurer.gender);
		adventurer.age = rollAge();

		createBaseStats();
		createDerivateStats();
		for (int i = 1; i < adventurer.getLevel(); i++) {
			adventurer.levelUp();
		}

		rollHomeTown();
		adventurer.weapon = weaponFactory.rollAdventurerStartingWeapon(adventurer.tier, adventurer.maxStats.PHY, adventurer.job);
		adventurer.armour = new ReinforcedLeather();

	}

	private void createBaseStats() {

		Random random = new Random();

		adventurer.maxStats.HP = (200 + adventurer.race.raceBonusStats.HP + adventurer.job.jobBonusStats.HP + rollRandomStats() * 10 + rollTierBonusStats() * 10);
		adventurer.maxStats.MP = (50 + adventurer.race.raceBonusStats.MP + adventurer.job.jobBonusStats.MP + rollRandomStats() * 10 + rollTierBonusStats() * 10);
		adventurer.maxStats.PHY = (30 + adventurer.race.raceBonusStats.PHY + adventurer.job.jobBonusStats.PHY + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.AGI = (30 + adventurer.race.raceBonusStats.AGI + adventurer.job.jobBonusStats.AGI + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.MAG = (30 + adventurer.race.raceBonusStats.MAG + adventurer.job.jobBonusStats.MAG + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.DEX = (30 + adventurer.race.raceBonusStats.DEX + adventurer.job.jobBonusStats.DEX + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.PRC = (30 + adventurer.race.raceBonusStats.PRC + adventurer.job.jobBonusStats.PRC + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.INT = (30 + adventurer.race.raceBonusStats.INT + adventurer.job.jobBonusStats.INT + rollRandomStats() + rollTierBonusStats());
		adventurer.maxStats.TST = (20 + random.nextInt(21));
		adventurer.maxStats.FUN = (random.nextInt(100) + 1);

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

	}

	private void createDerivateStats() {

		adventurer.calculateSecondaryStats();
		
	}

	private int rollTierBonusStats() {

		Random random = new Random();
		int roll = 0;
		while (roll <= adventurer.tier) {
			int tempRoll = random.nextInt(10) + 1;
			if (tempRoll > roll) {
				roll = tempRoll;
			}
		}

		return roll;

	}

	private int rollRandomStats() {
		Random random = new Random();
		int roll = random.nextInt(10) + 1;
		return roll;
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

}
