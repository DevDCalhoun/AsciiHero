
public abstract class ConsumableItem extends Item{
    private boolean used;
    private int healthPoints;
    private int manaPoints;
    
   ConsumableItem(String name, String type, String desc, int healthPoints, int manaPoints){
       super(name, type, desc);
       used = false;
       this.healthPoints = healthPoints;
       this.manaPoints = manaPoints;
   }
   
   public void setUsed() {
       used = true;
   }
   
   public boolean getUsed() {
       return used;
   } 
   
   public int getHealthPoints() {
       return healthPoints;
   }
   
   public int getManaPoints() {
       return manaPoints;
   }

}
