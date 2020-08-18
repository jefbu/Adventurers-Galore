package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Soul;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;

public class Excalibur extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Excalibur() {
		
		name = "Excalibur";
		hit = 75;
		damage = 14;
		crit = 10;
		weight = 18;
		
		xTile = 11;
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
		
		gemStone = new Topaz(4);
		
	}

}
