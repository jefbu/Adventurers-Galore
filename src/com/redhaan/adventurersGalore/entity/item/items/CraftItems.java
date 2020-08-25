package com.redhaan.adventurersGalore.entity.item.items;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class CraftItems extends Item {

	private static final long serialVersionUID = 1L;

	public CraftItems() {
	
		icon = new ImageTile("/spritesheets/craftItems.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);

	}

}
