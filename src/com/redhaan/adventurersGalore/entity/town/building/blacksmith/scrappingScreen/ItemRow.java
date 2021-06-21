package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.ElysianFlower;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.GloriousMoment;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.LiquidInnocence;
import com.redhaan.adventurersGalore.entity.item.items.LuckyClover;
import com.redhaan.adventurersGalore.entity.item.items.MorningSunlight;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.PentUpAnger;
import com.redhaan.adventurersGalore.entity.item.items.RationalThought;
import com.redhaan.adventurersGalore.entity.item.items.ReforgedPlough;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.items.SpringBreeze;
import com.redhaan.adventurersGalore.entity.item.items.StolenMoonlight;
import com.redhaan.adventurersGalore.entity.item.items.Tusk;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Wanderlust;
import com.redhaan.adventurersGalore.entity.item.items.Wing;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen.SharpeningScreen;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ItemRow extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Item item;
	private int orderNumber;
	private Random random;
	
	private Item returnItem1, returnItem2, returnItem3;
	
	public ItemRow(Item item, int orderNumber) {
		
		this.item = item;
		random = new Random();
		
		this.orderNumber = orderNumber;
		
		returnItem1 = getReturnItem(item, 1);
		returnItem2 = getReturnItem(item, 2);
		returnItem3 = getReturnItem(item, 3);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 40 && gameContainer.getInput().getMouseX() < 590 &&
				gameContainer.getInput().getMouseY() > 155 + orderNumber * 40 && gameContainer.getInput().getMouseY() < 190 + orderNumber * 40) {
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				scrap (returnItem1, returnItem2, returnItem3);
			}
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if (item.ID == ItemID.Armour) {
			
			renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff121621);
			renderer.drawRectOpaque(45, 157 + orderNumber * 40, 35, 32, 0xff685245);
				renderer.drawImageTile(Armour.icon, 46, 157 + orderNumber * 40, item.xTile, item.yTile);
			renderer.drawRectOpaque(85, 157 + orderNumber * 40, 90, 32, 0xff685245);
				renderer.drawText(item.name, 90, 167 + orderNumber * 40, 0xff231911);		
			renderer.drawRectOpaque(180, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.defence, 193, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(215, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.weight, 227, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(250, 157 + orderNumber * 40, 30, 32, 0xff685245);
			renderer.drawRectOpaque(285, 157 + orderNumber * 40, 30, 32, 0xff685245);

			renderer.drawRectOpaque(320, 157 + orderNumber * 40, 60, 32, 0xff685245);
				renderer.drawImageTile(returnItem1.icon, 325, 162 + orderNumber * 40, returnItem1.xTile, returnItem1.yTile);
				renderer.drawText("80%", 345, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(385, 157 + orderNumber * 40, 60, 32, 0xff685245);
				if (secondIngredient(item)) { 
					renderer.drawImageTile(returnItem2.icon, 390, 162 + orderNumber * 40, returnItem2.xTile, returnItem2.yTile);
					renderer.drawText("50%", 410, 167 + orderNumber * 40, 0xff231911);
					}
			renderer.drawRectOpaque(450, 157 + orderNumber * 40, 60, 32, 0xff685245);
				if (thirdIngredient(item)) {
					renderer.drawImageTile(returnItem3.icon, 455, 162 + orderNumber * 40, returnItem3.xTile, returnItem3.yTile); 
					renderer.drawText("20%", 475, 167 + orderNumber * 40, 0xff231911);
					}
			
		}
		
		else {
			
			renderer.drawRectOpaque(40, 155 + orderNumber * 40, 550, 35, 0xff121621);
			renderer.drawRectOpaque(45, 157 + orderNumber * 40, 35, 32, 0xff685245);
				renderer.drawImageTile(Weapon.icon, 46, 157 + orderNumber * 40, item.xTile, item.yTile);
			
			renderer.drawRectOpaque(85, 157 + orderNumber * 40, 90, 32, 0xff685245);
				renderer.drawText(item.name, 90, 167 + orderNumber * 40, 0xff231911);		
			renderer.drawRectOpaque(180, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.damage, 193, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(215, 157 + orderNumber * 40,  30, 32, 0xff685245);
				renderer.drawText("" + item.hit, 225, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(250, 157 + orderNumber * 40, 30, 32, 0xff685245);
				renderer.drawText("" + item.crit, 260, 167 + orderNumber * 40, 0xff231911);
			renderer.drawRectOpaque(285, 157 + orderNumber * 40, 30, 32, 0xff685245);	
				renderer.drawText("" + item.weight, 295, 167 + orderNumber * 40, 0xff231911);
			
			renderer.drawRectOpaque(320, 157 + orderNumber * 40, 30, 32, 0xff685245);	
			renderer.drawRectOpaque(355, 157 + orderNumber * 40, 30, 32, 0xff685245);	

			renderer.drawRectOpaque(390, 157 + orderNumber * 40, 60, 32, 0xff685245);
			renderer.drawImageTile(returnItem1.icon, 395, 162 + orderNumber * 40, returnItem1.xTile, returnItem1.yTile);
			renderer.drawText("80%", 415, 167 + orderNumber * 40, 0xff231911);
		renderer.drawRectOpaque(455, 157 + orderNumber * 40, 60, 32, 0xff685245);
			if (secondIngredient(item)) { 
				renderer.drawImageTile(returnItem2.icon, 460, 162 + orderNumber * 40, returnItem2.xTile, returnItem2.yTile);
				renderer.drawText("50%", 480, 167 + orderNumber * 40, 0xff231911);
				}
		renderer.drawRectOpaque(520, 157 + orderNumber * 40, 60, 32, 0xff685245);
			if (thirdIngredient(item)) {
				renderer.drawImageTile(returnItem3.icon, 525, 162 + orderNumber * 40, returnItem3.xTile, returnItem3.yTile); 
				renderer.drawText("20%", 545, 167 + orderNumber * 40, 0xff231911);
				}	
			
		}

			
	}
	
	private void scrap(Item item1, Item item2, Item item3) {
				
		if (item.ID == ItemID.Armour) { 
			for (int i = 0; i < Inventory.armours.size(); i++) {
				if (Inventory.armours.get(i) == item) { Inventory.armours.remove(i); }
			}
		}
		else {
			for (int ii = 0; ii < Inventory.weapons.size(); ii++) {
				if (Inventory.weapons.get(ii) == item) { Inventory.weapons.remove(ii); }
			}
		}
		
		ArrayList<Item> loot = new ArrayList<Item>();
		
		int roll1 = random.nextInt(100) + 1;
		if (roll1 > 20) { loot.add(item1); }
		if(item2 != null) {
		int roll2 = random.nextInt(100) + 1;
		if (roll2 > 50) { loot.add(item2); }
		}
		if (item3 != null) {
		int roll3 = random.nextInt(100) + 1;
		if (roll3 > 80) { loot.add(item3); }
		}
		
		if(loot.size() > 0) { 
			
			String text = "Received: ";
			for (Item item: loot) { text = text + " " + item.name; }
			Toast.activate (true, text, 300, 220);
		}
		
		else { Toast.activate(true, "Unfortunately, nothing was salvaged", 300, 220); }
		
		ScrappingScreen.initialised = false;
		SharpeningScreen.initialised = false;
		
		
	}
	
	
	private Item getReturnItem(Item item, int order) {
		
		switch (item.name) {
		
		case "Iron Sword":
			switch(order) {
			case 1: return new Iron();
			case 2: break;
			case 3: break;
			}
			break;
		case "Broadsword":
			switch(order) {
			case 1: return new Iron();
			case 2: return new Claw();
			case 3: break;
			}
			break;
		case "Bastard Sword":
			switch(order) {
			case 1: return new Iron();
			case 2: return new Claw(); 
			case 3: return new Fang(); 
			}
			break;
		case "Sabre":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Claw(); 
			case 3: return new Wing(); 
			}
			break;
		case "Scimitar":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new ViolentSpirit(); 
			case 3: break;
			}
			break;
		case "Katana":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Gold(); 
			case 3: return new EvilSpirit(); 
			}
			break;
		case "Foil":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Silver(); 
			case 3: return new HeartSpirit(); 
			}
			break;
		case "Silver Sword":
			switch(order) {
			case 1: return new Silver(); 
			case 2: return new NobleSpirit(); 
			case 3: return new LiquidInnocence(); 
			}
			break;
		case "Epee":
			switch(order) {
			case 1: return new Coral(); 
			case 2: return new HeartSpirit(); 
			case 3: return new StolenMoonlight(); 
			}
			break;
		case "Falchion":
			switch(order) {
			case 1: return new Gold(); 
			case 2: return new SpiritOfMischief(); 
			case 3: return new ReforgedPlough(); 
			}
			break;
		case "Dagger":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Tusk(); 
			case 3: break;
			}
			break;
		case "Knife":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Claw(); 
			case 3: return new Tusk(); 
			}
			break;
		case "Dirk":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Tusk(); 
			case 3: return new Fang(); 
			}
			break;
		case "Machete":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new ViolentSpirit(); 
			case 3: break;
			}
			break;
		case "Cinqueada":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Tusk(); 
			case 3: return new EvilSpirit(); 
			}
			break;
		case "Katar":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new EvilSpirit(); 
			case 3: return new LuckyClover(); 
			}
			break;
		case "Quarterstaff":
			switch(order) {
			case 1: return new OakWood(); 
			case 2: return new Antlers(); 
			case 3: break;
			}
			break;
		case "Bo":
			switch(order) {
			case 1: return new OakWood(); 
			case 2: return new Antlers(); 
			case 3: return new Ivory(); 
			}
			break;
		case "Baton":
			switch(order) {
			case 1: return new OakWood();
			case 2: return new Antlers();
			case 3: return new Ivory(); 
			}
			break;
		case "Cudgel":
			switch(order) {
			case 1: return new Bone(); 
			case 2: return new Ivory(); 
			case 3: return new SpiritOfMischief(); 
			}
			break;
		case "Waddy":
			switch(order) {
			case 1: return new Antlers(); 
			case 2: return new VagrantSpirit(); 
			case 3: return new RationalThought(); 
			}
			break;
		case "Spear":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new OakWood(); 
			case 3: break;
			}
			break;
		case "Lance":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new OakWood(); 
			case 3: return new Claw(); 
			}
			break;
		case "Pike":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new OakWood(); 
			case 3: return new Claw(); 
			}
			break;
		case "Yari":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Silver(); 
			case 3: return new EvilSpirit(); 
			}
			break;
		case "Trident":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Gold(); 
			case 3: return new HeartSpirit(); 
			}
			break;
		case "Naginata":
			switch(order) {
			case 1: return new Coral(); 
			case 2: return new ViolentSpirit(); 
			case 3: return new Wanderlust(); 
			}
			break;
		case "Short Bow":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Antlers(); 
			case 3: return new OakWood(); 
			}
			break;
		case "Composite":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Ivory(); 
			case 3: return new OakWood(); 
			}
			break;
		case "Hand Bow":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Ivory(); 
			case 3: return new OakWood(); 
			}
			break;
		case "Recurve":
			switch(order) {
			case 1: return new OakWood();
			case 2: return new Ivory(); 
			case 3: return new VagrantSpirit(); 
			}
			break;
		case "LongBow":
			switch(order) {
			case 1: return new Ivory(); 
			case 2: return new SpiritOfMischief(); 
			case 3: return new ElysianFlower(); 
			}
			break;
		case "Coat":
			switch(order) {
			case 1: return new Pelt(); 
			case 2: return new Ivory(); 
			case 3: break;
			}
			break;
		case "Leather":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Ivory(); 
			case 3: break;
			}
			break;
		case "Chain":
			switch(order) {
			case 1: return new Iron(); 
			case 2: break;
			case 3: break;
			}
			break;
		case "Cuirass":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Silver(); 
			case 3: break;
			}
			break;
		case "Quilt":
			switch(order) {
			case 1: return new Pelt(); 
			case 2: return new Ivory();
			case 3: return new Bone(); 
			}
			break;
		case "Boiled Leather":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Ivory(); 
			case 3: return new Coral(); 
			}
			break;
		case "Riveted":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Coral(); 
			case 3: break;
			}
			break;
		case "Plate":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Silver(); 
			case 3: return new Antlers(); 
			}
			break;
		case "Gambeson":
			switch(order) {
			case 1: return new Pelt(); 
			case 2: return new Ivory(); 
			case 3: return new HeartSpirit(); 
			}
			break;
		case "Reinforced Leather":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new Ivory(); 
			case 3: return new ViolentSpirit(); 
			}
			break;
		case "Scale":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Coral(); 
			case 3: return new SpiritOfMischief(); 
			}
			break;
		case "Gothic":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new Silver(); 
			case 3: return new HeartSpirit(); 
			}
			break;
		case "Brigandine":
			switch(order) {
			case 1: return new Pelt(); 
			case 2: return new NobleSpirit(); 
			case 3: return new SpringBreeze(); 
			}
			break;
		case "Lamellar":
			switch(order) {
			case 1: return new Hide(); 
			case 2: return new EvilSpirit(); 
			case 3: return new MorningSunlight(); 
			}
			break;
		case "Hauberk":
			switch(order) {
			case 1: return new Iron(); 
			case 2: return new VagrantSpirit();
			case 3: return new PentUpAnger(); 
			}
			break;
		case "Jousting":
			switch(order) {
			case 1: return new Silver(); 
			case 2: return new NobleSpirit(); 
			case 3: return new GloriousMoment(); 
			}
			break;
		
		}
		
		return null;
				
	}
	
	private boolean secondIngredient (Item item) {
		
		switch (item.name) {
		
		case "Iron Sword": return false;
		case "Chain": return false;
		}
		
		return true;
		
	}
	
	
	private boolean thirdIngredient(Item item) {
		
		switch(item.name) {
		
		case "Bastard Sword": return true;
		case "Sabre": return true;
		case "Katana": return true;
		case "Foil": return true;
		case "Silver Sword": return true;
		case "Epee": return true;
		case "Falchion": return true;
		
		case "Knife": return true;
		case "Dirk": return true;
		case "Cinqueada": return true;
		case "Katar": return true;
		
		case "Bo": return true;
		case "Baton": return true;
		case "Cudgel": return true;
		case "Waddy": return true;
		
		case "Lance": return true;
		case "Pike": return true;
		case "Yari": return true;
		case "Trident": return true;
		case "Naginata": return true;
		
		case "Short Bow": return true;
		case "Composite": return true;
		case "Hand Bow": return true;
		case "Recurve": return true;
		case "Longbow": return true;
		
		case "Quilt": return true;
		case "Boiled Leather": return true;
		case "Plate": return true;
		case "Gambeson": return true;
		case "Reinforced Leather": return true;
		case "Scale": return true;
		case "Gothic": return true;
		case "Brigandine": return true;
		case "Lamellar": return true;
		case "Hauberk": return true;
		case "Jousting": return true;
		
		
		
		}
		
		return false;
		
	}
	
	
	

}
