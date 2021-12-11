package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Sapphire extends GemStone {

	private static final long serialVersionUID = 1L;

	public Sapphire(int level) {
		
		super(0, 0, 0, 0, 0, 1, 0, 0, 0);
		name = "sapphire";
		this.level = level;
		gemStoneEnum = GemStoneEnum.sapphire;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 12;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapSapphire; break;
		case 2: ID = ItemID.basicSapphire; break;
		case 3: ID = ItemID.qualitySapphire; break;
		case 4: ID = ItemID.flawlessSapphire; break;
		
		}
		
	}

}
