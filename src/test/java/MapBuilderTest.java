import static org.junit.Assert.*;

import org.junit.Test;

public class MapBuilderTest {

	@Test
	public void test() {
		
		//Creates a 5x5 Grid
		int width = 5;
		int height = 5;		
		
		//Passes Grid to constructor to set the array and values associated with it
		MapBuilder map = new MapBuilder(width, height);
		
		//Tests to see if the values are what they are supposed to be
		assert(map.getHeight() == 5);
		assert(map.getWidth() == 5);
		
		//Tests for random spot on the grid to see if it's null
		int random_int = (int)Math.floor(Math.random()*(4-0+1)+0);
		assert(map.getMap()[random_int][random_int] == null);	
		
		//Populates map and tests to make sure random map spot is populated
		map.generateCaveGround();
		map.generateCave();
		assert(map.getMap()[random_int][random_int] != null);
	}

}
