package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.LiquidInnocence;
import com.redhaan.adventurersGalore.entity.item.items.MorningSunlight;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;

public class Lich extends Enemy {
	
	
	public Lich() {
		
		name = "Lich";
		row = 32;
		
		maxStats.HP = 30;
		currentStats.HP = 30;
		
		maxStats.attack = 22;
		currentStats.attack = 22;
		maxStats.defence = 18;	
		currentStats.defence = 18;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 30;
		currentStats.evade = 30;
		maxStats.critical = 30;
		currentStats.critical = 30;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 6;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new HeartSpirit(), 150));
		dropTable.add(new ItemDrop(new Onyx(3), 150));
		dropTable.add(new ItemDrop(new MorningSunlight(), 50));
		dropTable.add(new ItemDrop(new LiquidInnocence(), 40));
		dropTable.add(new ItemDrop(new Topaz(4), 20));
		dropTable.add(new ItemDrop(Rune.cit, 20));
		
		
	}

}
