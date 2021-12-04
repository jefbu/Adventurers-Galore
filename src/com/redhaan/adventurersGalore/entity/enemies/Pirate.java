package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Brigandine;
import com.redhaan.adventurersGalore.entity.item.items.Bile;
import com.redhaan.adventurersGalore.entity.item.items.GloriousMoment;
import com.redhaan.adventurersGalore.entity.item.items.HistoricDocument;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Baton;

public class Pirate extends Enemy {
	
	private static final long serialVersionUID = 1L;

	public Pirate() {
		
		name = "Pirate";
		row = 7;
		
		maxStats.HP = 21;
		currentStats.HP = 21;
		
		maxStats.attack = 19;
		currentStats.attack = 19;
		maxStats.defence = 13;	
		currentStats.defence = 13;
		maxStats.hit = 85;
		currentStats.hit = 85;
		maxStats.evade = 15;
		currentStats.evade = 15;
		maxStats.critical = 20;
		currentStats.critical = 20;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Aggressive;
		
		dropTable.add(new ItemDrop(new Bile(), 300));
		dropTable.add(new ItemDrop(new Turquoise(1), 150));
		dropTable.add(new ItemDrop(new Baton(), 50));
		dropTable.add(new ItemDrop(new HistoricDocument(), 20));
		dropTable.add(new ItemDrop(new GloriousMoment(), 5));
		dropTable.add(new ItemDrop(new Brigandine(), 3));			
		
	}

}
