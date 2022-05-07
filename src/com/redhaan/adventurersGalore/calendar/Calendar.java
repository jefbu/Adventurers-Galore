package com.redhaan.adventurersGalore.calendar;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.worldMap.SubState;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Calendar extends GameObject {

	private static final long serialVersionUID = 1L;
	public static int daysPassed;
	public static int monthDay;
	private int timer;
	public static int calendarSpeed;
	private Months month;
	private ImageTile image;
	private int imgX, imgY;
	private boolean hover;
	
	public Calendar() {
		daysPassed = 0;
		monthDay = 1;
		timer = 0;
		calendarSpeed = 1;
		month = Months.breezelin;
		image = new ImageTile("/spriteSheets/CalendarSpeeds.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
		imgX = 0;
		imgY = 0;
		hover = false;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;
		
		case WorldMap:
			
		if(WorldMap.subState != SubState.TravelerEvent) {
			
			if(gameContainer.getInput().getMouseX() > 520 && gameContainer.getInput().getMouseX() < 620 &&
					gameContainer.getInput().getMouseY() > 20 && gameContainer.getInput().getMouseY() < 40) {
		
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						updateSpeed();
					} else { hover = true; }
			} 
			
			else if(gameContainer.getInput().isKeyUp(KeyEvent.VK_S)) {
				updateSpeed();
			}
			
			else { hover = false; }
			
			timer++;
			if(timer * deltaTime * calendarSpeed > 3 ) {
				daysPassed++;
				monthDay++;
				if(monthDay > 30) { 
					monthDay = 1; 	
					switch(month) {
					case breezelin: month = Months.heatlin; break;
					case heatlin: month = Months.plantlin; break;
					case plantlin: month = Months.moistlin; break;
					case moistlin: month = Months.snowlin; break;
					case snowlin: month = Months.sparklin; break;
					case sparklin: month = Months.shinelin; break;
					case shinelin: month = Months.dusklin; break;
					case dusklin: month = Months.breezelin; break;
					default: System.out.println("Error at calendar month decision");
					}
				}
				timer = 0;
			}
			break;
				
		}
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat: break;
		case Titlescreen: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;
		
		case WorldMap:
		if(hover) { renderer.drawRect(499, 19, 122, 22, 0x88FFFFFF); }
		renderer.drawRectOpaque(500, 20, 120, 20, 0x33cccccc);
		renderer.drawRect(505, 22, 20, 16, 0xff000000);
		renderer.drawImageTile(image, 505, 22, imgX, imgY);
		renderer.drawText(month.toString() + ", " + monthDay + "  (S)", 530, 25, 0xff000000);
		
		break;
		}
		
	}
	
	
	private void updateSpeed() {
		
		switch(calendarSpeed) {
		case 1: calendarSpeed = 3; imgX = 1; imgY = 0; break;
		case 3: calendarSpeed = 10; imgX = 0; imgY = 1; break;
		case 10: calendarSpeed = 40; imgX = 1; imgY = 1; break;
		case 40: calendarSpeed = 1; imgX = 0; imgY = 0; break;
		default: System.out.println("Error at calendar speed setting");
		}
		
	}	

}
