package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Amber extends GemStone {

	private static final long serialVersionUID = 1L;

	public Amber(int level) {
		
		super(0, 0, 0, 0, 0, 0, 1, 0, 0);
		name = "amber";
		this.level = level;
		gemStoneEnum = GemStoneEnum.amber;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 17;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapAmber; break;
		case 2: ID = ItemID.basicAmber; break;
		case 3: ID = ItemID.qualityAmber; break;
		case 4: ID = ItemID.flawlessAmber; break;
		
		}
			
			
	}

}
