package readingFiles;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles {
	
	
	/*
	 * Method takes a file name and reads the file and stores the contents of the
	 * file into an Array List.
	 * Parameter: File name
	 * Returns: Array List of the given strings in the file
	 * with the format
	 * LastName FirstName Gender(Male or Female) DOB(mm/dd/yyyy) Color
	 */
	public ArrayList<String> readFile(String pathname) throws IOException, ParseException {

	    File file = new File(pathname);
	    Scanner scanner = new Scanner(file);
	    ArrayList<String> finalList = new ArrayList<String>( );
	    try {
	        while(scanner.hasNextLine()) {
	        	String line = scanner.nextLine();
	        	String changedLine = "";
	        	if (line.contains(","))
	        		line = line.replaceAll(",", "");
	        	if (line.contains("|"))
	        		line = line.replaceAll("\\|", "");
	        	if (line.contains("-"))
	        		line = line.replaceAll("-", "/");
	        	changedLine = fixGender(line);
	        	finalList.add(fixPosition(changedLine.trim()));
	        }
	        return finalList;
	    } finally {
	        scanner.close();
	    }
	}
	
	/*
	 * This method reads the extracted string from the file
	 * and fixes the position of the color in case it is misplaced
	 * Input: String
	 * Returns: Fixed String in the format described above
	 */
	private String fixPosition(String line) {
		String[] splitLine = line.split("\\s+");
		String finalLine = "";
			for (int i=0; i<splitLine.length; i++) {
				if (i==(splitLine.length - 2) && !splitLine[i].matches(RegexMatching.dateRegex)) {
					String temp = splitLine[i];
					splitLine[i] = splitLine[i+1];
					splitLine[i+1] = temp;
				}
				finalLine = finalLine + splitLine[i] + " ";
			}
			return finalLine;
	}

	/*
	 * This method reads the extracted string from the file
	 * and fixes the Gender in case it is not either 'Male' or 'Female'
	 * Input: String
	 * Returns: Fixed String in the format described above
	 */
	private String fixGender(String line) throws ParseException {
		String[] splitLine = line.split("\\s+");
		String finalLine = "";
		if(splitLine.length > 5) {
			for(int i=0; i<splitLine.length; i++) {
				if(i==2)
					splitLine[i] = "";
				else if (i==3 && splitLine[i].startsWith("M")) 
					splitLine[i] = "Male";
				else if (i==3 && splitLine[i].startsWith("F"))
					splitLine[i] = "Female";
				finalLine = finalLine + splitLine[i] + " ";
			}
			return finalLine;
		} else
			return line;
	}
}
