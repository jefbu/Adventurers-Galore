package com.redhaan.adventurersGalore.entity.item.weapon.staves;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Quarterstaff extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 1;
	
	public Quarterstaff() {
		
		name = "Quarterstaff";
		hit = 100;
		damage = 5;
		crit = 0;
		weight = 7;

		type = WeaponType.STAFF;

		xTile = 0;
		yTile = 2;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(2);
		int runesRoll = 0;
		for (int i = 0; i < runeSlots; i++) { if (random.nextBoolean()) { runesRoll++; }}
		for (int ii = 0; ii < runesRoll; ii++) { runes.add(rollRune()); }
		
		upgrades = rollUpgrades(4);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(85)) { crit++; }
		
	}
	

}
