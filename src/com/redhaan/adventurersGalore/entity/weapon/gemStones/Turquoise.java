package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Turquoise extends GemStone{
	
	public Turquoise(int level) {
		
		super(0, 0, 1, 0, 0, 0, 0, 0, 0);
		name = "turquoise";
		this.level = level;
		gemStoneEnum = GemStoneEnum.turquoise;
		addLevelModifiers();
		makeName();
	
	}

}
