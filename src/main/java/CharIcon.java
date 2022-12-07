import java.awt.Color;

import asciiPanel.AsciiPanel;

/**
 * CharIcon is used to represent a Character based on the CharacterType
 * @author Group 2
 *
 */
public enum CharIcon {
	Player((char)1, AsciiPanel.white),
	Enemy((char)36, AsciiPanel.brightRed),
	Freindly((char)33, AsciiPanel.brightGreen),
	Default((char)63, AsciiPanel.white);
	
	private char icon;
    private Color color;
	
    /**
     * 
     * @return icon
     */
    public char icon() {
    	return icon; 
    }
    
    /**
     * 
     * @return color
     */
    public Color color() { 
    	return color; 
    }
    
    /**
     * 
     * @param icon
     * @param color
     */
    CharIcon(char icon, Color color){
        this.icon = icon;
        this.color = color;
    }
}