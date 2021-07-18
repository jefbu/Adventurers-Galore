package com.redhaan.adventurersGalore.entity.item.weapon.daggers;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Misericordia extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Misericordia() {
		
		name = "Misericordia";
		hit = 90;
		damage = 10;
		crit = 50;
		weight = 13;

		type = WeaponType.DAGGER;

		xTile = 6;
		yTile = 1;
		
		ID = ItemID.Weapon;
		
		isLegendary = true;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		//rollUpgrades(3);
		
		soul = rollSoul();
		
		gemStone = new Amethyst(4);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}

}
