package com.redhaan.adventurersGalore.entity.item.weapon.staves;

import java.io.Serializable;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Baton extends Weapon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final int TIER = 2;
	
	public Baton() {
		
		name = "Baton";
		hit = 95;
		damage = 7;
		crit = 10;
		weight = 9;

		type = WeaponType.STAFF;

		xTile = 2;
		yTile = 2;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(3);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(2);
		
		if (rollBonusUpgrades(50)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}

}
