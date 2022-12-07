import static org.junit.Assert.*;

import org.junit.Test;

public class TileEnumTest {

	@Test
	public void test() {
		TileEnum t1 = TileEnum.Grass;
		TileEnum t2 = TileEnum.Stone;
		TileEnum t3 = TileEnum.Tree;
		TileEnum t4 = TileEnum.Dirt;
		
		assert((char)t1.tile() == TileEnum.Grass.tile());
		assert(char)t2.tile() == TileEnum.Stone.tile();
		assert(char)t3.tile() == TileEnum.Tree.tile();
		assert(char)t4.tile() == TileEnum.Dirt.tile();
	}

}
