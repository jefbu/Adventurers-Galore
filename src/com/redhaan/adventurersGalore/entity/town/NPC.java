package com.redhaan.adventurersGalore.entity.town;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Race;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.NameFactory;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.RaceFactory;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class NPC extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private final static int NPCTILESIZE = 16;
	static ImageTile icon = new ImageTile("/medium_icons.png", NPCTILESIZE, NPCTILESIZE);
	static ImageTile portrait = new ImageTile("/NPCPortrait.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	
	Random random;
	private String gender;
	public int body, head, skin, portraitBody, portraitHead, portraitSkin;
	private Race race;
	private RaceFactory raceFactory;
	public String name;
	private NameFactory nameFactory;
	
	protected boolean dialogueActive;
	private NPCDialogue npcDialogue;
	
	protected int xLocation, yLocation;
	protected int xHome, yHome;
	protected int facing;
	protected boolean visible;
	
	protected int familiarity;	
	
	private Routine routine;
	
	
	public NPC() {
		
		random = new Random();
		raceFactory = new RaceFactory();
		nameFactory = new NameFactory();
		setHomeLocation();
		
		if(random.nextBoolean()) { 
			gender = "Male"; 
			body = random.nextInt(8); portraitBody = body;
			head = random.nextInt(8); portraitHead = head;
			skin = random.nextInt(8); portraitSkin = skin;
		} 
		else { 
			gender = "Female"; 
			body = random.nextInt(8) + 8; portraitBody = body;
			head = random.nextInt(8) + 8; portraitHead = head;
			skin = random.nextInt(8) + 8; portraitSkin = skin;
		}

		race = raceFactory.setRace(0);
		name = nameFactory.rollName(race, gender);
		
		dialogueActive = false;
		npcDialogue = new NPCDialogue(this);
		
		xLocation = xHome;
		yLocation = yHome;
		
		facing = 0;
		visible = false;
		
		familiarity = 0;
		
		routine = new Routine(this);
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(TownMap.subState) {
		
		case General:
			
			if(dialogueActive) { npcDialogue.update(gameContainer, deltaTime); 	}
			
			else {
				
				routine.update(this);
				
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					if (gameContainer.getInput().getMouseX() >= xLocation && gameContainer.getInput().getMouseX() <= xLocation + NPCTILESIZE &&
							gameContainer.getInput().getMouseY() >= yLocation && gameContainer.getInput().getMouseY() <= yLocation + NPCTILESIZE) {
						dialogueActive = true;
					}
				}
				
			}
			break;
			
		case Alchemist: break;
		case Blacksmith: break;
		case Inn: break;
		default: break;		
		
		}		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(TownMap.subState) {
		
		case General: 
			
			if (dialogueActive) { npcDialogue.render(gameContainer, renderer); }
		
			else {
			
				if(visible) {
					renderer.drawImageTile(icon, xLocation, yLocation, body, 5 + facing);
					renderer.drawImageTile(icon, xLocation, yLocation, head, 13 + facing);
					renderer.drawImageTile(icon, xLocation, yLocation, skin, 21 + facing);
								
					switch(familiarity) {
					
					case 0: break;
					case 1:
						renderer.drawRectOpaque(xLocation - 7, yLocation + 17, 30, 10, 0xff552121);
						renderer.drawText(name, xLocation - 4, yLocation + 19, 0xffbb7777);
						break;
					case 2:
						renderer.drawRectOpaque(xLocation - 7, yLocation + 17, 30, 10, 0xff212155);
						renderer.drawText(name, xLocation - 4, yLocation + 19, 0xff7777bb);
						break;
					case 3:
						renderer.drawRectOpaque(xLocation - 7, yLocation + 17, 30, 10, 0xff215521);
						renderer.drawText(name, xLocation - 4, yLocation + 19, 0xff77bb77);
						break;
					default: break;
					}
				}
				
			}			
			break;
		
		case Alchemist: break;
		case Blacksmith: break;
		case Inn: break;
		default: break;	
			
		}
		
	}
	
	
	private void setHomeLocation() {
		
		int roll = random.nextInt(5);
		
		switch(roll) {
		
		case 0: xHome = 485; yHome = 215; break;
		case 1: xHome = 525; yHome = 225; break;
		case 2: xHome = 560; yHome = 240; break;
		case 3: xHome = 405; yHome = 110; break;
		case 4: xHome = 375; yHome = 200; break;
		
		}
		
	}
	
	
	
	

}
