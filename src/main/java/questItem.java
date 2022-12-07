
public class questItem extends Item{
	
	questItem(String name){
		super(name, "quest reward", "quest reward item");
	}
	
	public questItem(questItem q) {
		this.xPos = q.xPos;
		this.yPos = q.yPos;
		this.itemCollected = q.itemCollected;
		this.itemName = q.itemName;
		this.itemType = q.itemType;
		this.itemDesc = q.itemDesc;
		}
}
