package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;

public class Excalibur extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Excalibur() {
		
		name = "Excalibur";
		hit = 75;
		damage = 14;
		crit = 15;
		weight = 20;

		type = WeaponType.SWORD;

		xTile = 11;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		isLegendary = true;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		//rollUpgrades(3);
		
		soul = rollSoul();
		
		gemStone = new Topaz(4);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}

}
