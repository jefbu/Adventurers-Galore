package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.Lesses;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;

public class RabidStag extends Enemy {
	
	
	public RabidStag() {
		
		name = "Rabid Stag";
		row = 25;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 19;
		currentStats.attack = 19;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 85;
		currentStats.hit = 85;
		maxStats.evade = 30;
		currentStats.evade = 30;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Lesses(), 300));
		dropTable.add(new ItemDrop(new Antlers(), 200));
		dropTable.add(new ItemDrop(new Emerald(2), 50));
		dropTable.add(new ItemDrop(new NobleSpirit(), 15));
		dropTable.add(new ItemDrop(new Emerald(3), 5));
		dropTable.add(new ItemDrop(new Pearl(4), 1));
		
	}

}
