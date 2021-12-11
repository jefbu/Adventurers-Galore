package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Amethyst extends GemStone {

	private static final long serialVersionUID = 1L;

	public Amethyst(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "amethyst";
		this.level = level;
		gemStoneEnum = GemStoneEnum.amethyst;
		addLevelModifiers();
		makeName();
		
		xTile = 0 + this.level - 1;
		yTile = 16;
		
		switch (level) {
		
		case 1: ID = ItemID.cheapAmethyst; break;
		case 2: ID = ItemID.basicAmethyst; break;
		case 3: ID = ItemID.qualityAmethyst; break;
		case 4: ID = ItemID.flawlessAmethyst; break;
		
		}

		
	}

}
