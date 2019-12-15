package com.redhaan.adventurersGalore.partyScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WeaponWidget extends GameObject {
	
	private ImageTile portrait;
	private int temp;
	Random random;
	private int offX, offY, width, height;
	private ImageTile icon;
	
	
	public WeaponWidget(int offX, int offY, int width, int height) {
		
		portrait = new ImageTile("/weapons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		temp = 0;
		random = new Random();
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		icon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 4;
		if (temp > 0) {
			temp = 0;
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		Weapon weapon = GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon;

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);
		
		renderer.drawImageTile(portrait, offX + 5, offY + 5, (int) temp, 0);
		renderer.drawText(Integer.toString(weapon.damage), offX + 45, offY + 5, 0xffBBFFBB);
		renderer.drawText(Integer.toString(weapon.hit), offX + 65, offY + 5, 0xffBBBBFF);
		renderer.drawText(Integer.toString(weapon.crit), offX + 85, offY + 5, 0xffDDBBDD);
		renderer.drawText(weapon.name, offX + 5, offY + 40, 0xffBBBBBB);
		if(weapon.soul != null) {
			renderer.drawText(weapon.soul.race.name + "slayer", offX + 5, offY + 50, 0xffBBBBBB);
		} else {
			renderer.drawText("Soulless", offX + 5, offY + 50, 0xffBBBBBB);
		}
		
		for (int i = 0; i < weapon.runeSlots; i++) {
			renderer.drawRectOpaque(offX + 5 + (i * 20), offY + 70, 15, 20, 0x55EEEEDD);
		}
		
		renderer.drawImageTile(icon, offX + 80, offY + 80, weapon.upgrades, 0);
	}
		

}
