package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;

public class Banshee extends Enemy {
	
	
	public Banshee() {
		
		name = "Banshee";
		row = 30;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 20;
		currentStats.attack = 20;
		maxStats.defence = 15;	
		currentStats.defence = 15;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 30;
		currentStats.evade = 30;
		maxStats.critical = 50;
		currentStats.critical = 50;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 2;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new Antlers(), 200));
		dropTable.add(new ItemDrop(new Sapphire(1), 150));
		dropTable.add(new ItemDrop(new Topaz(2), 100));
		dropTable.add(new ItemDrop(new SpiritOfMischief(), 80));
		dropTable.add(new ItemDrop(Potion.bluePotion, 30));
		dropTable.add(new ItemDrop(Rune.var, 4));
		
	}
	
	
	
	

}
