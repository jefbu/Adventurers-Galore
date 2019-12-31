package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Ruby extends GemStone {
	
	public Ruby(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "ruby";
		this.level = level;
		gemStoneEnum = GemStoneEnum.ruby;
		addLevelModifiers();
		makeName();
		
	}

}
