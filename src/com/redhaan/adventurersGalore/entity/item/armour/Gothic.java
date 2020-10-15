package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Gothic extends Armour {
	
	private static final long serialVersionUID = 1L;

	public Gothic() {
		
		super();
		
		name = "Gothic";
		weight = 22;
		defence = 11;
		
		xTile = 2;
		yTile = 3;
		
		ID = ItemID.Armour;
		
		
	}

}
