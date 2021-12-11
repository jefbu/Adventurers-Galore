package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WeaponRow extends GameObject {

	private static final long serialVersionUID = 1L;
	private int number;
	private Weapon weapon;
	private ImageTile icon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	
	private int detailColour, deleteColour;
	
	private boolean lineHover;
	private boolean dustbinHover;

	public WeaponRow(Weapon weapon, int number) {
		
		this.number = number;
		this.weapon = weapon;
		
		detailColour = 0xff354223;
		deleteColour = 0xffF2BFAB;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 535 && gameContainer.getInput().getMouseX() < 577) {
			if (gameContainer.getInput().getMouseY() > 48 + 45 * number && gameContainer.getInput().getMouseY() < 48 + 45 * number + 38) {
				dustbinHover = true;
				
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					if (weapon != GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon) {
						Inventory.weapons.remove(weapon);
						InventoryScreen.weaponWidget.updated = false;
					}
				}
			}		
			else { dustbinHover = false; }			
		} else { dustbinHover = false; }
		
		if (gameContainer.getInput().getMouseX() > 19 && gameContainer.getInput().getMouseX() < 621) {
			if (gameContainer.getInput().getMouseY() > 48 + 45 * number && gameContainer.getInput().getMouseY() < 48 + 45 * number + 38) {
				lineHover = true;
				
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1) && !dustbinHover) {
					if (weapon != GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon) {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.calculateAffinites(GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon, weapon);
						Inventory.weapons.remove(weapon);
						Inventory.weapons.add(GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon);
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon = weapon;
						InventoryScreen.closeScreen(GameState.PartyScreen);
					}
				}
				
			} else { lineHover = false; }
		} else { lineHover = false; }
		

		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		int colour;
		if (lineHover) { colour = detailColour; } else { colour = InventoryScreen.passiveColour; }
		
		renderer.drawRectOpaque(20, 45 + 45 * number, 600, 38, colour);
		
		if(Inventory.weaponChange) { renderer.drawRect(19, 44, 602, 40, 0xffDDBB66); }
		
		renderer.drawRectOpaque(25, 48 + 45 * number, 36, 32, InventoryScreen.highlightColour);
			renderer.drawImageTile(Weapon.icon, 27, 49 + 45 * number, weapon.xTile, weapon.yTile);
			
		renderer.drawRectOpaque(66, 48 + 45 * number, 70, 32, InventoryScreen.highlightColour);
			renderer.drawText(weapon.name, 75, 62 + 45 * number, InventoryScreen.passiveColour);
			
		renderer.drawRectOpaque(141, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
			renderer.drawText(Integer.toString(weapon.damage), 147, 62 + 45 * number, InventoryScreen.passiveColour);
	
		renderer.drawRectOpaque(166, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
			renderer.drawText(Integer.toString(weapon.hit), 170, 62 + 45 * number, InventoryScreen.passiveColour);	
			
		renderer.drawRectOpaque(191, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
			renderer.drawText(Integer.toString(weapon.crit), 195, 62 + 45 * number, InventoryScreen.passiveColour);
			
		renderer.drawRectOpaque(216, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
			renderer.drawText(Integer.toString(weapon.weight), 222, 62 + 45 * number, InventoryScreen.passiveColour);
		
		renderer.drawRectOpaque(241, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
			if (weapon.upgrades > 0) { renderer.drawImageTile(icon, 235, 49 + 45 * number, weapon.upgrades, 0);	}	
			
		renderer.drawRectOpaque(266, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);	
			if(weapon.gemStone != null) {
				renderer.drawImageTile(CraftItems.icon, 274, 63 + 45 * number, weapon.gemStone.xTile, weapon.gemStone.yTile);
			}
			
		renderer.drawRectOpaque(291, 48 + 45 * number, 70, 32, InventoryScreen.highlightColour);
			if(weapon.soul != null) { renderer.drawText(weapon.soul.race.name + "slayer", 299, 63 + 45 * number, InventoryScreen.passiveColour); }
			else { renderer.drawText("Soulless", 299, 63 + 45 * number, InventoryScreen.passiveColour); }
		
		renderer.drawRectOpaque(366, 48 + 45 * number, 60, 32, InventoryScreen.highlightColour);
			for (int i = 0; i < weapon.runeSlots; i++) {
				renderer.drawRectOpaque(370 + i * 19, 48 + 45 * number + 5, 15, 20, InventoryScreen.highlightColour);
			}
			
		renderer.drawRectOpaque(431, 48 + 45 * number, 100, 32, InventoryScreen.highlightColour);
		switch(weapon.type) {
		case SWORD: 
			renderer.drawText("Swords: " + translate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword.value), 436, 63 + 45 * number, InventoryScreen.passiveColour); 
			break;
		case STAFF: 
			renderer.drawText("Staves: " + translate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff.value), 436, 63 + 45 * number, InventoryScreen.passiveColour); 
			break;
		case DAGGER: 
			renderer.drawText("Daggers: " + translate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger.value), 436, 63 + 45 * number, InventoryScreen.passiveColour); 
			break;
		case SPEAR:
			renderer.drawText("Spears: " + translate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear.value), 436, 63 + 45 * number, InventoryScreen.passiveColour); 
			break;
		case BOW:
			renderer.drawText("Bows: " + translate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow.value), 436, 63 + 45 * number, InventoryScreen.passiveColour); 
			break;
		default: System.out.println("error at weaponRow");
		}
		
		renderer.drawRectOpaque(536, 48 + 45 * number, 32, 32, InventoryScreen.highlightColour);
		if(dustbinHover) { renderer.drawRect(536, 48 + 45 * number, 32, 32, deleteColour); }
		renderer.drawImageTile(icon, 536, 48 + 45 * number, 1, 2);
		
			
	}
	
	
	
	
	
	private String translate(int value) {
		
		switch(value) {
		
		case 0: return "Dummy";
		case 1: return "Basic";
		case 2: return "Intermediate";
		case 3: return "Advanced";
		case 4: return "Expert";
		case 5: return "Master";
		default: return "Error";
		
		}
		
	}
	
	

}
