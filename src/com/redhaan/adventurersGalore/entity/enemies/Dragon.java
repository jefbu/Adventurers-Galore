package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.items.DragonBlood;
import com.redhaan.adventurersGalore.entity.item.items.GloriousMoment;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.Yoichi;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Ruby;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.SilverSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.VorpalSword;

public class Dragon extends Enemy {
	
	
	public Dragon() {
		
		name = "Dragon";
		row = 8;
		
		maxStats.HP = 30;
		currentStats.HP = 30;
		
		maxStats.attack = 27;
		currentStats.attack = 27;
		maxStats.defence = 25;	
		currentStats.defence = 25;
		maxStats.hit = 115;
		currentStats.hit = 115;
		maxStats.evade = 50;
		currentStats.evade = 50;
		maxStats.critical = 25;
		currentStats.critical = 25;
		
		maxStats.move = 6;
		currentStats.move = 6;
		
		range = 3;
		
		ai = EnemyAI.Active;
		
		dropTable.add(new ItemDrop(new Ruby(2), 600));
		dropTable.add(new ItemDrop(new DragonBlood(), 300));
		dropTable.add(new ItemDrop(new SilverSword(), 100));
		dropTable.add(new ItemDrop(new VorpalSword(), 50));
		dropTable.add(new ItemDrop(new GloriousMoment(), 100));
		dropTable.add(new ItemDrop(Rune.fu, 50));
		dropTable.add(new ItemDrop(new Yoichi(), 30));
		
	}

}
