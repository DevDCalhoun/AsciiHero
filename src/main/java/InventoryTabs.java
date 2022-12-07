
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class InventoryTabs extends JPanel{
	InventoryLists l; 
	
	public InventoryTabs(InventoryLists l) {
		super(new GridLayout(1, 1));
        this.l = l;
		/**
		 *Creates a tabbed panel container 
		 */
		JTabbedPane tab = new JTabbedPane();
		
		/**
		 * fetches images to use for icons, error checks for missing .png
		 */
		ImageIcon heart = createImage("/hearts.png");
		ImageIcon armor = createImage("/armor.png");
		ImageIcon blocks = createImage("/blocks.png"); 
		
		/**
		 * Creates the tabs to be used
		 */
		JComponent consComp = createPanel('C');
		JComponent armorComp = createPanel('A');
		JComponent questItemsComp = createPanel('Q');
		
		/**
		 * adds tabs to the container
		 */
		tab.addTab("Consumables", heart, consComp, "Things you can use");
		tab.addTab("Armor", armor, armorComp, "Things you can equip to your character");
		tab.addTab("Quest Items", blocks, questItemsComp, "Things you find on quests");
		
		/**
		 * adds entire tab to the JPanel, basically returns it
		 */
		add(tab);
		
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
	/**
	 * draws items on the tab 
	 */
	public JComponent createPanel(char c) {
		JPanel panel = new JPanel(true);
		panel.setLayout(new GridLayout(1, 1));
		if(c == 'C') {
			panel.add(l.addConsumableList());
		}
		
		if(c == 'A') {
		    panel.add(l.addArmorItemList());
		}
		
		if(c == 'Q') {
			panel.add(l.addQuestItemList());
		}
		
		return panel;
	}
	/**
	 *error checks for image file 
	 */
	public static ImageIcon createImage(String path ) {
		java.net.URL img = InventoryTabs.class.getResource(path);
		if(img != null) {
			return new ImageIcon(img);
		} else {
			System.err.println("Couldn't find file:" + path);
			return null;
		}
	}
}
