package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class ReinforcedLeather extends Armour {

	private static final long serialVersionUID = 1L;

	public ReinforcedLeather() {
		
		super();
		weight = 8;
		defence = 7;
		
		icon = new ImageTile("/armour.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		xTile = 2;
		yTile = 1;
		
		
	}

}
