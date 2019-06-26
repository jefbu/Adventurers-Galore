package main;

import main.adventurerMenu.AdventurerMenu;
import main.dungeonScreen.DungeonScreen;
import main.mapScreen.MapScreen;
import main.titleScreen.TitleScreen;
import utilities.GameStateValue;

public class GameState {
	
	AdventurerMenu adventurerMenu;
	DungeonScreen dungeonScreen;
	MapScreen mapScreen;
	TitleScreen titleScreen;
	
	public GameState() {
		adventurerMenu = new AdventurerMenu();
		dungeonScreen = new DungeonScreen();
		mapScreen = new MapScreen();
		titleScreen = new TitleScreen();
	}
	
	public void update(GameStateValue gameStateValue) {
		switch(gameStateValue) {
		case ADVENTURERMENU: adventurerMenu.update(); break;
		case DUNGEONSCREEN: dungeonScreen.update(); break;
		case MAPSCREEN: mapScreen.update(); break;
		case TITLESCREEN: titleScreen.update(); break;
		default: break;
		}
	}
	
	public void render(GameStateValue gameStateValue) {
		switch(gameStateValue) {
		case ADVENTURERMENU: adventurerMenu.render(); break;
		case DUNGEONSCREEN: dungeonScreen.render(); break;
		case MAPSCREEN: mapScreen.render(); break;
		case TITLESCREEN: titleScreen.render(); break;
		default: break;
		}
	}

}
