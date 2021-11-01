package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Cuirass;
import com.redhaan.adventurersGalore.entity.item.armour.Hauberk;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.Lesses;
import com.redhaan.adventurersGalore.entity.item.items.LiquidInnocence;

public class KoboldKnight extends Enemy {
	
	
	public KoboldKnight() {
		
		name = "Kobold Knight";
		row = 14;
		
		maxStats.HP = 21;
		currentStats.HP = 21;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 13;	
		currentStats.defence = 13;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new Cuirass(), 100));
		dropTable.add(new ItemDrop(new Lesses(), 200));
		dropTable.add(new ItemDrop(new Coral(), 150));
		dropTable.add(new ItemDrop(new LiquidInnocence(), 5));
		dropTable.add(new ItemDrop(new Hauberk(), 2));
		
	}

}
