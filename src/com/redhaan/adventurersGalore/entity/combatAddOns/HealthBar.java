package com.redhaan.adventurersGalore.entity.combatAddOns;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.Monster;

import gameEngine.ecclesiastes.Renderer;

public class HealthBar {

	public static void drawHealthBar(Monster monster, Renderer renderer) {

		int percentageHealthy = monster.currentStats.HP * 100 / monster.maxStats.HP;
		int greenSquare = (GameManager.GAMETILESIZE - 2) * percentageHealthy / 100;
		int redSquare = GameManager.GAMETILESIZE - 2 - greenSquare;

		renderer.drawRect(monster.getCombatX() * GameManager.GAMETILESIZE,
				monster.getCombatY() * GameManager.GAMETILESIZE + GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 3,
				0xff000000);

		renderer.drawRectOpaque(monster.getCombatX() * GameManager.GAMETILESIZE + 1,
				monster.getCombatY() * GameManager.GAMETILESIZE + GameManager.GAMETILESIZE + 1, redSquare, 1,
				0xffEE5533);

		renderer.drawRectOpaque(monster.getCombatX() * GameManager.GAMETILESIZE + 1 + redSquare,
				monster.getCombatY() * GameManager.GAMETILESIZE + GameManager.GAMETILESIZE + 1, greenSquare, 1,
				0xff55EE33);

	}

}
