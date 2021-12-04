package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.Bezoar;
import com.redhaan.adventurersGalore.entity.item.items.Wanderlust;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.GaeBolg;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Katana;

public class EvilAvatar extends Enemy {
	
	
	public EvilAvatar() {
		
		name = "Evil Avatar";
		row = 36;
		
		maxStats.HP = 24;
		currentStats.HP = 24;
		
		maxStats.attack = 23;
		currentStats.attack = 23;
		maxStats.defence = 20;	
		currentStats.defence = 20;
		maxStats.hit = 110;
		currentStats.hit = 110;
		maxStats.evade = 90;
		currentStats.evade = 90;
		maxStats.critical = 60;
		currentStats.critical = 60;
		
		maxStats.move = 5;
		currentStats.move = 5;
		
		range = 1;
		
		ai = EnemyAI.Passive;
		
		dropTable.add(new ItemDrop(new Bezoar(), 100));
		dropTable.add(new ItemDrop(new Katana(), 70));
		dropTable.add(new ItemDrop(new Wanderlust(), 50));
		dropTable.add(new ItemDrop(Potion.redPotion, 50));
		dropTable.add(new ItemDrop(Rune.ges, 30));
		dropTable.add(new ItemDrop(new GaeBolg(), 10));
		
	}

}
