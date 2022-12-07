import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GameRoundManagerTester {

    @Test
    void testCheckCollision() {
        PlayerCharacter player = new PlayerCharacter();
        player.set_xPos(0);
        player.set_yPos(0);
        ArrayList<NonPlayerCharacter> characters = new ArrayList<NonPlayerCharacter>();
        NonPlayerCharacter NPC1 = new NonPlayerCharacter();
        NonPlayerCharacter NPC2 = new NonPlayerCharacter();
        NPC1.set_xPos(0);
        NPC1.set_yPos(0);
        NPC2.set_xPos(1);
        NPC2.set_yPos(1);
        characters.add(NPC1);
        characters.add(NPC2);
        ArrayList<Item> items = new ArrayList<Item>();
        QuestLog playerLog = new QuestLog();
        InventoryLists list = new InventoryLists(player);
        
        GameRoundManager grm = new GameRoundManager(player, characters, items, new MapBuilder(80,24), playerLog, list);
        
        assertTrue(grm.checkCollision(player, NPC1));
        assertFalse(grm.checkCollision(player, NPC2));
    }
    
    @Test
    void testNPCMovement() {
        PlayerCharacter player = new PlayerCharacter();
        player.set_xPos(0);
        player.set_yPos(0);
        ArrayList<NonPlayerCharacter> characters = new ArrayList<NonPlayerCharacter>();
        NonPlayerCharacter NPC1 = new NonPlayerCharacter();
        NPC1.set_xPos(0);
        NPC1.set_yPos(5);
        NPC1.setFieldOfView(5);
        NPC1.setCharacterType("enemy");
        characters.add(NPC1);
        ArrayList<Item> items = new ArrayList<Item>();
        QuestLog playerLog = new QuestLog();
        InventoryLists list = new InventoryLists(player);
        
        GameRoundManager grm = new GameRoundManager(player, characters, items, new MapBuilder(80,24), playerLog, list);
        grm.nextRound();
       
        assertTrue(NPC1.get_yPos() == 4);
    }
    
    @Test
    void testNPCMovementRandom() {
        PlayerCharacter player = new PlayerCharacter();
        player.set_xPos(0);
        player.set_yPos(0);
        ArrayList<NonPlayerCharacter> characters = new ArrayList<NonPlayerCharacter>();
        NonPlayerCharacter NPC1 = new NonPlayerCharacter();
        NPC1.set_xPos(0);
        NPC1.set_yPos(15);
        NPC1.setFieldOfView(5);
        NPC1.setCharacterType("enemy");
        characters.add(NPC1);
        ArrayList<Item> items = new ArrayList<Item>();
        QuestLog playerLog = new QuestLog();
        InventoryLists list = new InventoryLists(player);
        
        GameRoundManager grm = new GameRoundManager(player, characters, items, new MapBuilder(80,24), playerLog, list);
        grm.nextRound();
        
        assertTrue(NPC1.get_xPos() != 0 || NPC1.get_xPos() != 15);
    }
    
    
    @Test
    void testItemPlayerCollision() {
        PlayerCharacter player = new PlayerCharacter();
        player.set_xPos(0);
        player.set_yPos(0);
        ArrayList<NonPlayerCharacter> characters = new ArrayList<NonPlayerCharacter>();
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new HealthItem();
        item.set_xPos(0);
        item.set_yPos(0);
        items.add(item);
        QuestLog playerLog = new QuestLog();
        InventoryLists list = new InventoryLists(player);
        
        NonPlayerCharacter NPC1 = new NonPlayerCharacter();
        NPC1.setHealthPoints(0);
        NPC1.set_xPos(0);
        NPC1.set_yPos(0);
        characters.add(NPC1);
        
        GameRoundManager grm = new GameRoundManager(player, characters, items, new MapBuilder(80,24), playerLog, list);
        
        assertTrue(grm.checkPlayerItemCollision(player, item));
    }
    

}
