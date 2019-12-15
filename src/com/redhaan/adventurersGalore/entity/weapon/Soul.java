package com.redhaan.adventurersGalore.entity.weapon;

import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class Soul {
	
	public Race race;
	
	public Soul(Race race) {
		
		this.race = race;
		
	}
	
	
	
	
	public static Soul dwarfSlayer = new Soul(Race.dwarf);

}
