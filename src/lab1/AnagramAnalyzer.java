package lab1;

import java.util.List;

public class AnagramAnalyzer {

	public int getAnagramCountFromDictionary(String word, List<String> dict) {
		int count = 0;
		
		for (String dictWord : dict) {
			boolean isAnagram = isAnagram(word, dictWord);
			
			if (isAnagram)
				++count;
		}
		
		return count;
	}

	
	public boolean isAnagram(String string1, String string2) {
		
		for (int i = 0; i < string1.length(); i++) {
			boolean found = false;
			char c1 = string1.charAt(i);
			
			for (int j = 0; j < string2.length() && !found; j++) {
				char c2 = string2.charAt(j);
				
				if (c1 == c2) {
					StringBuilder sb = new StringBuilder(string2);
					string2 = sb.deleteCharAt(j).toString();
					found = true;
				}
			}
			
			if (!found) {
				return false;
			}
		}
		
		if (string2.length() != 0) {
			return false;
		}
		
		return true;
	}
}
