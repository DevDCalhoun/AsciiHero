import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import asciiPanel.AsciiPanel;

class CharIconTester{
	
	CharIcon[] cI = CharIcon.values();
	static Color c = AsciiPanel.white;
	
	@Test
	void iconTest() {		
		assert(cI[3].icon() == '?');
	}
	
	@Test
	void colorTest() {
		assert(CharIcon.Default.color() == c);
	}
	
	@Test
	void nameTest() {
		assert(cI[3].name() == "Default");
	}
}