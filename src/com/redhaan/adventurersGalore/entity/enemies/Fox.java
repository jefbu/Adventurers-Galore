package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;

public class Fox extends Enemy {
	
	
	public Fox() {
		
		name = "Fox";
		row = 24;
		
		maxStats.HP = 16;
		currentStats.HP = 16;
		
		maxStats.attack = 16;
		currentStats.attack = 16;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 90;
		currentStats.hit = 90;
		maxStats.evade = 50;
		currentStats.evade = 50;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 7;
		currentStats.move = 7;
		
		range = 1;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new Pelt(), 350));
		dropTable.add(new ItemDrop(new Hide(), 200));
		dropTable.add(new ItemDrop(Tattoo.fox, 1));
		
	}

}
