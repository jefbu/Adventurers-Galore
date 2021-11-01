package com.redhaan.adventurersGalore.entity.town.building.alchemist;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.UnicornHorn;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class PotionLine extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private int x, y;
	private int potionNumber;
	private boolean potionLineHover;
	
	protected boolean initialised;
	private boolean enough;
	
	private int item1Y, item2Y, item3Y;
	private int item1QTY, item2QTY, item3QTY;
	
	
	private static ImageTile icon = new ImageTile("/spritesheets/craftItems.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
	
	public PotionLine(int x, int y, int potionNumber) {
		
		this.x = x;
		this.y = y;
		this.potionNumber = potionNumber;
		potionLineHover = false;
		initialised = false;
		enough = false;
		
	}

	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(!initialised) { initialise(); }
		
		if (gameContainer.getInput().getMouseX() > x && gameContainer.getInput().getMouseX() < x + 260 &&
				gameContainer.getInput().getMouseY() > y && gameContainer.getInput().getMouseY() < y + 40) {
			potionLineHover = true;
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1) && enough) {
				checkInventory(potionNumber);
				initialised = false;
				enough = false;
			}
		}
		else { potionLineHover = false; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRectOpaque(x, y, 260, 40, 0xff061115);
		
		if (potionLineHover) { 
			if (enough) { renderer.drawRect(x, y, 260, 40, 0xff22AA88); }
			else { renderer.drawRect(x, y, 260, 40, 0xffAA8822); }
		}
		
		renderer.drawRectOpaque(x + 5, y + 5, 30, 30, 0xff434855);
			if (potionNumber > 0) { renderer.drawImageTile(icon, x + 12, y + 12, 10, potionNumber - 1); }
		
		renderer.drawRectOpaque(x + 40, y + 5, 65, 30, 0xff232835);
			renderer.drawImageTile(icon, x + 45, y + 12, 3, item1Y);
			renderer.drawText("1", x + 70, y + 17, 0xff5671a3);
			renderer.drawText("(" + item1QTY + ")", x + 80, y + 17, 0xff5671a3);
			
		renderer.drawRectOpaque(x + 110, y + 5, 65, 30, 0xff232835);
			renderer.drawImageTile(icon, x + 115, y + 12, 2, item2Y);
			renderer.drawText("2", x + 140, y + 17, 0xff5671a3);
			renderer.drawText("(" + item2QTY + ")", x + 150, y + 17, 0xff5671a3);
			
		renderer.drawRectOpaque(x + 180, y + 5, 65, 30, 0xff232835);
			renderer.drawImageTile(icon, x + 185, y + 12, 2, item3Y);
			renderer.drawText("5", x + 210, y + 17, 0xff5671a3);
			renderer.drawText("(" + item3QTY + ")", x + 220, y + 17, 0xff5671a3);
	}
	
	
	private void initialise() {
		
		switch (potionNumber) {
		
		case 1:
			if (Inventory.unicornHorn >= 1 && Inventory.giantToe >= 2 && Inventory.lesses >= 5) { enough = true; }
			item1Y = 4;
			item2Y = 9;
			item3Y = 1;
			item1QTY = Inventory.unicornHorn;
			item2QTY = Inventory.giantToe;
			item3QTY = Inventory.lesses;
			break;
		
		case 2:
			if (Inventory.bezoar >= 1 && Inventory.bile >= 2 && Inventory.turtleShell >= 5) { enough = true; }
			item1Y = 0;
			item2Y = 6;
			item3Y = 4;
			item1QTY = Inventory.bezoar;
			item2QTY = Inventory.bile;
			item3QTY = Inventory.turtleShell;
			break;
		
		case 3:
			if (Inventory.historicDocument >= 1 && Inventory.volcanicAsh>= 2 && Inventory.robinEgg >= 5) { enough = true; }
			item1Y = 2;
			item2Y = 5;
			item3Y = 3;
			item1QTY = Inventory.historicDocument;
			item2QTY = Inventory.volcanicAsh;
			item3QTY = Inventory.robinEgg;
			break;
			
		case 4:
			if (Inventory.phoenixFeather >= 1 && Inventory.snakeTongue >= 2 && Inventory.beastBlood >= 5) { enough = true; }
			item1Y = 3;
			item2Y = 2;
			item3Y = 0;
			item1QTY = Inventory.phoenixFeather;
			item2QTY = Inventory.snakeTongue;
			item3QTY = Inventory.beastBlood;
			break;
			
		case 5:
			if (Inventory.manaTreeBranch >= 1 && Inventory.turtleShell >= 2 && Inventory.lizardEye >= 5) { enough = true; }
			item1Y = 8;
			item2Y = 4;
			item3Y = 7;
			item1QTY = Inventory.manaTreeBranch;
			item2QTY = Inventory.turtleShell;
			item3QTY = Inventory.lizardEye;
			break;
			
		case 6:
			if (Inventory.dragonBlood >= 1 && Inventory.robinEgg >= 2 && Inventory.ectoplasm >= 5) { enough = true; }
			item1Y = 5;
			item2Y = 3;
			item3Y = 8;
			item1QTY = Inventory.dragonBlood;
			item2QTY = Inventory.robinEgg;
			item3QTY = Inventory.ectoplasm;
			break;
			
		case 7:
			if (Inventory.mummyWrapping >= 1 && Inventory.ectoplasm >= 2 && Inventory.volcanicAsh >= 5) { enough = true; }
			item1Y = 6;
			item2Y = 8;
			item3Y = 5;
			item1QTY = Inventory.mummyWrapping;
			item2QTY = Inventory.ectoplasm;
			item3QTY = Inventory.volcanicAsh;
			break;
			
		case 8:
			if (Inventory.vampireDust >= 1 && Inventory.beastBlood >= 2 && Inventory.snakeTongue >= 5) { enough = true; }
			item1Y = 1;
			item2Y = 0;
			item3Y = 2;
			item1QTY = Inventory.vampireDust;
			item2QTY = Inventory.beastBlood;
			item3QTY = Inventory.snakeTongue;
			break;
			
		case 9:
			if (Inventory.daemonHeart >= 1 && Inventory.lesses >= 2 && Inventory.bile >= 5) { enough = true; }
			item1Y = 7;
			item2Y = 1;
			item3Y = 6;
			item1QTY = Inventory.daemonHeart;
			item2QTY = Inventory.lesses;
			item3QTY = Inventory.bile;
			break;
		}
		
		initialised = true;
		
	}
	
	
	
	private void checkInventory(int potionNumber) {
		
		switch (potionNumber) {
		
		case 1:
			Inventory.unicornHorn -= 1;
			Inventory.giantToe -= 2;
			Inventory.lesses -= 5;
			Inventory.whitePotion++;
			break;
		
		case 2:
			Inventory.bezoar -= 1;
			Inventory.bile -= 2;
			Inventory.turtleShell -= 5;
			Inventory.goldPotion++;
			break;
			
		case 3:
			Inventory.historicDocument -= 1;
			Inventory.volcanicAsh -= 2;
			Inventory.robinEgg -= 5;
			Inventory.tealPotion++;
			break;
			
		case 4:
			Inventory.phoenixFeather -= 1;
			Inventory.snakeTongue -= 2;
			Inventory.beastBlood -= 5;
			Inventory.redPotion++;
			break;
			
		case 5:
			Inventory.manaTreeBranch -= 1;
			Inventory.turtleShell -= 2;
			Inventory.lizardEye -= 5;
			Inventory.greenPotion++;
			break;
			
		case 6:
			Inventory.dragonBlood -= 1;
			Inventory.robinEgg -= 2;
			Inventory.ectoplasm -= 5;
			Inventory.bluePotion++;
			break;
			
		case 7:
			Inventory.mummyWrapping -= 1;
			Inventory.ectoplasm -= 2;
			Inventory.volcanicAsh -= 5;
			Inventory.brownPotion++;
			break;
			
		case 8:
			Inventory.vampireDust -= 1;
			Inventory.beastBlood -= 2;
			Inventory.snakeTongue -= 5;
			Inventory.purplePotion++;
			break;
			
		case 9:
			Inventory.daemonHeart -= 1;
			Inventory.lesses -= 2;
			Inventory.bile -= 5;
			Inventory.blackPotion++;
			break;
			
		}
		
		
	}
	


	
	
	
	

}
