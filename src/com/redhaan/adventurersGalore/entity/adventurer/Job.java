package com.redhaan.adventurersGalore.entity.adventurer;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Job {

	public Stats jobBonusStats;
	public Stats percentageStats;
	public String name;

	public JobEnum jobEnum;
	
	public ImageTile icon;

	public Job(JobEnum jobEnum, String name, int bonusHP, int bonusMP, int bonusPHY, int bonusAGI, int bonusMAG,
			int bonusDEX, int bonusPRC, int bonusINT, int bonusMove, ImageTile icon, 
			int levelHP, int levelMP, int levelPHY, int levelAGI, int levelMAG, int levelDEX, int levelPRC, int levelINT, int levelMOVE) {

		jobBonusStats = new Stats();
		percentageStats = new Stats();
		this.jobEnum = jobEnum;

		this.name = name;
		jobBonusStats.HP = bonusHP;
		jobBonusStats.MP = bonusMP;
		jobBonusStats.PHY = bonusPHY;
		jobBonusStats.AGI = bonusAGI;
		jobBonusStats.MAG = bonusMAG;
		jobBonusStats.DEX = bonusDEX;
		jobBonusStats.PRC = bonusPRC;
		jobBonusStats.INT = bonusINT;
		jobBonusStats.move = bonusMove;
		
		percentageStats.HP = levelHP;
		percentageStats.MP = levelMP;
		percentageStats.PHY = levelPHY;
		percentageStats.AGI = levelAGI;
		percentageStats.MAG = levelMAG;
		percentageStats.DEX = levelDEX;
		percentageStats.INT = levelINT;
		percentageStats.PRC = levelPRC;
		percentageStats.move = levelMOVE;
		
		this.icon = icon;

	}

	public static Job squire = new Job(JobEnum.Squire, "Squire", 3, 0, 2, 1, 0, 0, 1, 1, 0, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			15, 5, 10, 10, 5, 5, 5, 10, 2);
	public static Job knight = new Job(JobEnum.Knight, "Knight", 5, 1, 3, 1, 1, 1, 1, 2, 0, new ImageTile("/knight.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE),
			15, 5, 10, 10, 5, 5, 5, 10, 2);
	public static Job paladin = new Job(JobEnum.Paladin, "Paladin", 6, 3, 3, 2, 2, 2, 2, 2, 1, new ImageTile("/paladin.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE),
			15, 5, 10, 10, 5, 5, 5, 10, 2);

	
	public static Job mage = new Job(JobEnum.Mage, "Mage", 0, 4, 0, 0, 2, 1, 0, 1, 0, new ImageTile("/mage.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			5, 15, 5, 5, 15, 10, 5, 5, 1);
	public static Job magus = new Job(JobEnum.Magus, "Magus", 1, 5, 0, 1, 3, 1, 1, 2, 0, new ImageTile("/magus.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			5, 15, 5, 5, 15, 10, 5, 5, 1);
	public static Job archMage = new Job(JobEnum.ArchMage, "Archmage", 3, 7, 0, 1, 5, 2, 2, 2, 1, new ImageTile("/archmage.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			5, 15, 5, 5, 15, 10, 5, 5, 1);

	
	public static Job thief = new Job(JobEnum.Thief, "Thief", 1, 2, 0, 2, 0, 0, 0, 1, 1, new ImageTile("/thief.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 5, 5, 15, 5, 5, 5, 5, 3);
	public static Job knave = new Job(JobEnum.Knave, "Knave", 2, 3, 1, 3, 0, 1, 1, 1, 1, new ImageTile("/knave.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 5, 5, 15, 5, 5, 5, 5, 3);
	public static Job catBurglar = new Job(JobEnum.CatBurglar, "Catburglar", 4, 4, 1, 5, 1, 1, 1, 1, 2, new ImageTile("/catburglar.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 5, 5, 15, 5, 5, 5, 5, 3);
	

	public static Job archer = new Job(JobEnum.Archer, "Archer", 2, 2, 1, 1, 0, 0, 1, 1, 0, new ImageTile("/archer.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 10, 10, 10, 5, 5, 5, 10, 3);
	public static Job hunter = new Job(JobEnum.Hunter, "Hunter", 3, 3, 2, 2, 1, 1, 2, 1, 0, new ImageTile("/hunter.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 10, 10, 10, 5, 5, 5, 10, 3);
	public static Job sniper = new Job(JobEnum.Sniper, "Sniper", 5, 4, 3, 3, 2, 2, 2, 1, 1, new ImageTile("/sniper.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			10, 10, 10, 10, 5, 5, 5, 10, 3);
	

	public static Job barbarian = new Job(JobEnum.Barbarian, "Barbarian", 4, 0, 3, 0, 0, 0, 0, 0, 0, new ImageTile("/barbarian.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			20, 0, 15, 5, 5, 5, 5, 5, 2);
	public static Job berserker = new Job(JobEnum.Berserker, "Berserker", 6, 1, 5, 1, 0, 1, 0, 0, 0, new ImageTile("/berserker.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			20, 0, 15, 5, 5, 5, 5, 5, 2);
	public static Job redMist = new Job(JobEnum.RedMist, "Red Mist", 8, 2, 6, 2, 0, 1, 1, 1, 1, new ImageTile("/redmist.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE), 
			20, 0, 15, 5, 5, 5, 5, 5, 2);


}
