package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.armour.Gambeson;
import com.redhaan.adventurersGalore.entity.item.armour.Gothic;
import com.redhaan.adventurersGalore.entity.item.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.item.armour.Scale;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourTier3 extends GameObject {
	
	
	private static final long serialVersionUID = 1L;

	private Gambeson gambeson;
	private ReinforcedLeather reinforcedLeather;
	private Scale scale;
	private Gothic gothic;
	
	private Hide hide;
	private Pelt pelt;
	private Ivory ivory;
	private HeartSpirit heartSpirit;
	private ViolentSpirit violentSpirit;
	private SpiritOfMischief spiritOfMischief;
	private Coral coral;
	private Silver silver;
	private Iron iron;
	
	private int hoverOption;

	public ArmourTier3() {
		
		gambeson = new Gambeson();
		reinforcedLeather = new ReinforcedLeather();
		scale = new Scale();
		gothic = new Gothic();
		hide = new Hide();
		pelt = new Pelt();
		ivory = new Ivory();
		coral = new Coral();
		silver = new Silver();
		iron = new Iron();
		heartSpirit = new HeartSpirit();
		violentSpirit = new ViolentSpirit();
		spiritOfMischief = new SpiritOfMischief();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.pelt >= 8 && Inventory.ivory >= 5 && Inventory.heartSpirit >= 1) { 
					Inventory.armours.add(new Gambeson());
					Inventory.pelt -= 8;
					Inventory.ivory -= 5;
					Inventory.heartSpirit -= 1;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 8 && Inventory.ivory >= 5 && Inventory.violentSpirit >= 1) { 
					Inventory.armours.add(new ReinforcedLeather());
					Inventory.hide -= 8;
					Inventory.ivory -= 5;
					Inventory.violentSpirit -= 1;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 245 && gameContainer.getInput().getMouseY() < 285) {
			
			hoverOption = 3;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.coral >= 5 && Inventory.spiritOfMischief>= 1) { 
					Inventory.armours.add(new Scale());
					Inventory.iron -= 5;
					Inventory.coral -= 5;
					Inventory.spiritOfMischief -= 1;
					ScrappingScreen.initialised = false;
					SharpeningScreen.initialised = false;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 290 && gameContainer.getInput().getMouseY() < 330) {
			
			hoverOption = 4;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 3 && Inventory.silver >= 5 && Inventory.heartSpirit >= 1) { 
					Inventory.armours.add(new Gothic());
					Inventory.iron -= 3;
					Inventory.silver -= 5;
					Inventory.heartSpirit -= 1;
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
			renderer.drawImageTile(Armour.icon, 35, 160, gambeson.xTile, gambeson.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(gambeson.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(CraftItems.icon, 162, 167, pelt.xTile, pelt.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.pelt >= 8) { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 167, ivory.xTile, ivory.yTile);
			renderer.drawText("5", 260, 171, 0xff886622);
			if(Inventory.ivory >= 5) { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 167, heartSpirit.xTile, heartSpirit.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.heartSpirit >= 1) { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(Armour.icon, 35, 205, reinforcedLeather.xTile, reinforcedLeather.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(reinforcedLeather.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 162, 212, hide.xTile, hide.yTile);
			renderer.drawText("8", 185, 216, 0xff886622);
			if(Inventory.hide >= 8) { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 212, ivory.xTile, ivory.yTile);
			renderer.drawText("5", 260, 216, 0xff886622);
			if(Inventory.ivory >= 5) { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 267, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 212, violentSpirit.xTile, violentSpirit.yTile);
			renderer.drawText("1", 335, 216, 0xff886622);
			if(Inventory.violentSpirit >= 1) { renderer.drawText("(" + Inventory.violentSpirit + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.violentSpirit + ")", 342, 216, 0xff774422); }	
			
		renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
			renderer.drawImageTile(Armour.icon, 35, 250, scale.xTile, scale.yTile);
			renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
			renderer.drawText(scale.name, 75, 260, 0xff685245);
			
			renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 162, 257, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 261, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 257, coral.xTile, coral.yTile);
			renderer.drawText("5", 260, 261, 0xff886622);
			if(Inventory.coral >= 5) { renderer.drawText("(" + Inventory.coral + ")", 267, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.coral + ")", 267, 261, 0xff774422); }
			
			renderer.drawRectOpaque(305, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 257, spiritOfMischief.xTile, spiritOfMischief.yTile);
			renderer.drawText("1", 335, 261, 0xff886622);
			if(Inventory.spiritOfMischief >= 1) { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 342, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 342, 261, 0xff774422); }
			
		renderer.drawRectOpaque(30, 290, 570, 40, 0xff181205);
			renderer.drawImageTile(Armour.icon, 35, 295, gothic.xTile, gothic.yTile);
			renderer.drawRectOpaque(70, 295, 80, 30, 0xff231911);
			renderer.drawText(gothic.name, 75, 305, 0xff685245);
			
			renderer.drawRectOpaque(155, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 162, 302, iron.xTile, iron.yTile);
			renderer.drawText("3", 185, 306, 0xff886622);
			if(Inventory.iron >= 3) { renderer.drawText("(" + Inventory.iron + ")", 192, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 306, 0xff774422); }
	
			renderer.drawRectOpaque(230, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 237, 302, silver.xTile, silver.yTile);
			renderer.drawText("5", 260, 306, 0xff886622);
			if(Inventory.silver >= 5) { renderer.drawText("(" + Inventory.silver + ")", 267, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.silver + ")", 267, 306, 0xff774422); }
			
			renderer.drawRectOpaque(305, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(CraftItems.icon, 312, 302, heartSpirit.xTile, heartSpirit.yTile);
			renderer.drawText("1", 335, 306, 0xff886622);
			if(Inventory.heartSpirit >= 1) { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.heartSpirit + ")", 342, 306, 0xff774422); }
			
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.pelt >= 8 && Inventory.ivory >= 5 && Inventory.heartSpirit >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.hide >= 8 && Inventory.ivory >= 5 && Inventory.violentSpirit >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;		
		case 3:
			if (Inventory.iron >= 5 && Inventory.coral >= 5 && Inventory.spiritOfMischief >= 1) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
			break;	
		case 4:
			if (Inventory.iron >= 3 && Inventory.silver >= 5 && Inventory.heartSpirit >= 1) { renderer.drawRect(30, 290, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 290, 570, 40, 0xffBB6622); }
			break;	
		
		}
			
	}
	

}
