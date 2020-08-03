package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Topaz extends GemStone {

	private static final long serialVersionUID = 1L;

	public Topaz(int level) {
		
		super(0, 1, 0, 0, 0, 0, 0, 0, 0);
		name = "topaz";
		this.level = level;
		gemStoneEnum = GemStoneEnum.topaz;
		addLevelModifiers();
		makeName();
		
	}

}
