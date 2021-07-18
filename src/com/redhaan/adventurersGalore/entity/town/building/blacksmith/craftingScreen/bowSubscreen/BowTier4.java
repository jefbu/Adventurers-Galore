package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.bowSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.ElysianFlower;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.LongBow;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BowTier4 extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LongBow longBow;
	
	private Ivory ivory;
	private SpiritOfMischief spiritOfMischief;
	private ElysianFlower elysianFlower;
	
	private int hoverOption;

	public BowTier4() {
		
		longBow = new LongBow();
		ivory = new Ivory();
		spiritOfMischief = new SpiritOfMischief();
		elysianFlower = new ElysianFlower();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.ivory >= 5 && Inventory.spiritOfMischief >= 1 && Inventory.elysianFlower >= 1) { 
					Inventory.weapons.add(new LongBow());
					Inventory.ivory -= 5;
					Inventory.spiritOfMischief -= 1;
					Inventory.elysianFlower -= 1;
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
		renderer.drawImageTile(Weapon.icon, 35, 160, longBow.xTile, longBow.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(longBow.name, 75, 170, 0xff685245);
	
		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(CraftItems.icon, 162, 167, ivory.xTile, ivory.yTile);
		renderer.drawText("5", 185, 171, 0xff886622);
		if(Inventory.ivory >= 5) { renderer.drawText("(" + Inventory.ivory + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.ivory + ")", 192, 171, 0xff774422); }
	
		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 237, 167, spiritOfMischief.xTile, spiritOfMischief.yTile);
		renderer.drawText("1", 260, 171, 0xff886622);
		if(Inventory.spiritOfMischief >= 1) { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 267, 171, 0xff774422); }
	
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(CraftItems.icon, 312, 167, elysianFlower.xTile, elysianFlower.yTile);
		renderer.drawText("1", 335, 171, 0xff886622);
		if(Inventory.elysianFlower >= 1) { renderer.drawText("(" + Inventory.elysianFlower + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.elysianFlower + ")", 342, 171, 0xff774422); }
		
		
	switch(hoverOption) {
	
	case 0: break;
	case 1:
		if (Inventory.ivory >= 5 && Inventory.spiritOfMischief >= 1 && Inventory.elysianFlower >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
		else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
		break;		
	
	}		
	}

}
