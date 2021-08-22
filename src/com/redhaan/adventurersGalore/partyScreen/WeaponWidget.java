package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.item.weapon.Rune;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.inventory.InventoryScreen.MenuBar;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WeaponWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY, width, height;
	private ImageTile icon;
	private Weapon weapon;
	
	private int passiveColour, activeColour;
	private boolean hover;
	
	WeaponAffinityWidget weaponAffinityWidget;
	
	private int weaponColour;
	
	
	public WeaponWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		icon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
		passiveColour = 0xff242822;
		activeColour = 0xff484442;
		hover = false;
		
		weaponAffinityWidget = new WeaponAffinityWidget();
		
		weaponColour = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(gameContainer.getInput().getMouseX() > offX && gameContainer.getInput().getMouseX() < offX + width &&
				gameContainer.getInput().getMouseY() > offY && gameContainer.getInput().getMouseY() < offY + height) {
			
			hover = true;
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				MenuBar.selectedTab = 3;
				Inventory.weaponChange = true;
				GameManager.gameState = GameState.Inventory;
			}
			
		}
		else { hover = false; }
		
		weaponColour = GameManager.adventurers.allAdventurers.get(PartyScreen.member).affinities.highestAffinity();
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		weapon = GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon;
		
		if (hover) { 
			renderer.drawRectOpaque(offX, offY, width, height, activeColour); 
			renderer.drawRect(offX - 1, offY - 1, width + 2, height + 2, 0xff7191D1);
			}
		else { renderer.drawRectOpaque(offX, offY, width, height, passiveColour); }
		
		renderer.drawImageTile(Weapon.icon, offX + 5, offY + 5, weapon.xTile, weapon.yTile);
		
		String soulText = "Soulless";
		if(weapon.soul != null) { soulText = weapon.soul.race.name + "slayer"; }
		renderer.drawText(weapon.name + ", " + soulText, offX + 45, offY + 25, 0xffBBBBBB);
		renderer.drawText("Range: " + weapon.minRange + " - " + weapon.maxRange, offX + 45, offY + 35, 0xffBBBBBB);
		
		renderer.drawText(Integer.toString(weapon.damage), offX + 45, offY + 14, 0xffBBFFBB);
		renderer.drawText(Integer.toString(weapon.hit), offX + 65, offY + 14, 0xffBBBBFF);
		renderer.drawText(Integer.toString(weapon.crit), offX + 85, offY + 14, 0xffDDBBDD);
		renderer.drawText(Integer.toString(weapon.weight), offX + 105, offY + 14, 0xffDDDDDD);

		weaponAffinityWidget.render(gameContainer, renderer, weapon, offX, offY);
		
		if(!weapon.isLegendary) {		
			for (int i = 0; i < weapon.runeSlots; i++) {
				renderer.drawRectOpaque(offX + 5 + (i * 20), offY + 70, 15, 20, 0x55EEEEDD);
			}
			if (weapon.runes.size() > 0) {
				for (int ii = 0; ii < weapon.runes.size(); ii++) {
					renderer.drawImageTile(Rune.icon, offX + 5 + (ii * 20), offY + 70, weapon.runes.get(ii).xRow, weapon.runes.get(ii).yRow);
				}
			}

			
			renderer.drawImageTile(icon, offX + 80, offY + 65, weaponColour, 1);
			if(weapon.upgrades > 0) { renderer.drawImageTile(icon, offX + 100, offY + 65, weapon.upgrades, 0); }			
		}
		
		else {
			renderer.drawRectOpaque(offX + 5, offY + 65, width - 10, height / 4, 0x05DDAACC);
			renderer.drawText("Legendary Weapon", offX + 10, offY + 73, 0xffCCBBBB);
		}

		
		
	}
		

}
