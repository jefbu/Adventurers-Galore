package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Tusk;
import com.redhaan.adventurersGalore.entity.item.items.VolcanicAsh;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;

public class Ghoul extends Enemy {
	
	
	public Ghoul() {
		
		name = "Ghoul";
		row = 22;
		
		maxStats.HP = 23;
		currentStats.HP = 23;
		
		maxStats.attack = 20;
		currentStats.attack = 20;
		maxStats.defence = 12;	
		currentStats.defence = 12;
		maxStats.hit = 70;
		currentStats.hit = 70;
		maxStats.evade = 15;
		currentStats.evade = 15;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 4;
		currentStats.move = 4;
		
		range = 1;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Tusk(), 300));
		dropTable.add(new ItemDrop(new VolcanicAsh(), 150));
		dropTable.add(new ItemDrop(new Amethyst(2), 50));
		dropTable.add(new ItemDrop(Potion.purplePotion, 5));
		dropTable.add(new ItemDrop(Rune.wos, 2));
		
	}

}
