package com.redhaan.adventurersGalore.entity.adventurer.spells;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.entity.town.Town;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TownList extends GameObject {
	
	public static boolean active;
	private int selectMultiplier;
	private boolean cancelHover;
	
	public TownList() {
		
		active = false;
		cancelHover = false;
		selectMultiplier = 0;
			
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (active) {
			
			checkHover(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseX(),
					gameContainer.getInput().getMouseY(), gameContainer.getInput().getMouseY());
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				
				if (cancelHover) { 	
					active = false;
					cancelHover = false;
					selectMultiplier = 100;
					Calendar.calendarSpeed = 1;
					Transition.nextGameState = GameState.WorldMap;
					GameManager.gameState = GameState.Transition;
				}

				if(selectMultiplier < 50) {
					
					switch(selectMultiplier) {
					
					case 0: Party.setxTile(Town.kaghak.xLocations[0]); Party.setyTile(Town.kaghak.yLocations[0]); active = false; break;
					case 1: Party.setxTile(Town.apastan.xLocations[0]); Party.setyTile(Town.apastan.yLocations[0]); active = false; break;
					case 2: Party.setxTile(Town.ydatopto.xLocations[0]); Party.setyTile(Town.ydatopto.yLocations[0]); active = false; break;
					case 3: Party.setxTile(Town.omichli.xLocations[0]); Party.setyTile(Town.omichli.yLocations[0]); active = false; break;
					case 4: Party.setxTile(Town.potami.xLocations[0]); Party.setyTile(Town.potami.yLocations[0]); active = false; break;
					case 5: Party.setxTile(Town.taranau.xLocations[0]); Party.setyTile(Town.taranau.yLocations[0]); active = false; break;
					case 6: Party.setxTile(Town.sioc.xLocations[0]); Party.setyTile(Town.sioc.yLocations[0]); active = false; break;
					case 7: Party.setxTile(Town.hasiera.xLocations[0]); Party.setyTile(Town.hasiera.yLocations[0]); active = false; break;
					case 8: Party.setxTile(Town.zuhaitz.xLocations[0]); Party.setyTile(Town.zuhaitz.yLocations[0]); active = false; break;
					case 9: Party.setxTile(Town.ymvernu.xLocations[0]); Party.setyTile(Town.ymvernu.yLocations[0]); active = false; break;
					case 10: Party.setxTile(Town.nuage.xLocations[0]); Party.setyTile(Town.nuage.yLocations[0]); active = false; break;
					case 11: Party.setxTile(Town.oakheart.xLocations[0]); Party.setyTile(Town.oakheart.yLocations[0]); active = false; break;
					case 12: Party.setxTile(Town.yarimon.xLocations[0]); Party.setyTile(Town.yarimon.yLocations[0]); active = false; break;
					case 13: Party.setxTile(Town.crystalCapital.xLocations[0]); Party.setyTile(Town.crystalCapital.yLocations[0]); active = false; break;
					case 14: Party.setxTile(Town.portSplendid.xLocations[0]); Party.setyTile(Town.portSplendid.yLocations[0]); active = false; break;
					case 15: Party.setxTile(Town.coldHarbour.xLocations[0]); Party.setyTile(Town.coldHarbour.yLocations[0]); active = false; break;
					case 16: Party.setxTile(Town.fingertip.xLocations[0]); Party.setyTile(Town.fingertip.yLocations[0]); active = false; break;
					case 17: Party.setxTile(Town.tradersPassage.xLocations[0]); Party.setyTile(Town.tradersPassage.yLocations[0]); active = false; break;
					case 18: Party.setxTile(Town.outpost.xLocations[0]); Party.setyTile(Town.outpost.yLocations[0]); active = false; break;
					case 19: Party.setxTile(Town.dorei.xLocations[0]); Party.setyTile(Town.dorei.yLocations[0]); active = false; break;
					case 20: Party.setxTile(Town.bastion.xLocations[0]); Party.setyTile(Town.bastion.yLocations[0]); active = false; break;
					case 21: Party.setxTile(Town.midori.xLocations[0]); Party.setyTile(Town.midori.yLocations[0]); active = false; break;
					case 22: Party.setxTile(Town.adrielruin.xLocations[0]); Party.setyTile(Town.adrielruin.yLocations[0]); active = false; break;
					case 23: Party.setxTile(Town.lothrain.xLocations[0]); Party.setyTile(Town.lothrain.yLocations[0]); active = false; break;
					case 24: Party.setxTile(Town.prucupad.xLocations[0]); Party.setyTile(Town.prucupad.yLocations[0]); active = false; break;		
					case 25: Party.setxTile(Town.smabarn.xLocations[0]); Party.setyTile(Town.smabarn.yLocations[0]); active = false; break;					
					default: System.out.println("error at town teleportation");
					
					}
					
					Calendar.calendarSpeed = 1;
				}
			}
		}		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if (active) {
			
			renderer.drawRectOpaque(260, 60, 160, 350, 0xff554422);
			renderer.drawText("Where do you want to fly to?", 270, 65, 0xffcc9966);
			
			if(Town.kaghak.discovered) { renderer.drawText("Kaghak", 270, 80, 0xff99cc66); }
			else { renderer.drawText("Kaghak", 270, 80, 0xffcc9966); }
			
			if(Town.apastan.discovered) { renderer.drawText("Apastan", 270, 92, 0xff99cc66); }
			else { renderer.drawText("Apastan", 270, 92, 0xffcc9966); }
			
			if(Town.ydatopto.discovered) { renderer.drawText("Ydatopto", 270, 104, 0xff99cc66); }
			else { renderer.drawText("Ydatopto", 270, 104, 0xffcc9966); }
			
			if(Town.omichli.discovered) { renderer.drawText("Omichli", 270, 116, 0xff99cc66); }
			else { renderer.drawText("Omichli", 270, 116, 0xffcc9966); }
			
			if(Town.potami.discovered) { renderer.drawText("Potami", 270, 128, 0xff99cc66); }
			else { renderer.drawText("Potami", 270, 128, 0xffcc9966); }
			
			if(Town.taranau.discovered) { renderer.drawText("Taranau", 270, 140, 0xff99cc66); }
			else { renderer.drawText("Taranau", 270, 140, 0xffcc9966); }
			
			if(Town.sioc.discovered) { renderer.drawText("Sioc", 270, 152, 0xff99cc66); }
			else { renderer.drawText("Sioc", 270, 152, 0xffcc9966); }
			
			if(Town.hasiera.discovered) { renderer.drawText("Hasiera", 270, 164, 0xff99cc66); }
			else { renderer.drawText("Hasiera", 270, 164, 0xffcc9966); }
			
			if(Town.zuhaitz.discovered) { renderer.drawText("Zuhaitz", 270, 176, 0xff99cc66); }
			else { renderer.drawText("Zuhaitz", 270, 176, 0xffcc9966); }
			
			if(Town.ymvernu.discovered) { renderer.drawText("Ymvernu", 270, 188, 0xff99cc66); }
			else { renderer.drawText("Ymvernu", 270, 188, 0xffcc9966); }
			
			if(Town.nuage.discovered) { renderer.drawText("Nuage", 270, 200, 0xff99cc66); }
			else { renderer.drawText("Nuage", 270, 200, 0xffcc9966); }
			
			if(Town.oakheart.discovered) { renderer.drawText("Oakheart", 270, 212, 0xff99cc66); }
			else { renderer.drawText("Oakheart", 270, 212, 0xffcc9966); }
			
			if(Town.yarimon.discovered) { renderer.drawText("Yarimon", 270, 224, 0xff99cc66); }
			else { renderer.drawText("Yarimon", 270, 224, 0xffcc9966); }
			
			if(Town.crystalCapital.discovered) { renderer.drawText("Crystal Capital", 270, 236, 0xff99cc66); }
			else { renderer.drawText("Crystal Capital", 270, 236, 0xffcc9966); }
			
			if(Town.portSplendid.discovered) { renderer.drawText("Port Splendid", 270, 248, 0xff99cc66); }
			else { renderer.drawText("Port Splendid", 270, 248, 0xffcc9966); }
			
			if(Town.coldHarbour.discovered) { renderer.drawText("Cold Harbour", 270, 260, 0xff99cc66); }
			else { renderer.drawText("Cold Harbour", 270, 260, 0xffcc9966); }
			
			if(Town.fingertip.discovered) { renderer.drawText("Fingertip", 270, 272, 0xff99cc66); }
			else { renderer.drawText("Fingertip", 270, 272, 0xffcc9966); }
			
			if(Town.tradersPassage.discovered) { renderer.drawText("Trader's Passage", 270, 284, 0xff99cc66); }
			else { renderer.drawText("Trader's Passage", 270, 284, 0xffcc9966); }
			
			if(Town.outpost.discovered) { renderer.drawText("Outpost", 270, 296, 0xff99cc66); }
			else { renderer.drawText("Outpost", 270, 296, 0xffcc9966); }
			
			if(Town.dorei.discovered) { renderer.drawText("Dorei", 270, 308, 0xff99cc66); }
			else { renderer.drawText("Dorei", 270, 308, 0xffcc9966); }
			
			if(Town.bastion.discovered) { renderer.drawText("Bastion", 270, 320, 0xff99cc66); }
			else { renderer.drawText("Bastion", 270, 320, 0xffcc9966); }
			
			if(Town.midori.discovered) { renderer.drawText("Midori", 270, 332, 0xff99cc66); }
			else { renderer.drawText("Midori", 270, 332, 0xffcc9966); }
			
			if(Town.adrielruin.discovered) { renderer.drawText("Adrielruin", 270, 344, 0xff99cc66); }
			else { renderer.drawText("Adrielruin", 270, 344, 0xffcc9966); }
			
			if(Town.lothrain.discovered) { renderer.drawText("Lothrain", 270, 356, 0xff99cc66); }
			else { renderer.drawText("Lothrain", 270, 356, 0xffcc9966); }
			
			if(Town.prucupad.discovered) { renderer.drawText("Prucupad", 270, 368, 0xff99cc66); }
			else { renderer.drawText("Prucupad", 270, 368, 0xffcc9966); }
			
			if(Town.smabarn.discovered) { renderer.drawText("Smabarn", 270, 380, 0xff99cc66); }
			else { renderer.drawText("Smabarn", 270, 380, 0xffcc9966); }
			
			renderer.drawRectOpaque(262, 82  + (selectMultiplier * 12), 5, 5, 0xff000000);
			
			renderer.drawRectOpaque(370, 392, 45, 15, 0xffcc9966);
			renderer.drawText("Cancel", 375, 395, 0xff554422);
			if (cancelHover) { renderer.drawRect(369, 391, 47, 17, 0xffeeaa88); }
			
		}
		
	}
	
	private void checkHover(int x1, int x2, int y1, int y2) {
		
		if (x1 > 260 && x2 < 420) {
			
			if (y1 > 80 && y2 < 92) { selectMultiplier = 0; }
			else if (y1 > 92 && y2 < 104) { selectMultiplier = 1; }
			else if (y1 > 104 && y2 < 116) { selectMultiplier = 2; }
			else if (y1 > 116 && y2 < 128) { selectMultiplier = 3; }
			else if (y1 > 128 && y2 < 140) { selectMultiplier = 4; }
			else if (y1 > 140 && y2 < 152) { selectMultiplier = 5; }
			else if (y1 > 152 && y2 < 164) { selectMultiplier = 6; }
			else if (y1 > 164 && y2 < 176) { selectMultiplier = 7; }
			else if (y1 > 176 && y2 < 188) { selectMultiplier = 8; }
			else if (y1 > 188 && y2 < 200) { selectMultiplier = 9; }
			else if (y1 > 200 && y2 < 212) { selectMultiplier = 10; }
			else if (y1 > 212 && y2 < 224) { selectMultiplier = 11; }
			else if (y1 > 224 && y2 < 236) { selectMultiplier = 12; }
			else if (y1 > 236 && y2 < 248) { selectMultiplier = 13; }
			else if (y1 > 248 && y2 < 260) { selectMultiplier = 14; }
			else if (y1 > 260 && y2 < 272) { selectMultiplier = 15; }
			else if (y1 > 272 && y2 < 284) { selectMultiplier = 16; }
			else if (y1 > 284 && y2 < 296) { selectMultiplier = 17; }	
			else if (y1 > 296 && y2 < 308) { selectMultiplier = 18; }	
			else if (y1 > 308 && y2 < 320) { selectMultiplier = 19; }	
			else if (y1 > 320 && y2 < 332) { selectMultiplier = 20; }	
			else if (y1 > 332 && y2 < 344) { selectMultiplier = 21; }	
			else if (y1 > 344 && y2 < 356) { selectMultiplier = 22; }	
			else if (y1 > 356 && y2 < 368) { selectMultiplier = 23; }	
			else if (y1 > 368 && y2 < 380) { selectMultiplier = 24; }	
			else if (y1 > 380 && y2 < 392) { selectMultiplier = 25; }
			else { selectMultiplier = 100; }
	
		} else { selectMultiplier = 100; }
		
		if (x1 > 370 && x1 < 415 && y1 > 392 && y2 < 407) {	cancelHover = true; } else { cancelHover = false; }
		
	}
	
	

}


