package com.redhaan.adventurersGalore.dungeon;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatMap;
import com.redhaan.adventurersGalore.entity.party.Party;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DungeonPopup extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private boolean visible;
	private boolean alreadyClicked;
	private Dungeon dungeon;
	public int timer;

	public DungeonPopup(Dungeon dungeon) {
		visible = false;
		alreadyClicked = false;
		this.dungeon = dungeon;
		timer = 60;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (timer < 300) { timer++; }
		
		if(Party.getxTile() == dungeon.xLocation && Party.getyTile() == dungeon.yLocation) {
			dungeon.discovered = true;
			if (timer == 300) { visible = true; }
		} else { alreadyClicked = false; }
		
		if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			if (gameContainer.getInput().getMouseX() > 400 && gameContainer.getInput().getMouseX() < 430 &&
					gameContainer.getInput().getMouseY() > 260 && gameContainer.getInput().getMouseY() < 270) {
				visible = false;
				alreadyClicked = true;
				timer = 0;
				Combat.dungeon = true;
				CombatMap combatMap = dungeon.dungeonRooms.get(0).dungeonMap;
				Combat.combatMap = combatMap;
				GameManager.gameState = GameState.Combat;
			}
			else if (gameContainer.getInput().getMouseX() > 350 && gameContainer.getInput().getMouseX() < 380 &&
					gameContainer.getInput().getMouseY() > 260 && gameContainer.getInput().getMouseY() < 270) {
				visible = false;
				alreadyClicked = true;
				timer = 0;
			}
		}

		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if (visible && !alreadyClicked) {
			renderer.drawRectOpaque(200, 200, 240, 80, 0xff001133);
			
			renderer.drawText("You have discovered a dungeon,", 210, 210, 0xff99AABB);
			renderer.drawText("would you like to enter?", 210, 220, 0xff99AABB);
			
			renderer.drawRectOpaque(400, 260, 30, 10, 0xff998888);
			renderer.drawText("Yes!", 403, 261, 0xff220000);
			renderer.drawRectOpaque(350, 260, 30, 10, 0xff889988);
			renderer.drawText("No...", 353, 261, 0xff002200);
			
		}

		
	}
	
	
	
	


}
