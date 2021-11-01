package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Coat;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.HandBow;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;

public class KoboldArcher extends Enemy {
	
	
	public KoboldArcher() {
		
		name = "Kobold Archer";
		row = 13;
		
		maxStats.HP = 18;
		currentStats.HP = 18;
		
		maxStats.attack = 17;
		currentStats.attack = 17;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 2;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new Coat(), 200));
		dropTable.add(new ItemDrop(new HandBow(), 200));
		dropTable.add(new ItemDrop(new Sapphire(4), 2));
		
		
	}

}
