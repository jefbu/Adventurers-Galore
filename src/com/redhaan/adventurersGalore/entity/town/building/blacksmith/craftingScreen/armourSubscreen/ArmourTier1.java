package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.Chain;
import com.redhaan.adventurersGalore.entity.item.armour.Coat;
import com.redhaan.adventurersGalore.entity.item.armour.Cuirass;
import com.redhaan.adventurersGalore.entity.item.armour.Leather;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourTier1 extends GameObject {
	
	
	private static final long serialVersionUID = 1L;
	
	private Coat coat;
	private Leather leather;
	private Chain chain;
	private Cuirass cuirass;
	
	private Pelt pelt;
	private Hide hide;
	private Iron iron;
	private Silver silver;
	private Ivory ivory;
	
	private int hoverOption;

	public ArmourTier1() {
		
		coat = new Coat();
		leather = new Leather();
		chain = new Chain();
		cuirass = new Cuirass();
		
		pelt = new Pelt();
		hide = new Hide();
		iron = new Iron();
		silver = new Silver();
		ivory = new Ivory();
		
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
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 245 && gameContainer.getInput().getMouseY() < 285) {
			
			hoverOption = 3;
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 290 && gameContainer.getInput().getMouseY() < 330) {
			
			hoverOption = 4;
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(coat.icon, 35, 160, coat.xTile, coat.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(coat.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(pelt.icon, 162, 167, pelt.xTile, pelt.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.pelt >= 8) { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(ivory.icon, 237, 167, ivory.xTile, ivory.yTile);
			renderer.drawText("3", 260, 171, 0xff886622);
			if(Inventory.ivory >= 3) { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(leather.icon, 35, 205, leather.xTile, leather.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(leather.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(hide.icon, 162, 212, hide.xTile, hide.yTile);
			renderer.drawText("8", 185, 216, 0xff886622);
			if(Inventory.hide >= 8) { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(ivory.icon, 237, 212, ivory.xTile, ivory.yTile);
			renderer.drawText("3", 260, 216, 0xff886622);
			if(Inventory.ivory >= 3) { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff774422); }	
			
		renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
			renderer.drawImageTile(chain.icon, 35, 250, chain.xTile, chain.yTile);
			renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
			renderer.drawText(chain.name, 75, 260, 0xff685245);
			
			renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 257, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 261, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff774422); }	
			
		renderer.drawRectOpaque(30, 290, 570, 40, 0xff181205);
			renderer.drawImageTile(cuirass.icon, 35, 295, cuirass.xTile, cuirass.yTile);
			renderer.drawRectOpaque(70, 295, 80, 30, 0xff231911);
			renderer.drawText(cuirass.name, 75, 305, 0xff685245);
			
			renderer.drawRectOpaque(155, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 302, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 306, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 306, 0xff774422); }
	
			renderer.drawRectOpaque(230, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(silver.icon, 237, 302, silver.xTile, silver.yTile);
			renderer.drawText("3", 260, 306, 0xff886622);
			if(Inventory.silver >= 3) { renderer.drawText("(" + Inventory.silver + ")", 267, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.silver + ")", 267, 306, 0xff774422); }
			
			
			
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
		case 3:
			if (Inventory.iron >= 2 && Inventory.claw >= 5 && Inventory.fang >= 5) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
			break;	
		case 4:
			if (Inventory.iron >= 2 && Inventory.claw >= 5 && Inventory.fang >= 5) { renderer.drawRect(30, 290, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 290, 570, 40, 0xffBB6622); }
			break;	
		
		}
			
	}
	

}
