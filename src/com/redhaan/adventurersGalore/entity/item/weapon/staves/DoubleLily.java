package com.redhaan.adventurersGalore.entity.item.weapon.staves;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.item.weapon.ItemID;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Soul;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;

public class DoubleLily extends Weapon {

	private static final long serialVersionUID = 1L;
	public static final int TIER = 5;
	
	public DoubleLily() {
		
		name = "Double Lily";
		hit = 120;
		damage = 7;
		crit = 25;
		weight = 7;
		
		xTile = 5;
		yTile = 2;

		type = WeaponType.STAFF;

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
		
		gemStone = new Emerald(4);
		
		if (rollBonusUpgrades(60)) { hit++; }
		if (rollBonusUpgrades(60)) { damage++; }
		if (rollBonusUpgrades(60)) { crit++; }
		
	}
	

}
