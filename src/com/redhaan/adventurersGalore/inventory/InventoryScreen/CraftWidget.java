package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CraftWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	ItemContainer fang;
	ItemContainer pelt;
	ItemContainer hide;
	protected boolean updated;

	public CraftWidget() {
		
		fang = new ItemContainer("fang", 20, 60, 0, 1);
		pelt = new ItemContainer("pelt", 20, 82, 0, 4);
		hide = new ItemContainer("hide", 20, 104, 0, 3);
				
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(!updated) {
			
			fang.quantity = Inventory.fangs;
			pelt.quantity = Inventory.pelts;
			hide.quantity = Inventory.hides;
					
			updated = true;
			
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		fang.render(gameContainer, renderer);
		pelt.render(gameContainer, renderer);
		hide.render(gameContainer, renderer);
		
	}
	
	
	
	
	
	
	

}
