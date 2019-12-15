package com.redhaan.adventurersGalore.entity.adventurer.player;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.weapon.weapons.IronSword;

public class Player extends Adventurer {

	private static int xTile, yTile;

	public Player() {
		
		super();
		inParty = true;
		currentStats.move = 8;
		currentStats.PHY = 100;
		maxStats.PHY = 100;
		calculateAttack();
		calculateDefence();
		name = "Moltke";
		gender = "non binary";
		age = 58;
		currentStats.TST = 0;
		homeTown = Town.apastan;
		tier = 1;
		weapon = new IronSword();
		
	}

	
	public static int getXTile() {
		return xTile;
	}
	
	public static int getYTile() {
		return yTile;
	}
	
	public static void setXTile(int xTile) {
		Player.xTile = xTile;
	}
	
	public static void setYTile(int yTile) {
		Player.yTile = yTile;
	}

}
