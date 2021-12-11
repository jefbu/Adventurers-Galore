package com.redhaan.adventurersGalore.entity.item.weapon.gemStones;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class GemStone extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public int whiteBonus;
	public int yellowBonus;
	public int tealBonus;
	public int redBonus;
	public int greenBonus;
	public int blueBonus;
	public int brownBonus;
	public int purpleBonus;
	public int blackBonus;
	
	public int level;
	

	
	public GemStoneEnum gemStoneEnum;
	
	public GemStone(int whiteBonus, int yellowBonus, int tealBonus, int redBonus, int greenBonus, int blueBonus, int brownBonus, int purpleBonus, int blackBonus) {
		
		this.whiteBonus = whiteBonus;
		this.yellowBonus = yellowBonus;
		this.tealBonus = tealBonus;
		this.redBonus = redBonus;
		this.greenBonus = greenBonus;
		this.blueBonus = blueBonus;
		this.brownBonus = brownBonus;
		this.purpleBonus = purpleBonus;
		this.blackBonus = blackBonus;
		
	}
	
	public void addLevelModifiers() {
		
		whiteBonus = whiteBonus * level * 5 ;
		yellowBonus = yellowBonus * level * 5;
		tealBonus = tealBonus * level * 5;
		redBonus = redBonus * level * 5;
		greenBonus = greenBonus * level * 5;
		blueBonus = blueBonus * level * 5;
		brownBonus = brownBonus * level * 5;
		purpleBonus = purpleBonus * level * 5;
		blackBonus = blackBonus * level * 5;
		
	}
	
	
	public void makeName() {
		
		switch(level) {
		
		case 1: name = "cheap " + name; break;
		case 2: name = "basic " + name; break;
		case 3: name = "quality " + name; break;
		case 4: name = "flawless " + name; break;
		
		}
		
	}
	

}
