package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class SilverSword extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public SilverSword() {
		
		name = "Silver Sword";
		hit = 80;
		damage = 11;
		crit = 20;
		weight = 15;

		type = WeaponType.SWORD;

		xTile = 7;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(4);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(4);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}

}
