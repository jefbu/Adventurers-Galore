package com.redhaan.adventurersGalore.titleScreen.titleMenu;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Rectangle extends GameObject {
	
	private static final long serialVersionUID = 1L;
	boolean active;
	int offX, offY;
	int width, height;
	int activeColor, passiveColor;
	String name;
	
	public Rectangle(String name, int offX, int offY, int width, int height) {
		active = false;
		this.name = name;
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		activeColor = 0xff117733;
		passiveColor = 0xff994422;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if(active) {
		renderer.drawRect(offX, offY, width, height, activeColor);
		renderer.drawText(name, offX + 30, offY + 10, activeColor);
		}
		else { renderer.drawRect(offX, offY, width, height, passiveColor); 
		renderer.drawText(name, offX + 30, offY + 10, passiveColor);
		}
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}
