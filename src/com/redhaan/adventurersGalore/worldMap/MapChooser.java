package com.redhaan.adventurersGalore.worldMap;

public class MapChooser {

	public MapChooser() {
		
	}
	
	public int chooseMap(boolean downwards, int currentMap, int xLocation, int yLocation) {
		
		switch(currentMap) {
		
		case 0: if(downwards) {
			if(xLocation < 321 && yLocation < 241) { return 1; }
			if(xLocation > 320 && yLocation < 241) { return 2; }
			if(xLocation < 321 && yLocation > 240) { return 3; }
			if(xLocation > 320 && yLocation > 240) { return 4; }
		}
		case 1: if(!downwards) { return 0; }
			if(xLocation < 321 && yLocation < 241) { return 5; }
			if(xLocation > 320 && yLocation < 241) { return 6; }
			if(xLocation < 321 && yLocation > 240) { return 7; }
			if(xLocation > 320 && yLocation > 240) { return 8; }

		case 2: if(!downwards) { return 0; }
			if(xLocation < 321 && yLocation < 241) { return 9; }
			if(xLocation > 320 && yLocation < 241) { return 10; }
			if(xLocation < 321 && yLocation > 240) { return 11; }
			if(xLocation > 320 && yLocation > 240) { return 12; }
	
		case 3: if(!downwards) { return 0; }
			if(xLocation < 321 && yLocation < 241) { return 13; }
			if(xLocation > 320 && yLocation < 241) { return 14; }
			if(xLocation < 321 && yLocation > 240) { return 15; }
			if(xLocation > 320 && yLocation > 240) { return 16; }
			
		case 4: if(!downwards) { return 0; }
			if(xLocation < 321 && yLocation < 241) { return 17; }
			if(xLocation > 320 && yLocation < 241) { return 18; }
			if(xLocation < 321 && yLocation > 240) { return 19; }
			if(xLocation > 320 && yLocation > 240) { return 20; }
			
		case 5: if(!downwards) { return 1; }
			if(xLocation < 321 && yLocation < 241) { return 21; }
			if(xLocation > 320 && yLocation < 241) { return 22; }
			if(xLocation < 321 && yLocation > 240) { return 23; }
			if(xLocation > 320 && yLocation > 240) { return 24; }
			
		case 6: if(!downwards) { return 1; }
		case 7: if(!downwards) { return 1; }
		case 8: if(!downwards) { return 1; }
		
		
		case 9: if(!downwards) { return 2; }
		case 10: if(!downwards) { return 2; }
		case 11: if(!downwards) { return 2; }
		case 12: if(!downwards) { return 2; }
		
		case 13: if(!downwards) { return 3; }
		case 14: if(!downwards) { return 3; }
		case 15: if(!downwards) { return 3; }
		case 16: if(!downwards) { return 3; }
		
		case 17: if(!downwards) { return 4; }
		case 18: if(!downwards) { return 4; }
		case 19: if(!downwards) { return 4; }
		case 20: if(!downwards) { return 4; }
		
		case 21: if(!downwards) { return 5; }
		case 22: if(!downwards) { return 5; }
		case 23: if(!downwards) { return 5; }
		case 24: if(!downwards) { return 5; }
		
		case 25: if(!downwards) { return 6; }
		case 26: if(!downwards) { return 6; }
		case 27: if(!downwards) { return 6; }
		case 28: if(!downwards) { return 6; }
		
		case 29: if(!downwards) { return 7; }
		case 30: if(!downwards) { return 7; }
		case 31: if(!downwards) { return 7; }
		case 32: if(!downwards) { return 7; }
		
		case 33: if(!downwards) { return 8; }
		case 34: if(!downwards) { return 8; }
		case 35: if(!downwards) { return 8; }
		case 36: if(!downwards) { return 8; }
		
		case 37: if(!downwards) { return 9; }
		case 38: if(!downwards) { return 9; }
		case 39: if(!downwards) { return 9; }
		case 40: if(!downwards) { return 9; }
		
		case 41: if(!downwards) { return 10; }
		case 42: if(!downwards) { return 10; }
		case 43: if(!downwards) { return 10; }
		case 44: if(!downwards) { return 10; }
		
		case 45: if(!downwards) { return 11; }
		case 46: if(!downwards) { return 11; }
		case 47: if(!downwards) { return 11; }
		case 48: if(!downwards) { return 11; }
		
		case 49: if(!downwards) { return 12; }
		case 50: if(!downwards) { return 12; }
		case 51: if(!downwards) { return 12; }
		case 52: if(!downwards) { return 12; }
		
		case 53: if(!downwards) { return 13; }
		case 54: if(!downwards) { return 13; }
		case 55: if(!downwards) { return 13; }
		case 56: if(!downwards) { return 13; }
		
		case 57: if(!downwards) { return 14; }
		case 58: if(!downwards) { return 14; }
		case 59: if(!downwards) { return 14; }
		case 60: if(!downwards) { return 14; }
		
		case 61: if(!downwards) { return 15; }
		case 62: if(!downwards) { return 15; }
		case 63: if(!downwards) { return 15; }
		case 64: if(!downwards) { return 15; }
		
		case 65: if(!downwards) { return 16; } 
		case 66: if(!downwards) { return 16; }
		case 67: if(!downwards) { return 16; }
		case 68: if(!downwards) { return 16; }
		
		case 69: if(!downwards) { return 17; }
		case 70: if(!downwards) { return 17; }
		case 71: if(!downwards) { return 17; }
		case 72: if(!downwards) { return 17; }
		
		case 73: if(!downwards) { return 18; }
		case 74: if(!downwards) { return 18; }
		case 75: if(!downwards) { return 18; }
		case 76: if(!downwards) { return 18; }
		
		case 77: if(!downwards) { return 19; }
		case 78: if(!downwards) { return 19; }
		case 79: if(!downwards) { return 19; }
		case 80: if(!downwards) { return 19; }
		
		case 81: if(!downwards) { return 20; }
		case 82: if(!downwards) { return 20; }
		case 83: if(!downwards) { return 20; }
		case 84: if(!downwards) { return 20; }
			
		}
		
		
		
		
		
		
		return 0;
		
	}
	
	
	
	
	
	
	
}
