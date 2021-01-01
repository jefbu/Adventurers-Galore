package com.redhaan.adventurersGalore.entity.town;

import java.util.Random;

public class ScheduleStep {
	
	public int waitTime;
	private Random random;
	public boolean visible;
	public int xDestination, yDestination;
	private int waitingTimer;
	private int moveTimer, acceleration;
	private int facing;
	public int scheduleStepID;
	
	public ScheduleStep(int xLocation, int yLocation, int waitingTime) {
		
		random = new Random();
		xDestination = xLocation;
		yDestination = yLocation;
		waitTime = waitingTime;
		visible = false;
		moveTimer = 0;
		acceleration = 0;
		facing = 0;
		waitingTimer = 0;
		scheduleStepID = 0;
	
	}
	
	
	
	public ScheduleStep(int currentID, int previousID, NPC npc) {
		
		random = new Random();
		decideLocation(currentID, previousID, npc);
		decideWaitTime(scheduleStepID);
		visible = true;
		moveTimer = 0;
		acceleration = 0;
		facing = random.nextInt(8);
		waitingTimer = 0;
		
	}
	
	
	
	public void update(NPC npc) {
		
		boolean moving = true;
		if(npc.xLocation == xDestination && npc.yLocation == yDestination) { moving = false; }
		
		
		if(moving) {
			
			npc.visible = true;
			moveTimer++;
			
			if(moveTimer < 10) { acceleration = 1; }
			else if(moveTimer > 100) { acceleration = 3; }
			else if(moveTimer > 30) { acceleration = 2; }
			
			
			int xDistance = Math.abs(npc.xLocation - xDestination);
			int yDistance = Math.abs(npc.yLocation - yDestination);
			
			if (xDistance + yDistance < 10) { moveTimer = 0; }
			else if (xDistance + yDistance < 30) { moveTimer = 1; }
			
			if(xDistance >= yDistance && xDistance !=0) {
				if(npc.xLocation > xDestination) {
					npc.xLocation -= 1 * acceleration; 
					if(Math.abs(xDistance - yDistance) > 2) { npc.facing = 2; }
					else if(npc.yLocation > yDestination) { npc.facing = 4; }
					else { npc.facing = 7; }
				}
				else { 
					npc.xLocation += 1 * acceleration; 
					if(Math.abs(xDistance - yDistance) > 2) { npc.facing = 0; }
					else if(npc.yLocation > yDestination) { npc.facing = 5; }
					else { npc.facing = 6; }
				}
			}
			
			else if(xDistance < yDistance) {
				if(npc.yLocation > yDestination) { 
					npc.yLocation -= 1 * acceleration; 
					if(Math.abs(xDistance - yDistance) > 2) { npc.facing = 1; }
					else if (npc.xLocation > xDestination) { npc.facing = 4; }
					else { npc.facing = 5; }
				}
				else { 
					npc.yLocation += 1* acceleration; 
					if(Math.abs(xDistance - yDistance) > 2) { npc.facing = 3;}
					else if (npc.xLocation > xDestination) { npc.facing = 7; }
					else { npc.facing = 6;}
				}
			}
			
			else {
				moving = false;
				npc.facing = facing;
			}
		}
		
		else {
			npc.visible = this.visible;
			waitingTimer++;
		}
		
	}
	
	
	public boolean waitTimeOver() {
		
		if(waitingTimer > waitTime) { 
			waitingTimer = 0;
			return true; } 
		else { return false; }
		
	}
	
	
	private void decideLocation(int currentID, int previousID, NPC npc) {
		
		boolean goOn = true;
		
		switch(currentID) {
		
		case 0:
			if (npc.xHome == 485) { scheduleStepID = 12; xDestination = 460 + random.nextInt(10); yDestination = 190 + random.nextInt(10); }
			else if (npc.xHome == 525) { scheduleStepID = 12; xDestination = 460 + random.nextInt(10); yDestination = 190 + random.nextInt(10); }
			else if (npc.xHome == 560) { scheduleStepID = 12; xDestination = 460 + random.nextInt(10); yDestination = 190 + random.nextInt(10); }
			else if (npc.xHome == 405) { scheduleStepID = 12; xDestination = 460 + random.nextInt(10); yDestination = 190 + random.nextInt(10); }
			else if (npc.xHome == 375) { scheduleStepID = 9; xDestination = 350 + random.nextInt(10); yDestination = 230 + random.nextInt(10); }
			break;
		
		case 1:
			scheduleStepID = 2;
			xDestination = 125 + random.nextInt(10);
			yDestination = 215 + random.nextInt(10);
			break;
		
		case 2:
			if(previousID == 1) {
				scheduleStepID = 4;
				xDestination = 225 + random.nextInt(10);
				yDestination = 270 + random.nextInt(10);
			}
			else if(previousID == 4) {
				scheduleStepID = 1;
				xDestination = 70 + random.nextInt(30);
				yDestination = 110 + random.nextInt(30);
			}
			break;
			
		case 3:
			scheduleStepID = 4;
			xDestination = 225 + random.nextInt(10);
			yDestination = 270 + random.nextInt(10);
			break;
			
		case 4:
			while(goOn) {
				int roll = random.nextInt(7);
				switch(roll) {
				case 0: scheduleStepID = 2; xDestination = 125 + random.nextInt(10); yDestination = 215 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 3; xDestination = 180 + random.nextInt(10); yDestination = 370 + random.nextInt(15); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 5; xDestination = 270 + random.nextInt(20); yDestination = 195 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 6; xDestination = 260 + random.nextInt(80); yDestination = 240 + random.nextInt(50); if (previousID != scheduleStepID) { goOn = false; } break;
				case 4: scheduleStepID = 8; xDestination = 310 + random.nextInt(10); yDestination = 190 + random.nextInt(5); if (previousID != scheduleStepID) { goOn = false; } break;
				case 5: scheduleStepID = 9; xDestination = 340 + random.nextInt(20); yDestination = 225 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 6: scheduleStepID = 10; xDestination = 360 + random.nextInt(10); yDestination = 290 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				}
			}
			break;
			
		case 5:
			while(goOn) {
				int roll = random.nextInt(4);
				switch(roll) {
				case 0: scheduleStepID = 4; xDestination = 210 + random.nextInt(20); yDestination = 265 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 6; xDestination = 260 + random.nextInt(80); yDestination = 240 + random.nextInt(50); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 8; xDestination = 310 + random.nextInt(10); yDestination = 190 + random.nextInt(5); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 9; xDestination = 340 + random.nextInt(20); yDestination = 225 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				}
			}
			break;
			
		case 6:
			while(goOn) {
				int roll = random.nextInt(5);
				switch(roll) {
				case 0: scheduleStepID = 4; xDestination = 210 + random.nextInt(20); yDestination = 265 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 5; xDestination = 270 + random.nextInt(20); yDestination = 195 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 8; xDestination = 310 + random.nextInt(10); yDestination = 190 + random.nextInt(5); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 9; xDestination = 340 + random.nextInt(20); yDestination = 225 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 4: scheduleStepID = 10; xDestination = 360 + random.nextInt(10); yDestination = 290 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				}
			}
			break;
			
		case 7:
			scheduleStepID = 8;
			xDestination = 310 + random.nextInt(10);
			yDestination = 190 + random.nextInt(5);
			break;
			
		case 8:
			while(goOn) {
				int roll = random.nextInt(4);
				switch(roll) {
				case 0: scheduleStepID = 4; xDestination = 210 + random.nextInt(20); yDestination = 265 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 5; xDestination = 270 + random.nextInt(20); yDestination = 195 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 6; xDestination = 260 + random.nextInt(80); yDestination = 240 + random.nextInt(50); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 7; xDestination = 270 + random.nextInt(15); yDestination = 70 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;

				}
			}
			break;
			
		case 9:
			while(goOn) {
				int roll = random.nextInt(5);
				switch(roll) {
				case 0: scheduleStepID = 4; xDestination = 210 + random.nextInt(20); yDestination = 265 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 5; xDestination = 270 + random.nextInt(20); yDestination = 195 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 6; xDestination = 260 + random.nextInt(80); yDestination = 240 + random.nextInt(50); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 10; xDestination = 360 + random.nextInt(10); yDestination = 290 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 4: scheduleStepID = 12; xDestination = 445 + random.nextInt(25); yDestination = 185 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				}
			}
			break;
			
		case 10:
			while(goOn) {
				int roll = random.nextInt(4);
				switch(roll) {
				case 0: scheduleStepID = 4; xDestination = 210 + random.nextInt(20); yDestination = 265 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 1: scheduleStepID = 6; xDestination = 260 + random.nextInt(80); yDestination = 240 + random.nextInt(50); if (previousID != scheduleStepID) { goOn = false; } break;
				case 2: scheduleStepID = 9; xDestination = 340 + random.nextInt(20); yDestination = 225 + random.nextInt(10); if (previousID != scheduleStepID) { goOn = false; } break;
				case 3: scheduleStepID = 11; xDestination = 440 + random.nextInt(50); yDestination = 400 + random.nextInt(30); if (previousID != scheduleStepID) { goOn = false; } break;
				}
			}
			break;
			
		case 11:
			scheduleStepID = 10;
			xDestination = 360 + random.nextInt(10);
			yDestination = 290 + random.nextInt(10);
			break;
			
		case 12:
			scheduleStepID = 9;
			xDestination = 340 + random.nextInt(20);
			yDestination = 225 + random.nextInt(10);
			break;
						
		}	
		
	}
	
	
	private void decideWaitTime(int scheduleStepID) {
		
		switch(scheduleStepID) {
		
		case 1: waitTime = 450 + random.nextInt(600); break;
		case 3: waitTime = 450 + random.nextInt(450); break;
		case 5: waitTime = 300 + random.nextInt(450); break;
		case 6: waitTime = 150 + random.nextInt(450); break;
		case 7: waitTime = 300 + random.nextInt(300); break;
		case 11: waitTime = 300 + random.nextInt(300); break;
		default: waitTime = 0; break;
		
		}
		
	}

		
		
	
}
