package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Sabre extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 2;
	
	public Sabre() {
		
		name = "Sabre";
		hit = 80;
		damage = 8;
		crit = 15;
		weight = 9;

		type = WeaponType.SWORD;

		xTile = 3;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(4);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(3);
		
		if (rollBonusUpgrades(50)) { hit++; }
		if (rollBonusUpgrades(80)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}

}
