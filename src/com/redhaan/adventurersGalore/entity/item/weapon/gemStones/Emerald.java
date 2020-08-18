package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class Emerald extends GemStone {

	private static final long serialVersionUID = 1L;

	public Emerald(int level) {
		
		super(0, 0, 0, 0, 1, 0, 0, 0, 0);
		name = "pearl";
		this.level = level;
		gemStoneEnum = GemStoneEnum.pearl;
		addLevelModifiers();
		makeName();
		
	}

}
