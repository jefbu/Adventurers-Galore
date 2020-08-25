package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Soul;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;

public class SilverSword extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public SilverSword() {
		
		name = "Silver Sword";
		hit = 80;
		damage = 11;
		crit = 20;
		weight = 10;

		type = WeaponType.SWORD;

		xTile = 7;
		yTile = 0;
		
		ID = 4;
		
		rollRuneSlots(4);
		
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
		if (rollBonusUpgrades(90)) { damage++; }
		if (rollBonusUpgrades(80)) { crit++; }
		
	}

}
