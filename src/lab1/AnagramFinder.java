package lab1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramFinder {

	public static Map<String, Integer> findAnagrams(List<char[]> dict) {
		Map<String, Integer> anagrams = new HashMap<String, Integer>();
		
		for (char[] word : dict) {
			Arrays.sort(word);
			
			Integer anagramCount = anagrams.get(new String(word));
			
			if (anagramCount == null) {
				anagrams.put(new String(word), 1);
			}
			else {
				anagrams.put(new String(word), anagramCount + 1);
			}
		}
		
		return anagrams;
	}
	
}
