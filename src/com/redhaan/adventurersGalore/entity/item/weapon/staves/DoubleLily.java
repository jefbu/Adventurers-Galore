package com.redhaan.adventurersGalore.entity.item.weapon.staves;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;

public class DoubleLily extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public DoubleLily() {
		
		name = "Double Lily";
		hit = 80;
		damage = 9;
		crit = 20;
		weight = 14;
		
		xTile = 5;
		yTile = 2;
		
		minRange = 1;
		maxRange = 2;

		type = WeaponType.STAFF;

		ID = ItemID.Weapon;
		
		isLegendary = true;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		//rollUpgrades(3);
		
		soul = rollSoul();
		
		gemStone = new Emerald(4);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}
	

}
