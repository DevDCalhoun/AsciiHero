import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;


class QuestTester {
	
	@Test
	void testGetEnemyName() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>());
		//Act
		String enemyName = q.getEnemyName();
		//Assert
		assertTrue(enemyName.equals("NewEnemy"));
	}
	
	@Test
	void testSetEnemyName() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>());
		//Act
		q.setEnemyName("NewerEnemy");
		String enemyName = q.getEnemyName();
		//Assert
		assertTrue(enemyName.equals("NewerEnemy"));
	}
	
	
	@Test
	void testGetItems() {
		//Arrange
		Vector<String> i = new Vector<String>();
		i.add("item123");
		Quest q = new Quest("NewEnemy", i);	
		//Act
		Vector<String> i2 = q.getItems();
		i2.add("item123");
		//Assert
		assertTrue(i.elementAt(0).equals(i2.elementAt(0)));
	}
	
	@Test
	void testSetItems() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>());
		Vector<String> i = new Vector<String>();
		i.add("item123");
		//Act
		q.setItems(i);
		//Assert
		assertTrue(i.elementAt(0).equals(q.getItems().elementAt(0)));
	}
	
	@Test
	void testGetNarrative() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>(), "Go eleminate the new enemy", 5, new questItem("testReward"));
		//Act
		String narrative = q.getNarrative();
		//Assert
		assertTrue(narrative.equals("Go eleminate the new enemy"));
	}
	
	@Test
	void testSetNarrative() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>(), "Go eleminate the new enemy", 0, new questItem("testReward"));
		//Act
		q.setNarrative("Go find the sword");
		String narrative = q.getNarrative();
		//Assert
		assertTrue(narrative.equals("Go find the sword"));
	}
	
	@Test
	void testGetQuestStatus() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>());
		//Act
		char status = q.getQuestStatus();
		//Assert
		assertTrue(status == 'N');		// N for quest is not finished
	}
	
	@Test
	void testSetQuestStatus() {
		//Arrange
		Quest q = new Quest("NewEnemy", new Vector<String>());
		//Act
		q.setQuestStatus('F');
		char status = q.getQuestStatus();
		//Assert
		assertTrue(status == 'F');
		
	}
	
	@Test
	void testRewardPoints() {
		Quest q = new Quest("New Enemy", new Vector<String>(), "Narrative", 10, new questItem("testReward"));
		int firstReward = q.getRewardPoints();
		q.setRewardPoints(5);
		int secondReward = q.getRewardPoints();
		
		assertTrue(firstReward == 10);
		assertTrue(secondReward == 5);
	}
	
	@Test
	void testRewardItem() {
		Quest q = new Quest("New Enemy", new Vector<String>(), "Narrative", 10, new questItem("testReward"));
		
		assertTrue(q.getRewardItem() != null);
		
		questItem tempItem = new questItem("test health item");
		
		q.setRewardItem(tempItem);

		Item reward = q.getRewardItem();
		
		assertTrue(reward.getItemName() == "test health item");
	}
	
	@Test
	void testCopyConstructor() {
		Vector<String> itemsList = new Vector<String>();
		itemsList.add("one");
		itemsList.add("two");
		Quest toBeCopied = new Quest("enemy's name", itemsList, "This is a quest narrative", 0, new questItem("testReward"));
		
		Quest copiedQuest = toBeCopied;
		
		assertTrue(copiedQuest.getEnemyName() == "enemy's name");
		assertTrue(copiedQuest.getNarrative() == "This is a quest narrative");
		assertTrue(toBeCopied.getItems() == copiedQuest.getItems());
	}
	
	@Test
	void testAlignmentRewards() {
		Quest q = new Quest();
		
		q.setQuestAlignmentReward(10);
		
		assertTrue(q.getQuestAlignmentReward() == 10);
	}
	
}