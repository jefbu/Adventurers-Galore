package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.items.RobinEgg;
import com.redhaan.adventurersGalore.entity.item.items.SpringBreeze;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.IronSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Sabre;

public class Birdman extends Enemy {
	
	private static final long serialVersionUID = 1L;

	public Birdman() {
		
		
		name = "Birdman";
		row = 11;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new RobinEgg(), 400));
		dropTable.add(new ItemDrop(new VagrantSpirit(), 20));
		dropTable.add(new ItemDrop(new SpringBreeze(), 5));
		dropTable.add(new ItemDrop(Tattoo.kestrel, 1));
		dropTable.add(new ItemDrop(new IronSword(), 200));
		dropTable.add(new ItemDrop(new Sabre(), 100));
		
	}
	
	

}
