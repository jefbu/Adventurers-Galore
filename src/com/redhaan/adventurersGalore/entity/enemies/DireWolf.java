package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amber;

public class DireWolf extends Enemy {

	public DireWolf() {
		
		name = "Dire Wolf";
		row = 0;
		
		maxStats.HP = 26;
		currentStats.HP = 26;
		
		maxStats.attack = 22;
		currentStats.attack = 22;
		maxStats.defence = 16;	
		currentStats.defence = 16;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 25;
		currentStats.evade = 25;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Fang(), 300));
		dropTable.add(new ItemDrop(new Amber(1), 250));
		dropTable.add(new ItemDrop(new Amber(2), 150));
		dropTable.add(new ItemDrop(Potion.goldPotion, 30));
		dropTable.add(new ItemDrop(new Amber(4), 10));		
		
	}
	
	
}
