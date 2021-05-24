package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AlchemyWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private ItemContainer beastBlood;
	private ItemContainer lesses;
	
	
	private ItemContainer whitePotion;
	private ItemContainer goldPotion;
	private ItemContainer tealPotion;
	private ItemContainer redPotion;
	private ItemContainer greenPotion;
	private ItemContainer bluePotion;
	private ItemContainer brownPotion;
	private ItemContainer purplePotion;
	private ItemContainer blackPotion;
	
	
	protected boolean updated;

	public AlchemyWidget() {
		
		beastBlood = new ItemContainer("beast blood", 20, 60, 2, 0);
		lesses = new ItemContainer("lesses", 20, 82, 2, 1);
		
		whitePotion = new ItemContainer("white potion", 400, 60, 10, 0);
		goldPotion = new ItemContainer("gold potion", 400, 82, 10, 1);
		tealPotion = new ItemContainer("teal potion", 400, 104, 10, 2);
		redPotion = new ItemContainer("red potion", 400, 126, 10, 3);
		greenPotion = new ItemContainer("green potion", 400, 148, 10, 4);
		bluePotion = new ItemContainer("blue potion", 400, 170, 10, 5);
		brownPotion = new ItemContainer("brown potion", 400, 192, 10, 6);
		purplePotion = new ItemContainer("purple potion", 400, 214, 10, 7);
		blackPotion = new ItemContainer("black potion", 400, 236, 10, 8);

		
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (!updated) {
			
			beastBlood.quantity = Inventory.beastBlood;
			lesses.quantity = Inventory.lesses;
			
			whitePotion.quantity = Inventory.whitePotion;
			goldPotion.quantity = Inventory.goldPotion;
			tealPotion.quantity = Inventory.tealPotion;
			redPotion.quantity = Inventory.redPotion;
			greenPotion.quantity = Inventory.greenPotion;
			bluePotion.quantity = Inventory.bluePotion;
			brownPotion.quantity = Inventory.brownPotion;
			purplePotion.quantity = Inventory.purplePotion;
			blackPotion.quantity = Inventory.blackPotion;
			
			updated = true;
			
		}
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		beastBlood.render(gameContainer, renderer);
		lesses.render(gameContainer, renderer);
		
		whitePotion.render(gameContainer, renderer);
		goldPotion.render(gameContainer, renderer);
		tealPotion.render(gameContainer, renderer);
		redPotion.render(gameContainer, renderer);
		greenPotion.render(gameContainer, renderer);
		bluePotion.render(gameContainer, renderer);
		brownPotion.render(gameContainer, renderer);
		purplePotion.render(gameContainer, renderer);
		blackPotion.render(gameContainer, renderer);

		
	}

}
