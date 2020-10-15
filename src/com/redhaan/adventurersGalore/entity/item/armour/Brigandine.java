package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Brigandine extends Armour {
	
	private static final long serialVersionUID = 1L;

	public Brigandine() {
		
		super();
		
		name = "Brigandine";
		weight = 12;
		defence = 10;
		
		xTile = 3;
		yTile = 0;
		
		ID = ItemID.Armour;
		
		
	}

}
