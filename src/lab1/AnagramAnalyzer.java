package lab1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AnagramAnalyzer {

	/**
	 * Algorithme de base de l'énoncé
	 * @param string1
	 * @param string2
	 * @return
	 */
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

    /**
     * Log O(N) algorithm - should be the fastest way to find anagrams
     * @param string1
     * @param string2
     * @return
     */

    public static boolean fastestWay(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        char[] firstWord = string1.toCharArray();
        char[] secondWord = string2.toCharArray();

        Map<Character, Integer> lettersInFirstWord = new HashMap<>();

        for (char c : firstWord) {
            int count = 1;
            if (lettersInFirstWord.containsKey(c)) {
                count = lettersInFirstWord.get(c) + 1;
            }
            lettersInFirstWord.put(c, count);
        }

        for (char c: secondWord) {
            int count = -1;
            if (lettersInFirstWord.containsKey(c)) {
                count = lettersInFirstWord.get(c) - 1;
            }
            lettersInFirstWord.put(c, count);
        }

        for (char c : lettersInFirstWord.keySet()) {
            if (lettersInFirstWord.get(c) != 0) {
                return false;
            }
        }

        return true;

    }

    /**
     * Algorithm not being used
     * @param dict
     * @return
     */
    public static Map<String, Integer> findAnagrams(List<char[]> dict) {
        Map<String, Integer> anagrams = new HashMap<>();

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

    /**
     * Maps the dictionary
     * @param dictionary
     * @return
     */
    public static Map<Long, Integer> mapDictionaryAnagrams(List<char[]> dictionary) {
        Map<Long, Integer> anagrams = new HashMap<>();

        for (char[] word : dictionary) {
            long key = getStringUniqueNumericValue(word);
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
        long string1NumericValue = getStringUniqueNumericValue(string1);
        long string2NumericValue = getStringUniqueNumericValue(string2);

        return string1NumericValue == string2NumericValue;
    }

    /**
     * Se sert du thérorème fondamental en mathématique, idée trouvée ici : http://stackoverflow.com/questions/15045640/how-to-check-if-two-words-are-anagrams
     * ("By the fundamental theorem of arithmetic, 2 strings are anagrams if and only if their products are the same")
     */
    public static long getStringUniqueNumericValue(char[] string) {
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
