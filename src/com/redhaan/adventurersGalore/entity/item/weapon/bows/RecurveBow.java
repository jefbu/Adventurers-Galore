package com.redhaan.adventurersGalore.entity.item.weapon.bows;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class RecurveBow extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 3;
	
	public RecurveBow() {
		

		name = "Recurve";
		hit = 70;
		damage = 8;
		crit = 20;
		weight = 10;
		minRange = 2;
		maxRange = 3;
		
		type = WeaponType.BOW;
		
		xTile = 3;
		yTile = 3;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}
	
	

}
