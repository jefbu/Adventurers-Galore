package com.redhaan.adventurersGalore.entity.item.weapon.bows;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Yoichi extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public Yoichi() {
		
		name = "Yoichi Bow";
		hit = 70;
		damage = 10;
		crit = 30;
		weight = 4;
		minRange = 1;
		maxRange = 2;
		
		type = WeaponType.BOW;
		
		xTile = 0;
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
		
		gemStone = rollGemStone(4);
		
		if (rollBonusUpgrades(70)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(70)) { crit++; }
		
	}

}
