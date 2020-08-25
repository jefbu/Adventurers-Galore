package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class Onyx extends GemStone {

	private static final long serialVersionUID = 1L;

	public Onyx(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "onyx";
		this.level = level;
		gemStoneEnum = GemStoneEnum.onyx;
		addLevelModifiers();
		makeName();
		
		xTile = 8 + this.level;
		yTile = 8;
		
	}

}
