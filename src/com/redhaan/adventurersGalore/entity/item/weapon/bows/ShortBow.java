
package com.redhaan.adventurersGalore.entity.item.weapon.bows;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class ShortBow extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 1;
	
	public ShortBow() {
		
		name = "Short Bow";
		hit = 65;
		damage = 6;
		crit = 20;
		weight = 7;
		minRange = 2;
		maxRange = 2;
		
		type = WeaponType.BOW;
		
		xTile = 0;
		yTile = 3;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(2);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}
	

}


