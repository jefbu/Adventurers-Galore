package com.redhaan.adventurersGalore.entity.weapon.weapons;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.weapon.Rune;
import com.redhaan.adventurersGalore.entity.weapon.Soul;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;

public class IronSword extends Weapon {
	
	public IronSword() {
		
		name = "Iron Sword";
		hit = 80;
		damage = 100;
		crit = 10;
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
		
	}
	

}
