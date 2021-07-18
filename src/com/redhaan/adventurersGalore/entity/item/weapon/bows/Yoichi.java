package com.redhaan.adventurersGalore.entity.item.weapon.bows;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Yoichi extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Yoichi() {
		
		name = "Yoichi Bow";
		hit = 75;
		damage = 11;
		crit = 25;
		weight = 16;
		minRange = 2;
		maxRange = 3;
		
		type = WeaponType.BOW;
		
		xTile = 5;
		yTile = 3;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(4);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(70)) { crit++; }
		
	}

}
