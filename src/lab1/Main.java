package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static final String WORDS_FILE_PATH = "words.txt";
	static final String DICT_FILE_PATH = "dict.txt";
	
	public static void main(String[] args) {
		
		try {
			List<char[]> words = FileHelper.getWordsFromFile(WORDS_FILE_PATH);
			List<char[]> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);
			
			System.out.println("Processing...");	
			
			double startTime = System.nanoTime();

			long totalAnagramsCount = 0;

			Map<Long, WordAnagrams> wordsAnagrams = mapWordsAnagrams(words);	// N mots * K char
			
			for (char[] word : dictionary) {									// M mots * C char				
				long key = getStringAnagramsUniqueNumericValue(word);
				WordAnagrams wordAnagrams = wordsAnagrams.get(key);
				
				if (wordAnagrams != null) {
					wordAnagrams.AnagramsCount += 1;
					totalAnagramsCount += 1;
				}
			}		
			
			double endTime = System.nanoTime();
			
			for (WordAnagrams wa : wordsAnagrams.values()) {
				System.out.println("Il y a "+ wa.AnagramsCount +" anagrammes du mot "+ new String(wa.WordName));
			}
			
			double elapsedTime = (endTime - startTime) / 1000000000;
			
			System.out.println("Il y a un total de "+ totalAnagramsCount +" anagrammes.");
			System.out.println("Temps d'exécution : " + elapsedTime + " secondes.");
			
		} catch (IOException e) {
			System.out.println("An error occured while reading the words file.");
		}
	}
	
	public static Map<Long, WordAnagrams> mapWordsAnagrams(List<char[]> words) {
		Map<Long, WordAnagrams> anagrams = new HashMap<Long, WordAnagrams>();
		
		for (char[] word : words) {
			long key = getStringAnagramsUniqueNumericValue(word);			
			anagrams.put(key, new WordAnagrams(word, 0));
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
