package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.RationalThought;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Ruby;

public class Kitsune extends Enemy {
	
	
	public Kitsune() {
		
		name = "Kitsune";
		row = 38;
		
		maxStats.HP = 27;
		currentStats.HP = 27;
		
		maxStats.attack = 25;
		currentStats.attack = 25;
		maxStats.defence = 21;	
		currentStats.defence = 21;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 35;
		currentStats.evade = 35;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new HeartSpirit(), 100));
		dropTable.add(new ItemDrop(new RationalThought(), 10));
		dropTable.add(new ItemDrop(new Ruby(4), 30));
		dropTable.add(new ItemDrop(Tattoo.fox, 20));
		
		
	}

}
