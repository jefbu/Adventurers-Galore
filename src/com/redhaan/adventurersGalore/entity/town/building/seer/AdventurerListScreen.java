package com.redhaan.adventurersGalore.entity.town.building.seer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AdventurerListScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	
	protected boolean initialised;
	
	private ArrayList<String> list1, list2, list3, list4, list5, list6;
	private int xHero, yHero;
	
	private boolean infoActive;
	private boolean closeHover;
	
	private String informationToWrite;

	public AdventurerListScreen() {
		
		list1 = new ArrayList<String>();
		list2 = new ArrayList<String>();
		list3 = new ArrayList<String>();
		list4 = new ArrayList<String>();
		list5 = new ArrayList<String>();
		list6 = new ArrayList<String>();
		
		xHero = 0;
		yHero = 0;
		
		infoActive = false;
		closeHover = false;
		informationToWrite = "";
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (infoActive) {
			informationToWrite = AdventurerInfoText.updateTotalText();
			
			
			if (gameContainer.getInput().getMouseX() > 440 && gameContainer.getInput().getMouseX() < 470 &&
					gameContainer.getInput().getMouseY() > 370 && gameContainer.getInput().getMouseY() < 385) {				
				closeHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
					infoActive = false;
				}
			} else { closeHover = false; }
			
		}
		
		else {
		
			xHero = checkXHero(gameContainer);
			yHero = checkYHero(gameContainer);
			correctXandY();
			
			if (gameContainer.getInput().getMouseX() > 585 && gameContainer.getInput().getMouseX() < 615 &&
					gameContainer.getInput().getMouseY() > 395 && gameContainer.getInput().getMouseY() < 410) {
				closeHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					closeHover = false;
					initialised = false;
					TownMap.subState = TownSubState.General;
				}
			}
			
			else { 
				closeHover = false;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					infoActive = true;
					AdventurerInfoText.createTotalText(GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero));
				}			
			}
		}		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRectOpaque(25, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list1.size(); i++) { 
			renderer.drawText(list1.get(i), 40, 133 + i * 14, 0xffAA99DD); 
			}
		renderer.drawRectOpaque(125, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list2.size(); i++) { 
			renderer.drawText(list2.get(i), 140, 133 + i * 14, 0xffAA99DD); 
			}
		renderer.drawRectOpaque(225, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list3.size(); i++) { 
			renderer.drawText(list3.get(i), 240, 133 + i * 14, 0xffAA99DD); 
			}
		renderer.drawRectOpaque(325, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list4.size(); i++) { 
			renderer.drawText(list4.get(i), 340, 133 + i * 14, 0xffAA99DD); 
			}
		renderer.drawRectOpaque(425, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list5.size(); i++) { 
			renderer.drawText(list5.get(i), 440, 133 + i * 14, 0xffAA99DD); 
			}
		renderer.drawRectOpaque(525, 130, 95, 285, 0xff121621);
		for (int i = 0; i < list6.size(); i++) { 
			renderer.drawText(list6.get(i), 540, 133 + i * 14, 0xffAA99DD); 
			}
		
		renderer.drawRectOpaque(27 + xHero * 100, 135 + yHero * 14, 4, 4, 0xffDDFFFF);
		
		renderer.drawRectOpaque(585, 395, 30, 15, 0xffAA99DD);
		renderer.drawText("Close", 588, 398, 0xff121621);
		
		
		if (infoActive) {
			
			renderer.drawRectOpaque(140, 160, 340, 240, 0xff221111);
			renderer.drawRect(140, 160, 340, 240, 0xffAA7777);
			
			renderer.drawImageTile(GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).icon, 145, 165, 0, 0);
			renderer.drawText(GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).name, 185, 165, 0xffAA7777);
			renderer.drawText("Level: " + GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).getLevel(), 185, 175, 0xffAA7777);
			renderer.drawText(GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).job.name, 185, 185, 0xffAA7777);
			
			renderer.drawText(getNotableStats(), 260, 165, 0xffAA7777);
			renderer.drawText(getNotableSecondaryStats(), 260, 180, 0xffAA7777);
			
			renderer.drawText("Home town: " + GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).homeTown.name, 145, 230, 0xffAA7777);
			renderer.drawText("Current location: " + GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).homeTown.name, 145, 245, 0xffAA7777);
			renderer.drawText("Occupation: " + "Training", 315, 230, 0xffAA7777);
			renderer.drawText("Ambition: " + "Travel to Ymvernu", 315, 245, 0xffAA7777);
			
			renderer.drawText("Trust: " + "I could not scry how trusting they are of you.", 145, 270, 0xffAA7777);
			renderer.drawText("Compatibility: " + "They seem to be fairly compatible with your current party.", 145, 285, 0xffAA7777);
			
			renderer.drawText("I could not scry their ability levels", 145, 310, 0xffAA7777);
			renderer.drawText("They seem to be extremely talented as an adventurer", 145, 325, 0xffAA7777);
			
			renderer.drawText("I could not scry their political position", 145, 340, 0xffAA7777);
			
			
			
			renderer.drawRectOpaque(440, 370, 30, 15, 0xffAA7777);
			if (closeHover) { renderer.drawRect(440, 370, 30, 15, 0xff77AA77); } 
				else { renderer.drawRect(440, 370, 30, 15, 0xff221111); }
			renderer.drawText("Close", 443, 373, 0xff221111);
			
		}
		
		else {
			if (closeHover) { renderer.drawRect(585, 395, 30, 15, 0xff77AA77); } 
			else { renderer.drawRect(585, 395, 30, 15, 0xff121621); }
		}
	}
	
	
	private int checkXHero(GameContainer gameContainer) {
		
		int x = 0;
		
		if (gameContainer.getInput().getMouseX() < 120) { x = 0; }
		else if (gameContainer.getInput().getMouseX() < 220) { x = 1; }
		else if (gameContainer.getInput().getMouseX() < 320) { x = 2; }
		else if (gameContainer.getInput().getMouseX() < 420) { x = 3; }
		else if (gameContainer.getInput().getMouseX() < 520) { x = 4; }
		else { x = 5; }		
		
		return x;		
		
	}
	
	private int checkYHero(GameContainer gameContainer) {
		
		int y = 0;
		
		if (gameContainer.getInput().getMouseY() < 144) { y = 0; }
		else if (gameContainer.getInput().getMouseY() < 158) { y = 1; }
		else if (gameContainer.getInput().getMouseY() < 172) { y = 2; }
		else if (gameContainer.getInput().getMouseY() < 186) { y = 3; }
		else if (gameContainer.getInput().getMouseY() < 200) { y = 4; }
		else if (gameContainer.getInput().getMouseY() < 214) { y = 5; }
		else if (gameContainer.getInput().getMouseY() < 228) { y = 6; }
		else if (gameContainer.getInput().getMouseY() < 242) { y = 7; }
		else if (gameContainer.getInput().getMouseY() < 256) { y = 8; }
		else if (gameContainer.getInput().getMouseY() < 270) { y = 9; }
		else if (gameContainer.getInput().getMouseY() < 284) { y = 10; }
		else if (gameContainer.getInput().getMouseY() < 298) { y = 11; }
		else if (gameContainer.getInput().getMouseY() < 312) { y = 12; }
		else if (gameContainer.getInput().getMouseY() < 326) { y = 13; }
		else if (gameContainer.getInput().getMouseY() < 340) { y = 14; }
		else if (gameContainer.getInput().getMouseY() < 354) { y = 15; }
		else if (gameContainer.getInput().getMouseY() < 368) { y = 16; }
		else if (gameContainer.getInput().getMouseY() < 382) { y = 17; }
		else if (gameContainer.getInput().getMouseY() < 396) { y = 18; }			
		else { y = 19; }		
		
		return y;		
		
	}
	
	private void correctXandY() {
		
		if (list6.size() < 1 && xHero == 5) { xHero = 4; }
		if (list5.size() < 1 && xHero == 4) { xHero = 3; }
		if (list4.size() < 1 && xHero == 3) { xHero = 2; }
		if (list3.size() < 1 && xHero == 2) { xHero = 1; }
		if (list2.size() < 1 && xHero == 1) { xHero = 0; }
		
		switch (xHero) {
		
		case 0: if (list1.size() < 20) { if (yHero >= list1.size() ) { yHero = list1.size() - 1; } } break;
		case 1: if (list2.size() < 20) { if (yHero >= list2.size() ) { yHero = list2.size() - 1; } } break;
		case 2: if (list3.size() < 20) { if (yHero >= list3.size() ) { yHero = list3.size() - 1; } } break;
		case 3: if (list4.size() < 20) { if (yHero >= list4.size() ) { yHero = list4.size() - 1; } } break;
		case 4: if (list5.size() < 20) { if (yHero >= list5.size() ) { yHero = list5.size() - 1; } } break;
		case 5: if (list6.size() < 20) { if (yHero >= list6.size() ) { yHero = list6.size() - 1; } } break;
		
		
		}		
		
	}
	
	
	private String getNotableStats() {
		
		String text = "";
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.PHY < 10) { text = text + "low PHY  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.PHY > 20) { text = text + "high PHY  "; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.AGI < 10) { text = text + "low AGI  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.AGI > 20) { text = text + "high AGI  "; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.MAG < 10) { text = text + "low MAG  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.MAG > 20) { text = text + "high MAG  "; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.DEX < 10) { text = text + "low DEX  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.DEX > 20) { text = text + "high DEX  "; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.PRC < 10) { text = text + "low PRC  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.PRC > 20) { text = text + "high PRC  "; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.INT < 10) { text = text + "low INT  "; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.INT > 20) { text = text + "high INT  "; }
		
		return text;
		
	}
	
	private String getNotableSecondaryStats() {
		
		String text = "";
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.HP < 20) { text = text + "low HP"; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.PHY > 35) { text = text + "high HP"; }
		
		if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.MP < 20) { text = text + " low MP"; }
		else if (GameManager.adventurers.allAdventurers.get(xHero * 20 + yHero).maxStats.MP > 30) { text = text + " high MP"; }
		
		return text;
		
	}
	
	
	protected void initialise() {
		
		list1.clear();
		list2.clear();
		list3.clear();
		list4.clear();
		list5.clear();
		list6.clear();

		if (GameManager.adventurers.allAdventurers.size() < 21) {
			
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
		
		}
		
		else if (GameManager.adventurers.allAdventurers.size() < 41) {
			
			for (int i = 0; i < 20; i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
			for (int ii = 20; ii < GameManager.adventurers.allAdventurers.size(); ii++) {
				if (GameManager.adventurers.allAdventurers.get(ii).known) { list2.add(GameManager.adventurers.allAdventurers.get(ii).name); }
				else { list2.add("????????"); }
			}
						
		}
		
		else if (GameManager.adventurers.allAdventurers.size() < 61) {
			
			for (int i = 0; i < 20; i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
			for (int ii = 20; ii < 40; ii++) {
				if (GameManager.adventurers.allAdventurers.get(ii).known) { list2.add(GameManager.adventurers.allAdventurers.get(ii).name); }
				else { list2.add("????????"); }
			}
			for (int iii = 40; iii < GameManager.adventurers.allAdventurers.size(); iii++) {
				if (GameManager.adventurers.allAdventurers.get(iii).known) { list3.add(GameManager.adventurers.allAdventurers.get(iii).name); }
				else { list3.add("????????"); }
			}
						
		}
		
		else if (GameManager.adventurers.allAdventurers.size() < 81) {
			
			for (int i = 0; i < 20; i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
			for (int ii = 20; ii < 40; ii++) {
				if (GameManager.adventurers.allAdventurers.get(ii).known) { list2.add(GameManager.adventurers.allAdventurers.get(ii).name); }
				else { list2.add("????????"); }
			}
			for (int iii = 40; iii < 60; iii++) {
				if (GameManager.adventurers.allAdventurers.get(iii).known) { list3.add(GameManager.adventurers.allAdventurers.get(iii).name); }
				else { list3.add("????????"); }
			}
			for (int iv = 60; iv < GameManager.adventurers.allAdventurers.size(); iv++) {
				if (GameManager.adventurers.allAdventurers.get(iv).known) { list4.add(GameManager.adventurers.allAdventurers.get(iv).name); }
				else { list4.add("????????"); }
			}
						
		}
		
		else if (GameManager.adventurers.allAdventurers.size() < 101) {
			
			for (int i = 0; i < 20; i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
			for (int ii = 20; ii < 40; ii++) {
				if (GameManager.adventurers.allAdventurers.get(ii).known) { list2.add(GameManager.adventurers.allAdventurers.get(ii).name); }
				else { list2.add("????????"); }
			}
			for (int iii = 40; iii < 60; iii++) {
				if (GameManager.adventurers.allAdventurers.get(iii).known) { list3.add(GameManager.adventurers.allAdventurers.get(iii).name); }
				else { list3.add("????????"); }
			}
			for (int iv = 60; iv < 80; iv++) {
				if (GameManager.adventurers.allAdventurers.get(iv).known) { list4.add(GameManager.adventurers.allAdventurers.get(iv).name); }
				else { list4.add("????????"); }
			}
			for (int v = 80; v < GameManager.adventurers.allAdventurers.size(); v++) {
				if (GameManager.adventurers.allAdventurers.get(v).known) { list5.add(GameManager.adventurers.allAdventurers.get(v).name); }
				else { list5.add("????????"); }
			}
						
		}
		
		else {
			
			for (int i = 0; i < 20; i++) {
				if (GameManager.adventurers.allAdventurers.get(i).known) { list1.add(GameManager.adventurers.allAdventurers.get(i).name); }
				else { list1.add("????????"); }
			}
			for (int ii = 20; ii < 40; ii++) {
				if (GameManager.adventurers.allAdventurers.get(ii).known) { list2.add(GameManager.adventurers.allAdventurers.get(ii).name); }
				else { list2.add("????????"); }
			}
			for (int iii = 40; iii < 60; iii++) {
				if (GameManager.adventurers.allAdventurers.get(iii).known) { list3.add(GameManager.adventurers.allAdventurers.get(iii).name); }
				else { list3.add("????????"); }
			}
			for (int iv = 60; iv < 80; iv++) {
				if (GameManager.adventurers.allAdventurers.get(iv).known) { list4.add(GameManager.adventurers.allAdventurers.get(iv).name); }
				else { list4.add("????????"); }
			}
			for (int v = 80; v < 100; v++) {
				if (GameManager.adventurers.allAdventurers.get(v).known) { list5.add(GameManager.adventurers.allAdventurers.get(v).name); }
				else { list5.add("????????"); }
			}
			for (int vi = 100; vi < GameManager.adventurers.allAdventurers.size(); vi++) {
				if (GameManager.adventurers.allAdventurers.get(vi).known) { list6.add(GameManager.adventurers.allAdventurers.get(vi).name); }
				else { list6.add("????????"); }
			}
						
		}
		
		
		
		
		

		
	}
	
	
	
	
	

}
