import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;

public class MapContentFileReaderTester {

	@Test
	public void testMapContentsFileReader() {
		Vector<String> contentsVector;
		MapContentFileReader fileReader = new MapContentFileReader("enemies.txt");
		contentsVector = fileReader.getContents();
		
		assertTrue(contentsVector.contains("Dragon"));
		assertTrue(contentsVector.contains("Vampire"));
		assertTrue(contentsVector.contains("Ferocious Boar"));
	}

}
