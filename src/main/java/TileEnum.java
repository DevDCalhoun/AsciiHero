import java.awt.Color;

import asciiPanel.AsciiPanel;

/**
 * Used to represent the tiles used within a game map
 * @author Group 2
 *
 */
public enum TileEnum {
	Grass((char)34, AsciiPanel.green),
	Stone((char)177, AsciiPanel.yellow),
	Tree((char)73, AsciiPanel.red),
	TreeTop((char)118, AsciiPanel.brightGreen),
	Dirt((char)126, AsciiPanel.magenta);
	
    private char tile;
    
    /**
     * 
     * @return the ASCII character for the given tile
     */
    public char tile() {
    	return tile; 
    }
    
    /**
     * return the color of the given tile
     */
    private Color color;
    public Color color() { return color; }
    
    TileEnum(char tile, Color color){
        this.tile = tile;
        this.color = color;
    }
}

