
public class ArmorWeaponItem extends Item{
    private boolean equipped;
    private int attackStrength;
    private int defenseValue;
    private String slotName;
    
    ArmorWeaponItem(String name, String type, String desc, int attackStrength, int defenseValue, String slotName){
        super(name, type, desc);
        equipped = false;
        this.attackStrength = attackStrength;
        this.defenseValue = defenseValue; 
        this.slotName = slotName;
    }
    
    /**
     * 
     * @param equipped
     */
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    
    /**
     * 
     * @return the equipped bool
     */
    public boolean getEquipped() {
        return equipped;
    }
    
    /**
     * 
     * @return the attackStrength
     */
    public int getAttackStrength() {
        return attackStrength;
    }
    
    /**
     * 
     * @return the defenseValue
     */
    public int getDefenseValue() {
        return defenseValue;
    }

    /**
     * @return the slotName
     */
    public String getSlotName() {
        return slotName;
    }    
    
}
