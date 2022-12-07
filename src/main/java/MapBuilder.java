/**
 * MapBuilder is used a 2d array representing a game map to be used
 * within a swing Gui
 * @author Group 2
 *
 */
public class MapBuilder {
	  	private int width;
	    private int height;
	    private TileEnum[][] tiles;
	    
	    /**
	     * Constructor creates a new 2D array to be used for the map
	     * @param w width
	     * @param h height
	     */
	    public MapBuilder(int w, int h){
	    	width = w;
	    	height = h;
	    	tiles = new TileEnum[width][height];
	    }
	    
	    /**
	     * Inserts grass or other ground materials into the array
	     */
	    public void generateValleyGround(){
	    	for(int x = 0; x < width; x++) {
	    		for(int y = 0; y < height; y++) {
	    			tiles[x][y] = TileEnum.Grass;
	    		}
	    	}

	    }
	    
	    /**
	     * generates ground for a cave landscape
	     */
	    public void generateCaveGround() {
	    	for(int x = 0; x < width; x++) {
	    		for(int y = 0; y < height; y++) {
	    			tiles[x][y] = TileEnum.Dirt;
	    		}
	    	}
	    }
	    
	    /**
	     * this algorithm randomizes placement of trees
	     * on the given map array to generate a valley that changes
	     * every time it is generated
	     */
	    public void generateValley() {
	    	int coordX = 0;
	    	int coordY = 0;
	    	
	    	for(int i = 0; i < width; i++) {
	    		
	    		coordX = (int) Math.floor(Math.random()*((width - 1)-1+1)+1); // randomizes coordinates based on given
	    		coordY = (int) Math.floor(Math.random()*((height - 1)-1+1)+1); // width and height
	    		
	    		for(int j = 0; j < height; j++) {
	    			tiles[coordX][coordY] = TileEnum.Tree; // generates a tree at a randomized point on the map
	    			if((coordY - 1) > -1) {
	    				tiles[coordX][coordY - 1] = TileEnum.TreeTop; // puts the tree top directly above the randomized tree
	    			}
	    		}
	    	}
	    }
	    
	    /**
	     * generates a cave landscape
	     */
	    public void generateCave() {
	    	int coordX = 0;
	    	int coordY = 0;
	    	
	    	for(int i = 0; i < width; i++) {
	    		
	    		coordX = (int) Math.floor(Math.random()*((width - 1)-1+1)+1); // randomizes coordinates based on given
	    		coordY = (int) Math.floor(Math.random()*((height - 1)-1+1)+1); // width and height

	    		for(int j = 0; j < height; j++) {
	    			if((i == 0) || (i == width - 1) || (j == 0) || (j == height - 2)) {
	    				tiles[i][j] = TileEnum.Stone;
	    			}
	    			if(tiles[i][j] == TileEnum.Stone) {
	    				if(((coordX - 2 > 0) && (coordY - 2 > 0)) && ((coordX + 2 < width) && (coordY + 2 < height))) {
		    				tiles[coordX - 1][coordY - 1] = TileEnum.Stone;
		    				tiles[coordX - 1][coordY] = TileEnum.Stone;
		    				tiles[coordX][coordY + 1] = TileEnum.Stone;
		    				tiles[coordX + 2][coordY + 2] = TileEnum.Stone;
		    				tiles[coordX][coordY + 1] = TileEnum.Stone;
	    				}

	    			}
	    			tiles[coordX][coordY] = TileEnum.Stone; // generates a stone at a randomized point on the map
	    		}
	    	}
	    }
	    
	    /**
	     * Returns a map representation
	     * @return 2d tile array
	     */
	    public TileEnum[][] getMap() {
	    	return tiles;
	    }
	    
	    /**
	     * 
	     * @return width
	     */
	    public int getWidth() {
	    	return this.width;
	    }
	    
	    /**
	     * 
	     * @return height
	     */
	    public int getHeight() {
	    	return this.height;
	    }
}
