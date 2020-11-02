package com.redhaan.adventurersGalore.titleScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.titleScreen.titleMenu.TitleMenu;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;
import gameEngine.ecclesiastes.gfx.Image;

public class TitleScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	Image titleScreen;
	CastleFlag castleFlag1;
	CastleFlag castleFlag2;
	CastleFlag castleFlag3;
	CastleFlag castleFlag4;
	TitleAdventurer knight;
	TitleAdventurer knight2;
	TitlePrincess princess;
	TitleMenu titleMenu;
	
	SoundClip titleSoundClip;
	private boolean soundStarted;

	public TitleScreen() {

		titleScreen = new Image("/titleScreen/titleScreenCastle.png");
		castleFlag1 = new CastleFlag(7, 4);
		castleFlag2 = new CastleFlag(11, 5);
		castleFlag3 = new CastleFlag(11, 2);
		castleFlag4 = new CastleFlag(13, 8);
		knight = new TitleAdventurer(5, 12);
		knight2 = new TitleAdventurer(16, 13);
		princess = new TitlePrincess(13, 3);
		
		titleMenu = new TitleMenu();
		
		titleSoundClip = new SoundClip("/titlescreen.wav");
		soundStarted = false;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {
		
		case Titlescreen:
			castleFlag1.update(gameContainer, deltaTime);
			castleFlag2.update(gameContainer, deltaTime);
			castleFlag3.update(gameContainer, deltaTime);
			castleFlag4.update(gameContainer, deltaTime);
			knight.update(gameContainer, deltaTime);
			knight2.update(gameContainer, deltaTime);
			princess.update(gameContainer, deltaTime);
			
			titleMenu.update(gameContainer, deltaTime);
			
			if(!soundStarted) { titleSoundClip.loop(); soundStarted = true; }
			
			break;
		
		case WorldMap: if (soundStarted) { titleSoundClip.stop(); titleSoundClip.close(); } break; 
		case InTown: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
			
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch (GameManager.gameState) {
		case Titlescreen:
			
			renderer.drawImage(titleScreen, 0, 0);
			castleFlag1.render(gameContainer, renderer);
			castleFlag2.render(gameContainer, renderer);
			castleFlag3.render(gameContainer, renderer);
			castleFlag4.render(gameContainer, renderer);
			knight.render(gameContainer, renderer);
			knight2.render(gameContainer, renderer);
			princess.render(gameContainer, renderer);
			
			titleMenu.render(gameContainer, renderer);
			break;
			
		case WorldMap: break;
		case InTown: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;

		}
	}

}
