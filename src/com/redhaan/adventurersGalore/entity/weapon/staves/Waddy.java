package com.redhaan.adventurersGalore.entity.weapon.staves;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.weapon.Rune;
import com.redhaan.adventurersGalore.entity.weapon.Soul;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.weapon.gemStones.Pearl;

public class Waddy extends Weapon {
	
	public static final int TIER = 4;
	
	public Waddy() {
		
		name = "Waddy";
		hit = 110;
		damage = 60;
		crit = 10;
		weight = 55;
		
		xTile = 4;
		yTile = 2;
		
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
		if (roll == 10) { gemStone = new Pearl(4); }
		else if (roll == 9) { gemStone = new Pearl(3); }
		else if (roll == 8) { gemStone = new Pearl(2); }
		else if (roll == 7) { gemStone = new Pearl(1); }
		
	}

}
