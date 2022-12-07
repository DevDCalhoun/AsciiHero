/**
* Quest.Java
* Class to hold quest information given by the questEnumerator
*/

import java.util.Vector;

public class Quest {
	
	private String enemyName;
	
	/**
	 * Vector of item names that will be collected by player
	 */
	private Vector<String> items;
	
	/**
	 * Describes the quest objective
	 */
	private String narrative;
	private questItem rewardItem = new questItem("Quest Reward");
	private int rewardPoints;
	
	/**
	 * The status of the quest
	 */
	private char questStatus = 'N';
	
	private int questAlignmentReward;
	
	/**
	 * Default constructor
	 */
	public Quest() {
		setEnemyName("Default");
		setItems(new Vector<String>());
		setNarrative(null);
		setQuestAlignmentReward(0);
	}
	
	/**
	 * Parameterized Constructor for enemy and items
	 * @param enemyName  Name of enemy
	 * @param items  a vector of item names that will be collected by player
	 */
	public Quest(String enemyName, Vector<String> items) {
		setEnemyName(enemyName);
		setItems(items);
		setNarrative(null);
	}
	
	/**
	 * Parameterized Constructor for enemy, items, and narrative
	 * @param enemyName  Name of enemy
	 * @param items  a vector of item names that will be collected by player
	 * @param narrative  Describes the quest objective
	 */
	public Quest(String enemyName, Vector<String> items, String narrative, int rewardPoints, questItem reward) {
		setEnemyName(enemyName);
		setItems(items);
		setNarrative(narrative);
		setRewardPoints(rewardPoints);
		rewardItem = new questItem(reward);
	}
	
	/**
	 * Copy Constructor
	 */
	public Quest(Quest q) {
		this.enemyName = q.enemyName;
		this.items = q.getItems();
		this.narrative = q.getNarrative();
		}
	
	/**
	 * Returns the enemyName object
	 * @return name of the enemy
	 */
	public String getEnemyName() {
		return enemyName;
	}

	/**
	 * Sets the enemyName object
	 * @param enemyName name of the enemy
	 */
	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public void setRewardItem(questItem reward) {
		this.rewardItem = new questItem(reward);
	}
	
	public Item getRewardItem() {
		return rewardItem;
	}
	/**
	 * Returns the vector holding the quest's item names
	 * @return  a vector of item names that will be collected by player
	 */
	public Vector<String> getItems() {
		return items;
	}

	/**
	 * Sets the items vector
	 * @param items  a vector of item names that will be collected by player
	 */
	public void setItems(Vector<String> items) {		
		this.items = items;
	}
	
	
	/**
	 * Returns the narrative variable
	 * @return the narrative  Describes the quest objective
	 */
	public String getNarrative() {
		return narrative;
	}

	/**
	 * Sets the narrative variable
	 * @param narrative  Describes the quest objective
	 */
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	
	public void setRewardPoints(int reward) {
		this.rewardPoints = reward;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}

	/**
	 * Returns the questStatus char
	 * @return the status of the quest
	 */
	public char getQuestStatus() {
		return questStatus;
	}

	/**
	 * Sets the questStatus char
	 * @param questStatus The status of the quest
	 */
	public void setQuestStatus(char questStatus) {
		this.questStatus = questStatus;
	}
	
	public void setQuestAlignmentReward(int questAlignmentReward) {
		this.questAlignmentReward = questAlignmentReward;
	}
	
	public int getQuestAlignmentReward() {
		return questAlignmentReward;
	}
	
}
