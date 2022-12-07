

/**
 * The PlayerCharacter holds all the information for a player including
 * character statistics, position on the game map, and representation
 * @author Group 2
 *
 */
public class PlayerCharacter extends AB_Character{
	private ArmorWeaponItem helmet;
	private ArmorWeaponItem chestpiece;
	private ArmorWeaponItem legArmor;
	private ArmorWeaponItem shoes;
	private ArmorWeaponItem weapon;	
	boolean hasQuest;
	private int alignment;
			
	public PlayerCharacter() {
		super(40, 12, "playerCharacter", 100, 10, 10, 10);
		
		setHasQuest(false);
		setAlignment(0);
	}


    /**
     * @return the helmet
     */
    public ArmorWeaponItem getHelmet() {
        return helmet;
    }


    /**
     * @param helmet the helmet to set
     */
    public void setHelmet(ArmorWeaponItem helmet) {
        this.helmet = helmet;
    }


    /**
     * @return the chestpiece
     */
    public ArmorWeaponItem getChestpiece() {
        return chestpiece;
    }


    /**
     * @param chestpiece the chestpiece to set
     */
    public void setChestpiece(ArmorWeaponItem chestpiece) {
        this.chestpiece = chestpiece;
    }


    /**
     * @return the legArmor
     */
    public ArmorWeaponItem getLegArmor() {
        return legArmor;
    }


    /**
     * @param legArmor the legArmor to set
     */
    public void setLegArmor(ArmorWeaponItem legArmor) {
        this.legArmor = legArmor;
    }


    /**
     * @return the shoes
     */
    public ArmorWeaponItem getShoes() {
        return shoes;
    }


    /**
     * @param shoes the shoes to set
     */
    public void setShoes(ArmorWeaponItem shoes) {
        this.shoes = shoes;
    }


    /**
     * @return the weapon
     */
    public ArmorWeaponItem getWeapon() {
        return weapon;
    }


    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(ArmorWeaponItem weapon) {
        this.weapon = weapon;
    }
	
	@Override
	/**
     * 
     * @return defense value
     */
    public int getDefenseValue() {
        int armorBuff = 0;
        if(helmet != null) {
            armorBuff += helmet.getDefenseValue();
        }
        if(chestpiece != null ) {
            armorBuff += chestpiece.getDefenseValue();
        }
        if(legArmor != null) {
            armorBuff += legArmor.getDefenseValue();
        }
        if(shoes != null) {
            armorBuff += shoes.getDefenseValue();
        }
        return super.getDefenseValue() + armorBuff;
    }
	
	@Override
	/**
     * 
     * @return attack strength
     */
    public int getAttackStrength() {
        if(weapon != null) {
            return super.getAttackStrength() + weapon.getAttackStrength();
        }
        return super.getAttackStrength();
    }
    
	public boolean isHasQuest() {
		return hasQuest;
	}

	public void setHasQuest(boolean hasQuest) {
		this.hasQuest = hasQuest;
	}

	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
}