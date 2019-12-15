package com.redhaan.adventurersGalore.entity.weapon;

import java.util.ArrayList;
import java.util.Random;

public class Weapon {
	
	public int damage, hit, crit;
	public String name;
	public int upgrades;
	
	public Soul soul;
	
	public int runeTier;
	public int runeSlots;
	public ArrayList<Rune> runes;	
	
	public Weapon() {
				
		runes = new ArrayList<Rune>();
	}
	
	public void rollRuneSlots(int runeTier) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(runeTier) {
		
		case 1:
			if (roll > 95) { runeSlots = 3; }
			else if (roll > 85) { runeSlots = 2; }
			else if (roll > 70) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 2:
			if (roll > 90) { runeSlots = 3; }
			else if (roll > 70) { runeSlots = 2; }
			else if (roll > 40) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 3:
			if (roll > 80) { runeSlots = 3; }
			else if (roll > 50) { runeSlots = 2; }
			else if (roll > 20) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 4:
			if (roll > 60) { runeSlots = 3; }
			else if (roll > 20) { runeSlots = 2; }
			else if (roll > 5) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		}
		
	}
	
	public void upgrade() {
		
		damage = damage * 11 / 10;
		hit = hit * 105 / 100;
		crit = crit * 11 / 10;
		
	}
			

}
