package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class BoiledLeather extends Armour {

	private static final long serialVersionUID = 1L;

	public BoiledLeather() {
		
		super();
		
		name = "Boiled Leather";
		weight = 9;
		defence = 7;
		
		xTile = 1;
		yTile = 1;
		
		ID = ItemID.Armour;
		
		
	}

}
