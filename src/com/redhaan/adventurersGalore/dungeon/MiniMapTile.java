package com.redhaan.adventurersGalore.dungeon;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class MiniMapTile extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private int lineWidth, lineHeight;
	private static ImageTile icon = new ImageTile("/smallIcons.png", GameManager.GAMETILESIZE / 4, GameManager.GAMETILESIZE / 4);
	private int timer;
	
	protected int orderNumber;
	
	protected boolean hasHorizontalLineToTheRight, hasHorizontalLineToTheLeft, hasVerticalLineToTheTop, hasVerticalLineToTheBottom;
	public boolean discovered;
	
	Dungeon dungeon;
	
	public MiniMapTile(int orderNumber, Dungeon dungeon) {
		
		hasHorizontalLineToTheRight = false;
		hasVerticalLineToTheTop = false;
		discovered = false;
		
		this.dungeon = dungeon;
		
		width = 20;
		height = 30;
		lineWidth = 10;
		lineHeight = 10;
		timer = 0;
		
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
		timer++;
		if (timer > 90) { timer = 0; }
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		
		renderer.drawRect(offX, offY, width, height, 0xff003300);
		
		if(discovered) {
			renderer.drawRectOpaque(offX + 1, offY + 1, width - 2, height - 2, 0xff114411);
			if(hasHorizontalLineToTheRight) { renderer.drawRect(offX + width, offY + height / 2, lineWidth, 1, 0xff114411); }
			if(hasHorizontalLineToTheLeft) { renderer.drawRect(offX - lineWidth, offY + height / 2, lineWidth, 1, 0xff114411); }
			if(hasVerticalLineToTheTop) { renderer.drawRect(offX + width / 2, offY + height, 1, lineHeight, 0xff114411); }
			if(hasVerticalLineToTheBottom) { renderer.drawRect(offX + width / 2, offY - lineHeight, 1, lineHeight, 0xff114411); }
		}
		
		if(dungeon.dungeonRooms.get(dungeon.activeRoom).gridNumber == orderNumber && timer < 60) {
			renderer.drawImageTile(icon, offX + 6, offY + 12, 1, 9);
		}
		else if (dungeon.dungeonRooms.get(dungeon.activeRoom).gridNumber == orderNumber) { 
			renderer.drawImageTile(icon, offX + 6, offY + 12, 2, 9); 
		}
		

		
	}
	
	
	

}
