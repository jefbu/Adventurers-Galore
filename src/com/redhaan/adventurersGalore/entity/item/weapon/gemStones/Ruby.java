package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

public class Ruby extends GemStone {

	private static final long serialVersionUID = 1L;

	public Ruby(int level) {
		
		super(0, 0, 0, 0, 0, 0, 0, 1, 0);
		name = "ruby";
		this.level = level;
		gemStoneEnum = GemStoneEnum.ruby;
		addLevelModifiers();
		makeName();
		
	}

}
