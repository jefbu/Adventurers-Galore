package com.redhaan.adventurersGalore.entity.adventurer;

import java.io.Serializable;

import com.redhaan.adventurersGalore.entity.item.Item;

public class Affinities implements Serializable {

	private static final long serialVersionUID = 1L;
	public int white = 0;
	public int yellow = 0;
	public int teal = 0;
	public int red = 0;
	public int green = 0;
	public int blue = 0;
	public int brown = 0;
	public int purple = 0;
	public int black = 0;
	
	
	public int highestAffinity() {
		
		int number = 0;
		
		if (white >= yellow && white >= teal && white >= red && white >= green && white >= blue && white >= brown && white >= purple && white >= black) { return 5; }
		else if (yellow >= white && yellow >= teal && yellow >= red && yellow >= green && yellow >= blue && yellow >= brown && yellow >= purple && yellow >= black) { return  3; }
		else if (teal >= white && teal >= yellow && teal >= red && teal >= green && teal >= blue && teal >= brown && teal >= purple && teal >= black) { return 4; }
		else if (red >= white && red >= yellow && red >= teal && red >= green && red >= blue && red >= brown && red >= purple && red >= black) { return 0; }
		else if (green >= white && green >= yellow && green >= teal && green >= red && green >= blue && green >= brown && green >= purple && green >= black) { return 1; }
		else if (blue >= white && blue >= yellow && blue >= teal && blue >= red && blue >= green && blue >= brown && blue >= purple && blue >= black) { return 2; }
		else if (brown >= white && brown >= yellow && brown >= teal && brown >= red && brown >= green && brown >= blue && brown >= purple && brown >= black) { return 7; }
		else if (purple >= white && purple >= yellow && purple >= teal && purple >= red && purple >= green && purple >= blue && purple >= brown && purple >= black) { return 6; }
		else if (black >= white && black >= yellow && black >= teal && black >= red && black >= green && black >= blue && black >= brown && black >= purple) { return 8; }
		
		else { System.out.println("Error at highest affinity calculation"); }
			
		return number;
		
	}
	
	
	public void calculateAffinites(Item oldItem, Item newItem) {

		if (oldItem.gemStone != null) {
			white -= oldItem.gemStone.whiteBonus;
			yellow -= oldItem.gemStone.yellowBonus;
			teal -= oldItem.gemStone.tealBonus;
			red -= oldItem.gemStone.redBonus;
			green -= oldItem.gemStone.greenBonus;
			blue -= oldItem.gemStone.blueBonus;
			brown -= oldItem.gemStone.brownBonus;
			purple -= oldItem.gemStone.purpleBonus;
			black -= oldItem.gemStone.blackBonus;
		}
		
		if (newItem.gemStone != null) {
			white += newItem.gemStone.whiteBonus;
			yellow += newItem.gemStone.yellowBonus;
			teal += newItem.gemStone.tealBonus;
			red += newItem.gemStone.redBonus;
			green += newItem.gemStone.greenBonus;
			blue += newItem.gemStone.blueBonus;
			brown += newItem.gemStone.brownBonus;
			purple += newItem.gemStone.purpleBonus;
			black += newItem.gemStone.blackBonus;
		}
		
		if (white < 0) { white = 0; }
		if (yellow < 0) { yellow = 0; }
		if (teal < 0) { teal = 0; }
		if (red < 0) { red = 0; }
		if (green < 0) { green = 0; }
		if (blue < 0) { blue = 0; }
		if (brown < 0) { brown = 0; }
		if (purple < 0) { purple = 0; }
		if (black < 0) { black = 0; }

		
		
	}
	
	

}
