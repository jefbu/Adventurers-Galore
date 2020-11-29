package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.swordSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.LiquidInnocence;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.items.ReforgedPlough;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.items.StolenMoonlight;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Epee;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Falchion;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.SilverSword;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Tier4 extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private SilverSword silverSword;
	private Epee epee;
	private Falchion falchion;
	private Silver silver;
	private NobleSpirit nobleSpirit;
	private LiquidInnocence liquidInnocence;
	private Coral coral;
	private HeartSpirit heartSpirit;
	private StolenMoonlight stolenMoonlight;
	private Gold gold;
	private SpiritOfMischief spiritOfMischief;
	private ReforgedPlough reforgedPlough;	
	
	private int hoverOption;
	
	public Tier4() {
		
		silverSword = new SilverSword();
		epee = new Epee();
		falchion = new Falchion();
		silver = new Silver();
		nobleSpirit = new NobleSpirit();
		liquidInnocence = new LiquidInnocence();
		coral = new Coral();
		heartSpirit = new HeartSpirit();
		stolenMoonlight = new StolenMoonlight();
		gold = new Gold();
		spiritOfMischief = new SpiritOfMischief();
		reforgedPlough = new ReforgedPlough();
		
		hoverOption = 0;
				
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.silver >= 5 && Inventory.nobleSpirit >= 1 && Inventory.liquidInnocence >= 1) { 
					Inventory.weapons.add(new SilverSword());
					Inventory.silver -= 5;
					Inventory.nobleSpirit -= 1;
					Inventory.liquidInnocence -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.coral >= 2 && Inventory.heartSpirit >= 1 && Inventory.stolenMoonlight >= 1) { 
					Inventory.weapons.add(new Epee());
					Inventory.coral -= 2;
					Inventory.heartSpirit -= 1;
					Inventory.stolenMoonlight -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 245 && gameContainer.getInput().getMouseY() < 285) {
			
			hoverOption = 3;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.gold >= 5 && Inventory.spiritOfMischief >= 1 && Inventory.reforgedPlough >= 1) { 
					Inventory.weapons.add(new Falchion());
					Inventory.gold -= 5;
					Inventory.spiritOfMischief -= 1;
					Inventory.reforgedPlough -= 1;
				}
			}
			
		}	
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
	renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
		renderer.drawImageTile(silverSword.icon, 35, 160, silverSword.xTile, silverSword.yTile);
		renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
		renderer.drawText(silverSword.name, 75, 170, 0xff685245);
	
		renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
		renderer.drawImageTile(silver.icon, 162, 167, silver.xTile, silver.yTile);
		renderer.drawText("5", 185, 171, 0xff886622);
		if(Inventory.silver >= 5) { renderer.drawText("(" + Inventory.silver + ")", 192, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.silver + ")", 192, 171, 0xff774422); }
		
		renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(nobleSpirit.icon, 237, 167, nobleSpirit.xTile, nobleSpirit.yTile);
		renderer.drawText("1", 260, 171, 0xff886622);
		if(Inventory.nobleSpirit >= 1) { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 171, 0xff774422); }
		
		renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
		renderer.drawImageTile(liquidInnocence.icon, 312, 167, liquidInnocence.xTile, liquidInnocence.yTile);
		renderer.drawText("1", 335, 171, 0xff886622);
		if(Inventory.liquidInnocence >= 1) { renderer.drawText("(" + Inventory.liquidInnocence + ")", 342, 171, 0xff447722); }
		else { renderer.drawText("(" + Inventory.liquidInnocence + ")", 342, 171, 0xff774422); }
	
	renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
		renderer.drawImageTile(epee.icon, 35, 205, epee.xTile, epee.yTile);
		renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
		renderer.drawText(epee.name, 75, 215, 0xff685245);
		
		renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(coral.icon, 162, 212, coral.xTile, coral.yTile);
		renderer.drawText("2", 185, 216, 0xff886622);
		if(Inventory.coral >= 2) { renderer.drawText("(" + Inventory.coral + ")", 192, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.coral + ")", 192, 216, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(heartSpirit.icon, 237, 212, heartSpirit.xTile, heartSpirit.yTile);
		renderer.drawText("1", 260, 216, 0xff886622);
		if(Inventory.heartSpirit >= 1) { renderer.drawText("(" + Inventory.heartSpirit + ")", 267, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.heartSpirit + ")", 267, 216, 0xff774422); }
		
		renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
		renderer.drawImageTile(stolenMoonlight.icon, 312, 212, stolenMoonlight.xTile, stolenMoonlight.yTile);
		renderer.drawText("1", 335, 216, 0xff886622);
		if(Inventory.stolenMoonlight >= 1) { renderer.drawText("(" + Inventory.stolenMoonlight + ")", 342, 216, 0xff447722); }
		else { renderer.drawText("(" + Inventory.stolenMoonlight + ")", 342, 216, 0xff774422); }

	renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
		renderer.drawImageTile(falchion.icon, 35, 250, falchion.xTile, falchion.yTile);
		renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
		renderer.drawText(falchion.name, 75, 260, 0xff685245);
		
		renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(gold.icon, 162, 257, gold.xTile, gold.yTile);
		renderer.drawText("5", 185, 261, 0xff886622);
		if(Inventory.gold >= 5) { renderer.drawText("(" + Inventory.gold + ")", 192, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.gold + ")", 192, 261, 0xff774422); }	
		
		renderer.drawRectOpaque(230, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(spiritOfMischief.icon, 237, 257, spiritOfMischief.xTile, spiritOfMischief.yTile);
		renderer.drawText("1", 260, 261, 0xff886622);
		if(Inventory.spiritOfMischief >= 1) { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 267, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 267, 261, 0xff774422); }
		
		renderer.drawRectOpaque(305, 250, 70, 30, 0xff231911);
		renderer.drawImageTile(reforgedPlough.icon, 312, 257, reforgedPlough.xTile, reforgedPlough.yTile);
		renderer.drawText("1", 335, 261, 0xff886622);
		if(Inventory.reforgedPlough >= 1) { renderer.drawText("(" + Inventory.reforgedPlough + ")", 342, 261, 0xff447722); }
		else { renderer.drawText("(" + Inventory.reforgedPlough + ")", 342, 261, 0xff774422); }
		
		
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.silver >= 5 && Inventory.nobleSpirit >= 1 && Inventory.liquidInnocence >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.coral >= 2 && Inventory.heartSpirit >= 1 && Inventory.stolenMoonlight >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;	
		case 3:
			if (Inventory.gold >= 5 && Inventory.spiritOfMischief >= 1 && Inventory.reforgedPlough >= 1) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
		
		}
		
	}

}
