package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.armour.Lamellar;
import com.redhaan.adventurersGalore.entity.item.armour.Plate;
import com.redhaan.adventurersGalore.entity.item.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.VolcanicAsh;

public class Zombie extends Enemy {
	
	
	public Zombie() {
		
		name = "Zombie";
		row = 23;
		
		maxStats.HP = 24;
		currentStats.HP = 24;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 70;
		currentStats.hit = 70;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 3;
		currentStats.move = 3;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new VolcanicAsh(), 400));
		dropTable.add(new ItemDrop(new Claw(), 150));
		dropTable.add(new ItemDrop(new Plate(), 50));
		dropTable.add(new ItemDrop(new ReinforcedLeather(), 8));
		dropTable.add(new ItemDrop(new Lamellar(), 2));
		
	}

}
