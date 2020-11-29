package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourRow extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private int number;
	private Armour armour;
	
	private int detailColour;
	
	private boolean lineHover;
	private boolean dustbinHover;

	public ArmourRow(Armour armour, int number) {

		this.number = number;
		this.armour = armour;
		
		detailColour = 0xff354223;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 535 && gameContainer.getInput().getMouseX() < 577) {
			if (gameContainer.getInput().getMouseY() > 48 + 45 * number && gameContainer.getInput().getMouseY() < 48 + 45 * number + 38) {
				dustbinHover = true;
				
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					if (armour != GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour) {
						Inventory.armours.remove(armour);
						InventoryScreen.armourWidget.updated = false;
					}
				}
			}		
			else { dustbinHover = false; }			
		} else { dustbinHover = false; }
		
		if (gameContainer.getInput().getMouseX() > 19 && gameContainer.getInput().getMouseX() < 621) {
			if (gameContainer.getInput().getMouseY() > 48 + 45 * number && gameContainer.getInput().getMouseY() < 48 + 45 * number + 38) {
				lineHover = true;
				
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1) && !dustbinHover) {
					if (armour != GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour) {
						Inventory.armours.remove(armour);
						Inventory.armours.add(GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour);
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour = armour;
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
		
		if(Inventory.armourChange) { renderer.drawRect(19, 44, 602, 40, 0xffDDBB66); }
		
		renderer.drawRectOpaque(25, 48 + 45 * number, 36, 32, InventoryScreen.highlightColour);
		renderer.drawImageTile(armour.icon, 27, 49 + 45 * number, armour.xTile, armour.yTile);
		
		renderer.drawRectOpaque(66, 48 + 45 * number, 95, 32, InventoryScreen.highlightColour);
		renderer.drawText(armour.name, 75, 62 + 45 * number, InventoryScreen.passiveColour);
		
		renderer.drawRectOpaque(166, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
		renderer.drawText(Integer.toString(armour.defence), 171, 62 + 45 * number, InventoryScreen.passiveColour);
			
		renderer.drawRectOpaque(191, 48 + 45 * number, 20, 32, InventoryScreen.highlightColour);
		renderer.drawText(Integer.toString(armour.weight), 196, 62 + 45 * number, InventoryScreen.passiveColour);
		
		
		
	}

}
