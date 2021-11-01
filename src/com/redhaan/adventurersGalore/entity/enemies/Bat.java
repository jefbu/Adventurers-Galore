package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Bezoar;
import com.redhaan.adventurersGalore.entity.item.items.GiantToe;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Wing;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;

public class Bat extends Enemy {
	

	private static final long serialVersionUID = 1L;

	public Bat() {
		
		name = "Giant Bat";
		row = 4;
		
		maxStats.HP = 18;
		currentStats.HP = 18;
		
		maxStats.attack = 16;
		currentStats.attack = 16;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 7;
		currentStats.move = 7;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Hide(), 400));
		dropTable.add(new ItemDrop(new GiantToe(), 250));
		dropTable.add(new ItemDrop(new Wing(), 100));
		dropTable.add(new ItemDrop(new Bezoar(), 15));
		dropTable.add(new ItemDrop(new Cinqueada(), 2));
		dropTable.add(new ItemDrop(new Turquoise(4), 1));

		
	}

}
