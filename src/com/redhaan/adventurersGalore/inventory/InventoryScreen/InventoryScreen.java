package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.awt.event.KeyEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.partyScreen.WeaponWidget;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class InventoryScreen extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private MenuBar menuBar;
	protected static CraftWidget craftWidget;
	protected static AlchemyWidget alchemyWidget;
	protected static WeaponInventory weaponWidget;
	protected static ArmourWidget armourWidget;
	protected static GemWidget gemWidget;
	
	protected static int activeColour = 0xff273741;
	protected static int passiveColour = 0xff222936;
	protected static int highlightColour = 0xff587192;
	

	public InventoryScreen() {
		menuBar = new MenuBar();
		craftWidget = new CraftWidget();
		alchemyWidget = new AlchemyWidget();
		weaponWidget = new WeaponInventory();
		armourWidget = new ArmourWidget();
		gemWidget = new GemWidget();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {

		case Inventory:
			
			menuBar.update(gameContainer, deltaTime);
			
			switch(MenuBar.selectedTab) {
			
			case 1: craftWidget.update(gameContainer, deltaTime); break;
			case 2: alchemyWidget.update(gameContainer, deltaTime); break;
			case 3: weaponWidget.update(gameContainer, deltaTime); break;
			case 4: armourWidget.update(gameContainer, deltaTime); break;
			case 5: gemWidget.update(gameContainer, deltaTime); break;
			
			}
			
			
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_X)) { closeScreen(GameState.WorldMap); }
			
			break;
			
		case PartyCohesionCheckerUI: break;
		case PartyScreen: break;
		case QuestScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		case WorldMap: break;
		case Combat: break;
		case InTown: break;
		
		}		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {

		case Inventory:
			renderer.drawRectOpaque(10, 10, 620, 460, 0xff132427);
			menuBar.render(gameContainer, renderer);
			
			switch(MenuBar.selectedTab) {
			
			case 1: craftWidget.render(gameContainer, renderer); break;
			case 2: alchemyWidget.render(gameContainer, renderer); break;
			case 3: weaponWidget.render(gameContainer, renderer); break;
			case 4: armourWidget.render(gameContainer, renderer); break;
			case 5: gemWidget.render(gameContainer, renderer); break;
			
			
			}
			
			break;

			
			
		case Combat: break;
		case InTown: break;
		case PartyCohesionCheckerUI: break;
		case PartyScreen: break;
		case QuestScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		case WorldMap: break;

				
		}
	}
	
	
	public static void closeScreen(GameState nextState) {
		
		craftWidget.updated = false;
		alchemyWidget.updated = false;
		weaponWidget.updated = false;
		armourWidget.updated = false;
		gemWidget.updated = false;
		
		Inventory.weaponChange = false;
		Inventory.armourChange = false;
		
		Transition.nextGameState = nextState;
		GameManager.gameState = GameState.Transition;
		
	}
	
	

}
