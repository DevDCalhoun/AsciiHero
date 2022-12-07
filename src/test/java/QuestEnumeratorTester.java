import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class QuestEnumeratorTester {

	@Test
	public void testEnemyList() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Vector<String> enemiesVec; 
		enemiesVec = questEnum.getAllEnemiesList();
		assertFalse(enemiesVec.isEmpty());
	}
	
	@Test
	public void testFriendlyNPCsList() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Vector<String> friendliesVec;
		friendliesVec = questEnum.getAllFriendliesList();
		assertFalse(friendliesVec.isEmpty());
	}

	@Test
	public void testItemsList() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Vector<String> itemsVec;
		itemsVec = questEnum.getAllItemsList();
		assertFalse(itemsVec.isEmpty());
	}
	
	@Test
	public void testRewardItemsList() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Vector<String> rewardsVec;
		rewardsVec = questEnum.getAllItemsList();
		assertFalse(rewardsVec.isEmpty());
	} 		

	@Test
	public void testGetNewEvilQuest() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Quest tempQuest = new Quest(questEnum.getNewQuest("evil"));
		Vector<String> tempItemsVec = tempQuest.getItems();

		assertTrue(tempQuest.getEnemyName() != null);

		assertFalse(tempItemsVec.isEmpty());
	}

	@Test
	public void testGetNewGoodQuest() {
		QuestEnumerator questEnum = new QuestEnumerator();
		Quest tempQuest = questEnum.getNewQuest("good");
		Vector<String> tempItemsVec = tempQuest.getItems();
		
		assertTrue(tempQuest.getEnemyName() != null);
		assertFalse(tempItemsVec.isEmpty());
	}

}

