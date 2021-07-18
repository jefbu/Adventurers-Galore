package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.LuckyClover;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Katar;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerTier4 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Katar katar;
	private Iron iron;
	private EvilSpirit evilSpirit;
	private LuckyClover luckyClover;
	
	private int hoverOption;
	
	public DaggerTier4() {
		
		katar = new Katar();
		iron = new Iron();
		evilSpirit = new EvilSpirit();
		luckyClover = new LuckyClover();
	
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.evilSpirit >= 1 && Inventory.luckyClover >= 1) { 
					Inventory.weapons.add(new Katar());
					Inventory.iron -= 5;
					Inventory.evilSpirit -= 1;
					Inventory.luckyClover -= 1;
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
			renderer.drawImageTile(Weapon.icon, 35, 160, katar.xTile, katar.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(katar.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(CraftItems.icon, 162, 167, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 171, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 167, evilSpirit.xTile, evilSpirit.yTile);
			renderer.drawText("1", 260, 171, 0xff886622);
			if(Inventory.evilSpirit >= 1) { renderer.drawText("(" + Inventory.evilSpirit + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.evilSpirit + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 167, luckyClover.xTile, luckyClover.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.luckyClover >= 1) { renderer.drawText("(" + Inventory.luckyClover + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.luckyClover + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 5 && Inventory.evilSpirit >= 1 && Inventory.luckyClover >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		
		}
			
	}

}
