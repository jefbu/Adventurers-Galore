package com.redhaan.adventurersGalore.entity.item.weapon.staves;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Waddy extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public Waddy() {
		
		name = "Waddy";
		hit = 110;
		damage = 8;
		crit = 10;
		weight = 11;

		type = WeaponType.STAFF;

		xTile = 4;
		yTile = 2;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(3);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(2);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(70)) { crit++; }
		
	}

}
