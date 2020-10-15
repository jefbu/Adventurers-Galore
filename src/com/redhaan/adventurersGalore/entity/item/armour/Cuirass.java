package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Cuirass extends Armour {

	private static final long serialVersionUID = 1L;

	public Cuirass() {
		
		
		super();
		
		name = "Cuirass";
		weight = 14;
		defence = 8;
		
		xTile = 0;
		yTile = 3;
		
		ID = ItemID.Armour;
		
		
	}

}
