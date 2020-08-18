package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Soul;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Misericordia extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Misericordia() {
		
		name = "Misericordia";
		hit = 95;
		damage = 8;
		crit = 35;
		weight = 6;
		
		xTile = 6;
		yTile = 1;
		
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
		
		gemStone = new Amethyst(4);
		
	}

}
