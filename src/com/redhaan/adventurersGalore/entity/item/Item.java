package com.redhaan.adventurersGalore.entity.item;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.GemStone;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String name;
	public int weight;
	
	public ImageTile icon;
	public int xTile, yTile;
	
	public ItemID ID;
	public WeaponType type;
	
	public int defence;	
	public int damage, hit, crit;
	
	public int upgrades;
	
	public GemStone gemStone;


	public void upgrade() {
		
		if (ID == ItemID.Armour) {
			defence++;
		}
		else {
			damage++;
			hit = hit + 3;
			crit = crit + 2;
		}
		
	}
	
	
	
}
