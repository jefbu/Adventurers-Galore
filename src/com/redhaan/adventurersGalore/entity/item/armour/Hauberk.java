package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Hauberk extends Armour {
	
	private static final long serialVersionUID = 1L;

	public Hauberk() {
		
		super();
		
		name = "Hauberk";
		weight = 16;
		defence = 12;
		
		xTile = 3;
		yTile = 2;
		
		ID = ItemID.Armour;
		
		
	}

}
