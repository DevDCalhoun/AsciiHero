import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BattleTester {

	@Test
	void testUpdateVictimHP() {
		AB_Character victim = new NonPlayerCharacter();
		victim.setHealthPoints(5);
		victim.setDefenseValue(8);
		
		Battle battle = new Battle();
		battle.setVictim(victim);
		battle.setVictimStats();
		
		battle.updateVictimHP(2);
		
		assertTrue(victim.getHealthPoints() == 3);
	}
	
	@Test
	void testGetRandomAmount() {
		Battle battle = new Battle();
		int num = battle.getRandomAmount(10);
		
		assertTrue(num >= 0);
		assertTrue(num <= 10);
	}
	
	@Test
	void testCalculateDamage() {
		AB_Character victim = new NonPlayerCharacter();
		AB_Character attacker = new NonPlayerCharacter();
		
		Battle battle = new Battle();
		
		int damage = battle.calculateDamage();
		
		assertTrue(damage >= 0);
	}
	
	@Test
	void testAttackerStrength() {
		AB_Character victim = new NonPlayerCharacter();
		AB_Character attacker = new NonPlayerCharacter();
		
		attacker.setAttackStrength(100);//initial value to ensure change
		
		Battle battle = new Battle();
		battle.attack(attacker, victim);
		
		assertTrue(battle.getAttackerStrength() == 100);
	}
	
	@Test
	void testAttack() {
		AB_Character victim = new NonPlayerCharacter();
		AB_Character attacker = new NonPlayerCharacter();
		
		attacker.setAttackStrength(100);
		victim.setDefenseValue(1);//set low to ensure attack will affect overall health
		victim.setHealthPoints(100);
		
		Battle battle = new Battle();
		battle.attack(attacker, victim);
		
		/*
		 * assert that new health is loser than original health (100)
		 */
		assertTrue((100) > victim.getHealthPoints());
		
	}

}
