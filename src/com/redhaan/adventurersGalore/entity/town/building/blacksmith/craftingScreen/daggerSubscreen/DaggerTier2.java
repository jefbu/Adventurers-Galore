package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Tusk;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dirk;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerTier2 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Dirk dirk;
	
	private Iron iron;
	private Fang fang;
	private Tusk tusk;
	
	private int hoverOption;


	public DaggerTier2() {
		
		dirk = new Dirk();
		iron = new Iron();
		fang = new Fang();
		tusk = new Tusk();
	
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.fang >= 8 && Inventory.tusk >= 8) { 
					Inventory.weapons.add(new Dirk());
					Inventory.iron -= 3;
					Inventory.fang -= 8;
					Inventory.tusk -= 8;
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
			renderer.drawImageTile(Weapon.icon, 35, 160, dirk.xTile, dirk.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(dirk.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(CraftItems.icon, 162, 167, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 171, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 167, fang.xTile, fang.yTile);
			renderer.drawText("8", 260, 171, 0xff886622);
			if(Inventory.fang >= 8) { renderer.drawText("(" + Inventory.fang + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.fang + ")", 267, 171, 0xff774422); }
		
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 167, tusk.xTile, tusk.yTile);
			renderer.drawText("8", 335, 171, 0xff886622);
			if(Inventory.tusk >= 8) { renderer.drawText("(" + Inventory.tusk + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.tusk + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.fang >= 8 && Inventory.tusk >= 8) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
			
	}

}
