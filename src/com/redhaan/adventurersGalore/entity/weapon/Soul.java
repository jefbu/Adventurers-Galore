package com.redhaan.adventurersGalore.entity.weapon;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class Soul implements Serializable {

	private static final long serialVersionUID = 1L;
	public Race race;
	
	public Soul(Race race) {
		
		this.race = race;
		
	}
	
	
	
	
	public static Soul dwarfSlayer = new Soul(Race.dwarf);

}
