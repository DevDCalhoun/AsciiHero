import java.util.Vector;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

/**
 * Manages rounds that occur within a game
 * @author Group 2
 *
 */
public class GameRoundManager {
    private PlayerCharacter player;
    private ArrayList<NonPlayerCharacter> characters;
    private ArrayList<Item> items;
    private MapBuilder map;
    private Battle battle;
    private boolean justCollided = false;  //Used to allow the character and the NPC to separate after colliding.
    QuestLog playerLog;
    private InventoryLists inventoryList;
    
    /**
     * 
     * @param newPlayer PlayerCharacter object
     * @param newCharacters ArrayList of NonPlayerCharacter's
     * @param newItems ArrayList of Item's
     * @param newMap MapBuilder for building a 2d map
     */
    public GameRoundManager(PlayerCharacter newPlayer, ArrayList<NonPlayerCharacter> newCharacters, ArrayList<Item> newItems, MapBuilder newMap, QuestLog playerLog, InventoryLists inventoryList) {
          player = newPlayer;
          characters = newCharacters;
          items = newItems;
          map = newMap;
          battle = new Battle();
          this.playerLog = playerLog;
          this.inventoryList = inventoryList;
    }
      
    /**
     * Moves all the characters on screen,
     * checks for collisions between player and npc's,
     * handles combat actions in case of collisions,
     * and checks enemies defeated and items picked up
     * by the player character for quest completion to
     * be initiated, assuming that the player has
     * a current quest
     */
    public void nextRound() {
        //Iterates through the items to check for player collision
        
    	// checks if character has killed an enemy and picked up an item to mark quest task completion
        try {
            for(Item item : items) {
                boolean itemCollision = checkPlayerItemCollision(player, item);            
                if(itemCollision && addItemsToInv(item)) {
                    item.setItemCollected(true);
                    
                    if(playerLog.getCurrentQuest() != null) {
                        if(!playerLog.getCurrentItems().isEmpty()) {
                        	playerLog.getCurrentItems().remove(0);
                        	playerLog.getCurrentQuest().setEnemyName("defeated");
                        }
                    }
                }
            }
         } catch(ConcurrentModificationException e) {
                
             }
  
        
        // Does proper checks to see if current quest can be marked as completed and removed from current quests
        if((player.isHasQuest()) && (playerLog.getCurrentQuest() != null)) {
        	if((playerLog.getCurrentEnemy().equals("defeated")) && (playerLog.getCurrentItems().isEmpty())) {
        		player.setAlignment(player.getAlignment() + playerLog.getCurrentQuest().getQuestAlignmentReward());
        		inventoryList.addQuestItem(playerLog.getCurrentQuest().getRewardItem());
        		
        		playerLog.completeQuest();
        		JOptionPane.showMessageDialog(null, "Quest Complete!");
        		if(playerLog.getCurrentQuest() != null) {
        			player.setHasQuest(false);
        		}
        	}
        }
        
        // Iterates through the characters checking for collision and otherwise moving the npc
        try {
            for(NonPlayerCharacter character : characters) {
                if(character.getCharacterType().equals("enemy")) {
                    boolean collision = checkCollision(player, character);
                    
                    if(collision) {
                        battle(player, character);
                        moveNPC(character);
                
                    }
                    else if(!justCollided) {
                        moveNPC(character);
                    }
                    else {
                        justCollided = false;
                    }
                }
                justCollided = false;
            }
           
        }
        catch(ConcurrentModificationException e) {
            
        }
        
        //Iterates through the items to check for player collision
        
        try {
            for(Item item : items) {
                boolean itemCollision = checkPlayerItemCollision(player, item);            
                if(itemCollision && addItemsToInv(item)) {
                    item.setItemCollected(true);
                }
            }
        } catch(ConcurrentModificationException e) {
            
        }
    }
    
