package com.redhaan.adventurersGalore.quest.questUI;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Portrait extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	public static ImageTile icon;
	public static String name;
	public static int xOffset;
	public static int yOffset;
	
	
	public Portrait() {
		
		icon = null;
		name = "";
		
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {		
		
	}
	

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		try { renderer.drawImageTile(icon, 60, 210, QuestUI.quest.requester.genderInt, 0); } catch (Exception e) { }
		try { renderer.drawText(name, 70, 260, 0xff996644); } catch (Exception e) { }

		
	}

}
