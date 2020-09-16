package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CraftWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	ItemContainer tusk;
	ItemContainer fang;
	ItemContainer claw;
	ItemContainer oakwood;
	ItemContainer iron;
	ItemContainer gold;
	ItemContainer silver;
	ItemContainer antlers;
	ItemContainer bone;
	ItemContainer coral;	
	ItemContainer pelt;
	ItemContainer hide;
	protected boolean updated;

	public CraftWidget() {
		
		tusk = new ItemContainer("tusk", 20, 60, 0, 0);
		fang = new ItemContainer("fang", 20, 82, 0, 1);
		claw = new ItemContainer("claw", 20, 104, 0, 2);
		oakwood = new ItemContainer("oak wood", 20, 126, 0, 3);
		iron = new ItemContainer("iron", 20, 148, 0, 4);
		gold = new ItemContainer("gold", 20, 170, 0, 5);
		silver = new ItemContainer("silver", 20, 192, 0, 6);
		antlers = new ItemContainer("antlers", 20, 214, 0, 7);
		bone = new ItemContainer("bone", 20, 236, 0, 8);
		coral = new ItemContainer("coral", 20, 258, 0, 9);
		
		pelt = new ItemContainer("pelt", 20, 280, 1, 0);
		hide = new ItemContainer("hide", 20, 302, 1, 1);
				
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(!updated) {
			
			tusk.quantity = Inventory.tusk;			
			fang.quantity = Inventory.fang;
			claw.quantity = Inventory.claw;
			oakwood.quantity = Inventory.oakwood;
			iron.quantity = Inventory.iron;
			gold.quantity = Inventory.gold;
			silver.quantity = Inventory.silver;
			antlers.quantity = Inventory.antlers;
			bone.quantity = Inventory.bone;
			coral.quantity = Inventory.coral;
			
			pelt.quantity = Inventory.pelt;
			hide.quantity = Inventory.hide;
					
			updated = true;
			
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		tusk.render(gameContainer, renderer);
		fang.render(gameContainer, renderer);
		claw.render(gameContainer, renderer);
		oakwood.render(gameContainer, renderer);
		iron.render(gameContainer, renderer);
		gold.render(gameContainer, renderer);
		silver.render(gameContainer, renderer);
		antlers.render(gameContainer, renderer);
		bone.render(gameContainer, renderer);
		coral.render(gameContainer, renderer);

		pelt.render(gameContainer, renderer);
		hide.render(gameContainer, renderer);
		
	}
	
	
	
	
	
	
	

}
