package com.redhaan.adventurersGalore.entity.combatAddOns;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.SpellAnimation;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SpellOptions extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Adventurer adventurer;
	private int hoverOption;
	
	public SpellOptions(Adventurer adventurer) {
		
		this.adventurer = adventurer;
		hoverOption = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
				
		System.out.println("spell options being updated");
		
		checkHover(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());
		
		if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			switch(hoverOption) {
			case 0: break;
			case 1: 
				SpellAnimation.activate(adventurer.spells.get(0).spell, adventurer.spells.get(0).spellModifier); 
				adventurer.hasActed = true;
				adventurer.selected = false;
				break;
			case 2: break;
			case 3: break;
			}
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		System.out.println("spell options rendering");
		
		renderer.drawRectOpaque(200, 40, 250, 15 + 15 * adventurer.spellSlots, 0xff201133);
		if (adventurer.spells.size() > 0) { renderer.drawText(adventurer.spells.get(0).spellModifier.name + " " + adventurer.spells.get(0).spell.name, 205, 45, 0xff6899DD); }
		if (adventurer.spells.size() > 1) { renderer.drawText(adventurer.spells.get(1).spellModifier.name + " " + adventurer.spells.get(1).spell.name, 205, 60, 0xff6899DD); }
		if (adventurer.spells.size() > 2) { renderer.drawText(adventurer.spells.get(2).spellModifier.name + " " + adventurer.spells.get(2).spell.name, 205, 75, 0xff6899DD); }

		switch(hoverOption) {
		
		case 0: break;
		case 1: renderer.drawRect(203, 42, 244, 15, 0xffDDDDDD); break;
		case 2: renderer.drawRect(203, 57, 244, 15, 0xffDDDDDD); break;
		case 3: renderer.drawRect(203, 72, 244, 15, 0xffDDDDDD); break;
		
		}
		
	}
	
	
	private void checkHover(int x, int y) {
		
		if (x > 200 && x < 450) {
			
			if (y > 45 && y < 60 && adventurer.spells.size() > 0) { hoverOption = 1; }
			else if (y > 60 && y < 75 && adventurer.spells.size() > 1) { hoverOption = 2; } 
			else if (y > 75 && y < 90 && adventurer.spells.size() > 2) { hoverOption = 3; } 
			else { hoverOption = 0; }
	
		} 
		else { hoverOption = 0; }
		
	}
	
	
	
	
	
	
}
