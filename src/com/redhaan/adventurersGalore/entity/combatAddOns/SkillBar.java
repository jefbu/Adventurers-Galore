package com.redhaan.adventurersGalore.entity.combatAddOns;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.Monster;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SkillBar extends GameObject {

	private static final long serialVersionUID = 1L;

	public SkillBar(Monster monster) {
		
		
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		int skillBarSize = gameContainer.getWidth() / 3;
		int xStartPoint = gameContainer.getWidth() / 2 - skillBarSize / 2;
		int yStartPoint = 5;
		renderer.drawRect(xStartPoint, yStartPoint, skillBarSize, GameManager.GAMETILESIZE, 0xff000000);
		
		renderer.drawRect(xStartPoint + 3, yStartPoint + 2, skillBarSize / 5, GameManager.GAMETILESIZE - 4, 0xff999999);
		renderer.drawRect(xStartPoint + skillBarSize / 5 + 5, yStartPoint + 2, skillBarSize / 5, GameManager.GAMETILESIZE - 4, 0xff999999);
		renderer.drawRect(xStartPoint + skillBarSize * 2 / 5 + 7, yStartPoint + 2, skillBarSize / 5, GameManager.GAMETILESIZE - 4, 0xff999999);
		renderer.drawRect(xStartPoint + skillBarSize * 3 / 5 + 9, yStartPoint + 2, skillBarSize / 5, GameManager.GAMETILESIZE - 4, 0xff999999);
		
		
		renderer.drawText("SKILL", xStartPoint + skillBarSize * 4 / 5 + 15, yStartPoint + GameManager.GAMETILESIZE / 3, 0xffdd8899);		
	
	}

	

}
