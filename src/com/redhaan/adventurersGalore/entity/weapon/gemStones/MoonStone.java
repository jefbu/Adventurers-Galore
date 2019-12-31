package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class MoonStone extends GemStone {
	
	public MoonStone(int level) {
		
		super(0, 0, 2, 0, 1, 1, 0, 0, 0);
		name = "moonstone";
		this.level = level;
		gemStoneEnum = GemStoneEnum.moonstone;
		addLevelModifiers();
		makeName();
		
	}

}
