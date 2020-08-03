package com.redhaan.adventurersGalore;

import java.io.Serializable;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public abstract class GameObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private float posX, posY;
	private String tag;
	private int width, height;
	private boolean dead = false;
	
	public abstract void update(GameContainer gameContainer, float deltaTime);
	public abstract void render(GameContainer gameContainer, Renderer renderer);
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}

}
