package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Pearl extends GemStone {

	private static final long serialVersionUID = 1L;

	public Pearl(int level) {
		
		super(1, 0, 0, 0, 0, 0, 0, 0, 0);
		name = "pearl";
		this.level = level;
		gemStoneEnum = GemStoneEnum.pearl;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 15;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapPearl; break;
		case 2: ID = ItemID.basicPearl; break;
		case 3: ID = ItemID.qualityPearl; break;
		case 4: ID = ItemID.flawlessPearl; break;
		
		}
		
		
	}

}
