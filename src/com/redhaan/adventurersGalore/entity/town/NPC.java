package com.redhaan.adventurersGalore.entity.town;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Race;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.NameFactory;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.RaceFactory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class NPC extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private static ImageTile icon = new ImageTile("/medium_icons.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
	
	Random random;
	private String gender;
	public int body, head, skin;
	private Race race;
	private RaceFactory raceFactory;
	public String name;
	private NameFactory nameFactory;
	
	protected int xLocation, yLocation;
	protected int xHome, yHome;
	protected int facing;
	protected boolean visible;
	
	
	private Routine routine;
	
	
	public NPC() {
		
		random = new Random();
		raceFactory = new RaceFactory();
		nameFactory = new NameFactory();
		setHomeLocation();
		
		if(random.nextBoolean()) { gender = "Male"; } else { gender = "Female"; }
		body = random.nextInt(3);
		head = random.nextInt(3);
		skin = random.nextInt(3);
		race = raceFactory.setRace(0);
		name = nameFactory.rollName(race, gender);
		
		xLocation = xHome;
		yLocation = yHome;
		
		facing = 0;
		visible = false;
		
		routine = new Routine(this);
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		routine.update(this);
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if(visible) {
			renderer.drawImageTile(icon, xLocation, yLocation, body, 5 + facing);
			renderer.drawImageTile(icon, xLocation, yLocation, head, 13 + facing);
			renderer.drawImageTile(icon, xLocation, yLocation, skin, 21 + facing);
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
