import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Ab_CharacterTest extends AB_Character{
	
		public Ab_CharacterTest(){
			super(25,25,"PlayerCharacter",100,100,100,100);
		}
		
		@Test
		void xPosTest() {
			assertEquals(get_xPos(), 25, "Should be 25");
		}
		
		@Test
		void yPosTest() {
			assertEquals(get_yPos(), 25, "Should be 25");
		}
		
		@Test
		void characterTypeTest() {
			assertEquals(getCharacterType(), "playercharacter", "Should be playercharacter");
		}
		
		@Test
		void healthPointsValueTest() {
			assertEquals(getHealthPoints(), 100, "Should be 100");
		}
		
		@Test
		void manaValueTest() {
			assertEquals(getManaPoints(), 100, "Should be 100");
		}
		
		@Test
		void attackkStrengthValueTest() {
			assertEquals(getAttackStrength(), 100, "Should be 100");
		}
		
		@Test
		void defenseValueTest() {
			assertEquals(getDefenseValue(), 100, "Should be 100");
		}
	
}

