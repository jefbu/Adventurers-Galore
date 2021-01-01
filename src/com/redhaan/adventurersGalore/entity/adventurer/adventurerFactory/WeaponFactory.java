package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.CompositeBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.HandBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.LongBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.RecurveBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.Yoichi;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dagger;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dirk;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Katar;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Knife;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Machete;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Misericordia;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.GaeBolg;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Gungnir;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Lance;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Longinus;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Naginata;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Pike;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Spear;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Trident;
import com.redhaan.adventurersGalore.entity.item.weapon.spears.Yari;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Baton;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Bo;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Cudgel;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.DoubleLily;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Quarterstaff;
import com.redhaan.adventurersGalore.entity.item.weapon.staves.Waddy;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BastardSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.BroadSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Epee;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Excalibur;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Falchion;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Foil;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.IronSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Katana;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Sabre;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.Scimitar;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.SilverSword;
import com.redhaan.adventurersGalore.entity.item.weapon.swords.VorpalSword;

public class WeaponFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	Random random;
	
	
	public WeaponFactory() {		
		random = new Random();
	}
	
	
	public Weapon rollAdventurerStartingWeapon(int adventurerTier, int PHY, Job job) {
		
		Weapon weapon = new Dagger();
		int weaponTier = 0;
							
		int rollTier = random.nextInt(100) + 1;
		
		switch(adventurerTier) {
		
		case 0:
			if (rollTier > 99) { weaponTier = 5; }
			else if (rollTier > 90) { weaponTier = 4; }
			else if (rollTier > 80) { weaponTier = 3; }
			else if (rollTier > 60) { weaponTier = 2; }
			else { weaponTier = 1; }
			break;
		case 1:
			if (rollTier > 98) { weaponTier = 5; }
			else if (rollTier > 90) { weaponTier = 4; }
			else if (rollTier > 75) { weaponTier = 3; }
			else if (rollTier > 50) { weaponTier = 2; }
			else { weaponTier = 1; }
			break;
		case 2:
			if (rollTier > 97) { weaponTier = 5; }
			else if (rollTier > 85) { weaponTier = 4; }
			else if (rollTier > 70) { weaponTier = 3; }
			else if (rollTier > 40) { weaponTier = 2; }
			else { weaponTier = 1; }
			break;
		case 3:
			if (rollTier > 95) { weaponTier = 5; }
			else if (rollTier > 70) { weaponTier = 4; }
			else if (rollTier > 40) { weaponTier = 3; }
			else if (rollTier > 15) { weaponTier = 2; }
			else { weaponTier = 1; }
			break;
		case 4:
			if (rollTier > 90) { weaponTier = 5; }
			else if (rollTier > 50) { weaponTier = 4; }
			else if (rollTier > 20) { weaponTier = 3; }
			else if (rollTier > 5) { weaponTier = 2; }
			else { weaponTier = 1; }
			break;	
		
		}
		
		int rollType = random.nextInt(100) + 1;
		WeaponType weaponType = WeaponType.DAGGER;
		
		switch(job.jobEnum) {
		
		case Squire:
			if(rollType > 50) { weaponType = WeaponType.SWORD; }
			else if (rollType > 30) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Knight:
			if(rollType > 50) { weaponType = WeaponType.SWORD; }
			else if (rollType > 30) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Paladin:
			if(rollType > 50) { weaponType = WeaponType.SWORD; }
			else if (rollType > 30) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Mage:
			if (rollType > 40) { weaponType = WeaponType.STAFF; }
			else if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.BOW; }
			else { weaponType = WeaponType.SPEAR; }
			break;
		case Magus:
			if (rollType > 40) { weaponType = WeaponType.STAFF; }
			else if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.BOW; }
			else { weaponType = WeaponType.SPEAR; }
			break;
		case ArchMage:
			if (rollType > 40) { weaponType = WeaponType.STAFF; }
			else if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.BOW; }
			else { weaponType = WeaponType.SPEAR; }
			break;
			
		case Thief:
			if (rollType > 30) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 15) { weaponType = WeaponType.SWORD; }
			else if (rollType > 10) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Knave:
			if (rollType > 30) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 15) { weaponType = WeaponType.SWORD; }
			else if (rollType > 10) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case CatBurglar:
			if (rollType > 30) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 15) { weaponType = WeaponType.SWORD; }
			else if (rollType > 10) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Archer:
			if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Hunter:
			if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Sniper:
			if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else if (rollType > 5) { weaponType = WeaponType.SPEAR; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Barbarian:
			if (rollType > 70) { weaponType = WeaponType.SWORD; }
			else if (rollType > 40) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.STAFF; }
			else { weaponType = WeaponType.DAGGER; }
			break;
		case Berserker:
			if (rollType > 70) { weaponType = WeaponType.SWORD; }
			else if (rollType > 40) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.STAFF; }
			else { weaponType = WeaponType.DAGGER; }
			break;
		case RedMist:
			if (rollType > 70) { weaponType = WeaponType.SWORD; }
			else if (rollType > 40) { weaponType = WeaponType.SPEAR; }
			else if (rollType > 20) { weaponType = WeaponType.BOW; }
			else if (rollType > 5) { weaponType = WeaponType.STAFF; }
			else { weaponType = WeaponType.DAGGER; }
			break;
		
		default: System.out.println("Error at Weapon Type Roll"); break;
		
		}
		
		
		
		int rollWeapon = random.nextInt(100) + 1;
		switch (weaponTier) {
		
		case 1:
			switch (weaponType) {
			case DAGGER:
				if (rollWeapon > 50 && PHY >= 6) { weapon = new Dagger(); }
				else { weapon = new Knife(); }
				break;
			case STAFF:
				weapon = new Quarterstaff();
				break;
			case SWORD:
				if (rollWeapon > 50  && PHY >= 11) { weapon = new BroadSword(); }
				else { weapon = new IronSword(); }
				break;
			case SPEAR:
				weapon = new Spear();
				break;
			case BOW:
				weapon = new ShortBow();
				break;
			}
		break;	
			
		case 2:	
			switch(weaponType) {
			case DAGGER:
				weapon = new Dirk();
				break;
			case STAFF:
				if (rollWeapon > 50 && PHY >= 9) { weapon = new Baton(); }
				else { weapon = new Bo(); }
				break;
			case SWORD:
				if (rollWeapon > 50 && PHY >= 15) { weapon = new BastardSword(); }
				else { weapon = new Sabre(); }
				break;
			case SPEAR:
				if (rollWeapon > 50  && PHY >= 12) { weapon = new Pike(); }
				else { weapon = new Lance(); }
				break;
			case BOW:
				if (rollWeapon > 50  && PHY >= 9) { weapon = new CompositeBow(); }
				else { weapon = new HandBow(); }
				break;
			}
		break;
			
		case 3:
			switch(weaponType) {
			case DAGGER:
				if (rollWeapon > 50 && PHY >= 8) { weapon = new Machete(); }
				else { weapon = new Cinqueada(); }
				break;
			case STAFF:
				weapon = new Cudgel();
				break;
			case SWORD:				
				if (rollWeapon > 66 && PHY >= 14) { weapon = new Scimitar(); }
				else if (rollWeapon > 33 && PHY >= 13) { weapon = new Katana(); }
				else { weapon = new Foil(); }
				break;	
			case SPEAR:
				if (rollWeapon > 50 && PHY >= 14) { weapon = new Trident(); }
				else { weapon = new Yari(); }
				break;	
			case BOW:
				weapon = new RecurveBow();
				break;
			}
		break;

		case 4:
			switch(weaponType) {
			case DAGGER:
				weapon = new Katar();
				break;
			case STAFF:
				weapon = new Waddy();
				break;
			case SWORD:
				if (rollWeapon > 66 && PHY >= 17) { weapon = new Falchion(); }
				else if (rollWeapon > 33 && PHY >= 15) { weapon = new SilverSword(); }
				else { weapon = new Epee(); }
				break;
			case SPEAR:
				weapon = new Naginata();
			case BOW:
				weapon = new LongBow();
			}
		break;
			
		case 5:
			switch(weaponType) {
			case DAGGER:
				weapon = new Misericordia();
				break;
			case STAFF:
				weapon = new DoubleLily();
				break;
			case SWORD:
				if (rollWeapon > 50 && PHY >= 20) { weapon = new Excalibur(); }
				else { weapon = new VorpalSword(); }
				break;
			case SPEAR:
				if (rollWeapon > 66 && PHY >= 20) { weapon = new Gungnir(); }
				else if (rollWeapon > 33) { weapon = new GaeBolg(); }
				else { weapon = new Longinus(); }
				break;
			case BOW:
				weapon = new Yoichi();
				break;
			}
		break;

			
			
		default:
			System.out.println("Error at weapon roll");
			weapon = new Excalibur();
		}
				
		return weapon;		
		
		
	}
	

}
