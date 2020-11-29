package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.Brigandine;
import com.redhaan.adventurersGalore.entity.item.armour.Hauberk;
import com.redhaan.adventurersGalore.entity.item.armour.Jousting;
import com.redhaan.adventurersGalore.entity.item.armour.Lamellar;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.GloriousMoment;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.MorningSunlight;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.PentUpAnger;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.SpringBreeze;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourTier4 extends GameObject {
	
	
	private static final long serialVersionUID = 1L;

	private Brigandine brigandine;
	private Lamellar lamellar;
	private Hauberk hauberk;
	private Jousting jousting;
	
	private Hide hide;
	private Pelt pelt;
	private NobleSpirit nobleSpirit;
	private EvilSpirit evilSpirit;
	private VagrantSpirit vagrantSpirit;
	private SpringBreeze springBreeze;
	private MorningSunlight morningSunlight;
	private PentUpAnger pentupAnger;
	private GloriousMoment gloriousMoment;
	private Silver silver;
	private Iron iron;
	
	private int hoverOption;

	public ArmourTier4() {
		
		brigandine = new Brigandine();
		lamellar = new Lamellar();
		hauberk = new Hauberk();
		jousting = new Jousting();
		hide = new Hide();
		pelt = new Pelt();
		silver = new Silver();
		iron = new Iron();
		nobleSpirit = new NobleSpirit();
		evilSpirit = new EvilSpirit();
		vagrantSpirit = new VagrantSpirit();
		springBreeze = new SpringBreeze();
		morningSunlight = new MorningSunlight();
		pentupAnger = new PentUpAnger();
		gloriousMoment = new GloriousMoment();

		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.pelt >= 8 && Inventory.nobleSpirit >= 1 && Inventory.springBreeze >= 1) { 
					Inventory.armours.add(new Brigandine());
					Inventory.pelt -= 8;
					Inventory.nobleSpirit -= 1;
					Inventory.springBreeze -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 200 && gameContainer.getInput().getMouseY() < 240) {
			
			hoverOption = 2;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.hide >= 8 && Inventory.evilSpirit >= 1 && Inventory.morningSunlight >= 1) { 
					Inventory.armours.add(new Lamellar());
					Inventory.hide -= 8;
					Inventory.evilSpirit -= 1;
					Inventory.morningSunlight -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 245 && gameContainer.getInput().getMouseY() < 285) {
			
			hoverOption = 3;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.iron >= 5 && Inventory.vagrantSpirit >= 1 && Inventory.pentupAnger >= 1) { 
					Inventory.armours.add(new Hauberk());
					Inventory.iron -= 5;
					Inventory.vagrantSpirit -= 1;
					Inventory.pentupAnger -= 1;
				}
			}
			
		}
		
		else if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 290 && gameContainer.getInput().getMouseY() < 330) {
			
			hoverOption = 4;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.silver >= 5 && Inventory.nobleSpirit >= 1 && Inventory.gloriousMoment >= 1) { 
					Inventory.armours.add(new Jousting());
					Inventory.silver -= 5;
					Inventory.nobleSpirit -= 1;
					Inventory.gloriousMoment -= 1;
				}
			}
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(brigandine.icon, 35, 160, brigandine.xTile, brigandine.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(brigandine.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(pelt.icon, 162, 167, pelt.xTile, pelt.yTile);
			renderer.drawText("8", 185, 171, 0xff886622);
			if(Inventory.pelt >= 8) { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.pelt + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(nobleSpirit.icon, 237, 167, nobleSpirit.xTile, nobleSpirit.yTile);
			renderer.drawText("1", 260, 171, 0xff886622);
			if(Inventory.nobleSpirit >= 1) { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(springBreeze.icon, 312, 167, springBreeze.xTile, springBreeze.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.springBreeze >= 1) { renderer.drawText("(" + Inventory.springBreeze + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.springBreeze + ")", 342, 171, 0xff774422); }
		
		renderer.drawRectOpaque(30, 200, 570, 40, 0xff181205);
			renderer.drawImageTile(lamellar.icon, 35, 205, lamellar.xTile, lamellar.yTile);
			renderer.drawRectOpaque(70, 205, 80, 30, 0xff231911);
			renderer.drawText(lamellar.name, 75, 215, 0xff685245);
			
			renderer.drawRectOpaque(155, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(hide.icon, 162, 212, hide.xTile, hide.yTile);
			renderer.drawText("8", 185, 216, 0xff886622);
			if(Inventory.hide >= 8) { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.hide + ")", 192, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(evilSpirit.icon, 237, 212, evilSpirit.xTile, evilSpirit.yTile);
			renderer.drawText("1", 260, 216, 0xff886622);
			if(Inventory.evilSpirit >= 1) { renderer.drawText("(" + Inventory.evilSpirit + ")", 267, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.evilSpirit + ")", 267, 216, 0xff774422); }	
			
			renderer.drawRectOpaque(305, 205, 70, 30, 0xff231911);
			renderer.drawImageTile(morningSunlight.icon, 312, 212, morningSunlight.xTile, morningSunlight.yTile);
			renderer.drawText("1", 335, 216, 0xff886622);
			if(Inventory.morningSunlight >= 1) { renderer.drawText("(" + Inventory.morningSunlight + ")", 342, 216, 0xff447722); }
			else { renderer.drawText("(" + Inventory.morningSunlight + ")", 342, 216, 0xff774422); }	
			
		renderer.drawRectOpaque(30, 245, 570, 40, 0xff181205);
			renderer.drawImageTile(hauberk.icon, 35, 250, hauberk.xTile, hauberk.yTile);
			renderer.drawRectOpaque(70, 250, 80, 30, 0xff231911);
			renderer.drawText(hauberk.name, 75, 260, 0xff685245);
			
			renderer.drawRectOpaque(155, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(iron.icon, 162, 257, iron.xTile, iron.yTile);
			renderer.drawText("5", 185, 261, 0xff886622);
			if(Inventory.iron >= 5) { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.iron + ")", 192, 261, 0xff774422); }	
			
			renderer.drawRectOpaque(230, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(vagrantSpirit.icon, 237, 257, vagrantSpirit.xTile, vagrantSpirit.yTile);
			renderer.drawText("1", 260, 261, 0xff886622);
			if(Inventory.vagrantSpirit >= 1) { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 267, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.vagrantSpirit + ")", 267, 261, 0xff774422); }
			
			renderer.drawRectOpaque(305, 250, 70, 30, 0xff231911);
			renderer.drawImageTile(pentupAnger.icon, 312, 257, pentupAnger.xTile, pentupAnger.yTile);
			renderer.drawText("1", 335, 261, 0xff886622);
			if(Inventory.pentupAnger >= 1) { renderer.drawText("(" + Inventory.pentupAnger + ")", 342, 261, 0xff447722); }
			else { renderer.drawText("(" + Inventory.pentupAnger + ")", 342, 261, 0xff774422); }
			
		renderer.drawRectOpaque(30, 290, 570, 40, 0xff181205);
			renderer.drawImageTile(jousting.icon, 35, 295, jousting.xTile, jousting.yTile);
			renderer.drawRectOpaque(70, 295, 80, 30, 0xff231911);
			renderer.drawText(jousting.name, 75, 305, 0xff685245);
			
			renderer.drawRectOpaque(155, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(silver.icon, 162, 302, silver.xTile, silver.yTile);
			renderer.drawText("5", 185, 306, 0xff886622);
			if(Inventory.silver >= 5) { renderer.drawText("(" + Inventory.silver + ")", 192, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.silver + ")", 192, 306, 0xff774422); }
	
			renderer.drawRectOpaque(230, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(nobleSpirit.icon, 237, 302, nobleSpirit.xTile, nobleSpirit.yTile);
			renderer.drawText("1", 260, 306, 0xff886622);
			if(Inventory.nobleSpirit >= 1) { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.nobleSpirit + ")", 267, 306, 0xff774422); }
			
			renderer.drawRectOpaque(305, 295, 70, 30, 0xff231911);
			renderer.drawImageTile(gloriousMoment.icon, 312, 302, gloriousMoment.xTile, gloriousMoment.yTile);
			renderer.drawText("1", 335, 306, 0xff886622);
			if(Inventory.gloriousMoment >= 1) { renderer.drawText("(" + Inventory.gloriousMoment + ")", 342, 306, 0xff447722); }
			else { renderer.drawText("(" + Inventory.gloriousMoment + ")", 342, 306, 0xff774422); }
			
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.pelt >= 8 && Inventory.nobleSpirit >= 1 && Inventory.springBreeze >= 1) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;
		case 2:
			if (Inventory.hide >= 8 && Inventory.evilSpirit >= 1 && Inventory.morningSunlight >= 1) { renderer.drawRect(30, 200, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 200, 570, 40, 0xffBB6622); }
			break;		
		case 3:
			if (Inventory.iron >= 5 && Inventory.vagrantSpirit >= 1 && Inventory.pentupAnger >= 1) { renderer.drawRect(30, 245, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 245, 570, 40, 0xffBB6622); }
			break;	
		case 4:
			if (Inventory.silver >= 5 && Inventory.nobleSpirit >= 1 && Inventory.gloriousMoment >= 1) { renderer.drawRect(30, 290, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 290, 570, 40, 0xffBB6622); }
			break;	
		
		}
			
	}
	

}
