package com.redhaan.adventurersGalore.entity.weapon.swords;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.weapon.Rune;
import com.redhaan.adventurersGalore.entity.weapon.Soul;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.weapon.gemStones.MoonStone;

public class VorpalSword extends Weapon {
	
	public static final int TIER = 5;

	public VorpalSword() {
		
		name = "Vorpal Sword";
		hit = 100;
		damage = 90;
		crit = 20;
		weight = 85;
		
		xTile = 10;
		yTile = 0;
		
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
		
		gemStone = new MoonStone(4);
		
	}
	
}
