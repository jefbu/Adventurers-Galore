package com.redhaan.adventurersGalore.entity.adventurer;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Tattoo extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	public ImageTile largeIcon;
	public int iconX, iconY;
	public Stats statBonuses;
	
	public Tattoo(int iconX, int iconY, String name,  int bonusPHY, int bonusAGI, int bonusMAG, int bonusDEX, int bonusPRC, int bonusINT, int xTile, int yTile, ItemID ID) {
		
		largeIcon = new ImageTile("/tattoos.png", GameManager.GAMETILESIZE * 2, GameManager.GAMETILESIZE * 2);
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
		
		this.xTile = xTile;
		this.yTile = yTile;
		this.ID = ID;
		
	}
	
	public static Tattoo kestrel = new Tattoo(0, 0, "Kestrel", 0, 1, 0, 0, 1, 0, 5, 3, ItemID.kestrel);
	public static Tattoo fox = new Tattoo(1, 0, "Fox", 0, 1, 0, 1, 0, 0, 5, 4, ItemID.fox);
	public static Tattoo bull = new Tattoo(2, 0, "Bull", 1, 0, 0, 0, 0, 1, 5, 5, ItemID.bull);
	public static Tattoo butterfly = new Tattoo(3, 0, "Butterfly", 0, 0, 1, 1, 0, 0, 5, 6, ItemID.butterfly);
	
	
	

}
