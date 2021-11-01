package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.LizardEye;
import com.redhaan.adventurersGalore.entity.item.items.SnakeTongue;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dirk;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;

public class Snake extends Enemy {
	
	
	private static final long serialVersionUID = 1L;

	public Snake() {
		
		name = "Snake";
		row = 5;
		
		maxStats.HP = 18;
		currentStats.HP = 18;
		
		maxStats.attack = 17;
		currentStats.attack = 17;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 80;
		currentStats.hit = 80;
		maxStats.evade = 10;
		currentStats.evade = 10;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new SnakeTongue(), 300));
		dropTable.add(new ItemDrop(new LizardEye(), 300));
		dropTable.add(new ItemDrop(new Turquoise(2), 20));
		dropTable.add(new ItemDrop(Potion.redPotion, 5));
		dropTable.add(new ItemDrop(new Onyx(4), 1));
		dropTable.add(new ItemDrop(new Dirk(), 100));
		
		
	}
		

}



