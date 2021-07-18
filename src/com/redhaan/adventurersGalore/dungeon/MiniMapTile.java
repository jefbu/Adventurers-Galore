package com.redhaan.adventurersGalore.dungeon;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class MiniMapTile extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private int lineWidth, lineHeight;
	
	protected int orderNumber;
	
	protected boolean hasHorizontalLine, hasVerticalLine;
	public boolean discovered;
	
	Dungeon dungeon;
	
	public MiniMapTile(int orderNumber, Dungeon dungeon) {
		
		hasHorizontalLine = false;
		hasVerticalLine = false;
		discovered = false;
		
		this.dungeon = dungeon;
		
		width = 20;
		height = 30;
		lineWidth = 10;
		lineHeight = 10;
		
		this.orderNumber = orderNumber;
		
		switch(orderNumber) {
		case 0: offX = 10; offY = 25; break;
		case 1: offX = 40; offY = 25; break;
		case 2: offX = 70; offY = 25; break;
		case 3: offX = 100; offY = 25; break;
		case 4: offX = 130; offY = 25; break;
		case 5: offX = 10; offY = 65; break;
		case 6: offX = 40; offY = 65; break;
		case 7: offX = 70; offY = 65; break;
		case 8: offX = 100; offY = 65; break;
		case 9: offX = 130; offY = 65; break;
		case 10: offX = 10; offY = 105; break;
		case 11: offX = 40; offY = 105; break;
		case 12: offX = 70; offY = 105; break;
		case 13: offX = 100; offY = 105; break;
		case 14: offX = 130; offY = 105; break;
		case 15: offX = 10; offY = 145; break;
		case 16: offX = 40; offY = 145; break;
		case 17: offX = 70; offY = 145; break;
		case 18: offX = 100; offY = 145; break;
		case 19: offX = 130; offY = 145; break;
		case 20: offX = 10; offY = 185; break;
		case 21: offX = 40; offY = 185; break;
		case 22: offX = 70; offY = 185; break;
		case 23: offX = 100; offY = 185; break;
		case 24: offX = 130; offY = 185; break;
		default: break;
		}
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		
		renderer.drawRect(offX, offY, width, height, 0xff003300);
		
		if(dungeon.dungeonRooms.get(dungeon.activeRoom).gridNumber == orderNumber) {
			renderer.drawRectOpaque(offX + 1, offY + 1, width - 2, height - 2, 0xff669966);
			if(hasHorizontalLine) { renderer.drawRect(offX + width, offY + height / 2, lineWidth, 1, 0xff114411); }
			if(hasVerticalLine) { renderer.drawRect(offX + width / 2, offY + height, 1, lineHeight, 0xff114411); }
		}
		else if(discovered) {
			renderer.drawRectOpaque(offX + 1, offY + 1, width - 2, height - 2, 0xff114411);
			if(hasHorizontalLine) { renderer.drawRect(offX + width, offY + height / 2, lineWidth, 1, 0xff114411); }
			if(hasVerticalLine) { renderer.drawRect(offX + width / 2, offY + height, 1, lineHeight, 0xff114411); }
		}
		

		
	}
	
	
	

}
