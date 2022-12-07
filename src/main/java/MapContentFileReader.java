import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
/**
 * cen3031-fall22-tr-semester-project-cen3031fall22tr-group-2
 * 
 * MapContentFileReader.java
 * Class to read a specific file given by user and return a vector of all items in the file. 
 * 
 * Condition: .txt file is written one item per line
 */

public class MapContentFileReader {
	private Vector<String> contents = new Vector<String>();
	/**
	 * Class constructor takes in name of file to be read, reads each line via Scanner and places each item(one per line)
	 * into a vector of said items. 
	 * @param fileName
	 */
	MapContentFileReader(String fileName) {
		File file = new File(fileName); //fileName is passed into constructor as parameter
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String s = scan.nextLine();
				contents.add(s);//add each item to the vector
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return contents vector
	 */
	public Vector<String> getContents(){
		return contents;
	}
};
