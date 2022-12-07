import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NonPlayerCharacterTest {
	
	NonPlayerCharacter npc = new NonPlayerCharacter();
	CharIcon icon;

	@Test
	void xTest() {		
		assert(npc.get_xPos() == 10);				
	}
	
	@Test
	void yTest() {
		assert(npc.get_yPos() == 12);
	}
	
	@Test
	void iconTest() {
		
		npc.setIcon();
		assert(npc.getIcon() == CharIcon.Enemy);
	}

	@Test
	void isEnemyTest() {
		assertTrue(npc.getIsEnemy());
	}
	
	@Test
	void fovTest() {
		assert(npc.getFieldOfView() == 5);
	}
	
	@Test
	void HPTest() {
		assert(npc.getHealthPoints() == 10);
	}
	
	@Test
	void manaTest() {
		assert(npc.getManaPoints() == 10);
	}
	
	@Test
	void attackStrengthTest() {
		assert(npc.getAttackStrength() == 10);
	}
	
	@Test
	void defenseValueTest() {
		assert(npc.getDefenseValue() == 10);
	}
	
	

}