package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skill;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SkillChangeScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private boolean hover;
	private int hoverX, hoverY, hoverWidth;
	private boolean alreadyActive;
	private int timer;
	
	
	public SkillChangeScreen(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		hover = false;
		hoverX = 0;
		hoverY = 0;
		hoverWidth = 0;
		alreadyActive = false;
		timer = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		hover = false;
		
		if(alreadyActive) {
			timer++;
			if(timer > 45) { timer = 0; alreadyActive = false; }
		}
		
		if (checkHovering(offX + 5, offX + 130, offY + 40, offY + 60, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 40, offY + 60, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 40, offY + 60, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 65, offY + 85, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 65, offY + 85, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 65, offY + 85, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 90, offY + 110, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 90, offY + 110, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 90, offY + 110, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 115, offY + 135, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 115, offY + 135, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 115, offY + 135, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 140, offY + 160, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 140, offY + 160, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 140, offY + 160, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 165, offY + 185, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 165, offY + 185, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 165, offY + 185, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 130, offY + 190, offY + 210, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 135, offX + 260, offY + 190, offY + 210, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 265, offX + 390, offY + 190, offY + 210, 127, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 310, offX + 390, offY + 257, offY + 277, 82, gameContainer)) { hover = true; }
		else { hover = false; }
		
			
		if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {			
			
			if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 40, offY + 60, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 40, offY + 60, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.axe)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.axe); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 40, offY + 60, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger); }			

			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 65, offY + 85, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 65, offY + 85, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 65, offY + 85, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow); }
			
			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 90, offY + 110, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.trapping)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.trapping); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 90, offY + 110, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.fishing)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.fishing); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 90, offY + 110, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.foraging)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.foraging); }
			
			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 115, offY + 135, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.camping)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.camping); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 115, offY + 135, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.cooking)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.cooking); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 115, offY + 135, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.lockpick)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.lockpick); }

			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 140, offY + 160, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.pickpocket)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.pickpocket); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 140, offY + 160, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.stealth)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.stealth); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 140, offY + 160, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.entertaining)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.entertaining); }
			
			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 165, offY + 185, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.haggling)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.haggling); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 165, offY + 185, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.decorum)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.decorum); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 165, offY + 185, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.crafting)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.crafting); }
			
			else if(clickedOnSkill(gameContainer, offX + 5, offX + 130, offY + 190, offY + 210, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.alchemy)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.alchemy); }
			
			else if(clickedOnSkill(gameContainer, offX + 135, offX + 260, offY + 190, offY + 210, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.medicine)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.medicine); }
			
			else if(clickedOnSkill(gameContainer, offX + 265, offX + 390, offY + 190, offY + 210, GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.weaponSmith)) {
				changeSkill(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.weaponSmith); }
				
			
			else if(gameContainer.getInput().getMouseX() > offX + 310 && gameContainer.getInput().getMouseX() < offX + 390
				&& gameContainer.getInput().getMouseY() > offY + 257 && gameContainer.getInput().getMouseY() < offY + 277) {
				PartyScreen.subState = PartyScreenSubState.Main;
			}
			
			
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRectOpaque(offX, offY, width, height, 0xf8252537);
		
		renderer.drawText("Replace active skill: '" + PartyScreen.skill.name + "'?", offX + 10, offY + 10, 0xffAA8833);
		renderer.drawText("(Attention: the skill level of the active skill will go down)", offX + 10, offY + 20, 0xffAA8833);
		
		renderer.drawRectOpaque(offX, offY + 30, width, 1, 0xffAA8833);
		
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword, offX + 5, offY + 40, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.axe, offX + 135, offY + 40, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger, offX + 265, offY + 40, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff, offX + 5, offY + 65, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear, offX + 135, offY + 65, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow, offX + 265, offY + 65, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.trapping, offX + 5, offY + 90, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.fishing, offX + 135, offY + 90, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.foraging, offX + 265, offY + 90, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.camping, offX + 5, offY + 115, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.cooking, offX + 135, offY + 115, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.lockpick, offX + 265, offY + 115, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.pickpocket, offX + 5, offY + 140, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.stealth, offX + 135, offY + 140, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.entertaining, offX + 265, offY + 140, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.haggling, offX + 5, offY + 165, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.decorum, offX + 135, offY + 165, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.crafting, offX + 265, offY + 165, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.alchemy, offX + 5, offY + 190, renderer);
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.medicine, offX + 135, offY + 190, renderer);			
		drawSkillBox(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.weaponSmith, offX + 265, offY + 190, renderer);			

			
		if(hover) { renderer.drawRect(hoverX, hoverY, hoverWidth, 22, 0xff999999); }
		
		
		renderer.drawRectOpaque(offX, offY + 250, width, 1, 0xFFAA8833);
		
		renderer.drawRectOpaque(offX + 310, offY + 257, 80, 20, 0xff332418);
		renderer.drawText("Cancel", offX + 335, offY + 263, 0xff887264);
		
		if(alreadyActive) { renderer.drawText("This skill is already an active skill", offX + 10, offY + 263, 0xff884545); }
		
		

	}
	
	
	private void drawSkillBox(Skill skill, int offX, int offY, Renderer renderer) {
		
		renderer.drawRectOpaque(offX, offY, 125, 20, 0xff686868);
			renderer.drawText(skill.name, offX + 5, offY + 5, 0xff252537);
			renderer.drawText(translate(skill.value), offX + 65, offY + 5, pickColour(skill.value));
	
	}
	
	private boolean checkHovering(int leftSide, int rightSide, int top, int bottom, int width, GameContainer gameContainer) {
		
		if(gameContainer.getInput().getMouseX() > leftSide && gameContainer.getInput().getMouseX() < rightSide &&
				gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {
			hoverX = leftSide - 1;
			hoverY = top - 1;
			hoverWidth = width;
			return true;
		} else { return false; }
		
	}
	
	
	
	private Skill getNextActiveSkill(int order) {
		
		int numbersFound = 0;
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.sword; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.axe.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.axe; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.dagger; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.staff; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.spear; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.bow; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.trapping.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.trapping; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.fishing.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.fishing; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.foraging.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.foraging; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.camping.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.camping; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.cooking.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.cooking; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.lockpick.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.lockpick; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.pickpocket.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.pickpocket; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.stealth.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.stealth; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.entertaining.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.entertaining; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.haggling.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.haggling; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.decorum.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.decorum; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.crafting.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.crafting; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.alchemy.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.alchemy; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.medicine.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.medicine; } else { numbersFound++; }
		}
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.weaponSmith.activeSkill) { 
			if (order == numbersFound) { return GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.weaponSmith; } else { numbersFound++; }
		}
		
		return null;				
	}
	
	
	private void changeSkill(Skill skill) {
		
		getNextActiveSkill(PartyScreen.skillNumber).value--;
		getNextActiveSkill(PartyScreen.skillNumber).value--;
		if(getNextActiveSkill(PartyScreen.skillNumber).value < 0) { getNextActiveSkill(PartyScreen.skillNumber).value = 0; }
		
		getNextActiveSkill(PartyScreen.skillNumber).activeSkill = false;
		skill.activeSkill = true;
		
		PartyScreen.subState = PartyScreenSubState.Main;
		
	}
	
	private boolean clickedOnSkill(GameContainer gameContainer, int left, int right, int top, int bottom, Skill skill) {
		
		if(gameContainer.getInput().getMouseX() > left && gameContainer.getInput().getMouseX() < right
				&& gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {		
			if(!skill.activeSkill) { return true; } else { alreadyActive = true; }
		}
		return false;
	}
	
	
	
	private String translate (int value) {
		
		switch(value) {
		
		case 0: return "Dummy";
		case 1: return "Basic";
		case 2: return "Intermediate";
		case 3: return "Advanced";
		case 4: return "Expert";
		case 5: return "Master";
		default: return "Error";
		
		}
		
	}
	
	private int pickColour(int value) {
		
		switch(value) {
		
		case 0: return 0xff551122;
		case 1: return 0xff441133;
		case 2: return 0xff332244;
		case 3: return 0xff224444;
		case 4: return 0xff114433;
		case 5: return 0xff115522;
		default: return 0xffFFFFFF;
		
		}
		
	}
	
	
	
	

}
