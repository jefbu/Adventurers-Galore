package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Emerald extends GemStone {

	private static final long serialVersionUID = 1L;

	public Emerald(int level) {
		
		super(0, 0, 0, 0, 1, 0, 0, 0, 0);
		name = "pearl";
		this.level = level;
		gemStoneEnum = GemStoneEnum.pearl;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 11;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapEmerald; break;
		case 2: ID = ItemID.basicEmerald; break;
		case 3: ID = ItemID.qualityEmerald; break;
		case 4: ID = ItemID.flawlessEmerald; break;
		
		}
		
	}

}
