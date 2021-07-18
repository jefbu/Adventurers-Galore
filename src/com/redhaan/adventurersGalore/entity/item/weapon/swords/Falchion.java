package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Falchion extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public Falchion() {
		
		name = "Falchion";
		hit = 85;
		damage = 10;
		crit = 20;
		weight = 17;

		type = WeaponType.SWORD;

		xTile = 9;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(4);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(3);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(90)) { hit++; }
		if (rollBonusUpgrades(95)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}

}
