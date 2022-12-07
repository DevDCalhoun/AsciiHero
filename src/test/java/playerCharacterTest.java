import static org.junit.Assert.*;

import org.junit.Test;

public class playerCharacterTest {

	PlayerCharacter player = new PlayerCharacter();
	private CharIcon icon;
	
	@Test
	public void xPosTest() {
		assertEquals(player.get_xPos(), 40);
	}

	public void yPosTest() {
		assertEquals(player.get_yPos(), 12);
	}
	
	public void iconTest() {
		assertEquals(player.getIcon(), CharIcon.Player);
	}
	
	public void characterTest() {
		assertEquals(player.getCharacterType(), "playercharacter");
	}
	
	public void HealthPointValueTest() {
		assertEquals(player.getHealthPoints(), 10);
	}
	
	public void manaValueTest() {
		assertEquals(player.getManaPoints(), 10);
	}
	
	public void attackStrengthValueTest() {
		assertEquals(player.getAttackStrength(), 10);
	}
	
	public void defenseValueTest() {
		assertEquals(player.getDefenseValue(), 10);
	}
	
	public void alignmentValueTest() {
		player.setAlignment(player.getAlignment() + 1);
		assertEquals(player.getAlignment(), 1);
	}
	
	public void hasQuestTest( ) {
		player.setHasQuest(true);
		assertEquals(player.isHasQuest(), true);
	}
}

