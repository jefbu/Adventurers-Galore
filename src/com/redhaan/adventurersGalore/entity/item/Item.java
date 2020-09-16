package com.redhaan.adventurersGalore.entity.item;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.item.weapon.ItemID;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String name;
	public int weight;
	
	public ImageTile icon;
	public int xTile, yTile;
	
	public ItemID ID;

}
