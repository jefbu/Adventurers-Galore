package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class Pearl extends GemStone {

	private static final long serialVersionUID = 1L;

	public Pearl(int level) {
		
		super(1, 0, 0, 0, 0, 0, 0, 0, 0);
		name = "pearl";
		this.level = level;
		gemStoneEnum = GemStoneEnum.pearl;
		addLevelModifiers();
		makeName();
		
		
	}

}
