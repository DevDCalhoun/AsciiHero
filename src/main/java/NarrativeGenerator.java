import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Generates a narrative to be used with a quest based on the alignment of
 * the character
 * @author Group 2
 *
 */
public class NarrativeGenerator {
	 private File file;
	 Scanner scanner;
	 String narrative;
	 
	 /**
	  * default constructor
	  * @throws FileNotFoundException
	  */
	 NarrativeGenerator() throws FileNotFoundException {
		 setNarrative("");
	 }
	 
	 /**
	  * Creates an evil narrative to go along with a quest
	  * @param alignmentValue
	  * @return
	  * @throws FileNotFoundException
	  */
	 public String getEvilNarrative(int alignmentValue) throws FileNotFoundException {
		 setFile("evilNarrative.txt");
		 setScanner();
		 setNarrative("");
		 
		 while (scanner.hasNextLine()) {
			 setNarrative(scanner.nextLine());
			 if(narrative.equals(Integer.toString(alignmentValue))) {
				 narrative = "";
				 for(int i = 0; i < 5; ++i) {
					 narrative += scanner.nextLine() + "\n";
				 }
				 break;
			 }
		 }
		 
		 scanner.close();
		 
		 return narrative;
	 }
	 
	 /**
	  * creates a good narrative to go along with a quest
	  * @param alignmentValue
	  * @return
	  * @throws FileNotFoundException
	  */
	 public String getGoodNarrative(int alignmentValue) throws FileNotFoundException {
		 setFile("goodNarrative.txt");
		 setScanner();
		 setNarrative("");
		 
		 while (scanner.hasNextLine()) {
			 setNarrative(scanner.nextLine());
			 if(narrative.equals(Integer.toString(alignmentValue))) {
				 
				 narrative = "";
				 for(int i = 0; i < 5; ++i) {
					 narrative += scanner.nextLine() + "\n";
				 }
				 break;
			 }
		 }
		 
		 scanner.close();
		 
		 return narrative;
	 }
	 
	 /**
	  * sets the name of the file to be used for the narrative
	  * @param fileName
	  */
	 public void setFile(String fileName) {
		 this.file= new File(fileName);
	 }
	 
	 /**
	  * creates a scanner
	  * @throws FileNotFoundException
	  */
	 public void setScanner() throws FileNotFoundException {
		 this.scanner = new Scanner(file);
	 }
	 
	 /**
	  * sets the value of the narrative to be used with a quest
	  * @param narrative
	  */
	 public void setNarrative(String narrative) {
		 this.narrative = narrative;
	 }
}
