package com.redhaan.adventurersGalore.entity.item.weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.GemStone;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Weapon extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	public int damage, hit, crit;
	public int upgrades;
	
	public Soul soul;
	public GemStone gemStone;
	
	public int runeTier;
	public int runeSlots;
	public ArrayList<Rune> runes;
	
	public boolean isLegendary;
	
	public Weapon() {
				
		runes = new ArrayList<Rune>();
		icon = new ImageTile("/weapons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		isLegendary = false;
		
	}
	
	public void rollRuneSlots(int runeTier) {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(runeTier) {
		
		case 1:
			if (roll > 95) { runeSlots = 3; }
			else if (roll > 85) { runeSlots = 2; }
			else if (roll > 70) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 2:
			if (roll > 90) { runeSlots = 3; }
			else if (roll > 70) { runeSlots = 2; }
			else if (roll > 40) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 3:
			if (roll > 80) { runeSlots = 3; }
			else if (roll > 50) { runeSlots = 2; }
			else if (roll > 20) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 4:
			if (roll > 60) { runeSlots = 3; }
			else if (roll > 20) { runeSlots = 2; }
			else if (roll > 5) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		}
		
	}
	
	public void upgrade() {
		
		damage = damage * 105 / 100;
		hit = hit + 2;
		crit = crit * 105 / 100;
		
	}
			

}
