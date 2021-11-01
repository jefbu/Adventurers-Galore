package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.armour.Leather;
import com.redhaan.adventurersGalore.entity.item.items.BeastBlood;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Lesses;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amber;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Sabre;

public class GiantBat extends Enemy {

	private static final long serialVersionUID = 1L;

	public GiantBat() {
		
		name = "Giant Bat";
		row = 3;
		
		maxStats.HP = 20;
		maxStats.MP = 15;
		maxStats.PHY = 11;
		maxStats.AGI = 12;
		maxStats.MAG = 5;
		maxStats.DEX = 11;
		maxStats.INT = 6;
		maxStats.PRC = 8;
		maxStats.move = 7;
		
		currentStats.HP = 20;
		currentStats.MP = 15;
		currentStats.PHY = 11;
		currentStats.AGI = 12;
		currentStats.MAG = 5;
		currentStats.DEX = 11;
		currentStats.INT = 6;
		currentStats.PRC = 8;
		currentStats.move = 7;
		
		maxStats.attack = 20;
		maxStats.defence = 10;
		maxStats.hit = 75;
		maxStats.critical = 10;
		
		currentStats.attack = 20;
		currentStats.defence = 10;
		currentStats.hit = 75;
		currentStats.critical = 10;
		
		int gemStoneLevel = rollGemStoneLevel(60, 30, 9, 1);
		
		dropTable.add(new ItemDrop(new BeastBlood(), 900));


		
	}
		

}
