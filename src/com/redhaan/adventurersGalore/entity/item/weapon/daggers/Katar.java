package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Katar extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public Katar() {
		
		name = "Katar";
		hit = 85;
		damage = 8;
		crit = 40;
		weight = 10;
		
		type = WeaponType.DAGGER;
		
		xTile = 5;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(4);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(50)) { crit++; }		
		
	}
	

}
