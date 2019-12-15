package com.redhaan.adventurersGalore.entity.adventurer;

public class Race {

	public Stats raceBonusStats;
	public String name;
	
	public RaceEnum raceEnum;

	public Race(RaceEnum raceEnum, String name, int bonusHP, int bonusMP, int bonusPHY, int bonusAGI, int bonusMAG, int bonusDEX,
			int bonusPRC, int bonusINT) {

		raceBonusStats = new Stats();

		this.name = name;
		raceBonusStats.HP = bonusHP;
		raceBonusStats.MP = bonusMP;
		raceBonusStats.PHY = bonusPHY;
		raceBonusStats.AGI = bonusAGI;
		raceBonusStats.MAG = bonusMAG;
		raceBonusStats.DEX = bonusDEX;
		raceBonusStats.PRC = bonusPRC;
		raceBonusStats.INT = bonusINT;
		
		this.raceEnum = raceEnum;

	}

	public static Race human = new Race(RaceEnum.Human, "Human @  $  &", 60, 40, 5, 5, 5, 5, 5, 5);
	public static Race elf = new Race(RaceEnum.Elf, "Elf", 30, 70, 0, 10, 10, 10, 0, 0);
	public static Race dwarf = new Race(RaceEnum.Dwarf, "Dwarf", 75, 25, 10, 0, 0, 10, 5, 5);
	public static Race dryad = new Race(RaceEnum.Dryad, "Dryad", 50, 50, 10, 10, 10, 0, 0, 0);

}
