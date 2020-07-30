package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skill;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SkillWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	private boolean hover;
	private int hoverX, hoverY;
	
	public SkillWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		hover = false;
		hoverX = 0;
		hoverY = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 0 && 
				checkHovering(offX + 5, offX + width - 5, offY + 5, offY + 5 + 15, width + 2, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 1 && 
				checkHovering(offX + 5, offX + width - 5, offY + 25, offY + 25 + 15, width + 2, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 2 && 
				checkHovering(offX + 5, offX + width - 5, offY + 45, offY + 45 + 15, width + 2, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 3 && 
				checkHovering(offX + 5, offX + width - 5, offY + 65, offY + 65 + 15, width + 2, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 4 && 
				checkHovering(offX + 5, offX + width - 5, offY + 85, offY + 85 + 15, width + 2, gameContainer)) { hover = true; }
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 5 && 
				checkHovering(offX + 5, offX + width - 5, offY + 105, offY + 105 + 15, width + 2, gameContainer)) { hover = true; }	
		else { hover = false; }


		if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 5 && gameContainer.getInput().getMouseY() < offY + 5 + 15) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(0);
				PartyScreen.skillNumber = 0;
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 25 && gameContainer.getInput().getMouseY() < offY + 25 + 15) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(1);
				PartyScreen.skillNumber = 1;
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 45 && gameContainer.getInput().getMouseY() < offY + 45 + 15
					&& GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 2) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(2);
				PartyScreen.skillNumber = 2;
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 65 && gameContainer.getInput().getMouseY() < offY + 65 + 15
					&& GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 3) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(3);
				PartyScreen.skillNumber = 3;
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 85 && gameContainer.getInput().getMouseY() < offY + 85 + 15
					&& GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 4) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(4);
				PartyScreen.skillNumber = 4;
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 5
					&& gameContainer.getInput().getMouseY() > offY + 105 && gameContainer.getInput().getMouseY() < offY + 105 + 15
					&& GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 5) {
				PartyScreen.subState = PartyScreenSubState.SkillChange;
				PartyScreen.skill = getNextActiveSkill(5);
				PartyScreen.skillNumber = 5;
			}

		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282420);
		
		if(hover) { renderer.drawRect(hoverX, hoverY, width - 8, 17, 0xff999999); }

		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 0) {
			renderer.drawRectOpaque(offX + 5, offY + 5, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(0).name, offX + 10, offY + 10, 0xff708090);
			renderer.drawText(translate(getNextActiveSkill(0).value), offX + 200, offY + 10, 0xff708090);
		}
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 1) {
			renderer.drawRectOpaque(offX + 5, offY + 25, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(1).name, offX + 10, offY + 30, 0xff708090);
			renderer.drawText(translate(getNextActiveSkill(1).value), offX + 200, offY + 30, 0xff708090);
		}
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 2) {
			renderer.drawRectOpaque(offX + 5, offY + 45, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(2).name, offX + 10, offY + 50, 0xff708090);	
			renderer.drawText(translate(getNextActiveSkill(2).value), offX + 200, offY + 50, 0xff708090);
		}
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 3) {
			renderer.drawRectOpaque(offX + 5, offY + 65, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(3).name, offX + 10, offY + 70, 0xff708090);
			renderer.drawText(translate(getNextActiveSkill(3).value), offX + 200, offY + 70, 0xff708090);
		}
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 4) {
			renderer.drawRectOpaque(offX + 5, offY + 85, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(4).name, offX + 10, offY + 90, 0xff708090);
			renderer.drawText(translate(getNextActiveSkill(4).value), offX + 200, offY + 90, 0xff708090);
		}
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots > 5) {
			renderer.drawRectOpaque(offX + 5, offY + 105, width - 10, 15, 0xff384853);
			renderer.drawText(getNextActiveSkill(5).name, offX + 10, offY +110, 0xff708090);
			renderer.drawText(translate(getNextActiveSkill(5).value), offX + 200, offY + 110, 0xff708090);
		}
		

		
	}
	
	
	private boolean checkHovering(int leftSide, int rightSide, int top, int bottom, int width, GameContainer gameContainer) {
		
		if(gameContainer.getInput().getMouseX() > leftSide && gameContainer.getInput().getMouseX() < rightSide &&
				gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {
			hoverX = leftSide - 1;
			hoverY = top - 1;
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
	
	
	private String translate(int value) {
		
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
	
	

}
