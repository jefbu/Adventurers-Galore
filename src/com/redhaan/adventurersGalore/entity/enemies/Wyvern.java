package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Wanderlust;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Naginata;

public class Wyvern extends Enemy {
	
	
	public Wyvern() {
		
		name = "Wyvern";
		row = 34;
		
		maxStats.HP = 28;
		currentStats.HP = 28;
		
		maxStats.attack = 26;
		currentStats.attack = 26;
		maxStats.defence = 18;	
		currentStats.defence = 18;
		maxStats.hit = 115;
		currentStats.hit = 115;
		maxStats.evade = 35;
		currentStats.evade = 35;
		maxStats.critical = 35;
		currentStats.critical = 35;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Silver(), 250));
		dropTable.add(new ItemDrop(new VagrantSpirit(), 100));
		dropTable.add(new ItemDrop(new Turquoise(3), 150));
		dropTable.add(new ItemDrop(new Wanderlust(), 150));
		dropTable.add(new ItemDrop(Rune.bir, 20));
		dropTable.add(new ItemDrop(new Naginata(), 50));
		
	}

}
