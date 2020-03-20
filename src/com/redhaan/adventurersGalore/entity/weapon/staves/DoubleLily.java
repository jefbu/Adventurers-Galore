package com.redhaan.adventurersGalore.entity.weapon.staves;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.weapon.Rune;
import com.redhaan.adventurersGalore.entity.weapon.Soul;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.weapon.gemStones.Emerald;

public class DoubleLily extends Weapon {
	
	public static final int TIER = 5;
	
	public DoubleLily() {
		
		name = "Double Lily";
		hit = 120;
		damage = 7;
		crit = 25;
		weight = 7;
		
		xTile = 5;
		yTile = 2;
		
		isLegendary = true;
		
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
		
		gemStone = new Emerald(4);
		
	}
	

}
