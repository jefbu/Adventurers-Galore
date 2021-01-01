package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.spearSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Spear;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SpearTier1 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Spear spear;
	
	private Iron iron;
	private OakWood oakWood;
	
	private int hoverOption;
	
	public SpearTier1() {
		
		spear = new Spear();
		
		iron = new Iron();
		oakWood = new OakWood();
		
		hoverOption = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.oakwood >= 5) { 
					Inventory.weapons.add(new Spear());
					Inventory.iron -= 3;
					Inventory.oakwood -= 5;
				}
			}
			
		}
		
		
		else { hoverOption = 0; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(spear.icon, 35, 160, spear.xTile, spear.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(spear.name, 75, 170, 0xff685245);
		
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 171, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(oakWood.icon, 237, 167, oakWood.xTile, oakWood.yTile);
			renderer.drawText("5", 260, 171, 0xff886622);
			if(Inventory.oakwood >= 5) { renderer.drawText("(" + Inventory.oakwood + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.oakwood + ")", 267, 171, 0xff774422); }
					
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.oakwood >= 5) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
	}

}
