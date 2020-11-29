package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Plate extends Armour {

	private static final long serialVersionUID = 1L;

	public Plate() {
		
		super();
		
		name = "Plate";
		weight = 18;
		defence = 9;
		
		xTile = 1;
		yTile = 3;
		
		ID = ItemID.Armour;
		
		
	}

}
