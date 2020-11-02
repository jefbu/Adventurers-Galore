package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.staffSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.Ivory;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Cudgel;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BroadSword;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StaffTier3 extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private Cudgel cudgel;
	private Bone bone;
	private Ivory ivory;
	private SpiritOfMischief spiritOfMischief;
	
	private int hoverOption;


	public StaffTier3() {
		
		cudgel = new Cudgel();
		bone = new Bone();
		ivory = new Ivory();
		spiritOfMischief = new SpiritOfMischief();
		
		hoverOption = 0;
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 600 &&
				gameContainer.getInput().getMouseY() > 155 && gameContainer.getInput().getMouseY() < 195) {
			
			hoverOption = 1;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(Inventory.bone >= 3 && Inventory.ivory >= 3 && Inventory.spiritOfMischief >= 1) { 
					Inventory.weapons.add(new Cudgel());
					Inventory.bone -= 3;
					Inventory.ivory -= 3;
					Inventory.spiritOfMischief -= 1;
				}
			}
			
		}
		
		else { hoverOption = 0; }
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 155, 570, 40, 0xff181205);
			renderer.drawImageTile(cudgel.icon, 35, 160, cudgel.xTile, cudgel.yTile);
			renderer.drawRectOpaque(70, 160, 80, 30, 0xff231911);
			renderer.drawText(cudgel.name, 75, 170, 0xff685245);
	
			renderer.drawRectOpaque(155, 160, 70, 30, 0xff231911);		
			renderer.drawImageTile(bone.icon, 162, 167, bone.xTile, bone.yTile);
			renderer.drawText("3", 185, 171, 0xff886622);
			if(Inventory.bone >= 3) { renderer.drawText("(" + Inventory.bone + ")", 192, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.bone + ")", 192, 171, 0xff774422); }
		
			renderer.drawRectOpaque(230, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(ivory.icon, 237, 167, ivory.xTile, ivory.yTile);
			renderer.drawText("3", 260, 171, 0xff886622);
			if(Inventory.claw >= 3) { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.ivory + ")", 267, 171, 0xff774422); }
			
			renderer.drawRectOpaque(305, 160, 70, 30, 0xff231911);
			renderer.drawImageTile(spiritOfMischief.icon, 312, 167, spiritOfMischief.xTile, spiritOfMischief.yTile);
			renderer.drawText("1", 335, 171, 0xff886622);
			if(Inventory.spiritOfMischief >= 1) { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 342, 171, 0xff447722); }
			else { renderer.drawText("(" + Inventory.spiritOfMischief + ")", 342, 171, 0xff774422); }
			
			
		switch(hoverOption) {
		
		case 0: break;
		case 1:
			if (Inventory.iron >= 3 && Inventory.fang >= 8) { renderer.drawRect(30, 155, 570, 40, 0xff88AA55); }
			else { renderer.drawRect(30, 155, 570, 40, 0xffBB6622); }
			break;		
		
		}
			
	}

}
