package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SigilWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private boolean hover;
	private int hoverX, hoverY;
	
	public SigilWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		hover = false;
		hoverX = 0;
		hoverY = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).sigils.size() > 0 && 
				checkHovering(offX + 5, offX + 5 + width - 10, offY + 5, offY + 5 + height / 4, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).sigils.size() > 1 && 
				checkHovering(offX + 5, offX + 5 + width - 10, offY + 5 + (height / 4 + 5), offY + 5 + (height / 4 + 5) + height / 4, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).sigils.size() > 2 && 
				checkHovering(offX + 5, offX + 5 + width - 10, offY + 5 + 2 * (height / 4 + 5), offY + 5 +  2 * (height / 4 + 5) + height / 4, gameContainer)) { hover = true; }
		else { hover = false; }
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282028);
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.get(PartyScreen.member).sigilSlots; i++) {
			
			renderer.drawRectOpaque(offX + 5, (offY + 5) +  i * (height / 4 + 5), width - 10, height / 4, 0xff584858);
			renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).sigils.get(i).name, offX + 10, (offY + 10) +  i * (height / 4 + 5), 0xffCCBBCC);
			
		}
		
		if(hover) { renderer.drawRect(hoverX, hoverY, width - 8, height / 4 + 2, 0xff999999); }
		
	}
	
	
	private boolean checkHovering (int leftSide, int rightSide, int top, int bottom, GameContainer gameContainer) {
		
		if(gameContainer.getInput().getMouseX() > leftSide && gameContainer.getInput().getMouseX() < rightSide &&
				gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {
			hoverX = leftSide - 1;
			hoverY = top - 1;
			return true;
		} else { return false; }
		
	}
	
	
	

}
