package com.redhaan.adventurersGalore.partyScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CommentWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	public static int timer;
	private String stringToBeDrawnFrom;
	private String stringToBeDrawn;
	
	public CommentWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		stringToBeDrawnFrom = "";
		stringToBeDrawn = "";
		timer = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (timer == 0) {
			stringToBeDrawn = "";
			stringToBeDrawnFrom = "";
			Random random = new Random();
			int roll = random.nextInt(GameManager.adventurers.allAdventurers.get(PartyScreen.member).titbit.strings.size());
			stringToBeDrawnFrom = GameManager.adventurers.allAdventurers.get(PartyScreen.member).titbit.strings.get(roll);
		}
		
		if(stringToBeDrawn.length() < stringToBeDrawnFrom.length()) {
			stringToBeDrawn = stringToBeDrawnFrom.substring(0, timer);
		}

		timer++;	
		if (timer > 180) { timer = 0; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282420);
		
		renderer.drawText(stringToBeDrawn, offX + 5, offY + 5, 0xffAA99BB);
		
	}

}
