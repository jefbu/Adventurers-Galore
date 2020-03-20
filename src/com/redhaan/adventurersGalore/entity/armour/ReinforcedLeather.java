package com.redhaan.adventurersGalore.entity.armour;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class ReinforcedLeather extends Armour {
	
	public ReinforcedLeather() {
		
		super();
		weight = 8;
		defence = 7;
		
		icon = new ImageTile("/armour.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		iconX = 2;
		iconY = 1;
		
		
	}

}
