package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Cinqueada extends Weapon {
	
	private static final long serialVersionUID = 1L;
	public static final int TIER = 3;
	
	public Cinqueada() {
		
		name = "Cinqueada";
		hit = 80;
		damage = 7;
		crit = 35;
		weight = 7;
		
		type = WeaponType.DAGGER;
		
		xTile = 3;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(4);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(1);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(65)) { crit++; }
		
	}

}
