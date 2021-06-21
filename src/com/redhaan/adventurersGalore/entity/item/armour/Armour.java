package com.redhaan.adventurersGalore.entity.item.armour;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Armour extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static ImageTile icon;
	
	public Armour() {
		
		icon = new ImageTile("/armour.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}

}
