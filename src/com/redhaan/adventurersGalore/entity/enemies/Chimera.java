package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Gothic;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Pike;

public class Chimera extends Enemy {
	
	
	public Chimera() {
		
		name = "Chimera";
		row = 33;
		
		maxStats.HP = 30;
		currentStats.HP = 30;
		
		maxStats.attack = 25;
		currentStats.attack = 25;
		maxStats.defence = 20;	
		currentStats.defence = 20;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Coral(), 300));
		dropTable.add(new ItemDrop(new Pike(), 250));
		dropTable.add(new ItemDrop(new ViolentSpirit(), 100));
		dropTable.add(new ItemDrop(new Sapphire(3), 150));
		dropTable.add(new ItemDrop(new Gothic(), 50));
		dropTable.add(new ItemDrop(Rune.tiy, 30));
		
	}

}
