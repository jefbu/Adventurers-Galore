package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Epee extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public Epee() {
		
		name = "Epee";
		hit = 90;
		damage = 9;
		crit = 30;
		weight = 12;

		type = WeaponType.SWORD;

		xTile = 8;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(1);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(50)) { hit++; }
		if (rollBonusUpgrades(95)) { damage++; }
		if (rollBonusUpgrades(75)) { crit++; }
		
	}

}
