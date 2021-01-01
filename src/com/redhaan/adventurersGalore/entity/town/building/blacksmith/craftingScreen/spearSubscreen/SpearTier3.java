package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.spearSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Lance;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Pike;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Trident;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Yari;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SpearTier3 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Yari yari;
	private Trident trident;
	
	private Iron iron;
	private Silver silver;
	private EvilSpirit evilSpirit;
	private Gold gold;
	private HeartSpirit heartSpirit;
	
	private int hoverOption;

	public SpearTier3() {
		
		yari = new Yari();
		trident = new Trident();
		
		iron = new Iron();
		silver = new Silver();
		evilSpirit = new EvilSpirit();
		gold = new Gold();
		heartSpirit = new HeartSpirit();
		
		hoverOption = 0;
		
	}
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.silver >= 1 && Inventory.evilSpirit >= 1) { 
					Inventory.weapons.add(new Yari());
					Inventory.iron -= 5;
					Inventory.silver -= 1;
					Inventory.evilSpirit -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.gold >= 2 && Inventory.heartSpirit >= 1) { 
					Inventory.weapons.add(new Trident());
					Inventory.iron -= 3;
					Inventory.gold -= 2;
					Inventory.heartSpirit -= 1;
				}
			}
			
		}
		
		else { hoverOption = 0; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
		renderer.drawImageTile(yari.icon, 35, 160, yari.xTile, yari.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(yari.name, 75, 170, 0xff685245);

		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
		renderer.drawText("5", 185, 171, 0xff886622);
		if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }

		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(silver.icon, 237, 167, silver.xTile, silver.yTile);
		renderer.drawText("1", 260, 171, 0xff886622);
		if(Inventory.silver >= 1) { renderer.drawText("(" + Inventory.silver + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.silver + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(evilSpirit.icon, 312, 167, evilSpirit.xTile, evilSpirit.yTile);
		renderer.drawText("1", 335, 171, 0xff886622);
		if(Inventory.evilSpirit >= 1) { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 171, 0xff774422); }
	
	renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
		renderer.drawImageTile(trident.icon, 35, 205, trident.xTile, trident.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(trident.name, 75, 215, 0xff685245);
		
		renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(iron.icon, 162, 212, iron.xTile, iron.yTile);
		renderer.drawText("3", 185, 216, 0xff886622);
		if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(gold.icon, 237, 212, gold.xTile, gold.yTile);
		renderer.drawText("2", 260, 216, 0xff886622);
		if(Inventory.gold >= 2) { renderer.drawText("(" + Inventory.gold + ")", 267, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.gold + ")", 267, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(heartSpirit.icon, 312, 212, heartSpirit.xTile, heartSpirit.yTile);
		renderer.drawText("1", 335, 216, 0xff886622);
		if(Inventory.heartSpirit >= 1) { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 216, 0xff774422); }
		
		
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
