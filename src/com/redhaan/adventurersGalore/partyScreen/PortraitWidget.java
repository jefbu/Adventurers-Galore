package com.redhaan.adventurersGalore.partyScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class PortraitWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	private float temp;
	private int animationLine;
	Random random;

	private int offX, offY, width, height, gender;
	
	private static ImageTile malePortraits = new ImageTile("/portraits.png", 50, 70);
	private static ImageTile femalePortraits = new ImageTile("/Fportraits.png", 50, 70);

	public PortraitWidget(int offX, int offY, int width, int height) {

		temp = 0;
		animationLine = 0;
		random = new Random();
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		gender = 0;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 4;
		if (temp > 4) {
			temp = 0;
			if (random.nextInt(100) > 93) {
				animationLine = random.nextInt(1) + 1;
			} else { animationLine = 0; }
		}
		
		

		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).gender.equals("Female")) { gender = 4; } 
		else { gender = 0; }

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);
		
		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).gender.equals("Male")) {
		
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.skinX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.skinY);
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.earX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.earY);
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.mouthX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.mouthY);
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.noseX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.noseY);
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.eyesX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.eyesY);
		renderer.drawImageTile(malePortraits, offX + 5, offY + 15, 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.hairX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.hairY);
		
		}
		
		else {
			
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.skinX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.skinY);
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.earX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.earY);
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.mouthX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.mouthY);
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.noseX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.noseY);
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.eyesX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.eyesY);
			renderer.drawImageTile(femalePortraits, offX + 5, offY + 15, 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.hairX, GameManager.adventurers.allAdventurers.get(PartyScreen.member).portrait.hairY);
			
		}
		
		renderer.drawRect(offX + 5, offY + 15, 50, 70, 0xffBBBBBB);
		
		//renderer.drawRectOpaque(45, 80, 35, 32, 0x99778877);
		renderer.drawImageTile(GameManager.adventurers.allAdventurers.get(PartyScreen.member).icon, 45, 80, (int) temp + gender, animationLine);

	}

}
