package com.redhaan.adventurersGalore.entity.armour;

import java.io.Serializable;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Armour implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public int weight;
	public int defence;
	public String name;
	
	public ImageTile icon;
	public int iconX, iconY;
	
	
	public Armour() {
		
	}

}
