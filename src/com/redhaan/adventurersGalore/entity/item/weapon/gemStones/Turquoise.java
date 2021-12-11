package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Turquoise extends GemStone{

	private static final long serialVersionUID = 1L;

	public Turquoise(int level) {
		
		super(0, 0, 1, 0, 0, 0, 0, 0, 0);
		name = "turquoise";
		this.level = level;
		gemStoneEnum = GemStoneEnum.turquoise;
		addLevelModifiers();
		makeName();
	
		xTile = 0 + this.level - 1;
		yTile = 14;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapTurquoise; break;
		case 2: ID = ItemID.basicTurquoise; break;
		case 3: ID = ItemID.qualityTurquoise; break;
		case 4: ID = ItemID.flawlessTurquoise; break;
		
		}
		
	}

}
