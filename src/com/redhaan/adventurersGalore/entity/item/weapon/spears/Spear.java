package com.redhaan.adventurersGalore.entity.item.weapon.spears;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Spear extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 1;
	
	public Spear() {
		

		name = "Spear";
		hit = 75;
		damage = 7;
		crit = 0;
		weight = 9;
		minRange = 1;
		maxRange = 2;
		
		type = WeaponType.SPEAR;
		
		xTile = 0;
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
