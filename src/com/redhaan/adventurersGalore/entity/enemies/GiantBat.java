package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.BeastBlood;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.PhoenixFeather;
import com.redhaan.adventurersGalore.entity.item.items.Wing;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;

public class GiantBat extends Enemy {

	private static final long serialVersionUID = 1L;

	public GiantBat() {
		
		name = "Giant Bat";
		row = 3;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 85;
		currentStats.hit = 85;
		maxStats.evade = 30;
		currentStats.evade = 30;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 7;
		currentStats.move = 7;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new BeastBlood(), 250));
		dropTable.add(new ItemDrop(new PhoenixFeather(), 40));
		dropTable.add(new ItemDrop(Rune.fu, 2));
		dropTable.add(new ItemDrop(new Claw(), 400));
		dropTable.add(new ItemDrop(new Wing(), 200));


		
	}
		

}
