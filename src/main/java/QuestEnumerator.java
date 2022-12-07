import java.util.Vector;
import java.util.Collections;
/**
 * cen3031-fall22-tr-semester-project-cen3031fall22tr-group-2
 * 
 * QuestEnumerator.java
 * Class to generate random good and evil quests. 
 * 
 * Pre-Conditions:
 *      enemies.txt, friendlyNPCs.txt, mapItems.txt files exist and are written one item per line.
 *	mapItems contains at least three times the number of (enemies + friendlyNPCs)
 *	
 */
public class QuestEnumerator {
	private Vector<String> enemies = new Vector<String>();
	private Vector<String> friendlyNPCs = new Vector<String>();
	private Vector<String> mapItems = new Vector<String>();
	private Vector<String> rewardItemsNames = new Vector<String>();
	//private Vector<Item> rewardItems = new Vector<Item>();
	private Vector<Quest> goodQuests = new Vector<Quest>();
	private Vector<Quest> evilQuests = new Vector<Quest>();
	private int rewardPoints;
	public int itemsIndex = 0;
	public int rewardIndex = 0;
	private String questNarrative;
	private questItem reward;
	
	public QuestEnumerator(){
		MapContentFileReader enemyReader = new MapContentFileReader("enemies.txt");
		enemies = enemyReader.getContents();

		MapContentFileReader friendlyReader = new MapContentFileReader("friendlyNPCs.txt");
		friendlyNPCs = friendlyReader.getContents();

		MapContentFileReader mapItemsReader = new MapContentFileReader("mapItems.txt");
		mapItems = mapItemsReader.getContents();
		
		MapContentFileReader rewardItemsReader = new MapContentFileReader("rewardItems.txt");
		rewardItemsNames = rewardItemsReader.getContents();

		Collections.shuffle(enemies);
		Collections.shuffle(friendlyNPCs);
		Collections.shuffle(mapItems);
		Collections.shuffle(rewardItemsNames);

		setEvilQuests();
		setGoodQuests();
	}
	
	private void setEvilQuests(){
		Quest tempQuest;

		
		for(int i = 0; i < friendlyNPCs.size(); i++){

			rewardPoints = 0;
			Vector<String> tempItemsVec = new Vector<String>();
			int questSize = 1 + (int)(Math.random() * 3);

			String name = friendlyNPCs.elementAt(i);
			
			for(int j = 0; j < questSize; j++){
				tempItemsVec.add(mapItems.elementAt(itemsIndex)); //add the next item from mapItems to tempItemsVec for quest
				itemsIndex++;
				rewardPoints++;
			}

			setQuestNarrative(name, tempItemsVec);

			reward = new questItem(rewardItemsNames.get(rewardIndex));
			tempQuest = new Quest(name, tempItemsVec, questNarrative, rewardPoints, reward);

			rewardIndex++;
			evilQuests.add(tempQuest);

		}		
	}

	private void setGoodQuests(){
		Quest tempQuest;

		
		for(int i = 0; i < enemies.size(); i++){
			rewardPoints = 0;
			Vector<String> tempItemsVec = new Vector<String>();
			int questSize = 1 + (int)(Math.random() * 3);

			String name = enemies.elementAt(i);
			
			for(int j = 0; j < questSize; j++){
				tempItemsVec.add(mapItems.elementAt(itemsIndex)); //add the next item from mapItems to tempItemsVec for quest
				itemsIndex++;
				rewardPoints++;
			}

			setQuestNarrative(name, tempItemsVec);

			reward = new questItem(rewardItemsNames.get(rewardIndex));
			tempQuest = new Quest(name, tempItemsVec, questNarrative, rewardPoints, reward);

			rewardIndex++;
			goodQuests.add(tempQuest);

		}		
	}
	
	public Quest getNewQuest(String morality){
		if(morality.toLowerCase() == "evil"){
			if(evilQuests.size() == 0){
				return null;
			}else{
				return evilQuests.remove(0);
			}
		}else{
			if(goodQuests.size() == 0){
				return null;
			}else{
				return goodQuests.remove(0);
			}
		}
	}
	
	public void setQuestNarrative(String enemyName, Vector<String> items) {
		if(items.size() == 1) {
			questNarrative = String.format("Go kill this %s for me and get me a %s and you will get a reward.", enemyName, items.get(0));
		}else if(items.size() == 2) {
			questNarrative = String.format("Go kill this %s for me and get me a(n) %s and a(n) %s and you will get a reward.", enemyName, items.get(0), items.get(1));
		}else if(items.size() == 3){
			questNarrative = String.format("Go kill this %s for me and get me a(n) %s, a(n) %s and a(n) %s and you will get a reward.", enemyName, items.get(0), items.get(1), items.get(2));
		}
	}
	
	
	public Vector<String> getAllEnemiesList(){
		return enemies;
	}
	
	public Vector<String> getAllFriendliesList(){
		return friendlyNPCs;
	}
	
	public Vector<String> getAllItemsList(){
		return mapItems;
	}


}

