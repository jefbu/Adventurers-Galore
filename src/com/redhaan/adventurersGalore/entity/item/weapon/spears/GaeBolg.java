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
		hit = 130;
		damage = 11;
		crit = 20;
		weight = 18;
		minRange = 1;
		maxRange = 2;
		
		type = WeaponType.SPEAR;
		
		xTile = 6;
		yTile = 4;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(2);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(80)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}

}
