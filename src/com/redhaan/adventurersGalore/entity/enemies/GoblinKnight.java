package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.armour.Chain;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;

public class GoblinKnight extends Enemy {

	public GoblinKnight() {
		
		name = "Goblin Knight";
		row = 17;
		
		maxStats.HP = 22;
		currentStats.HP = 22;
		
		maxStats.attack = 18;
		currentStats.attack = 18;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 3;
		currentStats.move = 3;
		
		range = 1;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new Chain(), 100));
		dropTable.add(new ItemDrop(new Iron(), 150));
		dropTable.add(new ItemDrop(new Gold(), 100));
		dropTable.add(new ItemDrop(new EvilSpirit(), 30));
		dropTable.add(new ItemDrop(Potion.blackPotion, 2));
		
	}
	
}
