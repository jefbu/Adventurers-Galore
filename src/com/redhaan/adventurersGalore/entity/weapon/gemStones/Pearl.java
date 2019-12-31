package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Pearl extends GemStone {
	
	public Pearl(int level) {
		
		super(1, 0, 0, 0, 0, 0, 0, 0, 0);
		name = "pearl";
		this.level = level;
		gemStoneEnum = GemStoneEnum.pearl;
		addLevelModifiers();
		makeName();
		
		
	}

}
