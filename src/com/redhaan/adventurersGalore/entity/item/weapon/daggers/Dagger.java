package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Dagger extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 1;
	
	public Dagger() {
		
		name = "Dagger";
		hit = 75;
		damage = 6;
		crit = 25;
		weight = 6;
		
		type = WeaponType.DAGGER;
		
		xTile = 1;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
				
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}
	

}
