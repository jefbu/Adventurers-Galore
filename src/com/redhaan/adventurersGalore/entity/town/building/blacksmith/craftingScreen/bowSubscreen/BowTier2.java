package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.bowSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.CompositeBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.HandBow;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BowTier2 extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HandBow handBow;
	private CompositeBow compositeBow;
	
	private Hide hide;
	private Ivory ivory;
	private OakWood oakWood;
	
	private int hoverOption;
	
	public BowTier2() {
		
		handBow = new HandBow();
		compositeBow = new CompositeBow();
		
		hide = new Hide();
		ivory = new Ivory();
		oakWood = new OakWood();
		
		hoverOption = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 5 && Inventory.ivory >= 1 && Inventory.oakwood >= 8) { 
					Inventory.weapons.add(new CompositeBow());
					Inventory.hide -= 5;
					Inventory.ivory -= 1;
					Inventory.oakwood -= 8;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 3 && Inventory.ivory >= 2 && Inventory.oakwood >= 5) { 
					Inventory.weapons.add(new HandBow());
					Inventory.hide -= 3;
					Inventory.ivory -= 2;
					Inventory.oakwood -= 5;
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
		renderer.drawImageTile(Weapon.icon, 35, 160, compositeBow.xTile, compositeBow.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(compositeBow.name, 75, 170, 0xff685245);

		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(CraftItems.icon, 162, 167, hide.xTile, hide.yTile);
		renderer.drawText("5", 185, 171, 0xff886622);
		if(Inventory.hide >= 5) { renderer.drawText("(" + Inventory.hide + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.hide + ")", 192, 171, 0xff774422); }
	
		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 237, 167, ivory.xTile, ivory.yTile);
		renderer.drawText("1", 260, 171, 0xff886622);
		if(Inventory.ivory >= 1) { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 312, 167, oakWood.xTile, oakWood.yTile);
		renderer.drawText("8", 335, 171, 0xff886622);
		if(Inventory.oakwood >= 8) { renderer.drawText("(" + Inventory.oakwood + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.oakwood + ")", 342, 171, 0xff774422); }
	
	renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
		renderer.drawImageTile(Weapon.icon, 35, 205, handBow.xTile, handBow.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(handBow.name, 75, 215, 0xff685245);
		
		renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 162, 212, hide.xTile, hide.yTile);
		renderer.drawText("3", 185, 216, 0xff886622);
		if(Inventory.hide >= 3) { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 237, 212, ivory.xTile, ivory.yTile);
		renderer.drawText("2", 260, 216, 0xff886622);
		if(Inventory.ivory >= 2) { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 312, 212, oakWood.xTile, oakWood.yTile);
		renderer.drawText("5", 335, 216, 0xff886622);
		if(Inventory.oakwood >= 5) { renderer.drawText("(" + Inventory.oakwood + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.oakwood + ")", 342, 216, 0xff774422); }
		
		
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
