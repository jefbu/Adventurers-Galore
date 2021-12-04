package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.ElysianFlower;
import com.redhaan.adventurersGalore.entity.item.items.SnakeTongue;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;

public class RoyalSnake extends Enemy {
	
	
	public RoyalSnake() {
		
		name = "Royal Snake";
		row = 28;
		
		maxStats.HP = 25;
		currentStats.HP = 25;
		
		maxStats.attack = 22;
		currentStats.attack = 22;
		maxStats.defence = 13;	
		currentStats.defence = 13;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 40;
		currentStats.critical = 40;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new SnakeTongue(), 300));
		dropTable.add(new ItemDrop(new Pearl(1), 250));
		dropTable.add(new ItemDrop(new Pearl(2), 150));
		dropTable.add(new ItemDrop(new ElysianFlower(), 10));
		dropTable.add(new ItemDrop(new Cinqueada(), 15));
		
	}

}
