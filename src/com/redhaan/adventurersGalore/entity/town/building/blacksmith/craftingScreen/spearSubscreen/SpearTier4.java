package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.spearSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Wanderlust;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Naginata;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SpearTier4 extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Naginata naginata;
	
	private Coral coral;
	private ViolentSpirit violentSpirit;
	private Wanderlust wanderlust;
	
	private int hoverOption;
	
	
	public SpearTier4() {
		
		naginata = new Naginata();
		
		coral = new Coral();
		violentSpirit = new ViolentSpirit();
		wanderlust = new Wanderlust();
		
		hoverOption = 0;
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.coral >= 5 && Inventory.violentSpirit >= 1 && Inventory.wanderlust >= 1) { 
					Inventory.weapons.add(new Naginata());
					Inventory.coral -= 5;
					Inventory.violentSpirit -= 1;
					Inventory.wanderlust -= 1;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		
		else { hoverOption = 0; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(Weapon.icon, 35, 160, naginata.xTile, naginata.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(naginata.name, 75, 170, 0xff685245);
		
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(CraftItems.icon, 162, 167, coral.xTile, coral.yTile);
			renderer.drawText("5", 185, 171, 0xff886622);
			if(Inventory.coral >= 5) { renderer.drawText("(" + Inventory.coral + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.coral + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 167, violentSpirit.xTile, violentSpirit.yTile);
			renderer.drawText("1", 260, 171, 0xff886622);
			if(Inventory.violentSpirit >= 1) { renderer.drawText("(" + Inventory.violentSpirit + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.violentSpirit + ")", 267, 171, 0xff774422); }
		
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 167, wanderlust.xTile, wanderlust.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.wanderlust >= 1) { renderer.drawText("(" + Inventory.wanderlust + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.wanderlust + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.coral >= 5 && Inventory.violentSpirit >= 1 && Inventory.wanderlust >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
	}

}
