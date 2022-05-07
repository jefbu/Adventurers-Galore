package com.redhaan.adventurersGalore.entity.town;

import java.util.Random;

public abstract class TownNeighbours {
	
	private static Random random = new Random();
	
	public static Town getNeighbouringTowns(Town town) {
		
		int roll = random.nextInt(100) + 1;
		
		switch (town.name) {
		
		case "Kaghak": 
			if (roll > 20) { return Town.apastan; }
			else if (roll > 10) { return Town.taranau; }
			else { return Town.ydatopto; }
		case "Apastan":
			if (roll > 70) { return Town.kaghak; }
			else if (roll > 40) { return Town.ydatopto; }
			else if (roll > 30) { return Town.taranau; }
			else if (roll > 20) { return Town.lothrain; }
			else if (roll > 10) { return Town.prucupad; }
			else { return Town.sioc; }
		case "Ydatopto":
			if (roll > 70) { return Town.omichli; }
			else if (roll > 40) { return Town.potami; }
			else if (roll > 30) { return Town.hasiera; }
			else if (roll > 20) { return Town.sioc; }
			else if (roll > 10) { return Town.taranau; }
			else { return Town.apastan; }
		case "Omichli":
			if (roll > 60) { return Town.ydatopto; }
			else if (roll > 30) { return Town.potami; }
			else if (roll > 10) { return Town.hasiera; }
			else { return Town.sioc; }
		case "Potami":
			if (roll > 60) { return Town.ydatopto; }
			else if (roll > 30) { return Town.omichli; }
			else if (roll > 10) { return Town.yarimon; }
			else { return Town.zuhaitz; }
		case "Taranau":
			if (roll > 60) { return Town.sioc; }
			else if (roll > 40) { return Town.apastan; }
			else if (roll > 25) { return Town.hasiera; }
			else if (roll > 10) { return Town.nuage; }
			else { return Town.ydatopto; }
		case "Sioc":
			if (roll > 70) { return Town.taranau; }
			else if (roll > 50) { return Town.hasiera; }
			else if (roll > 30) { return Town.oakheart; }
			else if (roll > 10) { return Town.nuage; }
			else { return Town.ydatopto; }
		case "Hasiera":
			if (roll > 60) { return Town.zuhaitz; }
			else if (roll > 40) { return Town.oakheart; }
			else if (roll > 20) { return Town.sioc; }
			else if (roll > 10) { return Town.omichli; }
			else { return Town.nuage; }
		case "Zuhaitz":
			if (roll > 60) { return Town.hasiera; }
			else if (roll > 40) { return Town.omichli; }
			else if (roll > 20) { return Town.oakheart; }
			else if (roll > 10) { return Town.ymvernu; }
			else { return Town.yarimon; }
		case "Ymvernu":
			if (roll > 70) { return Town.oakheart; }
			else if (roll > 40) { return Town.coldHarbour; }
			else if (roll > 30) { return Town.yarimon; }
			else if (roll > 20) { return Town.potami; }
			else if (roll > 10) { return Town.zuhaitz; }
			else { return Town.nuage; }
		case "Nuage":
			if (roll > 80) { return Town.adrielruin; }
			else if (roll > 60) { return Town.lothrain; }
			else if (roll > 40) { return Town.sioc; }
			else if (roll > 30) { return Town.oakheart; }
			else if (roll > 20) { return Town.hasiera; }
			else if (roll > 10) { return Town.ymvernu; }
			else { return Town.taranau; }
		case "Oakheart":
			if (roll > 80) { return Town.sioc; }
			else if (roll > 60) { return Town.hasiera; }
			else if (roll > 40) { return Town.ymvernu; }
			else if (roll > 20) { return Town.nuage; }
			else if (roll > 10) { return Town.zuhaitz; }
			else { return Town.taranau; }
		case "Yarimon":
			if (roll > 70) { return Town.ymvernu; }
			else if (roll > 50) { return Town.potami; }
			else if (roll > 30) { return Town.fingertip; }
			else if (roll > 10) { return Town.coldHarbour; }
			else { return Town.zuhaitz; }
		case "Crystal Capital":
			if (roll > 70) { return Town.fingertip; }
			else if (roll > 40) { return Town.coldHarbour; }
			else if (roll > 20) { return Town.tradersPassage; }
			else { return Town.portSplendid; }
		case "Port Splendid":
			if (roll > 60) { return Town.crystalCapital; }
			else if (roll > 30) { return Town.fingertip; }
			else { return Town.coldHarbour; }
		case "Cold Harbour":
			if (roll > 70) { return Town.crystalCapital; }
			else if (roll > 40) { return Town.ymvernu; }
			else if (roll > 20) { return Town.fingertip; }
			else { return Town.portSplendid; }
		case "Fingertip":
			if (roll > 70) { return Town.crystalCapital; }
			else if (roll > 50) { return Town.tradersPassage; }
			else if (roll > 30) { return Town.portSplendid; }
			else if (roll > 10) { return Town.yarimon; }
			else { return Town.coldHarbour; }
		case "Trader's Passage":
			if (roll > 70) { return Town.crystalCapital; }
			else if ( roll > 40) { return Town.fingertip; }
			else if ( roll > 10) { return Town.dorei; }
			else { return Town.outpost; }
		case "Outpost":
			if (roll > 40) { return Town.dorei; }
			else { return Town.tradersPassage; }
		case "Dorei":
			if (roll > 60) { return Town.tradersPassage; }
			else if (roll > 20) { return Town.bastion; }
			else { return Town.outpost; }
		case "Bastion":
			if (roll > 70) { return Town.midori; }
			else if (roll > 40) { return Town.dorei; }
			else if (roll > 20) { return Town.smabarn; }
			else if (roll > 10) { return Town.adrielruin; }
			else { return Town.outpost; }
		case "Midori":
			if (roll > 60) { return Town.bastion; }
			else if (roll > 30) { return Town.smabarn; }
			else { return Town.adrielruin; }
		case "Adrielruin":
			if (roll > 80) { return Town.bastion; }
			else if (roll > 60) { return Town.smabarn; }
			else if (roll > 40) { return Town.lothrain; }
			else if (roll > 20) { return Town.prucupad; }
			else { return Town.nuage; }
		case "Lothrain":
			if (roll > 60) { return Town.adrielruin; }
			else if (roll > 40) { return Town.prucupad; }
			else if (roll > 20) { return Town.nuage; }
			else if (roll > 10) { return Town.apastan; }
			else { return Town.smabarn; }
		case "Prucupad":
			if (roll > 50) { return Town.adrielruin; }
			else if (roll > 10) { return Town.lothrain; }
			else { return Town.apastan; }
		case "Smabarn":
			if (roll > 70) { return Town.midori; }
			else if (roll > 40) { return Town.bastion; }
			else if (roll > 10) { return Town.adrielruin; }
			else { return Town.lothrain; }
				
		
		default: 
			System.out.println("error at town neighbours with " + town.name);
			return Town.kaghak;
		
		
		
		}
		
		
		
	}
	

}
