package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.DaemonHeart;
import com.redhaan.adventurersGalore.entity.item.items.ManaTreeBranch;
import com.redhaan.adventurersGalore.entity.item.items.PentUpAnger;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Longinus;

public class Daemon extends Enemy {
	
	
	public Daemon() {
		
		name = "Daemon";
		row = 43;
		
		maxStats.HP = 30;
		currentStats.HP = 30;
		
		maxStats.attack = 28;
		currentStats.attack = 28;
		maxStats.defence = 23;	
		currentStats.defence = 23;
		maxStats.hit = 120;
		currentStats.hit = 120;
		maxStats.evade = 60;
		currentStats.evade = 60;
		maxStats.critical = 40;
		currentStats.critical = 40;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 2;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new DaemonHeart(), 300));
		dropTable.add(new ItemDrop(new ManaTreeBranch(), 100));
		dropTable.add(new ItemDrop(new PentUpAnger(), 100));
		dropTable.add(new ItemDrop(Rune.var, 100));
		dropTable.add(new ItemDrop(new Longinus(), 50));
		dropTable.add(new ItemDrop(new Onyx(2), 700));
		dropTable.add(new ItemDrop(Potion.purplePotion, 50));
		
		
	}

}
