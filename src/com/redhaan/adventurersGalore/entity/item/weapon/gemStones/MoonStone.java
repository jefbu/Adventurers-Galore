package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class MoonStone extends GemStone {

	private static final long serialVersionUID = 1L;

	public MoonStone(int level) {
		
		super(0, 0, 2, 0, 1, 1, 0, 0, 0);
		name = "moonstone";
		this.level = level;
		gemStoneEnum = GemStoneEnum.moonstone;
		addLevelModifiers();
		makeName();
		
		xTile = 8 + this.level;

		
	}

}
