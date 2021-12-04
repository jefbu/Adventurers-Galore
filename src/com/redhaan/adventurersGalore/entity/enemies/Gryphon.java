package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Gungnir;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Yari;

public class Gryphon extends Enemy {
	
	
	public Gryphon() {
		
		name = "Gryphon";
		row = 35;
		
		maxStats.HP = 29;
		currentStats.HP = 29;
		
		maxStats.attack = 26;
		currentStats.attack = 26;
		maxStats.defence = 20;	
		currentStats.defence = 20;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 25;
		currentStats.evade = 25;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Gold(), 300));
		dropTable.add(new ItemDrop(new NobleSpirit(), 150));
		dropTable.add(new ItemDrop(new Pearl(3), 100));
		dropTable.add(new ItemDrop(new Yari(), 60));
		dropTable.add(new ItemDrop(Rune.yut, 40));
		dropTable.add(new ItemDrop(new Gungnir(), 10));
		
	}

}
