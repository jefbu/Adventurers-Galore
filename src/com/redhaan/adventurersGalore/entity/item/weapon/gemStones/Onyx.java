package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Onyx extends GemStone {

	private static final long serialVersionUID = 1L;

	public Onyx(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 0, 1);
		name = "onyx";
		this.level = level;
		gemStoneEnum = GemStoneEnum.onyx;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 18;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapOnyx; break;
		case 2: ID = ItemID.basicOnyx; break;
		case 3: ID = ItemID.qualityOnyx; break;
		case 4: ID = ItemID.flawlessOnyx; break;
		
		}
		
	}

}
