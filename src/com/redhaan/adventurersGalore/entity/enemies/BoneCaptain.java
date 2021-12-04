package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.GiantToe;
import com.redhaan.adventurersGalore.entity.item.items.StolenMoonlight;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Lance;

public class BoneCaptain extends Enemy {
	
	
	public BoneCaptain() {
		
		name = "Bone Captain";
		row = 21;
		
		maxStats.HP = 27;
		currentStats.HP = 27;
		
		maxStats.attack = 22;
		currentStats.attack = 22;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 95;
		currentStats.hit = 95;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new GiantToe(), 200));
		dropTable.add(new ItemDrop(new Bone(), 350));
		dropTable.add(new ItemDrop(new Lance(), 200));
		dropTable.add(new ItemDrop(new Onyx(3), 50));
		dropTable.add(new ItemDrop(new StolenMoonlight(), 15));
		
	}

}
