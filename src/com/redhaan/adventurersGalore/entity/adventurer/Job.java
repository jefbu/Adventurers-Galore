package com.redhaan.adventurersGalore.entity.adventurer;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Job {

	public Stats jobBonusStats;
	public String name;

	public JobEnum jobEnum;
	
	public ImageTile icon;

	public Job(JobEnum jobEnum, String name, int bonusHP, int bonusMP, int bonusPHY, int bonusAGI, int bonusMAG,
			int bonusDEX, int bonusPRC, int bonusINT, int bonusMove, ImageTile icon) {

		jobBonusStats = new Stats();
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
		
		this.icon = icon;

	}

	public static Job squire = new Job(JobEnum.Squire, "Squire", 80, 20, 10, 10, 5, 0, 5, 0, 4, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job knight = new Job(JobEnum.Knight, "Knight", 90, 30, 10, 10, 10, 0, 10, 10, 4, new ImageTile("/knight.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job paladin = new Job(JobEnum.Paladin, "Paladin", 90, 60, 15, 10, 15, 5, 10, 15, 5, new ImageTile("/paladin.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	
	public static Job mage = new Job(JobEnum.Mage, "Mage", 0, 100, 0, 0, 10, 5, 5, 10, 4, new ImageTile("/mage.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job magus = new Job(JobEnum.Magus, "Magus", 10, 110, 0, 5, 15, 5, 10, 15, 4, new ImageTile("/magus.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job archMage = new Job(JobEnum.ArchMage, "Archmage", 20, 130, 5, 5, 20, 5, 15, 20, 4, new ImageTile("/archmage.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));

	public static Job thief = new Job(JobEnum.Thief, "Thief", 50, 50, 0, 10, 0, 5, 10, 5, 5, new ImageTile("/thief.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job knave = new Job(JobEnum.Knave, "Knave", 60, 60, 5, 15, 5, 10, 10, 5, 5, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job catBurglar = new Job(JobEnum.CatBurglar, "Catburglar", 80, 70, 10, 20, 5, 10, 15, 10, 6, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));

	public static Job archer = new Job(JobEnum.Archer, "Archer", 60, 40, 5, 5, 0, 5, 10, 5, 4, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job hunter = new Job(JobEnum.Hunter, "Hunter", 80, 40, 10, 10, 5, 5, 15, 5, 5, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job sniper = new Job(JobEnum.Sniper, "Sniper", 100, 50, 10, 15, 10, 10, 20, 5, 5, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));

	public static Job barbarian = new Job(JobEnum.Barbarian, "Barbarian", 100, 0, 10, 10, 0, 0, 5, 5, 4, new ImageTile("/barbarian.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job berserker = new Job(JobEnum.Berserker, "Berserker", 120, 0, 15, 10, 5, 5, 10, 5, 4, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));
	public static Job redMist = new Job(JobEnum.RedMist, "Red Mist", 150, 0, 20, 15, 5, 10, 10, 10, 5, new ImageTile("/squire.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE));


}
