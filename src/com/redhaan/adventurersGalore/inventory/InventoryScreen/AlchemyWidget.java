package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AlchemyWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private ItemContainer beastBlood;
	private ItemContainer lesses;
	
	protected boolean updated;

	public AlchemyWidget() {
		
		beastBlood = new ItemContainer("beast blood", 20, 60, 0, 0);
		lesses = new ItemContainer("lesses", 20, 82, 0, 2);
		
		
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (!updated) {
			
			beastBlood.quantity = Inventory.beastBlood;
			lesses.quantity = Inventory.lesses;
			
			updated = true;
			
		}
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		beastBlood.render(gameContainer, renderer);
		lesses.render(gameContainer, renderer);
		
	}

}
