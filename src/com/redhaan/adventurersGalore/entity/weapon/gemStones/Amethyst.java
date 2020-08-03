package com.redhaan.adventurersGalore.entity.weapon.gemStones;

public class Amethyst extends GemStone {

	private static final long serialVersionUID = 1L;

	public Amethyst(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "amethyst";
		this.level = level;
		gemStoneEnum = GemStoneEnum.amethyst;
		addLevelModifiers();
		makeName();
		
	}

}
