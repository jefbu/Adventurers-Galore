package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.swordSubscreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Foil;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Katana;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Scimitar;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Tier3 extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private Scimitar scimitar;
	private Katana katana;
	private Foil foil;
	private Iron iron;
	private ViolentSpirit violentSpirit;
	private Gold gold;
	private EvilSpirit evilSpirit;
	private Silver silver;
	private HeartSpirit heartSpirit;
	
	private int hoverOption;
	

	public Tier3() {
		
		scimitar = new Scimitar();
		katana = new Katana();
		foil = new Foil();
		iron = new Iron();
		violentSpirit = new ViolentSpirit();
		gold = new Gold();
		evilSpirit = new EvilSpirit();
		silver = new Silver();
		heartSpirit = new HeartSpirit();
		
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
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
		renderer.drawImageTile(scimitar.icon, 35, 160, scimitar.xTile, scimitar.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(scimitar.name, 75, 170, 0xff685245);
	
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
		renderer.drawImageTile(katana.icon, 35, 205, katana.xTile, katana.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(katana.name, 75, 215, 0xff685245);
		
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
		renderer.drawImageTile(evilSpirit.icon, 312, 212, evilSpirit.xTile, evilSpirit.yTile);
		renderer.drawText("1", 335, 216, 0xff886622);
		if(Inventory.evilSpirit >= 1) { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.evilSpirit + ")", 342, 216, 0xff774422); }

	renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
		renderer.drawImageTile(foil.icon, 35, 250, foil.xTile, foil.yTile);
		renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
		renderer.drawText(foil.name, 75, 260, 0xff685245);
		
		renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(iron.icon, 162, 257, iron.xTile, iron.yTile);
		renderer.drawText("3", 185, 261, 0xff886622);
		if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(silver.icon, 237, 257, silver.xTile, silver.yTile);
		renderer.drawText("2", 260, 261, 0xff886622);
		if(Inventory.silver >= 2) { renderer.drawText("(" + Inventory.silver + ")", 267, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.silver + ")", 267, 261, 0xff774422); }
		
		renderer.drawRectOpaque(305, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(heartSpirit.icon, 312, 257, heartSpirit.xTile, heartSpirit.yTile);
		renderer.drawText("1", 335, 261, 0xff886622);
		if(Inventory.heartSpirit >= 1) { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 261, 0xff774422); }
		
		
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 5 && Inventory.violentSpirit >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.iron >= 3 && Inventory.gold >= 2 && Inventory.evilSpirit >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;	
		case 3:
			if (Inventory.iron >= 3 && Inventory.silver >= 2 && Inventory.heartSpirit >= 1) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
		
		}
		
	}

}
