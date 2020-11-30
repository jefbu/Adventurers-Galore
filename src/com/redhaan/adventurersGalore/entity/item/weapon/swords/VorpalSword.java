package com.redhaan.adventurersGalore.entity.item.weapon.swords;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;

public class VorpalSword extends Weapon implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;

	public VorpalSword() {
		
		name = "Vorpal Sword";
		hit = 100;
		damage = 12;
		crit = 20;
		weight = 18;

		type = WeaponType.SWORD;

		xTile = 10;
		yTile = 0;
		
		ID = ItemID.Weapon;
		
		isLegendary = true;
		
		rollRuneSlots(1);
		
		Random random = new Random();
		for (int i = 0; i < runeSlots; i++) {
			int roll = random.nextInt(100) + 1;
			if(roll > 60) { runes.add(Rune.Od); }
			else if (roll > 30) { runes.add(Rune.Er); }			
		}
		
		//rollUpgrades(3);
		
		soul = rollSoul();
		
		gemStone = new Sapphire(4);
		
		if (rollBonusUpgrades(50)) { hit++; }
		if (rollBonusUpgrades(70)) { damage++; }
		if (rollBonusUpgrades(50)) { crit++; }
		
	}
	
}
