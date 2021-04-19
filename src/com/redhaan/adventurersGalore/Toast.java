package com.redhaan.adventurersGalore;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Toast extends GameObject {

	private static final long serialVersionUID = 1L;
	public static boolean active;
	private static int offX, offY;
	private int timer;
	private boolean upwards;
	private static String text;
	private static int fillColour1, fillColour2, fillColour3, fillColour4, fillColour5, fillColour6, fillColour7, fillColour8, fillColour9;
	private static int textColour1, textColour2, textColour3, textColour4, textColour5, textColour6, textColour7, textColour8, textColour9;
	

	public Toast() {
		
		active = false;
		offX = 0;
		offY = 0;
		timer = 0;
		upwards = true;
		
		fillColour1 = 0xff000000;
		fillColour2 = 0xff000000;
		fillColour3 = 0xff000000;
		fillColour4 = 0xff000000;
		fillColour5 = 0xff000000;
		fillColour6 = 0xff000000;
		fillColour7 = 0xff000000;
		fillColour8 = 0xff000000;
		fillColour9 = 0xff000000;

		textColour1 = 0xff000000;
		textColour2 = 0xff000000;
		textColour3 = 0xff000000;
		textColour4 = 0xff000000;
		textColour5 = 0xff000000;
		textColour6 = 0xff000000;
		textColour7 = 0xff000000;
		textColour8 = 0xff000000;
		textColour9 = 0xff000000;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(active) {
			
			if (upwards) { timer++; }
			else { timer --; }
			
			if (timer == 45) { upwards = false; }
			else if (timer == 0) { upwards = true; active = false; }
			
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if(active) {
			
			if(timer > 30) {
				renderer.drawRect(offX, offY, 110, 30, textColour9);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour9);
				renderer.drawText(text, offX + 5, offY + 10, textColour9);
			}
			else if(timer > 25) {
				renderer.drawRect(offX, offY, 110, 30, textColour8);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour8);
				renderer.drawText(text, offX + 5, offY + 10, textColour8);
			}
			else if(timer > 20) {
				renderer.drawRect(offX, offY, 110, 30, textColour7);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour7);
				renderer.drawText(text, offX + 5, offY + 10, textColour7);
			}
			else if(timer > 16) {
				renderer.drawRect(offX, offY, 110, 30, textColour6);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour6);
				renderer.drawText(text, offX + 5, offY + 10, textColour6);
			}
			else if(timer > 12) {
				renderer.drawRect(offX, offY, 110, 30, textColour5);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour5);
				renderer.drawText(text, offX + 5, offY + 10, textColour5);
			}
			else if(timer > 9) {
				renderer.drawRect(offX, offY, 110, 30, textColour4);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour4);
				renderer.drawText(text, offX + 5, offY + 10, textColour4);
			}
			else if(timer > 6) {
				renderer.drawRect(offX, offY, 110, 30, textColour3);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour3);
				renderer.drawText(text, offX + 5, offY + 10, textColour3);
			}
			else if(timer > 3) {
				renderer.drawRect(offX, offY, 110, 30, textColour2);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour2);
				renderer.drawText(text, offX + 5, offY + 10, textColour2);
			}
			else if(timer > 0) {
				renderer.drawRect(offX, offY, 110, 30, textColour1);
				renderer.drawRectOpaque(offX + 1, offY + 1, 108, 28, fillColour1);
				renderer.drawText(text, offX + 5, offY + 10, textColour1);
			}

		}
		
	}
	
	public static void activate(boolean goodText, String text, int offX, int offY) {
		active = true;
		Toast.text = text;
		Toast.offX = offX;
		Toast.offY = offY;
		
		if(goodText) { 
			fillColour1 = 0x11448866;
			fillColour2 = 0x33448866; 
			fillColour3 = 0x55448866; 
			fillColour4 = 0x77448866; 
			fillColour5 = 0x99448866; 
			fillColour6 = 0xBB448866; 
			fillColour7 = 0xDD448866; 
			fillColour8 = 0xEE448866; 
			fillColour9 = 0xFF448866; 
			} 
		else { 
			fillColour1 = 0x11886644; 
			fillColour2 = 0x33886644; 
			fillColour3 = 0x55886644; 
			fillColour4 = 0x77886644; 
			fillColour5 = 0x99886644; 
			fillColour6 = 0xBB886644; 
			fillColour7 = 0xDD886644; 
			fillColour8 = 0xEE886644; 
			fillColour9 = 0xFF886644; 
			}
	
		
		if(goodText) { 
			textColour1 = 0x11115533; 
			textColour2 = 0x33115533; 
			textColour3 = 0x55115533; 
			textColour4 = 0x77115533; 
			textColour5 = 0x99115533; 
			textColour6 = 0xBB115533; 
			textColour7 = 0xDD115533; 
			textColour8 = 0xEE115533; 
			textColour9 = 0xFF115533; 
			} 
		else { 
			textColour1 = 0x11551133;
			textColour2 = 0x33551133;
			textColour3 = 0x55551133;
			textColour4 = 0x77551133;
			textColour5 = 0x99551133;
			textColour6 = 0xBB551133;
			textColour7 = 0xDD551133;
			textColour8 = 0xEE551133;
			textColour9 = 0xFF551133;
			}
	}
	
	
}
