package com.redhaan.adventurersGalore.entity.weapon;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Rune {
	
	public String name;
	ImageTile icon;
	
	public Rune(String name, ImageTile icon) {
		
		this.name = name;
		this.icon = icon;
		
	}
	
	
	public static Rune Od = new Rune("Od", null);
	public static Rune Er = new Rune("Er", null);

}
