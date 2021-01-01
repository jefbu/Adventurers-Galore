package com.redhaan.adventurersGalore.entity.town;

import java.util.ArrayList;
import java.util.Random;

public class Routine {
	
	
	private Random random;
	
	private int activeScheduleStep;
	private ArrayList<ScheduleStep> dailySchedule;
	
	private boolean sleepAtNight;
	
	private int timer;
	
	
	public Routine(NPC npc) {
		
		random = new Random();
		activeScheduleStep = 0;
		
		dailySchedule = createDailySchedule(npc);
		
		sleepAtNight = false;
		
		timer = 0;
		
	}
	
	
	
	public void update(NPC npc) {
		
		timer++;
		
		if(!sleepAtNight) {
			dailySchedule.get(activeScheduleStep).update(npc);
			
			if(dailySchedule.get(activeScheduleStep).waitTimeOver()) {
				if(activeScheduleStep == dailySchedule.size() - 1) { sleepAtNight = true; }
				else { activeScheduleStep++; }
			}			
		}

		if (timer == 7200) {
			sleepAtNight = false;
			timer = 0;
			activeScheduleStep = 0;
		}
		
	}
	
	
	
	
	
	private ArrayList<ScheduleStep> createDailySchedule(NPC npc) {
		
		ArrayList<ScheduleStep> schedule = new ArrayList<ScheduleStep>();
		
		schedule.add(new ScheduleStep(npc.xHome, npc.yHome, 1500 + random.nextInt(1500)));
		
		boolean goOn = true;
		
		while(goOn) {
			
			int currentID = schedule.get(schedule.size() - 1).scheduleStepID;
			int previousID = 0;
			if (schedule.size() > 1) { previousID = schedule.get(schedule.size() - 2).scheduleStepID; }
			
			schedule.add(new ScheduleStep(currentID, previousID, npc));
			
			int totalWaitTime = 0;
			for (ScheduleStep scheduleStep: schedule) {
				totalWaitTime += scheduleStep.waitTime;
			}
			if (totalWaitTime > 6000) { goOn = false; }
			
		}
		
		schedule.add(new ScheduleStep(npc.xHome, npc.yHome, 0));
		
		
		
		return schedule;
		
	}
	
	
	
	
}	