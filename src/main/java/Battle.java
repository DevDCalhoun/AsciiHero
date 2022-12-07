/**
 * cen3031-fall22-tr-semester-project-cen3031fall22tr-group-2
 * 
 * Battle.java
 * Class contains battle functionality. Calculates attack hits and carries out attack. 
 * 
 * Pre-Conditions:
 *      AB_Character class is functional and contains appropriate setters/getters
 *      
 * Post-Condition:
 * 		Victim character in each battle will have updated HP points
 *	
 */
public class Battle {
	private int attackerStrength;
	private int victimDefense;
	private int victimHealthPoints;
	private AB_Character attacker;
	private AB_Character victim;
	
	/*
	 * Carries out attack on a victim by an attacker 
	 * Important note- characters must be passed in in appropriate order: attacker first
	 */
	public void attack(AB_Character newAttacker, AB_Character newVictim) {
		setAttacker(newAttacker);
		setVictim(newVictim);
		
		setAttackerStrength(attacker.getAttackStrength());
		setVictimStats();
		updateVictimHP(calculateDamage());
	}
	
	public void setAttacker(AB_Character att) {
		attacker = att;
	}
	
	public void setVictim(AB_Character vic) {
		victim = vic;
	}
	
	public void setAttackerStrength(int strength){
		attackerStrength = strength;
	}
	
	public int getAttackerStrength() {
		return attackerStrength;
	}
	
	public void setVictimStats(){
		victimDefense = victim.getDefenseValue();
		victimHealthPoints = victim.getHealthPoints();
	}
	
	/*
	 * random integer to be used in determining attack and defense strength
	 */
	public int getRandomAmount(int max) {
		int rand = (int) (Math.random()*(max));
		return rand;
	}
	
	/*
	 * Calculate damage uses random integers to calculate to intensity of a hit on a victim
	 */
	public int calculateDamage() {
		int hit = getRandomAmount(attackerStrength);
		int defense = getRandomAmount(victimDefense);
		
		int damage = (hit - defense);
		
		if(damage <= 0) {
			return 0;
		}else {
			return damage;
		}
	}
	
	/*
	 * updates HP of the victim directly
	 */
	public void updateVictimHP(int damage) {
		int updatedHP = (victimHealthPoints - damage);
		victim.setHealthPoints(updatedHP);
	}
}

