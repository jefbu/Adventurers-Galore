package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Ruby;

public class Bull extends Enemy {
	
	
	public Bull() {
		
		name = "Bull";
		row = 27;
		
		maxStats.HP = 28;
		currentStats.HP = 28;
		
		maxStats.attack = 23;
		currentStats.attack = 23;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 90;
		currentStats.hit = 90;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Pelt(), 200));
		dropTable.add(new ItemDrop(new Ruby(1), 250));
		dropTable.add(new ItemDrop(new Ruby(2), 150));
		dropTable.add(new ItemDrop(Tattoo.bull, 1));
		
	}

}
