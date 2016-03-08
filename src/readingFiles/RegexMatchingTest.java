package readingFiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegexMatchingTest {

	@Test
	public void testGetDate() {
		RegexMatching rm = new RegexMatching();
		String testSentence = "Hingis Martina Female 4/2/1979 Green";
		String outputSentence = rm.getDate(testSentence);
		
		assertEquals("4/2/1979", outputSentence);
	}

	@Test
	public void testGetGender() {
		RegexMatching rm = new RegexMatching();
		String testSentence = "Hingis Martina Female 4/2/1979 Green";
		String outputSentence = rm.getGender(testSentence);
		
		assertEquals("Female", outputSentence);
	}

}
