package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AlchemyWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private ItemContainer beastBlood;
	private ItemContainer lesses;
	private ItemContainer snakeTongue;
	private ItemContainer robinEgg;
	private ItemContainer turtleShell;
	private ItemContainer volcanicAsh;
	private ItemContainer bile;
	private ItemContainer lizardEye;
	private ItemContainer ectoplasm;
	private ItemContainer giantToe;
	
	private ItemContainer bezoar;
	private ItemContainer vampireDust;
	private ItemContainer historicDocument;
	private ItemContainer phoenixFeather;
	private ItemContainer unicornHorn;
	private ItemContainer dragonBlood;
	private ItemContainer mummyWrapping;
	private ItemContainer daemonHeart;
	private ItemContainer manaTreeBranch;
	
	private ItemContainer whitePotion;
	private ItemContainer goldPotion;
	private ItemContainer tealPotion;
	private ItemContainer redPotion;
	private ItemContainer greenPotion;
	private ItemContainer bluePotion;
	private ItemContainer brownPotion;
	private ItemContainer purplePotion;
	private ItemContainer blackPotion;
	
	
	protected boolean updated;

	public AlchemyWidget() {
		
		beastBlood = new ItemContainer("beast blood", 20, 60, 2, 0);
		lesses = new ItemContainer("lesses", 20, 82, 2, 1);
		snakeTongue = new ItemContainer("snake tongues", 20, 104, 2, 2);
		robinEgg = new ItemContainer("robin's eggs", 20, 126, 2, 3);
		turtleShell = new ItemContainer("turtle shells", 20, 148, 2, 4);
		volcanicAsh = new ItemContainer("volcanic ashes", 20, 170, 2, 5);
		bile = new ItemContainer("bile", 20, 192, 2, 6);
		lizardEye = new ItemContainer("lizard eyes", 20, 214, 2, 7);
		ectoplasm = new ItemContainer("ectoplasm", 20, 236, 2, 8);
		giantToe = new ItemContainer("giant toes", 20, 258, 2, 9);
		
		bezoar = new ItemContainer("bezoars", 220, 60, 3, 0);
		vampireDust = new ItemContainer("vampire dust", 220, 82, 3, 1);
		historicDocument = new ItemContainer("historic documents", 220, 104, 3, 2);
		phoenixFeather = new ItemContainer("phoenix feathers", 220, 126, 3, 3);
		unicornHorn = new ItemContainer("unicorn horns", 220, 148, 3, 4);
		dragonBlood = new ItemContainer("dragon blood", 220, 170, 3, 5);
		mummyWrapping = new ItemContainer("mummy wrappings", 220, 192, 3, 6);
		daemonHeart = new ItemContainer("daemon hearts", 220, 214, 3, 7);
		manaTreeBranch = new ItemContainer("mana tree branches", 220, 236, 3, 8);

		
		whitePotion = new ItemContainer("white potion", 420, 60, 10, 0);
		goldPotion = new ItemContainer("gold potion", 420, 82, 10, 1);
		tealPotion = new ItemContainer("teal potion", 420, 104, 10, 2);
		redPotion = new ItemContainer("red potion", 420, 126, 10, 3);
		greenPotion = new ItemContainer("green potion", 420, 148, 10, 4);
		bluePotion = new ItemContainer("blue potion", 420, 170, 10, 5);
		brownPotion = new ItemContainer("brown potion", 420, 192, 10, 6);
		purplePotion = new ItemContainer("purple potion", 420, 214, 10, 7);
		blackPotion = new ItemContainer("black potion", 420, 236, 10, 8);

		
		updated = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (!updated) {
			
			beastBlood.quantity = Inventory.beastBlood;
			lesses.quantity = Inventory.lesses;
			snakeTongue.quantity = Inventory.snakeTongue;
			robinEgg.quantity = Inventory.robinEgg;
			turtleShell.quantity = Inventory.turtleShell;
			volcanicAsh.quantity = Inventory.volcanicAsh;
			bile.quantity = Inventory.bile;
			lizardEye.quantity = Inventory.lizardEye;
			ectoplasm.quantity = Inventory.ectoplasm;
			giantToe.quantity = Inventory.giantToe;
			
			bezoar.quantity = Inventory.bezoar;
			vampireDust.quantity = Inventory.vampireDust;
			historicDocument.quantity = Inventory.historicDocument;
			phoenixFeather.quantity = Inventory.phoenixFeather;
			unicornHorn.quantity = Inventory.unicornHorn;
			dragonBlood.quantity = Inventory.dragonBlood;
			mummyWrapping.quantity = Inventory.mummyWrapping;
			daemonHeart.quantity = Inventory.daemonHeart;
			manaTreeBranch.quantity = Inventory.manaTreeBranch;
			
			whitePotion.quantity = Inventory.whitePotion;
			goldPotion.quantity = Inventory.goldPotion;
			tealPotion.quantity = Inventory.tealPotion;
			redPotion.quantity = Inventory.redPotion;
			greenPotion.quantity = Inventory.greenPotion;
			bluePotion.quantity = Inventory.bluePotion;
			brownPotion.quantity = Inventory.brownPotion;
			purplePotion.quantity = Inventory.purplePotion;
			blackPotion.quantity = Inventory.blackPotion;
			
			updated = true;
			
		}
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		beastBlood.render(gameContainer, renderer);
		lesses.render(gameContainer, renderer);
		snakeTongue.render(gameContainer, renderer);
		robinEgg.render(gameContainer, renderer);
		turtleShell.render(gameContainer, renderer);
		volcanicAsh.render(gameContainer, renderer);
		bile.render(gameContainer, renderer);
		lizardEye.render(gameContainer, renderer);
		ectoplasm.render(gameContainer, renderer);
		giantToe.render(gameContainer, renderer);
		
		bezoar.render(gameContainer, renderer);
		vampireDust.render(gameContainer, renderer);
		historicDocument.render(gameContainer, renderer);
		phoenixFeather.render(gameContainer, renderer);
		unicornHorn.render(gameContainer, renderer);
		dragonBlood.render(gameContainer, renderer);
		mummyWrapping.render(gameContainer, renderer);
		daemonHeart.render(gameContainer, renderer);
		manaTreeBranch.render(gameContainer, renderer);
		
		whitePotion.render(gameContainer, renderer);
		goldPotion.render(gameContainer, renderer);
		tealPotion.render(gameContainer, renderer);
		redPotion.render(gameContainer, renderer);
		greenPotion.render(gameContainer, renderer);
		bluePotion.render(gameContainer, renderer);
		brownPotion.render(gameContainer, renderer);
		purplePotion.render(gameContainer, renderer);
		blackPotion.render(gameContainer, renderer);

		
	}

}
