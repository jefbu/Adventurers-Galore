package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Scale extends Armour {
	
	
	public Scale() {
		
		super();
		
		name = "Scale";
		weight = 14;
		defence = 10;
		
		xTile = 2;
		yTile = 2;
		
		ID = ItemID.Armour;
		
		
	}

}
