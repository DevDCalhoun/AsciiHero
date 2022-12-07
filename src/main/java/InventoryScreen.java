
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class InventoryScreen extends Item{
	private InventoryLists list;
	JFrame frame = new JFrame("Inventory");
//	private JScrollPane s = new JScrollPane();
	
	// define the primary JFrame
	public InventoryScreen(InventoryLists list) {
	    this.list = list;
		frame.setSize(500, 500);
		frame.setLocation(250, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
}
	
	public void makeTabs() {
		frame.add(new InventoryTabs(list), BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	
	
	
}
