package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class Turquoise extends GemStone{

	private static final long serialVersionUID = 1L;

	public Turquoise(int level) {
		
		super(0, 0, 1, 0, 0, 0, 0, 0, 0);
		name = "turquoise";
		this.level = level;
		gemStoneEnum = GemStoneEnum.turquoise;
		addLevelModifiers();
		makeName();
	
	}

}
