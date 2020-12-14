package com.redhaan.adventurersGalore.entity.item.weapon.spears;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class GaeBolg extends Weapon {
	
	
	public static final int TIER = 5;
	
	public GaeBolg() {
		

		name = "Gae Bolg";
		hit = 90;
		damage = 10;
		crit = 25;
		weight = 4;
		minRange = 1;
		maxRange = 2;
		
		type = WeaponType.SPEAR;
		
		xTile = 0;
		yTile = 3;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(2);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(80)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}

}
