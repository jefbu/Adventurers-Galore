package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Leather extends Armour {
	
	private static final long serialVersionUID = 1L;

	public Leather() {
		
		super();
		
		name = "Leather";
		weight = 8;
		defence = 6;
		
		xTile = 0;
		yTile = 1;
		
		ID = ItemID.Armour;
		
	}

}
