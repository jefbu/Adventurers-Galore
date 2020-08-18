package com.redhaan.adventurersGalore.entity.item.weapon;

import java.io.Serializable;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Rune implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	ImageTile icon;
	
	public Rune(String name, ImageTile icon) {
		
		this.name = name;
		this.icon = icon;
		
	}
	
	
	public static Rune Od = new Rune("Od", null);
	public static Rune Er = new Rune("Er", null);

}
