package outputFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import readingFiles.*;

public class OutputFile {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		try {
			// Creating object for reading files 
			ReadFiles r = new ReadFiles();
			final RegexMatching rm = new RegexMatching();
			
			System.out.println("Preparing file and print writer...");
			PrintWriter out = new PrintWriter(new FileWriter(new File("Output.txt"), true));
			
			System.out.println("Reading first file..");
			ArrayList<String> fileContent1 = r.readFile("comma.txt");
			System.out.println("Reading second file..");
			ArrayList<String> fileContent2 = r.readFile("pipe.txt");
			System.out.println("Reading third file..");
			ArrayList<String> fileContent3 = r.readFile("space.txt");
			
			// list with all the strings in the format
			// LastName FirstName Gender(Male or Female) DOB(mm/dd/yyyy) Color
			List<String> newList = new ArrayList<String>();
			newList.addAll(fileContent1);
			newList.addAll(fileContent2);
			newList.addAll(fileContent3);
			System.out.println("The final List with all the data from three files created");
			
			// Sorting the array
			Collections.sort(newList);
			// Creating the first comparator to display the 
			// list in sorted gender order
			Comparator<String> cmp1 = new Comparator<String>() {
				public int compare(String o1, String o2) {
					String gen1 ="", gen2 = "";
					gen1 = rm.getGender(o1);
					gen2 = rm.getGender(o2); 
					return gen1.compareTo(gen2);
				}
	
			};
			Collections.sort(newList, cmp1);
			System.out.println("Writing the first output to file where the list is sorted on the basis of gender");
			out.print("Output1:");
			for (String l : newList) {
				out.print(l.trim());
			}
			
			Comparator<String> cmp = new Comparator<String>() {
				public int compare(String o1, String o2) {
					Date date1 = null, date2 = null;
					try {
						date1 = formatter.parse(rm.getDate(o1));
						date2 = formatter.parse(rm.getDate(o2));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return date1.compareTo(date2);	
				}
			};
			
			Collections.sort(newList);
			Collections.sort(newList, cmp);
			System.out.println("Writing the second output to file where the list is sorted on the basis of DOB");
			out.print("Output2:");
			for (String l : newList) {
				out.print(l.trim());
			}
			
			
			Collections.sort(newList);
			Collections.reverse(newList);
			
			System.out.println("Writing the third output to file where the list is sorted on the reverse last names");
			out.print("Output3:");
			for(String s:newList) {
				out.print(s.trim());
			}
			
			
			
			out.close();
			
			System.out.println("Output.txt file has been saved to the folder");
			
			} catch (ParseException e) {
			e.printStackTrace();
			} catch (IOException e) {
	    		System.out.println("File Read Error");
	    	}
	    
	}
}

