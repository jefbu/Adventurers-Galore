package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.RobinEgg;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.LongBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;

public class GoblinArcher extends Enemy {
	
	
	public GoblinArcher() {
		
		
		name = "Goblin Archer";
		row = 15;
		
		maxStats.HP = 19;
		currentStats.HP = 19;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 15;
		currentStats.evade = 15;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 2;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new ShortBow(), 350));
		dropTable.add(new ItemDrop(new RobinEgg(), 150));
		dropTable.add(new ItemDrop(new Topaz(1), 50));
		dropTable.add(new ItemDrop(new LongBow(), 5));
		
	}
	

}
