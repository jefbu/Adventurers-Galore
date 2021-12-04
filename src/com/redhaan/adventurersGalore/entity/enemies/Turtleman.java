package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.LizardEye;
import com.redhaan.adventurersGalore.entity.item.items.TurtleShell;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Lance;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Epee;

public class Turtleman extends Enemy {

	public Turtleman() {
		

	name = "Turtleman";
	row = 26;
	
	maxStats.HP = 20;
	currentStats.HP = 20;
	
	maxStats.attack = 16;
	currentStats.attack = 16;
	maxStats.defence = 17;	
	currentStats.defence = 17;
	maxStats.hit = 80;
	currentStats.hit = 80;
	maxStats.evade = 10;
	currentStats.evade = 10;
	maxStats.critical = 10;
	currentStats.critical = 10;
	
	maxStats.move = 3;
	currentStats.move = 3;
	
	range = 2;
	
	ai = EnemyAI.Active;
	
	dropTable.add(new ItemDrop(new TurtleShell(), 350));
	dropTable.add(new ItemDrop(new LizardEye(), 200));
	dropTable.add(new ItemDrop(new Emerald(1), 150));
	dropTable.add(new ItemDrop(new Lance(), 150));
	dropTable.add(new ItemDrop(Rune.ay, 3));
	dropTable.add(new ItemDrop(new Epee(), 5));
	
	}
	
	
}
