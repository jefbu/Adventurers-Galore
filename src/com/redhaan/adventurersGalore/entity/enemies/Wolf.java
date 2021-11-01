package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.BoiledLeather;
import com.redhaan.adventurersGalore.entity.item.items.BeastBlood;
import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.PentUpAnger;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amber;

public class Wolf extends Enemy {

	private static final long serialVersionUID = 1L;

	public Wolf() {
		
		name = "Wolf";
		row = 1;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 15;
		currentStats.evade = 15;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new BeastBlood(), 300));
		dropTable.add(new ItemDrop(new Fang(), 400));
		dropTable.add(new ItemDrop(new Bone(), 200));
		dropTable.add(new ItemDrop(new BoiledLeather(), 70));
		dropTable.add(new ItemDrop(new Amber(3), 5));
		dropTable.add(new ItemDrop(new PentUpAnger(), 2));
		dropTable.add(new ItemDrop(Rune.cit, 1));

				
		
	}
		

}
