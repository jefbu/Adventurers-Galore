package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.TreasureChest;

public abstract class DungeonRoomFactory {
	
	static Random random = new Random();
	static ArrayList<DungeonRoom> list = new ArrayList<DungeonRoom>();
	
	public static ArrayList<DungeonRoom> createDungeonRooms(int dungeonLayoutType) {
		
		list.clear();
		
		switch(dungeonLayoutType) {
		
		case 1:
			list.add(new DungeonRoom(2, 99, 99, 99, 1, 0));
			list.add(new DungeonRoom(1, 99, 99, 8, 99, 2));
			break;
			
		case 2:
			list.add(new DungeonRoom(22, 1, 99, 99, 99, 0));
			list.add(new DungeonRoom(17, 4, 99, 0, 2, 1));
			list.add(new DungeonRoom(16, 3, 1, 99, 99, 0));
			list.add(new DungeonRoom(11, 99, 99, 2, 99, 0));
			list.add(new DungeonRoom(12, 7, 5, 1, 99, 1));
			list.add(new DungeonRoom(13, 6, 99, 99, 4, 0));
			list.add(new DungeonRoom(8, 99, 99, 5, 7, 1));
			list.add(new DungeonRoom(7, 99, 6, 4, 8, 1));
			list.add(new DungeonRoom(6, 9, 7, 99, 99, 0));
			list.add(new DungeonRoom(1, 99, 99, 8, 99, 2));
			break;
			
			
		}
		
		
		for (DungeonRoom room: list) {
			
			if(random.nextInt(100) > 1) { 
				TreasureChest treasureChest = new TreasureChest();
				treasureChest.setCombatX(random.nextInt(15) + 5);
				treasureChest.setCombatY(random.nextInt(11) + 2);
				room.hasTreasure = true;
				room.treasureChest = treasureChest;
			}
			
		}

		
		
		
		return list;
		
	}

}
