package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CraftWidget extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	ItemContainer tusk;
	ItemContainer fang;
	ItemContainer claw;
	ItemContainer oakwood;
	ItemContainer iron;
	ItemContainer gold;
	ItemContainer silver;
	ItemContainer antlers;
	ItemContainer bone;
	ItemContainer coral;	
	ItemContainer pelt;
	ItemContainer hide;
	
	ItemContainer evilSpirit;
	ItemContainer violentSpirit;
	ItemContainer vagrantSpirit;
	ItemContainer spiritOfMischief;
	ItemContainer nobleSpirit;
	ItemContainer heartSpirit;
	
	ItemContainer stolenMoonlight;
	ItemContainer liquidInnocence;
	ItemContainer luckyClover;
	ItemContainer rationalThought;
	ItemContainer reforgedPlough;
	ItemContainer springBreeze;
	ItemContainer morningSunlight;
	ItemContainer pentupAnger;
	ItemContainer gloriousMoment;
	ItemContainer elysianFlower;
	ItemContainer wanderlust;
	
	protected boolean updated;

	public CraftWidget() {
		
		tusk = new ItemContainer("tusk", 20, 60, 0, 0);
		fang = new ItemContainer("fang", 20, 82, 0, 1);
		claw = new ItemContainer("claw", 20, 104, 0, 2);
		oakwood = new ItemContainer("oak wood", 20, 126, 0, 3);
		iron = new ItemContainer("iron", 20, 148, 0, 4);
		gold = new ItemContainer("gold", 20, 170, 0, 5);
		silver = new ItemContainer("silver", 20, 192, 0, 6);
		antlers = new ItemContainer("antlers", 20, 214, 0, 7);
		bone = new ItemContainer("bone", 20, 236, 0, 8);
		coral = new ItemContainer("coral", 20, 258, 0, 9);
		
		pelt = new ItemContainer("pelt", 20, 280, 1, 0);
		hide = new ItemContainer("hide", 20, 302, 1, 1);
		
		
		evilSpirit = new ItemContainer("evil spirit", 280, 60, 9, 0);
		violentSpirit = new ItemContainer("violent spirit", 280, 82, 9, 1);
		spiritOfMischief = new ItemContainer("spirit of mischief", 280, 104, 9, 2);
		vagrantSpirit = new ItemContainer("vagrant spirit", 280, 126, 9, 3);
		nobleSpirit = new ItemContainer("noble spirit", 280, 148, 9, 4);
		heartSpirit = new ItemContainer("heart sirit", 280, 170, 9, 5);
		
		
		stolenMoonlight = new ItemContainer("stolen moonlight", 460, 60, 8, 0);
		liquidInnocence = new ItemContainer("liquid innocence", 460, 82, 8, 1);
		luckyClover = new ItemContainer("lucky clover", 460, 104, 8, 2);
		rationalThought = new ItemContainer("rational thought", 460, 126, 8, 3);
		reforgedPlough = new ItemContainer("reforged plough", 460, 148, 8, 4);
		springBreeze = new ItemContainer("spring breeze", 460, 170, 8, 5);
		morningSunlight = new ItemContainer("morning sunlight", 460, 192, 8, 6);
		pentupAnger = new ItemContainer("pent-up anger", 460, 214, 8, 7);
		gloriousMoment = new ItemContainer("glorious moment", 460, 236, 8, 8);
		elysianFlower = new ItemContainer("Elysian flower", 460, 258, 8, 9);
		wanderlust = new ItemContainer("Wanderlust", 460, 280, 7, 0);
		
		
				
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(!updated) {
			
			tusk.quantity = Inventory.tusk;			
			fang.quantity = Inventory.fang;
			claw.quantity = Inventory.claw;
			oakwood.quantity = Inventory.oakwood;
			iron.quantity = Inventory.iron;
			gold.quantity = Inventory.gold;
			silver.quantity = Inventory.silver;
			antlers.quantity = Inventory.antlers;
			bone.quantity = Inventory.bone;
			coral.quantity = Inventory.coral;
			
			pelt.quantity = Inventory.pelt;
			hide.quantity = Inventory.hide;
			
			evilSpirit.quantity = Inventory.evilSpirit;
			violentSpirit.quantity = Inventory.violentSpirit;
			spiritOfMischief.quantity = Inventory.spiritOfMischief;
			vagrantSpirit.quantity = Inventory.vagrantSpirit;
			nobleSpirit.quantity = Inventory.nobleSpirit;
			heartSpirit.quantity = Inventory.heartSpirit;
			
			stolenMoonlight.quantity = Inventory.stolenMoonlight;
			liquidInnocence.quantity = Inventory.liquidInnocence;
			luckyClover.quantity = Inventory.luckyClover;
			rationalThought.quantity = Inventory.rationalThought;
			reforgedPlough.quantity = Inventory.reforgedPlough;	
			springBreeze.quantity = Inventory.springBreeze;
			morningSunlight.quantity = Inventory.morningSunlight;
			pentupAnger.quantity = Inventory.pentupAnger;
			gloriousMoment.quantity = Inventory.gloriousMoment;
			elysianFlower.quantity = Inventory.elysianFlower;
			wanderlust.quantity = Inventory.wanderlust;
					
			updated = true;
			
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		tusk.render(gameContainer, renderer);
		fang.render(gameContainer, renderer);
		claw.render(gameContainer, renderer);
		oakwood.render(gameContainer, renderer);
		iron.render(gameContainer, renderer);
		gold.render(gameContainer, renderer);
		silver.render(gameContainer, renderer);
		antlers.render(gameContainer, renderer);
		bone.render(gameContainer, renderer);
		coral.render(gameContainer, renderer);

		pelt.render(gameContainer, renderer);
		hide.render(gameContainer, renderer);
		
		evilSpirit.render(gameContainer, renderer);
		violentSpirit.render(gameContainer, renderer);
		spiritOfMischief.render(gameContainer, renderer);
		vagrantSpirit.render(gameContainer, renderer);
		nobleSpirit.render(gameContainer, renderer);
		heartSpirit.render(gameContainer, renderer);
		
		stolenMoonlight.render(gameContainer, renderer);
		liquidInnocence.render(gameContainer, renderer);
		luckyClover.render(gameContainer, renderer);
		rationalThought.render(gameContainer, renderer);
		reforgedPlough.render(gameContainer, renderer);
		springBreeze.render(gameContainer, renderer);
		morningSunlight.render(gameContainer, renderer);
		pentupAnger.render(gameContainer, renderer);
		gloriousMoment.render(gameContainer, renderer);
		elysianFlower.render(gameContainer, renderer);
		wanderlust.render(gameContainer, renderer);
		
	}
	
	
	
	
	
	
	

}
