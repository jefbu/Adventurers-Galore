package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;
import com.redhaan.adventurersGalore.entity.item.armour.Quilt;
import com.redhaan.adventurersGalore.entity.item.items.Ectoplasm;
import com.redhaan.adventurersGalore.entity.item.items.ManaTreeBranch;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;

public class Pixie extends Enemy {
	
	public Pixie() {
		
		name = "Pixie";
		row = 9;
		
		maxStats.HP = 16;
		currentStats.HP = 16;
		
		maxStats.attack = 14;
		currentStats.attack = 14;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 85;
		currentStats.hit = 85;
		maxStats.evade = 40;
		currentStats.evade = 40;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 4;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new OakWood(), 400));
		dropTable.add(new ItemDrop(new Ectoplasm(), 300));
		dropTable.add(new ItemDrop(new Quilt(), 100));
		dropTable.add(new ItemDrop(new ManaTreeBranch(), 20));
		dropTable.add(new ItemDrop(Potion.greenPotion, 1));
		dropTable.add(new ItemDrop(Tattoo.butterfly, 1));
		
	}

}
