import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class NarrativeTester {

	@Test
	void test() throws FileNotFoundException {
		//narrative is generated from stats of PlayerCharacter instance and is tested
		//using a PlayerCharacter
		NarrativeGenerator n = new NarrativeGenerator();
		PlayerCharacter player = new PlayerCharacter();
		
		//good narrative options
		String narrativeG1 = n.getGoodNarrative(0);
		String narrativeG2 = n.getGoodNarrative(1);
		String narrativeG3 = n.getGoodNarrative(2);
		
		//evil narrative options
		String narrativeE1 = n.getEvilNarrative(0);
		String narrativeE2 = n.getEvilNarrative(-1);
		String narrativeE3 = n.getEvilNarrative(-2);
		
		//testing all possible good narratives
		assert(narrativeG1.equals(n.getGoodNarrative(player.getAlignment())));
		player.setAlignment(1);
		assert(narrativeG2.equals(n.getGoodNarrative(player.getAlignment())));;
		player.setAlignment(2);
		assert(narrativeG3.equals(n.getGoodNarrative(player.getAlignment())));;
		
		//testing all possible evil narratives
		player.setAlignment(0);
		assert(narrativeE1.equals(n.getEvilNarrative(player.getAlignment())));
		player.setAlignment(-1);
		assert(narrativeE2.equals(n.getEvilNarrative(player.getAlignment())));
		player.setAlignment(-2);
		assert(narrativeE3.equals(n.getEvilNarrative(player.getAlignment())));
	}

}