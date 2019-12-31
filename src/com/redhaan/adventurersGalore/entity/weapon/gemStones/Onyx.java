package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Onyx extends GemStone {
	
	public Onyx(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "onyx";
		this.level = level;
		gemStoneEnum = GemStoneEnum.onyx;
		addLevelModifiers();
		makeName();
		
	}

}
