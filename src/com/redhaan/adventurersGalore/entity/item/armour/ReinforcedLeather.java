package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class ReinforcedLeather extends Armour {

	private static final long serialVersionUID = 1L;

	public ReinforcedLeather() {
		
		super();
		
		name = "Reinforced Leather";
		weight = 11;
		defence = 9;
		
		xTile = 2;
		yTile = 1;
		
		ID = ItemID.Armour;
		
		
	}

}
