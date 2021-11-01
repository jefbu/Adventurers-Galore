package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Leather;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BastardSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BroadSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Falchion;

public class Bandit extends Enemy {
	
	public Bandit() {
		
		name = "Bandit";
		row = 10;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 12;	
		currentStats.defence = 12;
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
		
		dropTable.add(new ItemDrop(new BroadSword(), 200));
		dropTable.add(new ItemDrop(new Leather(), 150));
		dropTable.add(new ItemDrop(new Amethyst(1), 150));
		dropTable.add(new ItemDrop(new BastardSword(), 50));
		dropTable.add(new ItemDrop(new ViolentSpirit(), 10));
		dropTable.add(new ItemDrop(Potion.brownPotion, 3));
		dropTable.add(new ItemDrop(new Falchion(), 1));
		
	}

}
