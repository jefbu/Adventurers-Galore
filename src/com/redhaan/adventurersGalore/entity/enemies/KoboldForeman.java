package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Riveted;
import com.redhaan.adventurersGalore.entity.item.items.TurtleShell;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Ruby;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Cudgel;

public class KoboldForeman extends Enemy {
	
	
	public KoboldForeman() {
		
		name = "Kobold Foreman";
		row = 18;
		
		maxStats.HP = 26;
		currentStats.HP = 26;
		
		maxStats.attack = 21;
		currentStats.attack = 21;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 30;
		currentStats.evade = 30;
		maxStats.critical = 35;
		currentStats.critical = 35;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new TurtleShell(), 250));
		dropTable.add(new ItemDrop(new Turquoise(1), 200));
		dropTable.add(new ItemDrop(new Riveted(), 150));
		dropTable.add(new ItemDrop(new Ruby(3), 50));
		dropTable.add(new ItemDrop(new Cudgel(), 10));
		
	}

}
