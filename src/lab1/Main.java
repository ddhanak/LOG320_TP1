package lab1;

import java.io.IOException;
import java.math.BigInteger;
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

			Map<BigInteger, WordAnagrams> wordsAnagrams = mapWordsAnagrams(words);	// N mots * K char
			
			for (char[] word : dictionary) {									// M mots * C char				
				BigInteger key;
				if (word.length <= 8) {
					key = BigInteger.valueOf(getStringAnagramsUniqueNumericValue(word));
				}
				else {
					key = getStringAnagramsUniqueBigNumericValue(word);
				}
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
	
	public static Map<BigInteger, WordAnagrams> mapWordsAnagrams(List<char[]> words) {
		Map<BigInteger, WordAnagrams> anagrams = new LinkedHashMap<BigInteger, WordAnagrams>();
		
		for (char[] word : words) {
			BigInteger key;
			if (word.length <= 8) {
				key = BigInteger.valueOf(getStringAnagramsUniqueNumericValue(word));
			}
			else {
				key = getStringAnagramsUniqueBigNumericValue(word);
			}
			
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
	
	/**
	 * Se sert du thérorème fondamental en mathématique, idée trouvée ici : http://stackoverflow.com/questions/15045640/how-to-check-if-two-words-are-anagrams  
	 * ("By the fundamental theorem of arithmetic, 2 strings are anagrams if and only if their products are the same")
	 */
	public static BigInteger getStringAnagramsUniqueBigNumericValue(char[] string) {
		BigInteger value = big1;
		
		for (char c : string) {
			switch (c) {
			// Les lettres sont classées en ordre de popularité selon https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
				case 'e': value = value.multiply(big2); break;
				case 's': value = value.multiply(big3); break;
				case 'a': value = value.multiply(big5); break;
				case 'i': value = value.multiply(big7); break;
				case 't': value = value.multiply(big11); break;
				case 'n': value = value.multiply(big13); break;
				case 'r': value = value.multiply(big17); break;
				case 'u': value = value.multiply(big19); break;
				case 'l': value = value.multiply(big23); break;
				case 'o': value = value.multiply(big29); break;
				case 'd': value = value.multiply(big31); break;
				case 'c': value = value.multiply(big37); break;
				case 'p': value = value.multiply(big41); break;
				case 'm': value = value.multiply(big43); break;
				case 'v': value = value.multiply(big47); break;
				case 'q': value = value.multiply(big53); break;
				case 'f': value = value.multiply(big59); break;
				case 'b': value = value.multiply(big61); break;
				case 'g': value = value.multiply(big67); break;
				case 'h': value = value.multiply(big71); break;
				case 'j': value = value.multiply(big73); break;
				case 'x': value = value.multiply(big79); break;
				case 'y': value = value.multiply(big83); break;
				case 'z': value = value.multiply(big89); break;
				case 'w': value = value.multiply(big97); break;
				case 'k': value = value.multiply(big101); break;
				case '1': value = value.multiply(big103); break;
				case '2': value = value.multiply(big107); break;
				case '3': value = value.multiply(big109); break;
				case '4': value = value.multiply(big113); break;
				case '5': value = value.multiply(big127); break;
				case '6': value = value.multiply(big131); break;
				case '7': value = value.multiply(big137); break;
				case '8': value = value.multiply(big139); break;
				case '9': value = value.multiply(big149); break;
				case '0': value = value.multiply(big151); break;
				default: break;
			}	
		}
		
		return value;
	}
	
	static BigInteger big1 = new BigInteger("1");
	static BigInteger big2 = new BigInteger("2");
	static BigInteger big3 = new BigInteger("3"); 
	static BigInteger big5 = new BigInteger("5"); 
	static BigInteger big7 = new BigInteger("7");
	static BigInteger big11 = new BigInteger("11");
	static BigInteger big13 = new BigInteger("13");
	static BigInteger big17 = new BigInteger("17");
	static BigInteger big19 = new BigInteger("19");
	static BigInteger big23 = new BigInteger("23");
	static BigInteger big29 = new BigInteger("29");
	static BigInteger big31 = new BigInteger("31");
	static BigInteger big37 = new BigInteger("37");
	static BigInteger big41 = new BigInteger("41");
	static BigInteger big43 = new BigInteger("43");
	static BigInteger big47 = new BigInteger("47");
	static BigInteger big53 = new BigInteger("53");
	static BigInteger big59 = new BigInteger("59");
	static BigInteger big61 = new BigInteger("61");
	static BigInteger big67 = new BigInteger("67");
	static BigInteger big71 = new BigInteger("71");
	static BigInteger big73 = new BigInteger("73");
	static BigInteger big79 = new BigInteger("79");
	static BigInteger big83 = new BigInteger("83");
	static BigInteger big89 = new BigInteger("89");
	static BigInteger big97 = new BigInteger("97");
	static BigInteger big101 = new BigInteger("101");
	static BigInteger big103 = new BigInteger("103");
	static BigInteger big107 = new BigInteger("107");
	static BigInteger big109 = new BigInteger("109");
	static BigInteger big113 = new BigInteger("113");
	static BigInteger big127 = new BigInteger("127");
	static BigInteger big131 = new BigInteger("131");
	static BigInteger big137 = new BigInteger("137");
	static BigInteger big139 = new BigInteger("139");
	static BigInteger big149 = new BigInteger("149");
	static BigInteger big151 = new BigInteger("151");

}
