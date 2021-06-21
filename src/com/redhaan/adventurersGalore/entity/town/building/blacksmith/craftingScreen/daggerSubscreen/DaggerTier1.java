package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dagger;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Knife;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerTier1 extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private Dagger dagger;
	private Knife knife;
	private Iron iron;
	private Claw claw;
	private Fang fang;
	
	private int hoverOption;

	public DaggerTier1() {
		
		dagger = new Dagger();
		knife = new Knife();
		iron = new Iron();
		claw = new Claw();
		fang = new Fang();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.fang >= 8) { 
					Inventory.weapons.add(new Dagger());
					Inventory.iron -= 3;
					Inventory.fang -= 8;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 2 && Inventory.claw >= 5 && Inventory.fang >= 5) { 
					Inventory.weapons.add(new Knife());
					Inventory.iron -= 2;
					Inventory.claw -= 5;
					Inventory.fang -= 5;
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
			renderer.drawImageTile(dagger.icon, 35, 160, dagger.xTile, dagger.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(dagger.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 171, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(fang.icon, 237, 167, fang.xTile, fang.yTile);
			renderer.drawText("8", 260, 171, 0xff886622);
			if(Inventory.fang >= 8) { renderer.drawText("(" + Inventory.fang + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.fang + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(knife.icon, 35, 205, knife.xTile, knife.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(knife.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 212, iron.xTile, iron.yTile);
			renderer.drawText("2", 185, 216, 0xff886622);
			if(Inventory.iron >= 2) { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(claw.icon, 237, 212, claw.xTile, claw.yTile);
			renderer.drawText("5", 260, 216, 0xff886622);
			if(Inventory.claw >= 5) { renderer.drawText("(" + Inventory.claw + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.claw + ")", 267, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(fang.icon, 312, 212, fang.xTile, fang.yTile);
			renderer.drawText("5", 335, 216, 0xff886622);
			if(Inventory.fang >= 5) { renderer.drawText("(" + Inventory.fang + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.fang + ")", 342, 216, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.fang >= 8) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.iron >= 2 && Inventory.claw >= 5 && Inventory.fang >= 5) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;			
		
		}
			
	}
	

}
