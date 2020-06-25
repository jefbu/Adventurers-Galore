package com.redhaan.adventurersGalore.entity.adventurer;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Tattoo {
	
	public ImageTile icon;
	public int iconX, iconY;
	public String name;
	public Stats statBonuses;
	
	public Tattoo(String name, int iconX, int iconY, int bonusPHY, int bonusAGI, int bonusMAG, int bonusDEX, int bonusPRC, int bonusINT) {
		
		icon = new ImageTile("/tattoos.png", GameManager.GAMETILESIZE * 2, GameManager.GAMETILESIZE * 2);
		this.iconX = iconX;
		this.iconY = iconY;
		this.name = name;
		statBonuses = new Stats();
		statBonuses.PHY = bonusPHY;
		statBonuses.AGI = bonusAGI;
		statBonuses.MAG = bonusMAG;
		statBonuses.DEX = bonusDEX;
		statBonuses.PRC = bonusPRC;
		statBonuses.INT = bonusINT;		
		
	}
	
	public static Tattoo kestrel = new Tattoo("Kestrel", 0, 0, 0, 1, 0, 0, 1, 0);
	public static Tattoo fox = new Tattoo("Fox", 1, 0, 0, 1, 0, 1, 0, 0);
	
	
	

}
