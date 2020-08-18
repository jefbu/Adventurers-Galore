package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	int offX, offY;
	int width, height;
	
	public ArmourWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		Armour armour = GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour;
		
		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);
		renderer.drawImageTile(armour.icon, offX + 14, offY + 5, armour.xTile, armour.yTile);	
		renderer.drawText(Integer.toString(armour.defence), offX + 23, offY + 50, 0xffBBFFBB);
		renderer.drawText(Integer.toString(armour.weight), offX + 23, offY + 60, 0xffDDDDDD);
	
	}
		

}