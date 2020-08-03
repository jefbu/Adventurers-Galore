package com.redhaan.adventurersGalore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurers;

public class SaveGame {
	
	public static void save() {
		
		try {
		
			FileOutputStream saveFile = new FileOutputStream("saveTest.sav");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			ArrayList<GameObject> savedGameObjects = GameManager.gameObjects;
			Adventurers savedAdventurers = GameManager.adventurers;
			
			save.writeObject(savedGameObjects);
			save.writeObject(savedAdventurers);
			
			save.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		
	}

}
