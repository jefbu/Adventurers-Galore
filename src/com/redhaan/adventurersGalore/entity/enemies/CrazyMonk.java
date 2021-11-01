package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Bile;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Bo;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Quarterstaff;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Waddy;

public class CrazyMonk extends Enemy {
	
	
	public CrazyMonk() {
		
		name = "Crazy Monk";
		row = 19;
		
		maxStats.HP = 20;
		currentStats.HP = 20;
		
		maxStats.attack = 20;
		currentStats.attack = 20;
		maxStats.defence = 11;	
		currentStats.defence = 11;
		maxStats.hit = 90;
		currentStats.hit = 90;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 15;
		currentStats.critical = 15;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Quarterstaff(), 200));
		dropTable.add(new ItemDrop(new Bile(), 250));
		dropTable.add(new ItemDrop(new Bo(), 200));
		dropTable.add(new ItemDrop(new Topaz(3), 50));
		dropTable.add(new ItemDrop(new Waddy(), 3));
		
	}

}
