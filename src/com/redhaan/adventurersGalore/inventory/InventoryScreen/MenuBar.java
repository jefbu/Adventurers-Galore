package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.awt.event.KeyEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class MenuBar extends GameObject {
	
	public static int selectedTab;
	private boolean hover;
	
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		
		selectedTab = 1;
		hover = false;
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(Inventory.weaponChange) {
			
		}
		
		else if (Inventory.armourChange) {
			
			
		}
		
		else {
			
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_C)) { selectedTab = 1; }
			else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_A)) { selectedTab = 2; }
			else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_W)) { selectedTab = 3; }
			else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_O)) { selectedTab = 4; }
			else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_G)) { selectedTab = 5; }
			
			if (gameContainer.getInput().getMouseX() > 19 && gameContainer.getInput().getMouseX() < 91 &&
					gameContainer.getInput().getMouseY() > 14 && gameContainer.getInput().getMouseY() < 36) {
				hover = true;
				selectedTab = 1;
			}
			
			else if (gameContainer.getInput().getMouseX() > 94 && gameContainer.getInput().getMouseX() < 166 &&
					gameContainer.getInput().getMouseY() > 14 && gameContainer.getInput().getMouseY() < 36) {
				hover = true;
				selectedTab = 2;
			}
			
			else if (gameContainer.getInput().getMouseX() > 169 && gameContainer.getInput().getMouseX() < 231 &&
					gameContainer.getInput().getMouseY() > 14 && gameContainer.getInput().getMouseY() < 36) {
				hover = true;
				selectedTab = 3;
			}
			
			else if (gameContainer.getInput().getMouseX() > 244 && gameContainer.getInput().getMouseX() < 316 &&
					gameContainer.getInput().getMouseY() > 14 && gameContainer.getInput().getMouseY() < 36) {
				hover = true;
				selectedTab = 4;
			}
			
			else if (gameContainer.getInput().getMouseX() > 319 && gameContainer.getInput().getMouseX() < 391 &&
					gameContainer.getInput().getMouseY() > 14 && gameContainer.getInput().getMouseY() < 36) {
				hover = true;
				selectedTab = 5;
			}
			
			
			else { hover = false; }
			
		}


		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		
		if (Inventory.weaponChange) {
			
			renderer.drawRectOpaque(170, 15, 70, 20, InventoryScreen.activeColour);
			renderer.drawText("Weapons", 175, 22, 0xff415161);
			renderer.drawRectOpaque(15, 35, 610, 420, InventoryScreen.activeColour);	
			
		}
		
		else if (Inventory.armourChange) {
			
			renderer.drawRectOpaque(245, 15, 70, 20, InventoryScreen.activeColour);
			renderer.drawText("Outfit", 250, 22, 0xff415161);
			renderer.drawRectOpaque(15, 35, 610, 420, InventoryScreen.activeColour);
			
		}
		
		else { 		
		
		if(hover) {
			
			switch(selectedTab) {
			
			case 1: renderer.drawRect(19, 14, 72, 22, 0xffAA9988); break;
			case 2: renderer.drawRect(94, 14, 72, 22, 0xffAA9988); break;
			case 3: renderer.drawRect(169, 14, 72, 22, 0xffAA9988); break;
			case 4: renderer.drawRect(244, 14, 72, 22, 0xffAA9988); break;
			case 5: renderer.drawRect(319, 14, 72, 22, 0xffAA9988); break;
			
			}
		}
		
		if (selectedTab == 1) { renderer.drawRectOpaque(20, 15, 70, 20, InventoryScreen.activeColour); }
			else { renderer.drawRectOpaque(20, 15, 70, 20, InventoryScreen.passiveColour); }
			renderer.drawText("(C)rafting", 25, 22, 0xff415161);
			
		if (selectedTab == 2) { renderer.drawRectOpaque(95, 15, 70, 20, InventoryScreen.activeColour); }
			else { renderer.drawRectOpaque(95, 15, 70, 20, InventoryScreen.passiveColour); }
			renderer.drawText("(A)lchemy", 100, 22, 0xff415161);

		if (selectedTab == 3) { renderer.drawRectOpaque(170, 15, 70, 20, InventoryScreen.activeColour); }
			else { renderer.drawRectOpaque(170, 15, 70, 20, InventoryScreen.passiveColour); }
			renderer.drawText("(W)eapons", 175, 22, 0xff415161);
			
		if (selectedTab == 4) { renderer.drawRectOpaque(245, 15, 70, 20, InventoryScreen.activeColour); }
			else { renderer.drawRectOpaque(245, 15, 70, 20, InventoryScreen.passiveColour); }
			renderer.drawText("(O)utfit", 250, 22, 0xff415161);	

		if (selectedTab == 5) { renderer.drawRectOpaque(320, 15, 70, 20, InventoryScreen.activeColour); }
			else { renderer.drawRectOpaque(320, 15, 70, 20, InventoryScreen.passiveColour); }
			renderer.drawText("(G)ems", 325, 22, 0xff415161);	
			
			
		renderer.drawRectOpaque(15, 35, 610, 420, InventoryScreen.activeColour);	
		
		}
			
		
	}

}
