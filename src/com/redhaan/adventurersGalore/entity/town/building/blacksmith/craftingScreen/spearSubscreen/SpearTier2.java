package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.spearSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.CompositeBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.HandBow;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Lance;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Pike;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SpearTier2 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Lance lance;
	private Pike pike;
	
	private Iron iron;
	private OakWood oakWood;
	private Claw claw;
	
	private int hoverOption;

	public SpearTier2() {
		
		lance = new Lance();
		pike = new Pike();
		
		iron = new Iron();
		oakWood = new OakWood();
		claw = new Claw();
		
		hoverOption = 0;
		
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.oakwood >= 5 && Inventory.claw >= 5) { 
					Inventory.weapons.add(new Lance());
					Inventory.iron -= 5;
					Inventory.oakwood -= 5;
					Inventory.claw -= 5;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.oakwood >= 8 && Inventory.claw >= 8) { 
					Inventory.weapons.add(new Pike());
					Inventory.iron -= 3;
					Inventory.oakwood -= 8;
					Inventory.claw -= 8;
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
		renderer.drawImageTile(lance.icon, 35, 160, lance.xTile, lance.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(lance.name, 75, 170, 0xff685245);

		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
		renderer.drawText("5", 185, 171, 0xff886622);
		if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }

		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(oakWood.icon, 237, 167, oakWood.xTile, oakWood.yTile);
		renderer.drawText("5", 260, 171, 0xff886622);
		if(Inventory.oakwood >= 5) { renderer.drawText("(" + Inventory.oakwood + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.oakwood + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(claw.icon, 312, 167, claw.xTile, claw.yTile);
		renderer.drawText("5", 335, 171, 0xff886622);
		if(Inventory.claw >= 5) { renderer.drawText("(" + Inventory.claw + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.claw + ")", 342, 171, 0xff774422); }
	
	renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
		renderer.drawImageTile(pike.icon, 35, 205, pike.xTile, pike.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(pike.name, 75, 215, 0xff685245);
		
		renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(iron.icon, 162, 212, iron.xTile, iron.yTile);
		renderer.drawText("3", 185, 216, 0xff886622);
		if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(oakWood.icon, 237, 212, oakWood.xTile, oakWood.yTile);
		renderer.drawText("8", 260, 216, 0xff886622);
		if(Inventory.oakwood >= 8) { renderer.drawText("(" + Inventory.oakwood + ")", 267, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.oakwood + ")", 267, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(claw.icon, 312, 212, claw.xTile, claw.yTile);
		renderer.drawText("8", 335, 216, 0xff886622);
		if(Inventory.claw >= 8) { renderer.drawText("(" + Inventory.claw + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.claw + ")", 342, 216, 0xff774422); }
		
		
	switch(hoverOption) {
	
	case 0: break;
	case 1:
		if (Inventory.iron >= 3 && Inventory.oakwood >= 5 && Inventory.claw >= 5) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
		else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
		break;
	case 2:
		if (Inventory.iron >= 3 && Inventory.claw >= 5 && Inventory.oakwood >= 5) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
		else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
		break;			
	
	}
		
		
	}

}
