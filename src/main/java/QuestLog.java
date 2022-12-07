import java.util.Vector;

public class QuestLog{
	
	private final int MAX_QUESTS_IN_QUEUE = 2;
	private Vector<Quest> completedQuests;
	private Vector<Quest> questQueue;
	private Quest currentQuest;
	
	public QuestLog() {
		completedQuests = new Vector<Quest>();
		questQueue = new Vector<Quest>();
	}
	
	/**
	 * Adds quest to questQueue vector
	 * @param newQuest  Quest object to be added to questQueue vector
	 */
	public void addNewQuest(Quest newQuest) {
		if(questQueue.size() < MAX_QUESTS_IN_QUEUE) {
			if(questQueue.size() == 0) {
				currentQuest = newQuest;
			}
			questQueue.add(newQuest);
		}
	}
	
	/**
	 * Adds completed quest to completedQuests vector
	 * @param completedQuest  recently completed quest
	 */
	public void addToCompleted(Quest completedQuest) {
		completedQuests.add(completedQuest);
	}
	
	public void completeQuest() {
		questQueue.remove(0);
		currentQuest = getNextActiveQuest();
	}
	
	/**
	 * Selects the next quest in the questQueue to be current active
	 * @return the next current quest if available, null if not
	 */
	public Quest getNextActiveQuest() {
		if(questQueue.size() > 0) {
			currentQuest = questQueue.elementAt(0);
			return currentQuest;
		}else {
			return null;
		}
	}
	
	/**
	 * 
	 * @return a boolen to determine whether another quest may be added to the queue
	 */
	public boolean isQueueFull() {
		if(questQueue.size() == MAX_QUESTS_IN_QUEUE) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return a string from the quest object that details the object of the current active quest
	 */
	public String getCurrentNarrative() {
		return currentQuest.getNarrative();
	}
	
	/**
	 * 
	 * @return name of the enemy of current active quest
	 */
	public String getCurrentEnemy() {
		return currentQuest.getEnemyName();
	}
	
	/**
	 * 
	 * @return a vector of all the items required for the current active quest
	 */
	public Vector<String> getCurrentItems(){
		return currentQuest.getItems();
	}
	
	/**
	 * 
	 * @return the current quest player is on
	 */
	public Quest getCurrentQuest() {
		return currentQuest;
	}

}
