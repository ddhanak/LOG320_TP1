package lab1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

	static final String WORDS_FILE_PATH = "words.txt";
	static final String DICT_FILE_PATH = "dict.txt";
	
	public static void main(String[] args) {
		
		try {
			List<char[]> words = FileHelper.getWordsFromFile(WORDS_FILE_PATH);
			List<char[]> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);
			
			System.out.println("Processing...");	
			
			double startTime = System.nanoTime();
			
			Map<Long, Integer> dictionaryAnagrams = mapDictionaryAnagrams(dictionary); //N mots * C char
			
			List<WordAnagrams> wordAnagrams = new ArrayList<WordAnagrams>();
			long totalAnagramsCount = 0;
			
			for (char[] word : words) {												// M mots * C char
				WordAnagrams wa = new WordAnagrams();
				wa.WordName = new String(word);
				
				long key = getStringAnagramsUniqueNumericValue(word);
				Integer anagramsCount = dictionaryAnagrams.get(key);
				
				wa.AnagramsCount = (anagramsCount != null) ? anagramsCount : 0;
		
				wordAnagrams.add(wa);
				totalAnagramsCount += wa.AnagramsCount;
			}

			double endTime = System.nanoTime();
			
    public static void main(String[] args) {

				System.out.println("Il y a "+ wa.AnagramsCount +" anagrammes du mot "+ wa.WordName);
			}
			
			double elapsedTime = (endTime - startTime) / 1000000000;
			
			System.out.println("Il y a un total de "+ totalAnagramsCount +" anagrammes.");
			System.out.println("Temps d'exécution : " + elapsedTime + " secondes.");
			
		} catch (IOException e) {
            List<String> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);
		}
	}
	
	public static Map<Long, Integer> mapDictionaryAnagrams(List<char[]> dictionary) {
		Map<Long, Integer> anagrams = new HashMap<Long, Integer>();
		
		for (char[] word : dictionary) {
			long key = getStringAnagramsUniqueNumericValue(word);
			Integer count = anagrams.get(key);
			
			if (count == null) {
				anagrams.put(key, 1);
			}
			else {
				anagrams.put(key, count + 1);
			}
		}
		
		return anagrams;
	}
	
	/**
	 * Un algorithme O(N) pour le rapport
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean isAnagram(char[] string1, char[] string2) {
		long string1NumericValue = getStringAnagramsUniqueNumericValue(string1);
		long string2NumericValue = getStringAnagramsUniqueNumericValue(string2);
		
		return string1NumericValue == string2NumericValue;
	}
	
	/**
	 * Se sert du thérorème fondamental en mathématique, idée trouvée ici : http://stackoverflow.com/questions/15045640/how-to-check-if-two-words-are-anagrams  
	 * ("By the fundamental theorem of arithmetic, 2 strings are anagrams if and only if their products are the same")
	 */
	public static long getStringAnagramsUniqueNumericValue(char[] string) {
		long value = 1;
		
		for (char c : string) {
			switch (c) {
			// Les lettres sont classées en ordre de popularité selon https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
				case 'e': value *= 2; break;
				case 's': value *= 3; break;
				case 'a': value *= 5; break;
				case 'i': value *= 7; break;
				case 't': value *= 11; break;
				case 'n': value *= 13; break;
				case 'r': value *= 17; break;
				case 'u': value *= 19; break;
				case 'l': value *= 23; break;
				case 'o': value *= 29; break;
				case 'd': value *= 31; break;
				case 'c': value *= 37; break;
				case 'p': value *= 41; break;
				case 'm': value *= 43; break;
				case 'v': value *= 47; break;
				case 'q': value *= 53; break;
				case 'f': value *= 59; break;
				case 'b': value *= 61; break;
				case 'g': value *= 67; break;
				case 'h': value *= 71; break;
				case 'j': value *= 73; break;
				case 'x': value *= 79; break;
				case 'y': value *= 83; break;
				case 'z': value *= 89; break;
				case 'w': value *= 97; break;
				case 'k': value *= 101; break;
				case '1': value *= 103; break;
				case '2': value *= 107; break;
				case '3': value *= 109; break;
				case '4': value *= 113; break;
				case '5': value *= 127; break;
				case '6': value *= 131; break;
				case '7': value *= 137; break;
				case '8': value *= 139; break;
				case '9': value *= 149; break;
				case '0': value *= 151; break;
				default: break;
			}	
		}
		
		return value;
	}

}
