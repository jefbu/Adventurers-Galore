package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class BastardSword extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 2;
	
	public BastardSword() {
		
		name = "Bastard Sword";
		hit = 65;
		damage = 9;
		crit = 15;
		weight = 15;

		type = WeaponType.SWORD;
		
		xTile = 2;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(3);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}

}
