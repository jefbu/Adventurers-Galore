package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Sigil;
import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellModifier;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class SigilChangeScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	private boolean hover;
	private int hoverX, hoverY, hoverWidth;
	private ImageTile icon;
	public static int activeSpellSlot;
	
	
	public SigilChangeScreen(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		hover = false;
		hoverX = 0;
		hoverY = 0;
		hoverWidth = 0;
		activeSpellSlot = 0;
		icon = new ImageTile("/spriteSheets/craftItems.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		hover = false;
		
		
		if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 40, offY + 56, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 63, offY + 79, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 86, offY + 102, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 109, offY + 125, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 132, offY + 148, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 155, offY + 171, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 178, offY + 194, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 201, offY + 217, width - 8, gameContainer)) { hover = true; }
		else if (checkHovering(offX + 5, offX + 5 + width - 10, offY + 224, offY + 240, width - 8, gameContainer)) { hover = true; }
		
		else if (checkHovering(offX + 310, offX + 310 + 80, offY + 257, offY + 257 + 20, 82, gameContainer)) { hover = true; }

		else { hover = false; }
		
			
		if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				
			if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 40 && gameContainer.getInput().getMouseY() < offY + 56) {
				if(Inventory.whitePotion > 0) { 
					Inventory.whitePotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.whitePotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}			
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 63 && gameContainer.getInput().getMouseY() < offY + 79) {
				if(Inventory.goldPotion > 0) { 
					Inventory.goldPotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.goldPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 86 && gameContainer.getInput().getMouseY() < offY + 102) {
				if(Inventory.tealPotion > 0) { 
					Inventory.tealPotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.tealPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 109 && gameContainer.getInput().getMouseY() < offY + 125) {
				if(Inventory.redPotion > 0) { 
					Inventory.redPotion--;
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.redPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 132 && gameContainer.getInput().getMouseY() < offY + 148) {
				if(Inventory.greenPotion > 0) { 
					Inventory.greenPotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.greenPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 155 && gameContainer.getInput().getMouseY() < offY + 171) {
				if(Inventory.bluePotion > 0) { 
					Inventory.bluePotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.bluePotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 178 && gameContainer.getInput().getMouseY() < offY + 194) {
				if(Inventory.brownPotion > 0) { 
					Inventory.brownPotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.brownPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 201 && gameContainer.getInput().getMouseY() < offY + 217) {
				if(Inventory.purplePotion > 0) { 
					Inventory.purplePotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.purplePotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			else if(gameContainer.getInput().getMouseX() > offX + 5 && gameContainer.getInput().getMouseX() < offX + width - 10 &&
					gameContainer.getInput().getMouseY() > offY + 224 && gameContainer.getInput().getMouseY() < offY + 240) {
				if(Inventory.blackPotion > 0) { 
					Inventory.blackPotion--; 
					try {
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.set(
								activeSpellSlot, Sigil.rollSigil(Potion.blackPotion, GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot)));
					} catch (Exception e) { 
						GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.add(Sigil.rollSigil(Potion.whitePotion, new Sigil(Spell.dummy, SpellModifier.alabaster)));
					}
				}
			}
			
			else if(gameContainer.getInput().getMouseX() > offX + 310 && gameContainer.getInput().getMouseX() < offX + 390
				&& gameContainer.getInput().getMouseY() > offY + 257 && gameContainer.getInput().getMouseY() < offY + 277) {
				PartyScreen.subState = PartyScreenSubState.Main;
			}
			
		}	
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRectOpaque(offX, offY, width, height, 0xf8252537);
		
		if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.size() > activeSpellSlot) {
			renderer.drawText("Replace current spell (" + 
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot).spellModifier.name + " " +
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).spells.get(activeSpellSlot).spell.name + ")?", offX + 10, offY + 10, 0xffAA8833);
		}
		else { renderer.drawText("Drink a potion to acquire a spell", offX + 10, offY + 10, 0xffAA8833); }

		renderer.drawText("(Attention: if you get the same spell as the one being replaced, it will get stronger)", offX + 10, offY + 20, 0xffAA8833);
		
		renderer.drawRectOpaque(offX, offY + 30, width, 1, 0xffAA8833);
		
		drawPotionBox(Potion.whitePotion, offX + 5, offY + 40, renderer);
			renderer.drawText("(" + Inventory.whitePotion + ")", offX + 95, offY + 45, 0xff252537);
		drawPotionBox(Potion.goldPotion, offX + 5, offY + 63, renderer);
			renderer.drawText("(" + Inventory.goldPotion + ")", offX + 95, offY + 68, 0xff252537);
		drawPotionBox(Potion.tealPotion, offX + 5, offY + 86, renderer);
			renderer.drawText("(" + Inventory.tealPotion + ")", offX + 95, offY + 91, 0xff252537);
		drawPotionBox(Potion.redPotion, offX + 5, offY + 109, renderer);
			renderer.drawText("(" + Inventory.redPotion + ")", offX + 95, offY + 114, 0xff252537);
		drawPotionBox(Potion.greenPotion, offX + 5, offY + 132, renderer);
			renderer.drawText("(" + Inventory.greenPotion + ")", offX + 95, offY + 137, 0xff252537);
		drawPotionBox(Potion.bluePotion, offX + 5, offY + 155, renderer);
			renderer.drawText("(" + Inventory.bluePotion + ")", offX + 95, offY + 160, 0xff252537);
		drawPotionBox(Potion.brownPotion, offX + 5, offY + 178, renderer);
			renderer.drawText("(" + Inventory.brownPotion + ")", offX + 95, offY + 183, 0xff252537);
		drawPotionBox(Potion.purplePotion, offX + 5, offY + 201, renderer);
			renderer.drawText("(" + Inventory.purplePotion + ")", offX + 95, offY + 206, 0xff252537);
		drawPotionBox(Potion.blackPotion, offX + 5, offY + 224, renderer);
			renderer.drawText("(" + Inventory.blackPotion + ")", offX + 95, offY + 229, 0xff252537);

		

			
		if(hover) { renderer.drawRect(hoverX, hoverY, hoverWidth, 20, 0xff999999); }
		
		
		renderer.drawRectOpaque(offX, offY + 250, width, 1, 0xFFAA8833);
		
		renderer.drawRectOpaque(offX + 310, offY + 257, 80, 18, 0xff332418);
		renderer.drawText("Cancel", offX + 335, offY + 263, 0xff887264);
						

	}
	
	
	private void drawPotionBox(Potion potion, int offX, int offY, Renderer renderer) {
		
		renderer.drawRectOpaque(offX, offY, width - 10, 18, 0xff686868);
		renderer.drawImageTile(icon, offX + 5, offY, potion.xTile, potion.yTile);
		renderer.drawText(potion.name, offX + 25, offY + 5, 0xff252537);
	
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
		

}
