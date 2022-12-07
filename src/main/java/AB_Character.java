/**
 * Represents a type of Character and holds stats including position, hp, mp,
 * attackStrength, and defense value
 * @author Group 2
 *
 */
public abstract class AB_Character {

	private int xPos;
	private int yPos;
	private CharIcon icon;
	private String characterType;
	private int healthPoints; 
	private int manaPoints;
	private int attackStrength;
	private int defenseValue;
	
	/**
	 * 
	 * @param xPos
	 * @param yPos
	 * @param characterType
	 * @param healthPoints
	 * @param manaPoints
	 * @param attackStrength
	 * @param defenseValue
	 */
	AB_Character(int xPos, int yPos, String characterType, int healthPoints, int manaPoints, int attackStrength, int defenseValue) {
		set_xPos(xPos);
		set_yPos(yPos);
		setCharacterType(characterType);
		setIcon(); // the icon is set based on the characterType determined above - which is why no value is passed in as an argument
		setHealthPoints(healthPoints);
		setManaPoints(manaPoints);
		setAttackStrength(attackStrength);
		setDefenseValue(defenseValue);
	}
	
	/**
	 * 
	 * @param x position
	 */
	public void set_xPos(int x) {
		xPos = x;
	}
	
	/**
	 * 
	 * @return x position
	 */
	public int get_xPos() {
		return xPos;
	}
	
	/**
	 * 
	 * @param y position
	 */
	public void set_yPos(int y) {
		yPos = y;
	}
	
	/**
	 * 
	 * @return y position
	 */
	public int get_yPos() {
		return yPos;
	}
	
	/**
	 * sets the icon to an enum value based on the vale of the playerType string that is determined
	 * when an AB_Character class type is created
	 */
	public void setIcon() {
		if(this.characterType.toLowerCase().equals("PlayerCharacter".toLowerCase())) {
			icon = CharIcon.Player;
		}
		else if(this.characterType.toLowerCase().equals("Friendly".toLowerCase())){
			icon = CharIcon.Freindly;
		}
		else if(this.characterType.toLowerCase().equals("Enemy".toLowerCase())) {
			icon = CharIcon.Enemy;
		}
		else {
			icon = CharIcon.Default;
		}
	}
	
	/**
	 * 
	 * @return icon
	 */
	public CharIcon getIcon() {
		return icon;
	}
	
	/**
	 * 
	 * @param type
	 */
	public void setCharacterType(String type) {
		characterType = type;
	}
	
	/**
	 * 
	 * @return character type
	 */
	public String getCharacterType() {
		return characterType.toLowerCase();
	}
	
	/**
	 * 
	 * @param HP
	 */
	public void setHealthPoints(int HP) {
		healthPoints = HP;
	}
	
	/**
	 * 
	 * @return health points
	 */
	public int getHealthPoints() {
		return healthPoints;
	}
	
	/**
	 * 
	 * @param MP
	 */
	public void setManaPoints(int MP) {
		manaPoints = MP;
	}
	
	/**
	 * 
	 * @return mana points
	 */
	public int getManaPoints() {
		return manaPoints;
	}
	
	/**
	 * 
	 * @param strength
	 */
	public void setAttackStrength(int strength) {
		attackStrength = strength;
	}
	
	/**
	 * 
	 * @return attack strength
	 */
	public int getAttackStrength() {
		return attackStrength;
	}
	
	/**
	 * 
	 * @param DV
	 */
	public void setDefenseValue(int DV) {
		defenseValue = DV;
	}
	
	/**
	 * 
	 * @return defense value
	 */
	public int getDefenseValue() {
		return defenseValue;
	}
}

