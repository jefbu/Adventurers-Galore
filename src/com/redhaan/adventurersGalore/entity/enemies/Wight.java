package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.LuckyClover;
import com.redhaan.adventurersGalore.entity.item.items.MummyWrapping;
import com.redhaan.adventurersGalore.entity.item.items.VampireDust;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;

public class Wight extends Enemy {
	
	
	public Wight() {
		
		name = "Wight";
		row = 29;
		
		maxStats.HP = 15;
		currentStats.HP = 15;
		
		maxStats.attack = 25;
		currentStats.attack = 25;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 100;
		currentStats.hit = 100;
		maxStats.evade = 60;
		currentStats.evade = 60;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Onyx(1), 100));
		dropTable.add(new ItemDrop(new Turquoise(2), 200));
		dropTable.add(new ItemDrop(new VampireDust(), 60));
		dropTable.add(new ItemDrop(new MummyWrapping(), 40));
		dropTable.add(new ItemDrop(new LuckyClover(), 12));
		
	}

}
