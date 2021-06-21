package com.redhaan.adventurersGalore.entity.adventurer.spells;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class SpellEffect {
	
	
	public static void castSpell(Spell spell, SpellModifier spellModifier) {
		
		switch(spell.name) {
		
		case "Bountiful Vineyard":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && adventurer.maxStats.TST < 100) {
					adventurer.currentStats.TST++;
					adventurer.maxStats.TST++;
				}
			}
			GameManager.gameState = GameState.WorldMap;
			Toast.activate(true, "Party Trust Up!", 280, 50);
			break;
			
		case "Skies of Longing Vagabonds":
			Calendar.calendarSpeed = 0;
			Transition.nextGameState = GameState.WorldMap;
			GameManager.gameState = GameState.Transition;
			TownList.active = true;
			break;
			
		case "Volcano of Swallowing Ash":
			System.out.println("Booooom");
			break;
			
		case "Library of Maddening Wisdom":
			break;
		
		
		
		
		}
		
		
	}
	

}
