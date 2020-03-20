package com.redhaan.adventurersGalore.entity.weapon.daggers;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.weapon.Rune;
import com.redhaan.adventurersGalore.entity.weapon.Soul;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.weapon.gemStones.Topaz;

public class Cinqueada extends Weapon {
	
	public static final int TIER = 3;
	
	public Cinqueada() {
		
		name = "Cinqueada";
		hit = 80;
		damage = 6;
		crit = 35;
		weight = 5;
		
		xTile = 3;
		yTile = 1;
		
		rollRuneSlots(1);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		upgrades = random.nextInt(3);
		for (int i = 0; i < upgrades; i++) {
			upgrade();
		}
		soul = Soul.dwarfSlayer;
		
		int roll = random.nextInt(10) + 1;
		if (roll == 10) { gemStone = new Topaz(4); }
		else if (roll == 9) { gemStone = new Topaz(3); }
		else if (roll == 8) { gemStone = new Topaz(2); }
		else if (roll == 7) { gemStone = new Topaz(1); }
		
	}

}
