
/**
 * Represents a type of item
 * @author Group 2
 *
 */
public abstract class Item{
	boolean itemCollected;
	int xPos;
	int yPos;
	String itemName;
	String itemType;
	String itemDesc;
	
	Item() {
		setItemCollected(false);
		set_yPos(-1);
		set_xPos(-1);
	}
	/**
	 * this constructor accepts an item
	 * name, type, and description. The 
	 * location will be set elsewhere
	 */
	Item(String name, String type, String desc) {
		setItemName(name);
		setItemType(type);
		setItemDescription(desc);
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemType(String type) {
		itemType = type;
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public void setItemDescription(String d) {
		itemDesc = d;
	}
	
	public String getItemDescription() {
		return itemDesc;
	}
	/**
	 * 
	 * @return if item is collected
	 */
	boolean isCollected() {
		return itemCollected;
	}
	
	/**
	 * 
	 * @return y position
	 */
	public int get_yPos() {
		return yPos;
	}
	
	/**
	 * 
	 * @return x position
	 */
	public int get_xPos() {
		return xPos;
	}
	
	public void setItemCollected(boolean itemCollected) {
		this.itemCollected = itemCollected;
	}
	
	public void set_yPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void set_xPos(int xPos) {
		this.xPos = xPos;
	}
	
	public String toString() {
		return itemName;
	}
}