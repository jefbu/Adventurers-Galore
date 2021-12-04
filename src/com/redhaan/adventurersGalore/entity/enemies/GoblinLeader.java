package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.UnicornHorn;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Scimitar;

public class GoblinLeader extends Enemy {
	
	public GoblinLeader() {
		
		name = "Goblin Leader";
		row = 16;
		
		maxStats.HP = 28;
		currentStats.HP = 28;
		
		maxStats.attack = 20;
		currentStats.attack = 20;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 25;
		currentStats.evade = 25;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 2;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new OakWood(), 200));
		dropTable.add(new ItemDrop(new Topaz(1), 200));
		dropTable.add(new ItemDrop(new Silver(), 200));
		dropTable.add(new ItemDrop(new UnicornHorn(), 50));
		dropTable.add(new ItemDrop(new Scimitar(), 10));
		
	}

}
