package com.redhaan.adventurersGalore.partyScreen;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WeaponAffinityWidget implements Serializable {

	private static final long serialVersionUID = 1L;
	private ImageTile icon;
	
	
	public WeaponAffinityWidget() {
		
		icon = new ImageTile("/smallIcons.png", GameManager.GAMETILESIZE / 4, GameManager.GAMETILESIZE / 4);
		
	}


	public void render(GameContainer gameContainer, Renderer renderer, Weapon weapon, int offX, int offY) {

		if(weapon.gemStone != null) {

			renderer.drawImageTile(icon, offX + 5, offY + 50, weapon.gemStone.whiteBonus / 5, 5);
			renderer.drawImageTile(icon, offX + 15, offY + 50, weapon.gemStone.yellowBonus / 5, 3);
			renderer.drawImageTile(icon, offX + 25, offY + 50, weapon.gemStone.tealBonus / 5, 4);
			renderer.drawImageTile(icon, offX + 35, offY + 50, weapon.gemStone.redBonus / 5, 0);
			renderer.drawImageTile(icon, offX + 45, offY + 50, weapon.gemStone.greenBonus / 5, 1);
			renderer.drawImageTile(icon, offX + 55, offY + 50, weapon.gemStone.blueBonus / 5, 2);
			renderer.drawImageTile(icon, offX + 65, offY + 50, weapon.gemStone.purpleBonus / 5, 6);
			renderer.drawImageTile(icon, offX + 75, offY + 50, weapon.gemStone.brownBonus / 5, 7);
			renderer.drawImageTile(icon, offX + 85, offY + 50, weapon.gemStone.blackBonus / 5, 8);

			int gemStoneInt = 0;
			switch(weapon.gemStone.gemStoneEnum) {
			case amber: gemStoneInt = 7; break;
			case amethyst: gemStoneInt = 6; break;
			case emerald: gemStoneInt = 1; break;
			case onyx: gemStoneInt = 8; break;
			case pearl: gemStoneInt = 5; break;
			case ruby: gemStoneInt = 0; break;
			case sapphire: gemStoneInt = 2; break;
			case topaz: gemStoneInt = 3; break;
			case turquoise: gemStoneInt = 4; break;
			case moonstone: break;
			}
					
			if(!weapon.isLegendary) {
				renderer.drawImageTile(icon, offX + 110, offY + 50, weapon.gemStone.level + 8, gemStoneInt);
			}
			
		}
		
	}
	
	

}
