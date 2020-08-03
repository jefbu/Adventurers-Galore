package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StatsWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;

	public StatsWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		GameManager.adventurers.allAdventurers.get(0).currentStats.PHY = 150;
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282224);

		
		renderer.drawText(" HP: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.HP, 25, 135, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.HP < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.HP) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.HP + ")", 65, 135, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.HP > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.HP) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.HP + ")", 65, 135, 0xffDDBBBB);
			}
			
		renderer.drawText(" MP: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MP, 105, 135, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MP < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MP) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MP + ")", 145, 135, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MP > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MP) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MP + ")", 145, 135, 0xffDDBBBB);
			}

		renderer.drawText("ATT: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.attack, 25, 150, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.attack < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.attack) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.attack + ")", 65, 150, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.attack > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.attack) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.attack + ")", 65, 150, 0xffDDBBBB);
			}
			
		renderer.drawText("DEF: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.defence, 25, 165, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.defence < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.defence) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.defence + ")", 65, 165, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.defence > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.defence) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.defence + ")", 65, 165, 0xffDDBBBB);
			}

		renderer.drawText("HIT: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.hit, 105, 150, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.hit < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.hit) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.hit + ")", 145, 150, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.hit > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.hit) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.hit + ")", 145, 150, 0xffDDBBBB);
			}	
			
		renderer.drawText("CRT: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.critical, 105, 165, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.critical < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.critical) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.critical + ")", 145, 165, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.critical > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.critical) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.critical + ")", 145, 165, 0xffDDBBBB);
			}	
			
		renderer.drawText("MOV: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.move, 25, 180, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.move < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.move) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.move + ")", 65, 180, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.move > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.move) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.move + ")", 65, 180, 0xffDDBBBB);
			}

			
			
		renderer.drawText("PHY: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PHY, 25, 210, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PHY < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PHY) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PHY + ")", 65, 210, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PHY > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PHY) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PHY + ")", 65, 210, 0xffDDBBBB);
			}	

		renderer.drawText("AGI: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.AGI, 25, 225, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.AGI < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.AGI) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.AGI + ")", 65, 225, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.AGI > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.AGI) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.AGI + ")", 65, 225, 0xffDDBBBB);
			}
			
		renderer.drawText("MAG: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MAG, 25, 240, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MAG < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MAG) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MAG + ")", 65, 240, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.MAG > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MAG) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.MAG + ")", 65, 240, 0xffDDBBBB);
			}
			
		renderer.drawText("DEX: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.DEX, 105, 210, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.DEX < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.DEX) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.DEX + ")", 145, 210, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.DEX > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.DEX) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.DEX + ")", 145, 210, 0xffDDBBBB);
			}
			
		renderer.drawText("INT: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.INT, 105, 225, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.INT < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.INT) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.INT + ")", 145, 225, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.INT > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.INT) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.INT + ")", 145, 225, 0xffDDBBBB);
			}
			
		renderer.drawText("PRC: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PRC, 105, 240, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PRC < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PRC) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PRC + ")", 145, 240, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.PRC > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PRC) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.PRC + ")", 145, 240, 0xffDDBBBB);
			}
			
			
			
		renderer.drawText("TST: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.TST, 25, 270, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.TST < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.TST) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.TST + ")", 65, 270, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.TST > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.TST) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.TST + ")", 65, 270, 0xffDDBBBB);
			}	
			
		renderer.drawText("FUN: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.FUN, 105, 270, 0xffBBBBBB);
			if(GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.FUN < GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.FUN) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.FUN + ")", 145, 270, 0xffBBDDBB);
			}
			else if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.FUN > GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.FUN) {
				renderer.drawText("(" + GameManager.adventurers.allAdventurers.get(PartyScreen.member).currentStats.FUN + ")", 145, 270, 0xffDDBBBB);
			}	
			
		renderer.drawText("Travel: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).maxStats.travelSpeed + " kmh", 25, 300, 0xffBBBBBB);
			
		renderer.drawText("Tier: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).tier, 25, 320, 0xffBBBBBB);
		
		}		
				

}
