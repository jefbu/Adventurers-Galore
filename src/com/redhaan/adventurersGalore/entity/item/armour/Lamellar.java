package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Lamellar extends Armour {

	private static final long serialVersionUID = 1L;

	public Lamellar() {
		
		super();
		
		name = "Lamellar";
		weight = 15;
		defence = 11;
		
		xTile = 3;
		yTile = 1;
		
		ID = ItemID.Armour;
		
		
	}

}