    //Checks for collision between Characters 
    public boolean checkCollision(AB_Character char1, AB_Character char2) {
        if((char1.get_xPos() == char2.get_xPos()) && (char1.get_yPos() == char2.get_yPos())) {
            justCollided = true;
            return true;
        }
        
        if((char1.get_xPos()+1 == char2.get_xPos()) && (char1.get_yPos() == char2.get_yPos())) {
            justCollided = true;
            return true;
        }
        else if((char1.get_xPos()-1 == char2.get_xPos()) && (char1.get_yPos() == char2.get_yPos())) {
            justCollided = true;
            return true;
        }
        else if((char1.get_xPos() == char2.get_xPos()) && (char1.get_yPos()-1 == char2.get_yPos())) {
            justCollided = true;
            return true;
        }
        else if((char1.get_xPos() == char2.get_xPos()) && (char1.get_yPos()+1 == char2.get_yPos())) {
            justCollided = true;
            return true;
        }
        return false;
    }
    
    //Checks for collision between Character and map item.
    boolean checkMapItemCollision(int xLocation, int yLocation) {
        if((xLocation >= 0 && xLocation < map.getWidth()) && (yLocation >= 0 && yLocation < map.getHeight())) {
            if((map.getMap()[xLocation][yLocation] == TileEnum.Tree) || (map.getMap()[xLocation][yLocation] == TileEnum.TreeTop) || (map.getMap()[xLocation][yLocation] == TileEnum.Stone)) {
                return true;
            }
        }
        return false;
    }

    //Checks for collision between player and player collectible item
    
    boolean checkPlayerItemCollision(PlayerCharacter player, Item item) {
        if(player.get_xPos() == item.get_xPos() && player.get_yPos() == item.get_yPos()) {
            return true;
        }
        return false;
    }
    
    
    //Starts a battle between the player and the NPC character
    public void battle(AB_Character character1, AB_Character character2) {
        battle.attack(character1, character2);
        
        if(character1.getHealthPoints() < 0 && character1.getCharacterType().equals("enemy")) {
            int numberOfItemTypes = 1;
            Item droppedItem = new HealthItem();
            
            droppedItem.set_xPos(character1.get_xPos());
            droppedItem.set_yPos(character1.get_yPos());
            items.add(droppedItem);
            
            characters.remove(character1);          
        }
        else if(character2.getHealthPoints() < 0 && character2.getCharacterType().equals("enemy")) {
            int numberOfItemTypes = 1;
            Item droppedItem = new HealthItem();
            
            droppedItem.set_xPos(character2.get_xPos());
            droppedItem.set_yPos(character2.get_yPos());
            items.add(droppedItem);
            
            characters.remove(character2);
        }
        
    }

    
    
