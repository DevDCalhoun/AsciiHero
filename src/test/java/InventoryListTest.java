import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryListTest {

    @Test
    void testAddConsumable() {
        PlayerCharacter pc = new PlayerCharacter();
        InventoryLists list = new InventoryLists(pc);
        list.addConsumableItem(new HealthItem());
        assertTrue(list.getConsumableListSize() == 2);
    }
    
    @Test
    void testAddArmor() {
        PlayerCharacter pc = new PlayerCharacter();
        InventoryLists list = new InventoryLists(pc);
        list.addArmorItem(new ArmorWeaponItem("Gold Helmet", "Armor", "Precious helmet", 0, 25, "helmet"));
        System.out.println(list.getArmorItemListSize());
        assertTrue(list.getArmorItemListSize() == 7);
    }
    
    @Test
    void testAddItem() {
        PlayerCharacter pc = new PlayerCharacter();
        InventoryLists list = new InventoryLists(pc);
        Item i = new HealthItem();
        list.addQuestItem(i);
        assertTrue(list.getQuestItemListSize() == 1);
    }
    
    @Test
    void testMaxItem() {
        PlayerCharacter pc = new PlayerCharacter();
        InventoryLists list = new InventoryLists(pc);
        assertTrue(list.getMaxSize() == 10);
    }

}
