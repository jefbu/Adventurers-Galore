package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class AffinityWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	
	private ImageTile icons;
	
	public AffinityWidget(int offX, int offY, int width, int height) {
				
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
		icons = new ImageTile("/smallIcons.png", GameManager.GAMETILESIZE / 4, GameManager.GAMETILESIZE / 4);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242626);
		
		renderer.drawImageTile(icons, offX + 10, offY + 10, 11, 5);
		renderer.drawImageTile(icons, offX + 10, offY + 35, 11, 3);
		renderer.drawImageTile(icons, offX + 10, offY + 60, 11, 4);
		renderer.drawImageTile(icons, offX + 110, offY + 10, 11, 0);
		renderer.drawImageTile(icons, offX + 110, offY + 35, 11, 1);
		renderer.drawImageTile(icons, offX + 110, offY + 60, 11, 2);
		renderer.drawImageTile(icons, offX + 210, offY + 10, 11, 7);
		renderer.drawImageTile(icons, offX + 210, offY + 35, 11, 6);
		renderer.drawImageTile(icons, offX + 210, offY + 60, 11, 8);
		
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.white), offX + 25, offY + 10, 0xffDDDDDD);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.yellow), offX + 25, offY + 35, 0xffAD9100);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.teal), offX + 25, offY + 60, 0xff119CAF);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.red), offX + 125, offY + 10, 0xff992614);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.green), offX + 125, offY + 35, 0xff709E0F);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.blue), offX + 125, offY + 60, 0xff1400AD);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.brown), offX + 225, offY + 10, 0xff643C00);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.purple), offX + 225, offY + 35, 0xff7D005F);
		renderer.drawText(Integer.toString(GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.black), offX + 225, offY + 60, 0xff000000);


		
		
	}
	
	

}
