package com.redhaan.adventurersGalore.entity.item.armour;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Quilt extends Armour {

	private static final long serialVersionUID = 1L;

	public Quilt() {
		
		super();
		
		name = "Quilt";
		weight = 6;
		defence = 6;
		
		xTile = 1;
		yTile = 0;
		
		ID = ItemID.Armour;
		
		
	}

}
