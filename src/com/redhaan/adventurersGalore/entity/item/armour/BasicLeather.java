package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class BasicLeather extends Armour {
	
	private static final long serialVersionUID = 1L;

	public BasicLeather() {
		
		super();
		
		name = "Basic Leather";
		weight = 6;
		defence = 7;
		
		xTile = 0;
		yTile = 1;
		
		ID = ItemID.Armour;
		
	}

}
