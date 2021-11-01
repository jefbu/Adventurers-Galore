package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.DragonBlood;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Katar;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Knife;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Machete;

public class KoboldScrounger extends Enemy {
	
	
	public KoboldScrounger() {
		
		name = "Kobold Scrounger";
		row = 12;
		
		maxStats.HP = 19;
		currentStats.HP = 19;
		
		maxStats.attack = 19;
		currentStats.attack = 19;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Knife(), 200));
		dropTable.add(new ItemDrop(new Ivory(), 150));
		dropTable.add(new ItemDrop(new DragonBlood(), 30));
		dropTable.add(new ItemDrop(new Machete(), 5));
		dropTable.add(new ItemDrop(Potion.tealPotion, 5));
		dropTable.add(new ItemDrop(new Katar(), 1));
		
		
	}

}
