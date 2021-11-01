package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Gambeson;
import com.redhaan.adventurersGalore.entity.item.items.MummyWrapping;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dagger;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;

public class GoblinScrounger extends Enemy {
	
	private static final long serialVersionUID = 1L;

	public GoblinScrounger() {
		
		name = "Goblin Scrounger";
		row = 6;
		
		maxStats.HP = 21;
		currentStats.HP = 21;
		
		maxStats.attack = 19;
		currentStats.attack = 19;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Dagger(), 200));
		dropTable.add(new ItemDrop(new Sapphire(1), 100));
		dropTable.add(new ItemDrop(new Sapphire(2), 50));
		dropTable.add(new ItemDrop(new MummyWrapping(), 20));
		dropTable.add(new ItemDrop(new Gambeson(), 7));
		dropTable.add(new ItemDrop(Rune.kam, 2));

	
		
	}
		

}

