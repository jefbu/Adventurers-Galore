package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.swordSubscreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Tusk;
import com.redhaan.adventurersGalore.entity.item.items.Wing;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BastardSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Sabre;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Tier2 extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private BastardSword bastardSword;
	private Sabre sabre;
	private Iron iron;
	private Claw claw;
	private Tusk tusk;
	private Wing wing;
	
	private int hoverOption;

	public Tier2() {
		
		bastardSword = new BastardSword();
		sabre = new Sabre();
		iron = new Iron();
		claw = new Claw();
		tusk = new Tusk();
		wing = new Wing();
		
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
		renderer.drawImageTile(bastardSword.icon, 35, 160, bastardSword.xTile, bastardSword.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(bastardSword.name, 75, 170, 0xff685245);
	
		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(iron.icon, 162, 167, iron.xTile, iron.yTile);
		renderer.drawText("3", 185, 171, 0xff886622);
		if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 171, 0xff774422); }
		
		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(claw.icon, 237, 167, claw.xTile, claw.yTile);
		renderer.drawText("5", 260, 171, 0xff886622);
		if(Inventory.claw >= 5) { renderer.drawText("(" + Inventory.claw + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.claw + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(tusk.icon, 312, 167, tusk.xTile, tusk.yTile);
		renderer.drawText("3", 335, 171, 0xff886622);
		if(Inventory.tusk >= 3) { renderer.drawText("(" + Inventory.tusk + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.tusk + ")", 342, 171, 0xff774422); }
	
	renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
		renderer.drawImageTile(sabre.icon, 35, 205, sabre.xTile, sabre.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(sabre.name, 75, 215, 0xff685245);
		
		renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(iron.icon, 162, 212, iron.xTile, iron.yTile);
		renderer.drawText("5", 185, 216, 0xff886622);
		if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.iron + ")", 192, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(claw.icon, 237, 212, claw.xTile, claw.yTile);
		renderer.drawText("3", 260, 216, 0xff886622);
		if(Inventory.claw >= 3) { renderer.drawText("(" + Inventory.claw + ")", 267, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.claw + ")", 267, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(wing.icon, 312, 212, wing.xTile, wing.yTile);
		renderer.drawText("1", 335, 216, 0xff886622);
		if(Inventory.wing >= 1) { renderer.drawText("(" + Inventory.wing + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.wing + ")", 342, 216, 0xff774422); }
		
		
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.claw >= 5 && Inventory.tusk >= 3) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.iron >= 5 && Inventory.claw >= 3 && Inventory.wing >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;			
		
		}
		
	}

}
