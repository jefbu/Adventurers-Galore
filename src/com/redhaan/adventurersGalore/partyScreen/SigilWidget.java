package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.SpellAnimation;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellType;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class SigilWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private boolean hover;
	private boolean potionHover;
	private int hoverX, hoverY;
	private ImageTile upgradeIcon;
	
	public SigilWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		hover = false;
		potionHover = false;
		hoverX = 0;
		hoverY = 0;
		upgradeIcon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.size() > 0 && 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(0).spell.spellType == SpellType.WorldMap &&
				checkHovering(offX + 5, offX + 5 + width - 35, offY + 5, offY + 5 + height / 4, gameContainer)) { 
			
			hover = true; 
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				SpellAnimation.activate(GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(0).spell, 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(0).spellModifier, 
						null, GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MAG);
			}
		}
		
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.size() > 1 && 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(1).spell.spellType == SpellType.WorldMap &&
				checkHovering(offX + 5, offX + 5 + width - 35, offY + 5 + (height / 4 + 5), offY + 5 + (height / 4 + 5) + height / 4, gameContainer)) { 
			hover = true; 
			
		}
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.size() > 2 && 
				GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(2).spell.spellType == SpellType.WorldMap &&
				checkHovering(offX + 5, offX + 5 + width - 35, offY + 5 + 2 * (height / 4 + 5), offY + 5 +  2 * (height / 4 + 5) + height / 4, gameContainer)) { hover = true; }
		else { hover = false; }
		
		
		
		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spellSlots > 0 && 
				checkHovering(offX + width - 25, offX + width, offY + 5, offY + 5 + height / 4, gameContainer)) { 
			potionHover = true; 
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { SigilChangeScreen.activeSpellSlot = 0; PartyScreen.subState = PartyScreenSubState.SigilChange; }
			}
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spellSlots > 1 && 
				checkHovering(offX + width - 25, offX + width, offY + 5 + (height / 4 + 5), offY + 5 + (height / 4 + 5) + height / 4, gameContainer)) { 
			potionHover = true; 
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { SigilChangeScreen.activeSpellSlot = 1; PartyScreen.subState = PartyScreenSubState.SigilChange; }
			}
		else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).spellSlots > 2 && 
				checkHovering(offX + width - 25, offX + width, offY + 5 + 2 * (height / 4 + 5), offY + 5 +  2 * (height / 4 + 5) + height / 4, gameContainer)) { 
			potionHover = true;
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { SigilChangeScreen.activeSpellSlot = 2; PartyScreen.subState = PartyScreenSubState.SigilChange; }
			}
		else { potionHover = false; }
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282028);
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.get(PartyScreen.member).spellSlots; i++) {
			
			renderer.drawRectOpaque(offX + 5, (offY + 5) +  i * (height / 4 + 5), width - 35, height / 4, 0xff584858);
			renderer.drawRectOpaque(offX + width - 25, (offY + 5) +  i * (height / 4 + 5), 20, height / 4, 0xffCCBBCC);
		}
		
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.size(); i++) {
			
			
			switch(GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(i).level) {
			case 1: renderer.drawImageTile(upgradeIcon, offX + 5, (offY) +  i * (height / 4 + 5), 1, 4); break;
			case 2: renderer.drawImageTile(upgradeIcon, offX + 5, (offY) +  i * (height / 4 + 5), 2, 4); break;
			case 3: renderer.drawImageTile(upgradeIcon, offX + 5, (offY) +  i * (height / 4 + 5), 3, 4); break;
			default: break;
			}
				
			renderer.drawText(
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(i).spellModifier.name + " " +  
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(i).spell.name, offX + 35, (offY + 10) +  i * (height / 4 + 5), 0xffCCBBCC);
		
			renderer.drawImageTile(upgradeIcon, offX + width - 30, (offY - 5) +  i * (height / 4 + 5), 0, 0);
		}
		
		
		if(potionHover) { renderer.drawImageTile(upgradeIcon, hoverX, hoverY, 0, 4); }
		if(hover) { renderer.drawRect(hoverX, hoverY, width - 33, height / 4 + 2, 0xff999999); }
		
	}
	
	
	
	private boolean checkHovering (int leftSide, int rightSide, int top, int bottom, GameContainer gameContainer) {
		
		if(gameContainer.getInput().getMouseX() > leftSide && gameContainer.getInput().getMouseX() < rightSide &&
				gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {
			hoverX = leftSide - 1;
			hoverY = top - 1;
			return true;
		} else { return false; }
		
	}
	
	
	

}
