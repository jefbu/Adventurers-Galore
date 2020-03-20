package com.redhaan.adventurersGalore.entity.adventurer;

public class Race {

	public Stats raceBonusStats;
	public Stats percentageStats;
	public String name;
	
	public RaceEnum raceEnum;

	public Race(RaceEnum raceEnum, String name, int bonusHP, int bonusMP, int bonusPHY, int bonusAGI, int bonusMAG, int bonusDEX,
			int bonusPRC, int bonusINT, int bonusMOVE, int levelHP, int levelMP, int levelPHY, int levelAGI, int levelMAG, int levelINT, int levelDEX, int levelPRC) {

		raceBonusStats = new Stats();
		percentageStats = new Stats();

		this.name = name;
		raceBonusStats.HP = bonusHP;
		raceBonusStats.MP = bonusMP;
		raceBonusStats.PHY = bonusPHY;
		raceBonusStats.AGI = bonusAGI;
		raceBonusStats.MAG = bonusMAG;
		raceBonusStats.DEX = bonusDEX;
		raceBonusStats.PRC = bonusPRC;
		raceBonusStats.INT = bonusINT;
		raceBonusStats.move = bonusMOVE;
		
		percentageStats.HP = levelHP;
		percentageStats.MP = levelMP;
		percentageStats.PHY = levelPHY;
		percentageStats.AGI = levelAGI;
		percentageStats.MAG = levelMAG;
		percentageStats.DEX = levelDEX;
		percentageStats.PRC = levelPRC;
		percentageStats.INT = levelINT;							
		
		this.raceEnum = raceEnum;

	}

	public static Race human = new Race(RaceEnum.Human, "Human @  $  &", 2, 2, 1, 1, 1, 1, 1, 1, 1, 10, 5, 10, 10, 5, 10, 5, 10);
	public static Race elf = new Race(RaceEnum.Elf, "Elf", 0, 5, 0, 1, 2, 0, 0, 0, 2, 5, 10, 5, 10, 10, 5, 5, 5);
	public static Race dwarf = new Race(RaceEnum.Dwarf, "Dwarf", 5, 0, 3, 0, 0, 1, 2, 1, 0, 15, 5, 15, 5, 5, 10, 10, 10);
	public static Race dryad = new Race(RaceEnum.Dryad, "Dryad", 3, 2, 1, 1, 2, 0, 0, 1, 1, 10, 10, 10, 10, 10, 5, 5, 5);

}
