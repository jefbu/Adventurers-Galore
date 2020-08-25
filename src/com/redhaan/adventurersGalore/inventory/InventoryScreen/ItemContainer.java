package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class ItemContainer extends GameObject {

	private static final long serialVersionUID = 1L;
	static ImageTile icon = new ImageTile("/spritesheets/craftItems.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
	private int offX;
	private int offY;
	private int tileX;
	private int tileY;
	private String text;
	
	public int quantity;
	
	public ItemContainer(String text, int offX, int offY, int tileX, int tileY) {
		
		this.offX = offX;
		this.offY = offY;
		this.tileX = tileX;
		this.tileY = tileY;
		this.text = text;
		
		quantity = 0;
		
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
				
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, 100, 22, InventoryScreen.passiveColour);
		renderer.drawRectOpaque(offX + 3, offY + 2, 18, 18, InventoryScreen.highlightColour);
		renderer.drawRectOpaque(offX + 24, offY + 2, 54, 18, InventoryScreen.highlightColour);
		renderer.drawRectOpaque(offX + 81, offY + 2, 16, 18, InventoryScreen.highlightColour);
		renderer.drawImageTile(icon, offX + 3, offY + 3, tileX, tileY);
		renderer.drawText(text, offX + 27, offY + 6, 0xff221731);
		renderer.drawText(Integer.toString(quantity), offX + 85, offY + 6, 0xff221731);
		
	}

}
