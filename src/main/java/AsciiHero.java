import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Vector;

/*
 * AsciiHero main function
 * @authors Daryl Calhoun, Emily Griggs, Jordan Chaplin, Henry Castro, Lane Wilson
 *
 */
public class AsciiHero {

	public static void main(String[] args) throws FileNotFoundException {
		PlayerCharacter playerCharacter = new PlayerCharacter();
		ArrayList<NonPlayerCharacter> npcs = new ArrayList<NonPlayerCharacter>();
		ArrayList<Item> items = new ArrayList<Item>();
		
		NonPlayerCharacter enemy = new NonPlayerCharacter();
		NonPlayerCharacter enemy2 = new NonPlayerCharacter();
		NonPlayerCharacter enemy3 = new NonPlayerCharacter();
		NonPlayerCharacter enemy4 = new NonPlayerCharacter();
		NonPlayerCharacter enemy5 = new NonPlayerCharacter();
		NonPlayerCharacter enemy6 = new NonPlayerCharacter();
		NonPlayerCharacter friendly = new NonPlayerCharacter(40, 12, "Friendly", 10, 10, 10, 10, 5);
		
		QuestLog playerLog = new QuestLog();
		
		npcs.add(enemy);
		npcs.add(enemy2);
		npcs.add(enemy3);
		npcs.add(enemy4);
		npcs.add(enemy5);
		npcs.add(enemy6);
		npcs.add(friendly);
		
		MapBuilder map = new MapBuilder(80, 24); //2d map used within the GUI
		InventoryLists list = new InventoryLists(playerCharacter);
		GameRoundManager grm = new GameRoundManager(playerCharacter, npcs, items, map, playerLog, list); // controller for main game loop
		AsciiHeroGui gui = new AsciiHeroGui(playerCharacter, map, grm, playerLog);
		
		KeyEventListener keyListener = new KeyEventListener(gui, playerCharacter, map, grm, list); // handles all key events and connected events between class objects
		
		gui.getMapPanel().setFocusable(true);
		gui.addKeyListener(keyListener);
	}

}