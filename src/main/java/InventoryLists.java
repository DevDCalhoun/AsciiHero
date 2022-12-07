
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class InventoryLists implements ActionListener{
	
    private PlayerCharacter player;
    private int inventorySize;
	/**
	 * lists to be defined
	 */
	private JList<ConsumableItem> cList = new JList<ConsumableItem>();
	private JList<ArmorWeaponItem> aList = new JList<ArmorWeaponItem>();
	private JList<Item> qList = new JList<Item>();
	
	/**
	 * Objects used to add items to list
	 * 
	 * DefaultListModel provides a simple
	 * implementation of a list. All list
	 * functions taken care of by its class
	 * methods.
	 */
	public DefaultListModel<ConsumableItem> cDef = new DefaultListModel<ConsumableItem>();
	public DefaultListModel<ArmorWeaponItem> aDef = new DefaultListModel<ArmorWeaponItem>();
	public DefaultListModel<Item> qDef = new DefaultListModel<Item>();
	
    JLabel cLabel = new JLabel(); //used to get the item's description
    JLabel aLabel = new JLabel(); //used to get the item's description
    JLabel qLabel = new JLabel(); //used to get the item's description
    JPanel c = new JPanel(); //consumables list panel
    JPanel a = new JPanel(); //armor list panel
    JPanel q = new JPanel(); //quest item list panel
    JSplitPane consumablePane = new JSplitPane(); //split pane for item name and description
    JSplitPane armorPane = new JSplitPane(); //split pane for item name and description
    JSplitPane questItemPane = new JSplitPane(); //split pane for item name and description
    JButton useButton = new JButton("Use"); //button to use consumable
    JButton equipButton = new JButton("Equip"); //button to equip armor
    GridLayout g = new GridLayout(2,1); //table layout for button and description
    
	/**
	 *Constructor call the classes used to generate the lists
	 *
	 */
	public InventoryLists(PlayerCharacter player) {
	    this.player = player;
		consumablesList();
		armorList();
		questItemList();
		inventorySize = 10; //Maximum number of items that can be in inventory
	}
	
	/**
	 * Creates the list for the consumable items.
	 * Elements are added using the DefaultListModel
	 * object's addElement() method. 
	 */
	public void consumablesList() {
		cDef.addElement(new HealthItem());

		cList.setModel(cDef);
		c.setLayout(g);
		c.add(cLabel);
		c.add(useButton);
		cList.getSelectionModel().addListSelectionListener(e -> {
			ConsumableItem i = cList.getSelectedValue();
			if(i != null) {
			    cLabel.setText(i.getItemDescription());
			    if(!i.getUsed()) {
	                useButton.setBackground(Color.white);
	            }
	            else {
	                useButton.setBackground(Color.red);
	            }
			}
		});

		consumablePane.setLeftComponent(new JScrollPane(cList));
		consumablePane.setRightComponent(c);
		
		
		useButton.addActionListener(new UseListener());
	}
	
	/**
	 * Adds consumable to consumable item list 
	 * @param c
	 */
	public void addConsumableItem(ConsumableItem c) {
	    cDef.addElement(c);
	}
	
	
	/**
	 * returns list to be added to tab 
	 */
	public JSplitPane addConsumableList() {
		return consumablePane;
	}
	
	public int getConsumableListSize() {
	    return cDef.getSize();
	}
	
	public void armorList() {
	    aDef.addElement(new ArmorWeaponItem("Gold Helmet", "Armor", "Precious helmet", 0, 25, "helmet"));
	    aDef.addElement(new ArmorWeaponItem("Gold Chestpiece", "Armor", "Precious chestpice", 0, 25, "chestpiece"));
	    aDef.addElement(new ArmorWeaponItem("Gold leggings", "Armor", "Precious leggings", 0, 25, "legArmor"));
	    aDef.addElement(new ArmorWeaponItem("Gold shoes", "Armor", "Precious shoes", 0, 25, "shoes"));
	    aDef.addElement(new ArmorWeaponItem("Gold sword", "weapon", "Precious sword", 25, 0, "weapon"));
	    aDef.addElement(new ArmorWeaponItem("Broken sword", "weapon", "Broke sword", 2, 0, "weapon"));
        aList.setModel(aDef);
        a.setLayout(g);
        a.add(aLabel);
        aList.getSelectionModel().addListSelectionListener(e -> {
            ArmorWeaponItem i = aList.getSelectedValue();
            aLabel.setText(i.getItemDescription());
            if(!i.getEquipped()) {
                equipButton.setBackground(Color.white);
            }
            else {
                equipButton.setBackground(Color.GREEN);
            }
        });
        a.add(equipButton);
        armorPane.setLeftComponent(new JScrollPane(aList));
        armorPane.setRightComponent(a);
        
        equipButton.addActionListener(new EquipListener());
    }
	
    /**
     * Adds armor item to armor list
     * @param a
     */
	public void addArmorItem(ArmorWeaponItem a) {
	    aDef.addElement(a);
	}
	
	/**
     * returns list to be added to tab 
     */
    public JSplitPane addArmorItemList() {
        return armorPane;
    }
    
    public int getArmorItemListSize() {
        return aDef.getSize();
    }
	
	/**
	 * Creates the list for the Quest Items.
	 * Elements are added using the DefaultListModel
	 * object's addElement() method. 
	 */
	public void questItemList() {
		qList.setModel(qDef);
		q.setLayout(g);
		q.add(qLabel);
		qList.getSelectionModel().addListSelectionListener(e -> {
			Item i = qList.getSelectedValue();
			if(i != null) {
				qLabel.setText(i.getItemDescription());
			}
		});

		questItemPane.setLeftComponent(new JScrollPane(qList));
		questItemPane.setRightComponent(q);
	}
	
	/**
	 * Adds item to quest item list
	 * @param q
	 */
	public void addQuestItem(Item q) {
	    qDef.addElement(q);
	}
	
	/**
	 * returns list to be added to tab 
	 */
	public JSplitPane addQuestItemList() {
		return questItemPane;
	}
	
	public int getQuestItemListSize() {
	    return qDef.getSize();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = qList.getSelectedIndex();
		System.out.println(index);
	}
	
	public class UseListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    if(cList.getSelectedValue() instanceof HealthItem) {
		        player.setHealthPoints(player.getHealthPoints() + cList.getSelectedValue().getHealthPoints());
		    }
		    else if(cList.getSelectedValue() instanceof ManaItem) {
		        player.setManaPoints(player.getManaPoints() + cList.getSelectedValue().getManaPoints());
		    }
			useButton.setBackground(Color.RED);
			cDef.removeElement(cList.getSelectedValue());

		}
		
	}
	
	public class EquipListener implements ActionListener{
	    @Override
        public void actionPerformed(ActionEvent e) {
	       if(aList.getSelectedValue() == null) {
	           return;
	       }
	       if(aList.getSelectedValue() != null) {
	           aList.getSelectedValue().setEquipped(true);
	           equipButton.setBackground(Color.GREEN);
	       }
	       if(aList.getSelectedValue().getSlotName().equals("helmet")) { 
	           if(player.getHelmet() != null) {
	               player.getHelmet().setEquipped(false);
	           }
	           player.setHelmet(aList.getSelectedValue());
	       }
	       else if(aList.getSelectedValue().getSlotName().equals("chestpiece")) { 
	           if(player.getChestpiece() != null) {
	               player.getChestpiece().setEquipped(false);
	           }
               player.setChestpiece(aList.getSelectedValue());
           }
	       else if(aList.getSelectedValue().getSlotName().equals("legArmor")) { 
	           if(player.getLegArmor() != null) {
	               player.getLegArmor().setEquipped(false);
	           }
               player.setLegArmor(aList.getSelectedValue());
           }
	       else if(aList.getSelectedValue().getSlotName().equals("shoes")) { 
	           if(player.getShoes() != null) {
	               player.getShoes().setEquipped(false);
	           }
               player.setShoes(aList.getSelectedValue());
           }
	       else if(aList.getSelectedValue().getSlotName().equals("weapon")) { 
	           if(player.getWeapon() != null) {
	               player.getWeapon().setEquipped(false);
	           }
               player.setWeapon(aList.getSelectedValue());
           }
	    }
	}
	
	public int getMaxSize() {
	    return inventorySize;
	}
}


