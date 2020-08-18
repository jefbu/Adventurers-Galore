package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Cinqueada;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dagger;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dirk;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Katar;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Knife;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Machete;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Misericordia;
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
		
		Weapon weapon = new IronSword();
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
			if (rollType > 20) { weaponType = WeaponType.SWORD; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Knight:
			if (rollType > 20) { weaponType = WeaponType.SWORD; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Paladin:
			if (rollType > 20) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Mage:
			if (rollType > 30) { weaponType = WeaponType.STAFF; }
			else if (rollType > 10) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.SWORD; }
			break;
		case Magus:
			if (rollType > 30) { weaponType = WeaponType.STAFF; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.SWORD; }
			break;
		case ArchMage:
			if (rollType > 40) { weaponType = WeaponType.STAFF; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else { weaponType = WeaponType.DAGGER; }
			break;
			
		case Thief:
			if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Knave:
			if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case CatBurglar:
			if (rollType > 20) { weaponType = WeaponType.DAGGER; }
			else if (rollType > 10) { weaponType = WeaponType.SWORD; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Archer:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Hunter:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Sniper:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
			
		case Barbarian:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case Berserker:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		case RedMist:
			if (rollType > 30) { weaponType = WeaponType.SWORD; }
			else if (rollType > 15) { weaponType = WeaponType.DAGGER; }
			else { weaponType = WeaponType.STAFF; }
			break;
		
		default: System.out.println("Error at Weapon Type Roll"); break;
		
		}
		
		
		
		int rollWeapon = random.nextInt(100) + 1;
		switch (weaponTier) {
		
		case 1:
			switch (weaponType) {
			case DAGGER:
				if (rollWeapon > 50 && PHY >= 40) { weapon = new Dagger(); }
				else { weapon = new Knife(); }
				break;
			case STAFF:
				weapon = new Quarterstaff();
				break;
			case SWORD:
				if (rollWeapon > 50  && PHY >= 55) { weapon = new BroadSword(); }
				else { weapon = new IronSword(); }
				break;
			default: break;			
			}
		break;	
			
		case 2:	
			switch(weaponType) {
			case DAGGER:
				weapon = new Dirk();
				break;
			case STAFF:
				weapon = new Bo();
				break;
			case SWORD:
				if (rollWeapon > 50 && PHY >= 70) { weapon = new BastardSword(); }
				else { weapon = new Sabre(); }
				break;
			}
		break;
			
		case 3:
			switch(weaponType) {
			case DAGGER:
				if (rollWeapon > 50 && PHY >= 60) { weapon = new Machete(); }
				else { weapon = new Cinqueada(); }
				break;
			case STAFF:
				if (rollWeapon > 50 && PHY >= 50) { weapon = new Baton(); }
				else { weapon = new Cudgel(); }
				break;
			case SWORD:				
				if (rollWeapon > 66 && PHY >= 75) { weapon = new Scimitar(); }
				else if (rollWeapon > 33 && PHY >= 70) { weapon = new Katana(); }
				else { weapon = new Foil(); }
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
				if (rollWeapon > 66 && PHY >= 80) { weapon = new Falchion(); }
				else if (rollWeapon > 33 && PHY >= 75) { weapon = new SilverSword(); }
				else { weapon = new Epee(); }
				break;
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
				if (rollWeapon > 50 && PHY >= 90) { weapon = new Excalibur(); }
				else { weapon = new VorpalSword(); }
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
