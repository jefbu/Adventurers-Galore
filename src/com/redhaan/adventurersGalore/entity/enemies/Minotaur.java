package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.UnicornHorn;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.RecurveBow;

public class Minotaur extends Enemy {
	
	
	public Minotaur() {
		
		name = "Minotaur";
		row = 39;
		
		maxStats.HP = 28;
		currentStats.HP = 28;
		
		maxStats.attack = 28;
		currentStats.attack = 28;
		maxStats.defence = 20;	
		currentStats.defence = 20;
		maxStats.hit = 95;
		currentStats.hit = 95;
		maxStats.evade = 15;
		currentStats.evade = 15;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new UnicornHorn(), 100));
		dropTable.add(new ItemDrop(new RecurveBow(), 100));
		dropTable.add(new ItemDrop(Rune.dol, 40));
		dropTable.add(new ItemDrop(Tattoo.bull, 20));
		
	}

}
