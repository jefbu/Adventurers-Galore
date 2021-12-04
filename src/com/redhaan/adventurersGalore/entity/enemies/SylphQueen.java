package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;

public class SylphQueen extends Enemy {
	
	
	public SylphQueen() {
		
		name = "Sylph Queen";
		row = 41;
		
		maxStats.HP = 22;
		currentStats.HP = 22;
		
		maxStats.attack = 20;
		currentStats.attack = 20;
		maxStats.defence = 20;	
		currentStats.defence = 20;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 60;
		currentStats.evade = 60;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 7;
		currentStats.move = 7;
		
		range = 6;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new Emerald(1), 800));
		dropTable.add(new ItemDrop(new Emerald(2), 400));
		dropTable.add(new ItemDrop(new SpiritOfMischief(), 100));
		dropTable.add(new ItemDrop(Tattoo.butterfly, 20));
		
	}

}
