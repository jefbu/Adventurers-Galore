package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.weapon.bows.Yoichi;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Misericordia;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.GaeBolg;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Gungnir;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Longinus;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.DoubleLily;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Excalibur;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.VorpalSword;

public class HipsterSuit extends Enemy {
	
	private static final long serialVersionUID = 1L;

	public HipsterSuit() {
		
		name = "Hipster in a Suit";
		row = 44;
		
		maxStats.HP = 10;
		currentStats.HP = 10;
		
		maxStats.attack = 24;
		currentStats.attack = 24;
		maxStats.defence = 10;	
		currentStats.defence = 10;
		maxStats.hit = 140;
		currentStats.hit = 140;
		maxStats.evade = 20;
		currentStats.evade = 20;
		maxStats.critical = 10;
		currentStats.critical = 10;
		
		maxStats.move = 8;
		currentStats.move = 8;
		
		range = 15;
		
		ai = EnemyAI.Evasive;
		
		dropTable.add(new ItemDrop(new Excalibur(), 50));
		dropTable.add(new ItemDrop(new VorpalSword(), 50));
		dropTable.add(new ItemDrop(new DoubleLily(), 50));
		dropTable.add(new ItemDrop(new Yoichi(), 50));
		dropTable.add(new ItemDrop(new Gungnir(), 50));
		dropTable.add(new ItemDrop(new Longinus(), 50));
		dropTable.add(new ItemDrop(new GaeBolg(), 50));
		dropTable.add(new ItemDrop(new Misericordia(), 50));

			
		
	}
		

}
