import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import asciiPanel.AsciiPanel;

/**
 * QuestHunterGui provides basic Gui structure
 * for Quest Hunter
 * @author Jordan Chaplin & Daryl Calhoun
 *
 */
public class AsciiHeroGui extends JFrame {
	private AsciiPanel gamePanel; // AsciiPanel added on top of JFrame
	private boolean guiVisible; // used for test purposes with J-Unit
	private boolean hasQuest;
	private JOptionPane questPane; // quest pane used for retrieval and explanation of quest tasks
	private PlayerCharacter playerCharacter;
	private MapBuilder map;
	private int randMap;
	private String questNarrative;
	private GameRoundManager grm;
	QuestLog playerLog;
	QuestEnumerator questGenerator;
	Quest currentQuest;
	Object[] possibilities = {"Good Quest", "Evil Quest"};
	NarrativeGenerator narrativeGen;
	
	AsciiHeroGui(PlayerCharacter playerCharacter, MapBuilder map, GameRoundManager grm, QuestLog playerLog) throws FileNotFoundException {
		super(); // new JFrame
		guiVisible = false; // used for testing purposes in J-Unit test
		hasQuest = false;
		createLayout(); // sets up the basic layout of the Gui
		
		this.map = map;
		this.grm = grm;
		
		this.playerLog = playerLog;
		questGenerator = new QuestEnumerator();
		narrativeGen = new NarrativeGenerator();
		
		this.playerCharacter = playerCharacter;
		questNarrative = "Hello adventurer! There are no quests available at the moment. Come back later.";
		
		//building a new map
		randMap = (int) Math.floor(Math.random()*(1-0+1)+0); // used to generate one of two random maps
		buildGuiMap();
		
	}
	
	/**
	 * Creates a JFrame and adds basic AsciiPanel component
	 * using a GridLayout
	 */
	public void createLayout() {
		//create AsciiPanel and set JFrame layout
		gamePanel = new AsciiPanel(80, 24); 
		setLayout(new GridLayout(1, 1)); 
		
		setSize(gamePanel.getWidth() + 20, gamePanel.getHeight() + 20); // JFrame size set to match AsciiPanel
		add(gamePanel); // AsciiPanel added to JFrame
		pack(); 
		
		setVisible(true); // Jframe .this set visible
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		questPane = new JOptionPane(); // the questPane is used to show the quest when certain actions are taken
	}
	
	/**
	 * checks if the Gui is visible and returns true if so
	 * @return guiVisible
	 */
	public boolean isGamePanelVisible() {
		if(gamePanel.isShowing()) {
			guiVisible = true;
		}
		
		return guiVisible;
	}
	
	/**
	 * takeQuest() is called when certain actions are taken by the player
	 * to retrieve a quest
	 * @throws FileNotFoundException 
	 */
	public void takeQuest() throws FileNotFoundException {
		playerCharacter.setHasQuest(true);
		boolean isEvilQuest = false;
		
		String s = (String)JOptionPane.showInputDialog(
                gamePanel,
                "Choose a Quest Type\n",
                "Quest Giver",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "ham");
		
		questGenerator = new QuestEnumerator();
		
		if(s.equals("Good Quest")) {
			currentQuest = new Quest(questGenerator.getNewQuest("Good"));
			currentQuest.setQuestAlignmentReward(1);
		}
		else {
			currentQuest = new Quest(questGenerator.getNewQuest("evil"));
			currentQuest.setQuestAlignmentReward(-1);
			isEvilQuest = true;
		}
		
		if(!playerLog.isQueueFull()) {
			playerLog.addNewQuest(currentQuest);
			if(!isEvilQuest) {
				setQuestNarrative(narrativeGen.getGoodNarrative(playerCharacter.getAlignment()) + "\n" + currentQuest.getNarrative());
			}
			else {
				setQuestNarrative(narrativeGen.getEvilNarrative(playerCharacter.getAlignment()) + "\n" + currentQuest.getNarrative());
			}
		}
		else {
			questNarrative = "You are already on too many quests. Come back when you finish one.";
		}
		
		questPane.showMessageDialog(gamePanel, questNarrative, "Quest", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setQuestNarrative(String questNarrative) {
		this.questNarrative = questNarrative;
	}

	/**
	 * builds map by using MapBuilder and passing in the size
	 * of the AsciiPanel after generating the landscape
	 */
	public void buildGuiMap() {
		//map = new MapBuilder(80, 24);
		
		// generates a valley map
		if(randMap == 0) {
			map.generateValleyGround();
			map.generateValley();
		}
		
		// generates a cave map
		if(randMap == 1) {
			map.generateCaveGround();;
			map.generateCave();
		}
		
		playerMove(playerCharacter.get_xPos(), playerCharacter.get_yPos()); // places initial player position and generates the map initially
	}
	
	public void playerMove(int x, int y) {
		gamePanel.clear();
		redrawMap();
		if(playerCharacter.getHealthPoints() > 0) {
		    gamePanel.write(playerCharacter.getIcon().icon(), playerCharacter.get_xPos(), playerCharacter.get_yPos(), playerCharacter.getIcon().color());
		}
		ArrayList<NonPlayerCharacter> characters = grm.getNPCs();
        for(NonPlayerCharacter character : characters) {
           gamePanel.write(character.getIcon().icon(), character.get_xPos(), character.get_yPos(), character.getIcon().color());
        }
        
        ArrayList<Item> items = grm.getItems();
        for(Item item: items) {
        	if(!item.isCollected()) {
        		if((item.get_xPos() != -1) && (item.get_yPos() != -1))
        			gamePanel.write((char)5, item.get_xPos(), item.get_yPos(), AsciiPanel.brightMagenta);
        	}	
        }
        
		super.repaint(); 
	}

	
	public void redrawMap() {
		for(int i = 0; i < 80; ++i) {
			for(int j = 0; j < 24; ++j) {
				gamePanel.write(map.getMap()[i][j].tile(), i, j, map.getMap()[i][j].color()); // gets tile characters and colors
			}
		}
	}
	
	public Quest getCurrentQuest() {
		return currentQuest;
	}
	
	public MapBuilder getMap() {
		return this.map;
	}
	
	public AsciiPanel getMapPanel() {
		return this.gamePanel;
	}
}