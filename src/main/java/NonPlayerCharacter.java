/**
 * Non-Player Character represents either an enemy or a friendly npc and
 * holds statistics such as friendly/enemy status, if the npc has a quest, npc
 * statistics, field of view, and general statistics related to combat
 * @author Group 2
 *
 */
public class NonPlayerCharacter extends AB_Character{
	
	private boolean isEnemy;
	private boolean hasQuest;
	private int fieldOfView;

	public NonPlayerCharacter() {
		super(10, 12, "Enemy", 10, 10, 10, 10);
		setIsEnemy();
		setFieldOfView(5);
	}
	
	public NonPlayerCharacter(int xPos, int yPos, String characterType, int healthPoints, int manaPoints, int attackStrength, int defenseValue, int fieldOfView) {
		super(xPos, yPos, characterType, 10, 10, 10, 10);
		setIsEnemy();
		setFieldOfView(fieldOfView);
	}
	
	public void setIsEnemy() {
		if(super.getIcon() == CharIcon.Enemy) {
			isEnemy = true;
		}
		else {
			isEnemy = false;
		}
	}
	
	public boolean getIsEnemy() {
		return isEnemy;
	}
	
	public void setQuest() {
		//get a quest from wherever we decide to get quests
		if(super.getCharacterType().equals(("Friendly".toLowerCase()))) {
			hasQuest = true;
		}
	}
	
	public boolean getQuest() {
		return hasQuest;
	}
	
	public void setFieldOfView(int FOV) {
		fieldOfView = FOV;
	}
	
	public int getFieldOfView() {
		return fieldOfView;
	}
}