/*
public static Town kaghak = new Town("Kaghak", new int[] { 14 }, new int[] { 11 }, 8);
public static Town apastan = new Town("Apastan", new int[] { 18 }, new int[] { 25 }, 1);
public static Town ydatopto = new Town("Ydatopto", new int[] { 8, 9, 8 }, new int[] { 54, 54, 55 }, 1);
public static Town omichli= new Town("Omichli", new int[] { 17 }, new int[] { 59 }, 1);
public static Town potami = new Town("Potami", new int[] { 5 }, new int[] { 62 }, 1);
public static Town taranau = new Town("Taranau", new int[] { 31 }, new int[] { 37 }, 1);
public static Town sioc = new Town("Sioc", new int[] { 27, 28 }, new int[] { 44, 44 }, 1);
public static Town hasiera = new Town("Hasiera", new int[] { 24 }, new int[] { 57 }, 1);
public static Town zuhaitz = new Town("Zuhaitz", new int[] { 23 }, new int[] { 67 }, 1);
public static Town ymvernu = new Town("Ymvernu", new int[] { 29 }, new int[] { 78 }, 1);
public static Town nuage = new Town("Nuage", new int[] { 40, 41 }, new int[] { 50, 50 }, 1);
public static Town oakheart = new Town("Oakheart", new int[] { 33 }, new int[] { 56 }, 1);
public static Town yarimon = new Town("Yarimon", new int[] { 13, 14 }, new int[] { 100, 100 }, 1);
public static Town crystalCapital = new Town("Crystal Capital", new int[] { 84, 85, 84 }, new int[] { 95, 95, 96 }, 1);
public static Town portSplendid = new Town("Port Splendid", new int[] { 71 }, new int[] { 93 }, 1);
public static Town coldHarbour = new Town("Cold Harbour", new int[] { 62 }, new int[] { 78 }, 1);
public static Town fingertip = new Town("Fingertip", new int[] { 55 }, new int[] { 102 }, 1);
public static Town tradersPassage = new Town("Trader's Passage", new int[] { 117 }, new int[] { 99 }, 1);
public static Town outpost = new Town("Outpost", new int[] { 144 }, new int[] { 106 }, 1);
public static Town dorei = new Town("Dorei", new int[] { 136 }, new int[] { 91 }, 1);
public static Town bastion = new Town("Bastion", new int[] { 118, 118, 119, 119 }, new int[] { 51, 52, 51, 52 }, 1);
public static Town midori = new Town("Midori", new int[] { 114, 115 }, new int[] { 34, 34 }, 1);
public static Town adrielruin = new Town("Adrielruin", new int[] { 75, 75, 76, 76 }, new int[] { 38, 39, 38, 39 }, 1);
public static Town lothrain = new Town("Lothrain", new int[] { 49 }, new int[] { 29 }, 1);
public static Town prucupad = new Town("Prucupad", new int[] { 66 }, new int[] { 18 }, 1);
public static Town smabarn = new Town("Smabarn", new int[] { 101 }, new int[] { 28 }, 1);
*/
