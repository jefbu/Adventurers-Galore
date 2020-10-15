package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Gambeson extends Armour {
	

	private static final long serialVersionUID = 1L;

	public Gambeson() {
		
		super();
		
		name = "Gambeson";
		weight = 9;
		defence = 8;
		
		xTile = 2;
		yTile = 0;
		
		ID = ItemID.Armour;
		
		
	}

}
