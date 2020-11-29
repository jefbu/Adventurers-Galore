package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.BoiledLeather;
import com.redhaan.adventurersGalore.entity.item.armour.Plate;
import com.redhaan.adventurersGalore.entity.item.armour.Quilt;
import com.redhaan.adventurersGalore.entity.item.armour.Riveted;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourTier2 extends GameObject {

	private static final long serialVersionUID = 1L;

	private Quilt quilt;
	private BoiledLeather boiledLeather;
	private Riveted riveted;
	private Plate plate;
	
	private Hide hide;
	private Pelt pelt;
	private Ivory ivory;
	private Bone bone;
	private Coral coral;
	private Silver silver;
	private Antlers antlers;
	private Iron iron;
	
	private int hoverOption;

	public ArmourTier2() {
		
		quilt = new Quilt();
		boiledLeather = new BoiledLeather();
		riveted = new Riveted();
		plate = new Plate();
		hide = new Hide();
		pelt = new Pelt();
		ivory = new Ivory();
		bone = new Bone();
		coral = new Coral();
		silver = new Silver();
		antlers = new Antlers();
		iron = new Iron();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.pelt >= 8 && Inventory.ivory >= 3 && Inventory.bone >= 1) { 
					Inventory.armours.add(new Quilt());
					Inventory.pelt -= 8;
					Inventory.ivory -= 3;
					Inventory.bone -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 8 && Inventory.ivory >= 3 && Inventory.coral >= 1) { 
					Inventory.armours.add(new BoiledLeather());
					Inventory.hide -= 8;
					Inventory.ivory -= 3;
					Inventory.coral -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 245 && gameContainer.getInput().getMouseY() < 285) {
			
			hoverOption = 3;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.coral >= 3) { 
					Inventory.armours.add(new Riveted());
					Inventory.iron -= 5;
					Inventory.coral -= 3;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 290 && gameContainer.getInput().getMouseY() < 330) {
			
			hoverOption = 4;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.silver >= 3 && Inventory.antlers >= 5) { 
					Inventory.armours.add(new Quilt());
					Inventory.iron -= 3;
					Inventory.silver -= 3;
					Inventory.antlers -= 5;
				}
			}
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(quilt.icon, 35, 160, quilt.xTile, quilt.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(quilt.name, 75, 170, 0xff685245);
	
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
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(bone.icon, 312, 167, bone.xTile, bone.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.bone >= 1) { renderer.drawText("(" + Inventory.bone + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.bone + ")", 342, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(boiledLeather.icon, 35, 205, boiledLeather.xTile, boiledLeather.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(boiledLeather.name, 75, 215, 0xff685245);
			
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
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(coral.icon, 312, 212, coral.xTile, coral.yTile);
			renderer.drawText("1", 335, 216, 0xff886622);
			if(Inventory.coral >= 1) { renderer.drawText("(" + Inventory.coral + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.coral + ")", 342, 216, 0xff774422); }	
			
		renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
			renderer.drawImageTile(riveted.icon, 35, 250, riveted.xTile, riveted.yTile);
			renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
			renderer.drawText(riveted.name, 75, 260, 0xff685245);
			
			renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 257, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 261, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(coral.icon, 237, 257, coral.xTile, coral.yTile);
			renderer.drawText("3", 260, 261, 0xff886622);
			if(Inventory.coral >= 3) { renderer.drawText("(" + Inventory.coral + ")", 267, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.coral + ")", 267, 261, 0xff774422); }
			
		renderer.drawRectOpaque(30, 290, 570, 40, 0xff181205);
			renderer.drawImageTile(plate.icon, 35, 295, plate.xTile, plate.yTile);
			renderer.drawRectOpaque(70, 295, 80, 30, 0xff231911);
			renderer.drawText(plate.name, 75, 305, 0xff685245);
			
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
			
			renderer.drawRectOpaque(305, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(antlers.icon, 312, 302, antlers.xTile, antlers.yTile);
			renderer.drawText("5", 335, 306, 0xff886622);
			if(Inventory.antlers >= 5) { renderer.drawText("(" + Inventory.antlers + ")", 342, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.antlers + ")", 342, 306, 0xff774422); }
			
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.pelt >= 8 && Inventory.ivory >= 3 && Inventory.bone >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.hide >= 8 && Inventory.ivory >= 3 && Inventory.coral >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;		
		case 3:
			if (Inventory.iron >= 5 && Inventory.coral >= 3) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
			break;	
		case 4:
			if (Inventory.iron >= 3 && Inventory.silver >= 3 && Inventory.antlers >= 5) { renderer.drawRect(30, 290, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 290, 570, 40, 0xffBB6622); }
			break;	
		
		}
			
	}

}
