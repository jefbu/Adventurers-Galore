package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Topaz extends GemStone {

	private static final long serialVersionUID = 1L;

	public Topaz(int level) {
		
		super(0, 1, 0, 0, 0, 0, 0, 0, 0);
		name = "topaz";
		this.level = level;
		gemStoneEnum = GemStoneEnum.topaz;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 13;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapTopaz; break;
		case 2: ID = ItemID.basicTopaz; break;
		case 3: ID = ItemID.qualityTopaz; break;
		case 4: ID = ItemID.flawlessTopaz; break;
		
		}
		
	}

}
