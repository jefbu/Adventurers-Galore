package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Spear;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Trident;

public class SkeletonWarrior extends Enemy {
	
	
	public SkeletonWarrior() {
		
		name = "Skeleton Warrior";
		row = 20;
		
		maxStats.HP = 21;
		currentStats.HP = 21;
		
		maxStats.attack = 19;
		currentStats.attack = 19;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 2;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Spear(), 200));
		dropTable.add(new ItemDrop(new Onyx(1), 150));
		dropTable.add(new ItemDrop(new Onyx(2), 50));
		dropTable.add(new ItemDrop(new Trident(), 6));
		dropTable.add(new ItemDrop(Rune.hom, 2));
		
	}

}
