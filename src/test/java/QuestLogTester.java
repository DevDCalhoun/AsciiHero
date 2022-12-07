import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class QuestLogTester {

	@Test
	void testGetCurrentNarrative() {
		//Arrange
		QuestLog ql = new QuestLog();
		Quest q = new Quest("Enemy", new Vector<String>(), "Eliminate the enemy", 0, new questItem("test reward"));
		ql.addNewQuest(q);
		ql.getNextActiveQuest();
		//Act
		String narrative = ql.getCurrentNarrative();
		//Assert
		assertTrue(q.getNarrative().equals(narrative));
		
	}
	
	@Test
	void testGetCurrentEnemy() {
		//Arrange
		QuestLog ql = new QuestLog();
		Quest q = new Quest("Enemy", new Vector<String>(), "Eliminate the enemy", 0, new questItem("test reward"));
		ql.addNewQuest(q);
		ql.getNextActiveQuest();
		//Act
		String enemy = ql.getCurrentEnemy();
		//Assert
		assertTrue(q.getEnemyName().equals(enemy));
	}
	
	@Test
	void getCurrentItems() {
		//Arrange
		QuestLog ql = new QuestLog();
		Vector<String> items = new Vector<String>();
		items.add("Key");
		Quest q = new Quest("Enemy", items, "Eliminate the enemy", 0, new questItem("test reward"));
		ql.addNewQuest(q);
		ql.getNextActiveQuest();
		//Act
		String item = ql.getCurrentItems().elementAt(0);
		//Assert
		assertTrue(q.getItems().elementAt(0).equals(item));
	}
	
	@Test
	void testIsQueueFullWhenFull() {
		//Arrange
		QuestLog ql = new QuestLog();
		Quest q = new Quest("Enemy1", new Vector<String>());
		Quest q2 = new Quest("Enemy2", new Vector<String>());
		ql.addNewQuest(q);
		ql.addNewQuest(q2);
		//Act
		Boolean full = ql.isQueueFull();
		//Assert
		assertTrue(full);
	}
	
	@Test
	void testIsQueueFullWhenEmpty() {
		//Arrange
		QuestLog ql = new QuestLog();
		//Act
		Boolean full = ql.isQueueFull();
		//Assert
		assertFalse(full);
	}

}
