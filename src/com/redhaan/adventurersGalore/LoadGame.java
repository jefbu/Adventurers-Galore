package com.redhaan.adventurersGalore;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurers;

public class LoadGame {
	
	@SuppressWarnings("unchecked")
	public static void load() {
		
		try{
			FileInputStream saveFile = new FileInputStream("saveTest.sav");

			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			ArrayList<GameObject> savedGameObjects = new ArrayList<GameObject>();
			Adventurers savedAdventurers = new Adventurers();
			
			savedGameObjects = (ArrayList<GameObject>) save.readObject();
			savedAdventurers = (Adventurers) save.readObject();
			
			GameManager.gameObjects = savedGameObjects;
			GameManager.adventurers = savedAdventurers;
			GameManager.gameState = GameState.WorldMap;

			save.close(); 
			}
		
			catch(Exception exc){
			}
		
	}

}
