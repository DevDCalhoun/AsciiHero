import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

/**
 * Tracks key events that happens within a QuestHunter GUI
 * @author Group 2
 *
 */
public class KeyEventListener implements KeyListener {
	private int key;
	AsciiHeroGui gui;
	PlayerCharacter playerCharacter;
	MapBuilder map;
	GameRoundManager grm;
	InventoryScreen inv;
	InventoryLists list;
	
	/**
	 * 
	 * @param gui
	 * @param playerCharacter
	 * @param map
	 * @param grm
	 */
	KeyEventListener(AsciiHeroGui gui, PlayerCharacter playerCharacter, MapBuilder map, GameRoundManager grm, InventoryLists list) {
		this.gui = gui;
		this.playerCharacter = playerCharacter;
		this.map = map;
		this.grm = grm;
		this.list = list;
		inv = new InventoryScreen(list);
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		key = e.getKeyCode();
		
		if(!inv.frame.isShowing()){
			if(!(Character.compare(c, 'q') > 0) && !(Character.compare(c, 'q') < 0)) {
				try {
					gui.takeQuest();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		
		if ((key == KeyEvent.VK_LEFT) && (playerCharacter.get_xPos() - 1 > -1)) {
			if(!(map.getMap()[playerCharacter.get_xPos() - 1][playerCharacter.get_yPos()] == TileEnum.Tree) && !(map.getMap()[playerCharacter.get_xPos() - 1][playerCharacter.get_yPos()] == TileEnum.TreeTop) && !(map.getMap()[playerCharacter.get_xPos() - 1][playerCharacter.get_yPos()] == TileEnum.Stone)) {
		        playerCharacter.set_xPos(playerCharacter.get_xPos() - 1);
		        grm.nextRound(); 
		        gui.playerMove(playerCharacter.get_xPos() - 1, playerCharacter.get_yPos());
			}
	      }
		if ((key == KeyEvent.VK_RIGHT) && (playerCharacter.get_xPos() + 1 < map.getWidth())) {
			if(!(map.getMap()[playerCharacter.get_xPos() + 1][playerCharacter.get_yPos()] == TileEnum.Tree) && !(map.getMap()[playerCharacter.get_xPos() + 1][playerCharacter.get_yPos()] == TileEnum.TreeTop) && !(map.getMap()[playerCharacter.get_xPos() + 1][playerCharacter.get_yPos()] == TileEnum.Stone)) {
		        playerCharacter.set_xPos(playerCharacter.get_xPos() + 1);
		        grm.nextRound();
		        gui.playerMove(playerCharacter.get_xPos() + 1, playerCharacter.get_yPos());
		        
		        
			}
	      }
		if ((key == KeyEvent.VK_UP) && (playerCharacter.get_yPos() - 1 > -1)) {
			if(!(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() - 1] == TileEnum.Tree) && !(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() - 1] == TileEnum.TreeTop) && !(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() - 1] == TileEnum.Stone)) {
		        playerCharacter.set_yPos(playerCharacter.get_yPos() - 1);
		        grm.nextRound();
		        gui.playerMove(playerCharacter.get_xPos(), playerCharacter.get_yPos() - 1);
		        
			}
	      }
		if ((key == KeyEvent.VK_DOWN )&& (playerCharacter.get_yPos() + 1 < map.getHeight())) {
			if(!(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() + 1] == TileEnum.Tree) && !(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() + 1] == TileEnum.TreeTop) && !(map.getMap()[playerCharacter.get_xPos()][playerCharacter.get_yPos() + 1] == TileEnum.Stone)) {
		        playerCharacter.set_yPos(playerCharacter.get_yPos() + 1);
		        grm.nextRound();
		        gui.playerMove(playerCharacter.get_xPos(), playerCharacter.get_yPos() + 1);
		        
			}
	      }
		if(!inv.frame.isShowing()) {
			if(key == KeyEvent.VK_I) {
			    InventoryScreen inv = new InventoryScreen(list);
			    inv.makeTabs();
		}}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}