package readingFiles;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

public class ReadFilesTest {

	@Test
	public void testReadFile() throws IOException, ParseException {
		String path1 = "comma.txt";
		ReadFiles r = new ReadFiles();
		
		ArrayList<String> testList = r.readFile(path1);
		
		ArrayList<String> outputList = new ArrayList<String>();
		outputList.add("Abercrombie Neil Male 2/13/1943 Tan ");
		outputList.add("Bishop Timothy Male 4/23/1967 Yellow ");
		outputList.add("Kelly Sue Female 7/12/1959 Pink ");
		assertEquals(testList, outputList); 
		
	}

}
