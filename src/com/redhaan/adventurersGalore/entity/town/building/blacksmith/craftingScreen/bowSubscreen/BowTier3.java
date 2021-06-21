package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.bowSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.RecurveBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BowTier3 extends GameObject {
	
	private RecurveBow recurveBow;
	
	private OakWood oakWood;
	private Ivory ivory;
	private VagrantSpirit vagrantSpirit;
	
	private int hoverOption;
	
	
	public BowTier3() {
		
		recurveBow = new RecurveBow();
		
		oakWood = new OakWood();
		ivory = new Ivory();
		vagrantSpirit = new VagrantSpirit();
		
		hoverOption = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.oakwood >= 8 && Inventory.ivory >= 3 && Inventory.vagrantSpirit >= 1) { 
					Inventory.weapons.add(new RecurveBow());
					Inventory.oakwood -= 8;
					Inventory.ivory -= 3;
					Inventory.vagrantSpirit -= 1;
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
		renderer.drawImageTile(recurveBow.icon, 35, 160, recurveBow.xTile, recurveBow.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(recurveBow.name, 75, 170, 0xff685245);
	
		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(oakWood.icon, 162, 167, oakWood.xTile, oakWood.yTile);
		renderer.drawText("8", 185, 171, 0xff886622);
		if(Inventory.oakwood >= 8) { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff774422); }
	
		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(ivory.icon, 237, 167, ivory.xTile, ivory.yTile);
		renderer.drawText("3", 260, 171, 0xff886622);
		if(Inventory.ivory >= 3) { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff774422); }
	
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(vagrantSpirit.icon, 312, 167, vagrantSpirit.xTile, vagrantSpirit.yTile);
		renderer.drawText("1", 335, 171, 0xff886622);
		if(Inventory.vagrantSpirit >= 1) { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 342, 171, 0xff774422); }
		
		
	switch(hoverOption) {
	
	case 0: break;
	case 1:
		if (Inventory.oakwood >= 8 && Inventory.ivory >= 3 && Inventory.vagrantSpirit >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
		else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
		break;		
	
	}
		
	}

}
