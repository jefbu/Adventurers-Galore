package com.redhaan.adventurersGalore.entity.adventurer.player;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.weapon.swords.IronSword;

public class Player extends Adventurer {

	private static int xTile, yTile;

	public Player() {
		
		super();
		job = Job.squire;
		icon = job.icon;
		inParty = true;
		currentStats.move = 8;
		currentStats.PHY = 100;
		maxStats.PHY = 100;
		weapon = new IronSword();
		armour = new ReinforcedLeather();
		calculateSecondaryStats();
		name = "Moltke";
		gender = "Male";
		age = 58;
		currentStats.TST = 0;
		homeTown = Town.apastan;
		tier = 1;
		affinities = new Affinities();
		
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
