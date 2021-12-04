package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.ReforgedPlough;
import com.redhaan.adventurersGalore.entity.item.items.SpringBreeze;
import com.redhaan.adventurersGalore.entity.item.items.VampireDust;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Misericordia;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Horror extends Enemy {
	
	
	public Horror() {
		
		name = "Horror";
		row = 42;
		
		maxStats.HP = 32;
		currentStats.HP = 32;
		
		maxStats.attack = 28;
		currentStats.attack = 28;
		maxStats.defence = 25;	
		currentStats.defence = 25;
		maxStats.hit = 120;
		currentStats.hit = 120;
		maxStats.evade = 50;
		currentStats.evade = 50;
		maxStats.critical = 30;
		currentStats.critical = 30;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new EvilSpirit(), 350));
		dropTable.add(new ItemDrop(new VampireDust(), 120));
		dropTable.add(new ItemDrop(new ReforgedPlough(), 150));
		dropTable.add(new ItemDrop(new SpringBreeze(), 100));
		dropTable.add(new ItemDrop(new Amethyst(4), 100));
		dropTable.add(new ItemDrop(new Misericordia(), 50));
		dropTable.add(new ItemDrop(Rune.ay, 60));
		
		
	}

}
