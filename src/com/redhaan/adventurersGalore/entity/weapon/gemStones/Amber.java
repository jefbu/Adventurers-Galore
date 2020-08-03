package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Amber extends GemStone {

	private static final long serialVersionUID = 1L;

	public Amber(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "amber";
		this.level = level;
		gemStoneEnum = GemStoneEnum.amber;
		addLevelModifiers();
		makeName();
		
	}

}
