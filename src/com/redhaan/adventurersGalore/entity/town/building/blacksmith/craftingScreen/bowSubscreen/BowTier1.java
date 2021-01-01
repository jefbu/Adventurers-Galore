package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.bowSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dirk;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BowTier1 extends GameObject {
	
	private ShortBow shortBow;
	
	private Hide hide;
	private Antlers antlers;
	private OakWood oakWood;
	
	private int hoverOption;
	
	public BowTier1() {
		
		shortBow = new ShortBow();
		
		hide = new Hide();
		antlers = new Antlers();
		oakWood = new OakWood();
		
		hoverOption = 0;
		
	}
	
	
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 3 && Inventory.antlers >= 2 && Inventory.oakwood >= 5) { 
					Inventory.weapons.add(new ShortBow());
					Inventory.hide -= 3;
					Inventory.antlers -= 2;
					Inventory.oakwood -= 5;
				}
			}
			
		}
		
		
		else { hoverOption = 0; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(shortBow.icon, 35, 160, shortBow.xTile, shortBow.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(shortBow.name, 75, 170, 0xff685245);
		
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(hide.icon, 162, 167, hide.xTile, hide.yTile);
			renderer.drawText("3", 185, 171, 0xff886622);
			if(Inventory.hide >= 3) { renderer.drawText("(" + Inventory.hide + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.hide + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(antlers.icon, 237, 167, antlers.xTile, antlers.yTile);
			renderer.drawText("2", 260, 171, 0xff886622);
			if(Inventory.antlers >= 2) { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff774422); }
		
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(oakWood.icon, 312, 167, oakWood.xTile, oakWood.yTile);
			renderer.drawText("5", 335, 171, 0xff886622);
			if(Inventory.oakwood >= 5) { renderer.drawText("(" + Inventory.oakwood + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.oakwood + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.hide >= 3 && Inventory.antlers >= 2 && Inventory.oakwood >= 5) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
	}

}
