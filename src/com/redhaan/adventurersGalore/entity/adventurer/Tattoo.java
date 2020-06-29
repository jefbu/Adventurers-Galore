package com.redhaan.adventurersGalore.entity.adventurer;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Tattoo {
	
	public ImageTile icon;
	public int iconX, iconY;
	public String name;
	public Stats statBonuses;
	
	public Tattoo(int iconX, int iconY, String name,  int bonusPHY, int bonusAGI, int bonusMAG, int bonusDEX, int bonusPRC, int bonusINT) {
		
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
	
	public static Tattoo kestrel = new Tattoo(0, 0, "Kestrel", 0, 1, 0, 0, 1, 0);
	public static Tattoo fox = new Tattoo(1, 0, "Fox", 0, 1, 0, 1, 0, 0);
	public static Tattoo bull = new Tattoo(2, 0, "Bull", 1, 0, 0, 0, 0, 1);
	public static Tattoo butterfly = new Tattoo(3, 0, "Butterfly", 0, 0, 1, 1, 0, 0);
	
	
	

}
