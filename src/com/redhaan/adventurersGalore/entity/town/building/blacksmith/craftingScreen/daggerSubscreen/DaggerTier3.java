package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Machete;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerTier3 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Machete machete;
	private Cinqueada cinqueada;
	private Iron iron;
	private ViolentSpirit violentSpirit;
	private Fang fang;
	private EvilSpirit evilSpirit;
	
	private int hoverOption;
	
	public DaggerTier3() {
		
		machete = new Machete();
		cinqueada = new Cinqueada();
		iron = new Iron();
		violentSpirit = new ViolentSpirit();
		fang = new Fang();
		evilSpirit = new EvilSpirit();
	
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.violentSpirit >= 1) { 
					Inventory.weapons.add(new Machete());
					Inventory.iron -= 5;
					Inventory.violentSpirit -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.fang >= 8 && Inventory.evilSpirit >= 1) { 
					Inventory.weapons.add(new Cinqueada());
					Inventory.iron -= 3;
					Inventory.fang -= 8;
					Inventory.evilSpirit -= 1;
				}
			}
			
		}
		
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(machete.icon, 35, 160, machete.xTile, machete.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(machete.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 171, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(violentSpirit.icon, 237, 167, violentSpirit.xTile, violentSpirit.yTile);
			renderer.drawText("1", 260, 171, 0xff886622);
			if(Inventory.violentSpirit >= 1) { renderer.drawText("(" + Inventory.violentSpirit + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.violentSpirit + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(cinqueada.icon, 35, 205, cinqueada.xTile, cinqueada.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(cinqueada.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 212, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 216, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(fang.icon, 237, 212, fang.xTile, fang.yTile);
			renderer.drawText("8", 260, 216, 0xff886622);
			if(Inventory.fang >= 8) { renderer.drawText("(" + Inventory.fang + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.fang + ")", 267, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(evilSpirit.icon, 312, 212, evilSpirit.xTile, evilSpirit.yTile);
			renderer.drawText("1", 335, 216, 0xff886622);
			if(Inventory.evilSpirit >= 1) { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 216, 0xff774422); }	
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 5 && Inventory.violentSpirit >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.iron >= 3 && Inventory.fang >= 8 && Inventory.evilSpirit >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;
		
		}
			
	}

}
