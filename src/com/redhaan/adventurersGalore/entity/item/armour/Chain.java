package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Chain extends Armour {

	private static final long serialVersionUID = 1L;

	public Chain() {
		
		super();
		
		name = "Chain";
		weight = 11;
		defence = 7;
		
		xTile = 0;
		yTile = 2;
		
		ID = ItemID.Armour;
		
		
	}

}
