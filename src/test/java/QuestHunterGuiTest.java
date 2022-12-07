import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

public class QuestHunterGuiTest {

	@Test
	public void test() throws FileNotFoundException {
		PlayerCharacter playerCharacter = new PlayerCharacter();
		ArrayList<NonPlayerCharacter> npcs = new ArrayList<NonPlayerCharacter>();
		ArrayList<Item> items = new ArrayList<Item>();
		MapBuilder map = new MapBuilder(80, 24); 
		QuestLog playerLog = new QuestLog();
		InventoryLists list = new InventoryLists(playerCharacter);
		GameRoundManager grm = new GameRoundManager(playerCharacter, npcs, items, map, playerLog, list);
		AsciiHeroGui gui = new AsciiHeroGui(playerCharacter, map, grm, playerLog); 
		
		
		assert(gui.isVisible()); 
		assert(gui.isGamePanelVisible()); 
		assert(gui.getCurrentQuest() == null); 
	}

}