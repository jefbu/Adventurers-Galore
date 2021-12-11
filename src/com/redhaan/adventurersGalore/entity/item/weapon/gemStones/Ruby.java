package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Ruby extends GemStone {

	private static final long serialVersionUID = 1L;

	public Ruby(int level) {
		
		super(0, 0, 0, 1, 0, 0, 0, 0, 0);
		name = "ruby";
		this.level = level;
		gemStoneEnum = GemStoneEnum.ruby;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 10;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapRuby; break;
		case 2: ID = ItemID.basicRuby; break;
		case 3: ID = ItemID.qualityRuby; break;
		case 4: ID = ItemID.flawlessRuby; break;
		
		}
		
	}

}
