package readingFiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatching {
	
	final static public String dateRegex = "(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d";
	final static public String genderRegex ="(Fem|M)ale";
	
	public String getDate(String desc) {
		String allMatches = new String();
		Matcher m = Pattern.compile(dateRegex).matcher(desc);
		if (m.find()) {
			allMatches = m.group();
		}
		return allMatches;
	}
	
	public String getGender(String desc) {
		String matches = new String();
		Matcher m = Pattern.compile(genderRegex).matcher(desc);
		if(m.find()) {
			matches = m.group();
		}
		return matches;
	}

}
