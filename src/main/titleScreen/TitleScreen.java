package main.titleScreen;

import java.util.Random;

import main.Game;

public class TitleScreen {
	
	public TitleScreen() {
		
	}
	
	public void update() {
		System.out.println("titleScreen");
	}
	
	public void render() {
		Random random = new Random();
		Game.renderPixels[random.nextInt(Game.renderPixels.length)] = 0x00ffff00;
	}

}