    //Moves the NPC character towards the player
    public void moveNPC(NonPlayerCharacter character) {
        int NPC_xPos = character.get_xPos();
        int NPC_yPos = character.get_yPos();
        int player_xPos = player.get_xPos();
        int player_yPos = player.get_yPos();
        
        boolean playerWithinView = false;
        
        for(int i = 1; i <= character.getFieldOfView(); ++i) {
            if(NPC_xPos == player_xPos && NPC_yPos + i == player_yPos) {
                boolean objectCollision = checkMapItemCollision(NPC_xPos, NPC_yPos + i);
                if(!objectCollision) {
                	if((NPC_yPos + 1) != (player.get_yPos())) {
                        character.set_yPos(++NPC_yPos);
                	}

                    playerWithinView = true;
                }
                break;
            }
            else if(NPC_xPos == player_xPos && NPC_yPos - i == player_yPos) {
                boolean objectCollision = checkMapItemCollision(NPC_xPos, NPC_yPos - i);
                if(!objectCollision) {
                	if((NPC_yPos - 1) != (player.get_yPos())) {
                        character.set_yPos(--NPC_yPos);
                	}
                    playerWithinView = true;
                }
                break;
            }
            else if(NPC_xPos + i == player_xPos && NPC_yPos == player_yPos) {
                boolean objectCollision = checkMapItemCollision(NPC_xPos + i, NPC_yPos);
                if(!objectCollision) {
                	if((NPC_xPos + 1) != (player.get_xPos())) {
                        character.set_xPos(++NPC_xPos);
                	}
                    playerWithinView = true;
                }
                break;
            }
            else if(NPC_xPos - i == player_xPos && NPC_yPos == player_yPos) {
                boolean objectCollision = checkMapItemCollision(NPC_xPos - i, NPC_yPos);
                if(!objectCollision) {
                	if((NPC_xPos - 1) != (player.get_xPos())) {
                        character.set_xPos(--NPC_xPos);
                	}
                    playerWithinView = true;
                }
                break;
            }
        }
        
        if(!playerWithinView) {
            boolean moveableLocation = false;
            while(!moveableLocation) {
                //int randomSteps = ((Math.abs(new Random().nextInt())) % 3) + 1;    //Random number of steps
                int direction = ((Math.abs(new Random().nextInt())) % 4) + 1;                               //Random direction 1 = North, ..., 4 = West
                
                if(direction == 1 && ((NPC_yPos - 1) > 0)) {
                    boolean objectCollision = checkMapItemCollision(NPC_xPos, NPC_yPos - 1);
                    if(!objectCollision) {
                        character.set_yPos(NPC_yPos - 1);
                        moveableLocation = true;
                    }
                }
                
                else if(direction == 2 && ((NPC_xPos + 1) < map.getWidth() - 1)) {
                    boolean objectCollision = checkMapItemCollision(NPC_xPos + 1, NPC_yPos);
                    if(!objectCollision) {
                        character.set_xPos(NPC_xPos + 1);
                        moveableLocation = true;
                    }
                }
                
                else if(direction == 3 && ((NPC_yPos + 1) < map.getHeight() - 1)) {
                    boolean objectCollision = checkMapItemCollision(NPC_xPos, NPC_yPos + 1);
                    if(!objectCollision) {
                        character.set_yPos(NPC_yPos + 1);
                        moveableLocation = true;
                    }
                }
                
                else if(direction == 4 && ((NPC_xPos - 1) > 0)) {
                    boolean objectCollision = checkMapItemCollision(NPC_xPos - 1, NPC_yPos);
                    if(!objectCollision) {
                        character.set_xPos(NPC_xPos - 1);
                        moveableLocation = true;
                    }
                }
            }
        }
       
       //Checks if move caused collision
       boolean collision = checkCollision(player, character);
            
       if(collision) {
           battle(character, player);
        }
       
    }
    
    /**
     * Checks if there is an npc that has a quest
     * @return if a quest is available
     */
    public boolean hasQuest() {
    	boolean questAvailable = false;
    	
    	for(NonPlayerCharacter character : characters) {
    		if(!character.getIsEnemy()) {
    			if(character.getQuest()) {
    				questAvailable = true;
    			}
    		}
    	}
    	
    	return questAvailable;
    }
    
    /**
     * 
     * @return NonPlayerCharacter ArrayList
     */
    public ArrayList<NonPlayerCharacter> getNPCs() {
        return characters;
    }
    
    /**
     * 
     * @return Item ArrayList
     */
  public  ArrayList<Item> getItems() {
        return items;
    }
  
  public ArrayList<Item> getCollectedItems() {
      ArrayList<Item> collectedItems = new ArrayList<Item>();
      for (Item item : items) {
          if(item.isCollected()) {
              collectedItems.add(item);
          }
      }
      return collectedItems;
  }
  
  public void clearItems() {
      items = new ArrayList<Item>();
  }
  
  public boolean addItemsToInv(Item item) {
      if((item instanceof ConsumableItem) && (inventoryList.getConsumableListSize() < inventoryList.getMaxSize())) {
          inventoryList.addConsumableItem((ConsumableItem) item);
          items.remove(item);
          return true;
      }
      else if(item instanceof ArmorWeaponItem && (inventoryList.getArmorItemListSize() < inventoryList.getMaxSize())) {
           inventoryList.addArmorItem((ArmorWeaponItem) item);
           items.remove(item);
           return true;
       }
       else if(inventoryList.getQuestItemListSize() < inventoryList.getMaxSize()){
            inventoryList.addQuestItem(item);
            items.remove(item);
            return true;
       }
       return false;
  }
 }