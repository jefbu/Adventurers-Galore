package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Foil extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 3;
	
	public Foil() {
		
		name = "Foil";
		hit = 85;
		damage = 8;
		crit = 25;
		weight = 11;

		type = WeaponType.SWORD;

		xTile = 4;
		yTile = 0;
		
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
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}

}
