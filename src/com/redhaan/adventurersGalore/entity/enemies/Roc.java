package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;

public class Roc extends Enemy {
	
	
	public Roc() {
		
		name = "Roc";
		row = 40;
		
		maxStats.HP = 28;
		currentStats.HP = 28;
		
		maxStats.attack = 25;
		currentStats.attack = 25;
		maxStats.defence = 21;	
		currentStats.defence = 21;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 25;
		currentStats.evade = 25;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 7;
		currentStats.move = 7;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		//dropTable.add(new ItemDrop(new PhoenixFeather(), 90));
		dropTable.add(new ItemDrop(new Sapphire(3), 900));
		//dropTable.add(new ItemDrop(new Foil(), 100));
		//dropTable.add(new ItemDrop(Tattoo.kestrel, 20));
		
	}

}
