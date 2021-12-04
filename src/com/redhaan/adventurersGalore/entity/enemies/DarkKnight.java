package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Jousting;
import com.redhaan.adventurersGalore.entity.item.armour.Scale;
import com.redhaan.adventurersGalore.entity.item.items.HistoricDocument;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.CompositeBow;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Excalibur;

public class DarkKnight extends Enemy {
	
	
	public DarkKnight() {
		
		name = "Dark Knight";
		row = 37;
		
		maxStats.HP = 30;
		currentStats.HP = 30;
		
		maxStats.attack = 22;
		currentStats.attack = 22;
		maxStats.defence = 24;	
		currentStats.defence = 24;
		maxStats.hit = 105;
		currentStats.hit = 105;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 3;
		currentStats.move = 3;
		
		range = 2;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new Iron(), 300));
		dropTable.add(new ItemDrop(new CompositeBow(), 200));
		dropTable.add(new ItemDrop(new Scale(), 70));
		dropTable.add(new ItemDrop(new Jousting(), 50));
		dropTable.add(new ItemDrop(new Excalibur(), 10));
		dropTable.add(new ItemDrop(new HistoricDocument(), 100));
		
	}

}
