package com.redhaan.adventurersGalore;

import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellEffect;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellModifier;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class SpellAnimation extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private ImageTile spellEffects;
	
	public static boolean active;
	private int timer;
	private int verticalGrowth;
	private int acceleration;
	private int flareAnimation;
	private int spellAnimation;
	private static int colour;
	private static Spell spell;
	private static SpellModifier spellModifier;
	
	public SpellAnimation() {
		
		spellEffects = new ImageTile("/spellEffects.png", GameManager.GAMETILESIZE * 6, GameManager.GAMETILESIZE * 6);
		
		active = false;
		timer = 0;
		verticalGrowth = 0;
		acceleration = 0;
		flareAnimation = 0;
		spellAnimation = 0;
		spell = Spell.oasis;
		colour = 0;
				
	}
		
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (active) {
			
			timer++;
			
			if (timer < 3) { acceleration = 2; }
			else if (timer < 6) { acceleration = 3; }
			else if (timer < 9) { acceleration = 4; }
			else { acceleration = 5; }
			
			if (verticalGrowth < 180) { verticalGrowth = verticalGrowth + acceleration; }
			
			if (timer < 30) { flareAnimation = 0; }
			else if (timer < 32) { flareAnimation = 1; }
			else if (timer < 34) { flareAnimation = 2; }
			else if (timer < 36) { flareAnimation = 3; }
			else if (timer < 38) { flareAnimation = 4; }
			else if (timer < 40) { flareAnimation = 5; }
			else if (timer < 42) { flareAnimation = 6; }
			else if (timer < 44) { flareAnimation = 7; }
			else if (timer < 46) { flareAnimation = 8; }
			else if (timer < 48) { flareAnimation = 9; }
			
			if (timer < 40) { spellAnimation = 0; }
			else if (timer < 50) { spellAnimation = 1; }
			else if (timer < 60) { spellAnimation = 2; }
			else if (timer < 70) { spellAnimation = 3; }
			else if (timer < 80) { spellAnimation = 4; }
			else if (timer < 90) { spellAnimation = 5; }
			else if (timer < 100) { spellAnimation = 6; }
			else if (timer < 110) { spellAnimation = 7; }
			else if (timer < 120) { spellAnimation = 8; }
			else if (timer < 130) { spellAnimation = 9; }
			else { 
				timer = 0; 
				verticalGrowth = 0;
				acceleration = 0;
				active = false; 
				SpellEffect.castSpell(spell, spellModifier);
				}
			
		}
			
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if (active) {
		
			renderer.drawRectOpaque(0, 240 - verticalGrowth, GameManager.GAMEWIDTH, verticalGrowth * 2, 0xff000000);
			renderer.drawRectOpaque(0, 240 - verticalGrowth / 4, GameManager.GAMEWIDTH, verticalGrowth / 2, colour);
						
			if (timer > 30) { renderer.drawImageTile(spellEffects, 215, 140, spellAnimation, spell.animationRow); }
			if (timer > 26 && timer < 50) { renderer.drawImageTile(spellEffects, 215, 140, flareAnimation, 0); }

		
		}
		
	}
	
	
	
	
	public static void activate(Spell spell, SpellModifier spellModifier) {
		
		SpellAnimation.spell = spell;
		SpellAnimation.spellModifier = spellModifier;
				
		switch(spellModifier.name) {
		
		case "Alabaster": colour = 0xffF2F0E6; break;
		case "Bone": colour = 0xffE3DAC9; break;
		case "Ivory": colour = 0xffFFFFF0; break;
		case "Amber": colour = 0xffFFBF00; break;
		case "Ochre": colour = 0xffCCC722; break;
		case "Honey": colour = 0xffEBAF4C; break;
		case "Aquamarine": colour = 0xff00FFBF; break;
		case "Cobalt": colour = 0xff00A674; break;
		case "Malachite": colour = 0xff008482; break;
		case "Scarlet": colour = 0xffFF2400; break;
		case "Crimson": colour = 0xffDC143C; break;
		case "Carmine": colour = 0xff960018; break;
		case "Viridian": colour = 0xff40826D; break;
		case "Chartreuse": colour = 0xffDFFF00; break;
		case "Olive": colour = 0xff708238; break;
		case "Azure": colour = 0xff007FFF; break;
		case "Cerulean": colour = 0xff007BA7; break;
		case "Indigo": colour = 0xff374874; break;
		case "Umber": colour = 0xff635147; break;
		case "Russet": colour = 0xff511D03; break;
		case "Tawny": colour = 0xff7E481C; break;
		case "Violet": colour = 0xff710193; break;
		case "Lilac": colour = 0xffB65FCF; break;
		case "Periwinkle": colour = 0xffBE93D4; break;
		case "Ebony": colour = 0xff080402; break;
		case "Charcoal": colour = 0xff28231D; break;
		case "Sable": colour = 0xff060606; break;
		
		
		}
		
		
		active = true;
		
		
		
	}
	
	
	

}
