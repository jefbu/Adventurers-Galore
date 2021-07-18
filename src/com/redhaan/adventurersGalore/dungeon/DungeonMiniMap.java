package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.combat.Combat;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DungeonMiniMap extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dungeon dungen;
	
	ArrayList<MiniMapTile> miniMapTiles;
	
	public DungeonMiniMap(Dungeon dungeon) {
	
		this.dungen = dungeon;
		
		miniMapTiles = new ArrayList<MiniMapTile>();
		for (int i = 0; i < 25; i++) {
			miniMapTiles.add(new MiniMapTile(i, dungeon));
		}
		
	}	
		
		

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(Combat.dungeon) {
			for (MiniMapTile miniMapTile: miniMapTiles) {
				miniMapTile.update(gameContainer, deltaTime);
			}
		}

		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
	
		if(Combat.dungeon) {
			renderer.drawRect(5, 20, 150, 200, 0xff005500);
			
			for (MiniMapTile miniMapTile: miniMapTiles) {
				miniMapTile.render(gameContainer, renderer);			
			}
		}
		
	}
	

}
