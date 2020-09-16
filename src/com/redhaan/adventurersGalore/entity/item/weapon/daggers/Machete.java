package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.weapon.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Soul;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;

public class Machete extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 3;
	
	public Machete() {
		
		name = "Machete";
		hit = 85;
		damage = 6;
		crit = 30;
		weight = 6;

		type = WeaponType.DAGGER;
		
		xTile = 4;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		upgrades = rollUpgrades(3);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}

}
