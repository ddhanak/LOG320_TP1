package lab1;

import java.util.List;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

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

	public boolean isAnagramTest(String string1, String string2){
		return false;
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


	// http://stackoverflow.com/questions/13692221/anagram-algorithm-in-java
	// O(n log n)
	public static boolean isAnagramSorted(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		char[] c1 = string1.toCharArray();
		char[] c2 = string2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String newString1 = new String(c1);
		String newString2 = new String(c2);
		return newString1.equals(newString2);
	}

	// http://stackoverflow.com/questions/13692221/anagram-algorithm-in-java
	// O(n)
	public static boolean isAnagramHash(String string1, String string2) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : string1.toLowerCase().toCharArray()) {
			Integer frequency = map.get(c);
			map.put(c, frequency == null ? 1 : frequency + 1);
		}

		Map<Character, Integer> map2 = new HashMap<>();
		for(char c : string2.toLowerCase().toCharArray()) {
			Integer frequency = map2.get(c);
			map2.put(c, frequency == null ? 1 : frequency + 1);
		}

		if (!map.equals(map2))
		{
			return false;
		}
		return true;
	}

}
