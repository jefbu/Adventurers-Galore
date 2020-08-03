package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class RaceFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	public RaceFactory() { }
	
	
	protected Race setRace(int tier) {
		
		Race race = null;
		int rarity = rollRaceRarity(tier);
		race = rollRace(rarity);
		return race;
		
	}
	
	private int rollRaceRarity(int tier) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(tier) {
		case 0:
			if(roll > 95) { return 2; }
			else if(roll > 80) { return 1; }
			else { return 0; }
		case 1:
			if(roll > 95) { return 2; }
			else if(roll > 80) { return 1; }
			else { return 0; }
		case 2:
			if(roll > 95) { return 2; }
			else if(roll > 75) { return 1; }
			else { return 0; }
		case 3:
			if(roll > 90) { return 2; }
			else if(roll > 65) { return 1; }
			else { return 0; }
		case 4:
			if(roll > 80) { return 2; }
			else if(roll > 50) { return 1; }
			else { return 0; }
		}
		
		return 99;
	
	}
	
	private Race rollRace(int rarity) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(rarity) {
		case 0: return Race.human;
		case 1:
			if(roll > 50) { return Race.elf; }
			else { return Race.dwarf; }
		case 2: return Race.dryad;
		}
		
		return null;
	
	}
		


}
