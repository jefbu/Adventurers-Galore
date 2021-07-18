package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.inventory.InventoryScreen.MenuBar;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	int offX, offY;
	int width, height;
	
	private int passiveColour, activeColour;
	private boolean hover;
	
	public ArmourWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
		passiveColour = 0xff242822;
		activeColour = 0xff484442;
		hover = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(gameContainer.getInput().getMouseX() > offX && gameContainer.getInput().getMouseX() < offX + width &&
				gameContainer.getInput().getMouseY() > offY && gameContainer.getInput().getMouseY() < offY + height) {
			
			hover = true;
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				MenuBar.selectedTab = 4;
				Inventory.armourChange = true;
				GameManager.gameState = GameState.Inventory;
			}
			
		}
		else { hover = false; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		Armour armour = GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour;
		
		if (hover) { 
			renderer.drawRectOpaque(offX, offY, width, height, activeColour); 
			renderer.drawRect(offX - 1, offY - 1, width + 2, height + 2, 0xff7191D1);
			}
		else { renderer.drawRectOpaque(offX, offY, width, height, passiveColour); }
		
		renderer.drawImageTile(Armour.icon, offX + 14, offY + 5, armour.xTile, armour.yTile);	
		renderer.drawText(Integer.toString(armour.defence), offX + 23, offY + 50, 0xffBBFFBB);
		renderer.drawText(Integer.toString(armour.weight), offX + 23, offY + 60, 0xffDDDDDD);
	
	}
		

}