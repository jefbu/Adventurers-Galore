package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WeaponWidget extends GameObject {
	
	private int offX, offY, width, height;
	private ImageTile icon;
	
	WeaponAffinityWidget weaponAffinityWidget;
	
	
	public WeaponWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		icon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
		weaponAffinityWidget = new WeaponAffinityWidget();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		Weapon weapon = GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon;

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);
		
		renderer.drawImageTile(weapon.icon, offX + 5, offY + 5, weapon.xTile, weapon.yTile);
		
		String soulText = "Soulless";
		if(weapon.soul != null) { soulText = weapon.soul.race.name + "slayer"; }
		renderer.drawText(weapon.name + ", " + soulText, offX + 45, offY + 25, 0xffBBBBBB);
		
		renderer.drawText(Integer.toString(weapon.damage), offX + 45, offY + 14, 0xffBBFFBB);
		renderer.drawText(Integer.toString(weapon.hit), offX + 65, offY + 14, 0xffBBBBFF);
		renderer.drawText(Integer.toString(weapon.crit), offX + 85, offY + 14, 0xffDDBBDD);
		renderer.drawText(Integer.toString(weapon.weight), offX + 105, offY + 14, 0xffDDDDDD);

		weaponAffinityWidget.render(gameContainer, renderer, weapon, offX, offY);
		
		if(!weapon.isLegendary) {		
			for (int i = 0; i < weapon.runeSlots; i++) {
				renderer.drawRectOpaque(offX + 5 + (i * 20), offY + 70, 15, 20, 0x55EEEEDD);
			}
			
			if(weapon.gemStone != null) { renderer.drawImageTile(icon, offX + 80, offY + 65, weapon.gemStone.level, 1); }
			if(weapon.upgrades > 0) { renderer.drawImageTile(icon, offX + 100, offY + 65, weapon.upgrades, 0); }			
		}
		
		else {
			renderer.drawRectOpaque(offX + 5, offY + 65, width - 10, height / 4, 0x05DDAACC);
			renderer.drawText("Legendary Weapon", offX + 10, offY + 73, 0xffCCBBBB);
		}

		
		
	}
		

}
