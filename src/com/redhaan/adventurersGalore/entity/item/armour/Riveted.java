package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Riveted extends Armour {
	

	private static final long serialVersionUID = 1L;

	public Riveted() {
		
		
		super();
		
		name = "Riveted";
		weight = 13;
		defence = 8;
		
		xTile = 1;
		yTile = 2;
		
		ID = ItemID.Armour;
		
		
	}

}
