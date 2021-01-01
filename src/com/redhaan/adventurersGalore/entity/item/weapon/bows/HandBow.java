package com.redhaan.adventurersGalore.entity.item.weapon.bows;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class HandBow extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 2;

	public HandBow() {
		

	name = "Hand Bow";
	hit = 65;
	damage = 6;
	crit = 20;
	weight = 7;
	minRange = 1;
	maxRange = 2;
	
	type = WeaponType.BOW;
	
	xTile = 2;
	yTile = 3;
	
	ID = ItemID.Weapon;
	
	rollRuneSlots(1);
	
	Random random = new Random();
	for (int i = 0; i < runeSlots; i++) {
		int roll = random.nextInt(100) + 1;
		if(roll > 60) { runes.add(Rune.Od); }
		else if (roll > 30) { runes.add(Rune.Er); }			
	}
	
	upgrades = rollUpgrades(2);
	if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
	
	soul = rollSoul();
	
	gemStone = rollGemStone(2);
	
	if (rollBonusUpgrades(60)) { hit++; }
	if (rollBonusUpgrades(80)) { damage++; }
	if (rollBonusUpgrades(80)) { crit++; }
	
	}
	
}
