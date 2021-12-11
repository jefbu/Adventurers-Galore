package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.LuckyClover;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amber;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.DoubleLily;

public class Cenourus extends Enemy {
	
	
	public Cenourus() {
			
		name = "Cenourus";
		row = 44;
		
		maxStats.HP = 18;
		currentStats.HP = 18;
		
		maxStats.attack = 14;
		currentStats.attack = 14;
		maxStats.defence = 14;	
		currentStats.defence = 14;
		maxStats.hit = 75;
		currentStats.hit = 75;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 3;
		currentStats.move = 3;
		
		range = 2;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new LuckyClover(), 2));
		dropTable.add(new ItemDrop(new DoubleLily(), 1));
		dropTable.add(new ItemDrop(Potion.brownPotion, 5));
		dropTable.add(new ItemDrop(new Emerald(3), 8));
		dropTable.add(new ItemDrop(new Sapphire(2), 20));
		dropTable.add(new ItemDrop(new Amber(3), 10));
		
	}
	

}
