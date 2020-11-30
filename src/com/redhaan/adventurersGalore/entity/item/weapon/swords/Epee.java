package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;

public class Epee extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 4;
	
	public Epee() {
		
		name = "Epee";
		hit = 90;
		damage = 8;
		crit = 30;
		weight = 10;

		type = WeaponType.SWORD;

		xTile = 8;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		rollRuneSlots(1);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		upgrades = rollUpgrades(1);
		if(upgrades > 0) { for (int i = 0; i < upgrades; i++) { upgrade(); } }
		
		soul = rollSoul();
		
		gemStone = rollGemStone(1);
		
		if (rollBonusUpgrades(50)) { hit++; }
		if (rollBonusUpgrades(95)) { damage++; }
		if (rollBonusUpgrades(75)) { crit++; }
		
	}

}
