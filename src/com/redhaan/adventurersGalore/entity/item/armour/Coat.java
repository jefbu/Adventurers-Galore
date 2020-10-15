package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Coat extends Armour {

	private static final long serialVersionUID = 1L;

	public Coat() {		
		
		super();
		
		name = "Coat";
		weight = 5;
		defence = 5;
		
		xTile = 0;
		yTile = 0;
		
		ID = ItemID.Armour;
		
		
	}

}
