package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Jousting extends Armour {
	
	private static final long serialVersionUID = 1L;

	public Jousting() {
		
		super();
		
		name = "Jousting";
		weight = 28;
		defence = 13;
		
		xTile = 3;
		yTile = 3;
		
		ID = ItemID.Armour;
		
		
	}

}
