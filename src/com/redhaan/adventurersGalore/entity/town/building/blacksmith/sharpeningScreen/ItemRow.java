package com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen.ScrappingScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ItemRow extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Item item;
	private int orderNumber;
	private int percentage;
	
	private boolean hovering;

	public ItemRow(Item item, int orderNumber) {
		
		this.item = item;
		this.orderNumber = orderNumber;
		percentage = calculatePercentage();
		
		hovering = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 40 && gameContainer.getInput().getMouseX() < 590 &&
				gameContainer.getInput().getMouseY() > 155 + orderNumber * 40 && gameContainer.getInput().getMouseY() < 190 + orderNumber * 40) {
					
			hovering = true;
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { sharpen(); }
			
		} else { hovering = false; }
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if (item.ID == ItemID.Armour) {
			
			if (hovering) { renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff263417); }
			else { renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff121621); }

			renderer.drawRectOpaque(45, 157 + orderNumber * 40, 35, 32, 0xff685245);
				renderer.drawImageTile(Armour.icon, 46, 157 + orderNumber * 40, item.xTile, item.yTile);
			renderer.drawRectOpaque(85, 157 + orderNumber * 40, 90, 32, 0xff685245);
				renderer.drawText(item.name, 90, 167 + orderNumber * 40, 0xff231911);		
			renderer.drawRectOpaque(180, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.defence, 193, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(215, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.weight, 227, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(250, 157 + orderNumber * 40, 30, 32, 0xff685245);
			renderer.drawRectOpaque(285, 157 + orderNumber * 40, 30, 32, 0xff685245);
			
			renderer.drawRectOpaque(320, 157 + orderNumber * 40, 80, 32, 0xff685245);
				renderer.drawText("Success: " + percentage + "%", 325, 167 + orderNumber * 40, 0xff231911);
			
		}
		
		else {
			
			if (hovering) { renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff263417); }
			else { renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff121621); }
			
			renderer.drawRectOpaque(45, 157 + orderNumber * 40, 35, 32, 0xff685245);
				renderer.drawImageTile(Weapon.icon, 46, 157 + orderNumber * 40, item.xTile, item.yTile);
			
			renderer.drawRectOpaque(85, 157 + orderNumber * 40, 90, 32, 0xff685245);
				renderer.drawText(item.name, 90, 167 + orderNumber * 40, 0xff231911);		
			renderer.drawRectOpaque(180, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.damage, 193, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(215, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.hit, 225, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(250, 157 + orderNumber * 40, 30, 32, 0xff685245);
				renderer.drawText("" + item.crit, 260, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(285, 157 + orderNumber * 40, 30, 32, 0xff685245);	
				renderer.drawText("" + item.weight, 295, 167 + orderNumber * 40, 0xff231911);
			
			renderer.drawRectOpaque(320, 157 + orderNumber * 40, 30, 32, 0xff685245);	
			renderer.drawRectOpaque(355, 157 + orderNumber * 40, 30, 32, 0xff685245);
			
			renderer.drawRectOpaque(390, 157 + orderNumber * 40, 80, 32, 0xff685245);
			renderer.drawText("Success: " + percentage + "%", 395, 167 + orderNumber * 40, 0xff231911);
			
		}
		
	}
	
	
	private int calculatePercentage() {
		
		int tier = 0;
		int percentage = 0;
		
		switch (item.name) {
		
		case "Iron Sword": tier = 1; break;
		case "Broadsword": tier = 1; break;
		case "Bastard Sword": tier = 2; break;
		case "Sabre": tier = 2; break;
		case "Scimitar": tier = 3; break;
		case "Katana": tier = 3; break;
		case "Foil": tier = 3; break;
		case "Silver Sword": tier = 4; break;
		case "Epee": tier = 4; break;
		case "Falchion": tier = 4; break;
		case "Excalibur": tier = 5; break;
		case "Vorpal": tier = 5; break;
		
		case "Dagger": tier = 1; break;
		case "Knife": tier = 1; break;
		case "Dirk": tier = 2; break;
		case "Machete": tier = 3; break;
		case "Cinqueada": tier = 3; break;
		case "Katar": tier = 4; break;
		case "Misericordia": tier = 5; break;
			
		case "Quarterstaff": tier = 1; break;
		case "Bo": tier = 2; break;
		case "Baton": tier = 2; break;
		case "Cudgel": tier = 3; break;
		case "Waddy": tier = 4; break;
		case "Double Lily": tier = 5; break;
		
		case "Spear": tier = 1; break;
		case "Lance": tier = 2; break;
		case "Pike": tier = 2; break;
		case "Yari": tier = 3; break;
		case "Trident": tier = 3; break;
		case "Naginata": tier = 4; break;
		case "Gae Bolg": tier = 5; break;
		case "Longinus": tier = 5; break;
		case "Gungnir": tier = 5; break;
		
		case "Short Bow": tier = 1; break;
		case "Composite": tier = 2; break;
		case "Hand Bow": tier = 2; break;
		case "Recurve": tier = 3; break;
		case "LongBow": tier = 4; break;
		case "Yoichi": tier = 5; break;
		
		case "Coat": tier = 1; break;
		case "Leather": tier = 1; break;
		case "Chain": tier = 1; break;
		case "Cuirass": tier = 1; break;
		case "Quilt": tier = 2; break;
		case "Boiled Leather": tier = 2; break;
		case "Riveted": tier = 2; break;
		case "Plate": tier = 2; break;
		case "Gambeson": tier = 3; break;
		case "Reinforced Leather": tier = 3; break;
		case "Scale": tier = 3; break;
		case "Gothic": tier = 3; break;
		case "Brigandine": tier = 4; break;
		case "Lamellar": tier = 4; break;
		case "Hauberk": tier = 4; break;
		case "Jousting": tier = 4; break;
		
		default: System.out.println("error at weapon names in item row at sharpening screen");
		
		}
		
		switch(tier) {
		
		case 1: percentage = 30; break;
		case 2: percentage = 25; break;
		case 3: percentage = 20; break;
		case 4: percentage = 15; break;
		case 5: percentage = 10; break;
		
		}
		
		switch(item.upgrades) {
		
		case 0: percentage += 60; break;
		case 1: percentage += 45; break;
		case 2: percentage += 30; break;
		case 3: percentage += 20; break;
		case 4: percentage += 10; break;
		
		}		
		
		return percentage;
		
	}
	
	
	private void sharpen() {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		if (roll < percentage) {
			item.upgrade();		
			item.upgrades++;
			Toast.activate(true, "Upgrade Successful!", 270, 140);
		}
		
		else {
			if (item.ID == ItemID.Armour) { 
				for (int i = 0; i < Inventory.armours.size(); i++) {
					if (Inventory.armours.get(i) == item) { Inventory.armours.remove(i); }
				}
			}
			else {
				for (int ii = 0; ii < Inventory.weapons.size(); ii++) {
					if (Inventory.weapons.get(ii) == item) { Inventory.weapons.remove(ii); }
				}
			}
			Toast.activate(false, "Item ruined by your hybris!", 270, 140);
		}
		
		SharpeningScreen.initialised = false;
		ScrappingScreen.initialised = false;
		
		
	}
	
	
	
	
	
	
	
	
}
