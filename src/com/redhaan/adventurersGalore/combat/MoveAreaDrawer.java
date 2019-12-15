package com.redhaan.adventurersGalore.combat;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.Renderer;

public abstract class MoveAreaDrawer {
	
	public static void drawMoveArea(ArrayList<int[]> moveRange, Renderer renderer) {
		
		for (int i = 0; i < moveRange.size(); i++) {
			
			renderer.drawRectOpaque(moveRange.get(i)[0] * GameManager.GAMETILESIZE , moveRange.get(i)[1] * GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0x33eeeebb);
			
		}
		
	}

}
