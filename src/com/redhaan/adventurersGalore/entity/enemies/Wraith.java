package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.DaemonHeart;
import com.redhaan.adventurersGalore.entity.item.items.Ectoplasm;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Wraith extends Enemy {
	
	
	public Wraith() {
		
		name = "Wraith";
		row = 31;
		
		maxStats.HP = 24;
		currentStats.HP = 24;
		
		maxStats.attack = 21;
		currentStats.attack = 21;
		maxStats.defence = 16;	
		currentStats.defence = 16;
		maxStats.hit = 95;
		currentStats.hit = 95;
		maxStats.evade = 40;
		currentStats.evade = 40;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 3;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new Ectoplasm(), 250));
		dropTable.add(new ItemDrop(new Ivory(), 150));
		dropTable.add(new ItemDrop(new Amethyst(1), 100));
		dropTable.add(new ItemDrop(new Amethyst(2), 150));
		dropTable.add(new ItemDrop(new Amethyst(3), 50));
		dropTable.add(new ItemDrop(new DaemonHeart(), 50));
		
	}

}
