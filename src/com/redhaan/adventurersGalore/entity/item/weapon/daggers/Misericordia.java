package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Misericordia extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Misericordia() {
		
		name = "Misericordia";
		hit = 95;
		damage = 8;
		crit = 35;
		weight = 9;

		type = WeaponType.DAGGER;

		xTile = 6;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		isLegendary = true;
		
		rollRuneSlots(1);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		//rollUpgrades(3);
		
		soul = rollSoul();
		
		gemStone = new Amethyst(4);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}

}
