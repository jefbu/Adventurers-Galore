package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.staffSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Baton;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Bo;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BroadSword;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StaffTier2 extends GameObject {
	
	private Bo bo;
	private Baton baton;
	private OakWood oakwood;
	private Antlers antlers;
	private Ivory ivory;	
	
	private int hoverOption;
	
	
	public StaffTier2() {
		
		bo = new Bo();
		baton = new Baton();
		oakwood = new OakWood();
		antlers = new Antlers();
		ivory = new Ivory();
		
		hoverOption = 0;
		
	}
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.oakwood >= 8 && Inventory.antlers >= 3 && Inventory.ivory >= 1) { 
					Inventory.weapons.add(new Bo());
					Inventory.oakwood -= 8;
					Inventory.antlers -= 3;
					Inventory.ivory -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.oakwood >= 5 && Inventory.antlers >= 3 && Inventory.ivory >= 2) { 
					Inventory.weapons.add(new Baton());
					Inventory.oakwood -= 5;
					Inventory.antlers -= 3;
					Inventory.ivory -= 2;
				}
			}
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(bo.icon, 35, 160, bo.xTile, bo.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(bo.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(oakwood.icon, 162, 167, oakwood.xTile, oakwood.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.oakwood >= 8) { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.oakwood + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(antlers.icon, 237, 167, antlers.xTile, antlers.yTile);
			renderer.drawText("3", 260, 171, 0xff886622);
			if(Inventory.antlers >= 3) { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(ivory.icon, 312, 167, ivory.xTile, ivory.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.antlers >= 1) { renderer.drawText("(" + Inventory.antlers + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 342, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(baton.icon, 35, 205, baton.xTile, baton.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(baton.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(oakwood.icon, 162, 212, oakwood.xTile, oakwood.yTile);
			renderer.drawText("5", 185, 216, 0xff886622);
			if(Inventory.oakwood >= 5) { renderer.drawText("(" + Inventory.oakwood + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.oakwood + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(antlers.icon, 237, 212, antlers.xTile, antlers.yTile);
			renderer.drawText("3", 260, 216, 0xff886622);
			if(Inventory.antlers >= 3) { renderer.drawText("(" + Inventory.antlers + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 267, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(ivory.icon, 312, 212, ivory.xTile, ivory.yTile);
			renderer.drawText("2", 335, 216, 0xff886622);
			if(Inventory.ivory >= 2) { renderer.drawText("(" + Inventory.ivory + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 342, 216, 0xff774422); }
			
			
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
