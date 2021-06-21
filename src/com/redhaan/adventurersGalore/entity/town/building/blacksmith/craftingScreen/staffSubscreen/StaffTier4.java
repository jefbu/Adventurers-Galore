package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.staffSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.RationalThought;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Waddy;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StaffTier4 extends GameObject {
	
	
	private static final long serialVersionUID = 1L;
	
	private Waddy waddy;
	private Antlers antlers;
	private VagrantSpirit vagrantSpirit;
	private RationalThought rationalThought;
	
	private int hoverOption;


	public StaffTier4() {
		
		waddy = new Waddy();
		antlers = new Antlers();
		vagrantSpirit = new VagrantSpirit();
		rationalThought = new RationalThought();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.antlers >= 8 && Inventory.vagrantSpirit >= 1 && Inventory.rationalThought >= 1) { 
					Inventory.weapons.add(new Waddy());
					Inventory.antlers -= 8;
					Inventory.vagrantSpirit -= 1;
					Inventory.rationalThought -= 1;
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
			renderer.drawImageTile(waddy.icon, 35, 160, waddy.xTile, waddy.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(waddy.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(antlers.icon, 162, 167, antlers.xTile, antlers.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.antlers >= 8) { renderer.drawText("(" + Inventory.antlers + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(vagrantSpirit.icon, 237, 167, vagrantSpirit.xTile, vagrantSpirit.yTile);
			renderer.drawText("1", 260, 171, 0xff886622);
			if(Inventory.claw >= 1) { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(rationalThought.icon, 312, 167, rationalThought.xTile, rationalThought.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.rationalThought >= 1) { renderer.drawText("(" + Inventory.rationalThought + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.rationalThought + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.fang >= 8) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
			
	}

}
