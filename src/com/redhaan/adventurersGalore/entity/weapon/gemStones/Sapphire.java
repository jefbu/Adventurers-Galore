package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Sapphire extends GemStone {

	private static final long serialVersionUID = 1L;

	public Sapphire(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "sapphire";
		this.level = level;
		gemStoneEnum = GemStoneEnum.sapphire;
		addLevelModifiers();
		makeName();
		
	}

}
