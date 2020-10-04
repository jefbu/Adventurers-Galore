package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.staffSubscreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Quarterstaff;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StaffTier1 extends GameObject {

	private static final long serialVersionUID = 1L;

	private Quarterstaff quarterstaff;
	private OakWood oakWood;
	private Antlers antlers;
	
	private int hoverOption;

	public StaffTier1() {
		
		quarterstaff = new Quarterstaff();
		oakWood = new OakWood();
		antlers = new Antlers();
		
		hoverOption = 0;
		
	}
	
	
	
	
	
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(quarterstaff.icon, 35, 160, quarterstaff.xTile, quarterstaff.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(quarterstaff.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(oakWood.icon, 162, 167, oakWood.xTile, oakWood.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.oakwood >= 8) { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(antlers.icon, 237, 167, antlers.xTile, antlers.yTile);
			renderer.drawText("3", 260, 171, 0xff886622);
			if(Inventory.antlers >= 3) { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff774422); }
		
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.oakwood >= 8 && Inventory.antlers >= 3) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
			
	}

}
