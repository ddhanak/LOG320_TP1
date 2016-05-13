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
	public int estUneAnagramme(char[] string1, char[] string2) {	
		for (int i = 0; i < string1.length; i++) {
			boolean found = false;
			char c1 = string1[i];
			
			for (int j = 0; j < string2.length && !found; j++) {
				char c2 = string2[j];
				
				if (c1 == c2) {
					StringBuilder sb = new StringBuilder(new String(string2));
					string2 = sb.deleteCharAt(j).toString().toCharArray();
					found = true;
				}
			}
			
			if (!found) {
				return 0;
			}
		}
		
		if (string2.length != 0) {
			return 0;
		}
		
		return 1;
	}
	
	/**
	 * Try to beat that! O(N)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public int betterThanFastest(char[] string1, char[] string2) {    	
		if (string1.length != string2.length) {
            return 0;
        }
		
		int[] lettersCount = new int[36];
    	
    	for (int i = 0; i != string1.length; i++) {
    		int index = getCharIndex(string1[i]);
    		lettersCount[index]++;
    	}
    	
    	for (int i = 0; i != string2.length; i++) {
    		int index = getCharIndex(string2[i]);
    		lettersCount[index]--;
    	}
    	
    	for (int i = 1; i != lettersCount.length; i++) {   		
    		if (lettersCount[i] != 0) {
    			return 0;
    		}
    	}
    	
    	return 1;
    }
	
	
	
	public int betterThanbetterThanFastest(char[] string1, char[] string2) {    	
		if (string1.length != string2.length) {
            return 0;
        }
	
    	long v = getStringUniqueNumericValueTest(string1);
    	long v2 = getStringUniqueNumericValueTest(string2);

    	if(v != v2){
    		return 0;
    	}
    	
    	return 1;
    }

    /**
     * Log O(N) algorithm - should be the fastest way to find anagrams
     * @param string1
     * @param string2
     * @return
     */

    public static int fastestWay(char[] firstWord, char[] secondWord) {
        if (firstWord.length != secondWord.length) {
            return 0;
        }

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
                return 0;
            }
        }

        return 1;

    }
    
/*
    public static Map<char[], Integer> getAnagramsCount(char[][] list) {
    	Map<char[], Integer> anagrams = new HashMap<char[], Integer>(list.length / 2);
    	
    	anagrams.put(list[0], 0);
    	
    	for (int i = 1; i != list.length; i++) {
    		
    	}
    	
    	return null;
    }*/
    
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

    public static int getCharIndex(char c) {
        switch (c) {
            // Les lettres sont classées en ordre de popularité selon https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
	        case 'e': return 1;
	        case 's': return 2;
	        case 'a': return 3;
	        case 'i': return 4;
	        case 't': return 5;
	        case 'n': return 6;
	        case 'r': return 7;
	        case 'u': return 8;
	        case 'l': return 9;
	        case 'o': return 10;
	        case 'd': return 11;
	        case 'c': return 12;
	        case 'p': return 13;
	        case 'm': return 14;
	        case 'v': return 15;
	        case 'q': return 16;
	        case 'f': return 17;
	        case 'b': return 18;
	        case 'g': return 19;
	        case 'h': return 20;
	        case 'j': return 21;
	        case 'x': return 22;
	        case 'y': return 23;
	        case 'z': return 24;
	        case 'w': return 25;
	        case 'k': return 26;
	        case '1': return 27;
	        case '2': return 28;
	        case '3': return 29;
	        case '4': return 30;
	        case '5': return 31;
	        case '6': return 32;
	        case '7': return 33;
	        case '8': return 34;
	        case '9': return 35;
	        case '0': return 36;
            default: return 0;
        }
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
    
    
    public static long getStringUniqueNumericValueTest(char[] string) {
        long value = 1;

        for (char c : string) {
            switch (c) {
                // Les lettres sont classées en ordre de popularité selon https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
                case 'e': value += 1; break;
                case 's': value += 2; break;
                case 'a': value += 3; break;
                case 'i': value += 4; break;
                case 't': value += 5; break;
                case 'n': value += 6; break;
                case 'r': value += 7; break;
                case 'u': value += 8; break;
                case 'l': value += 9; break;
                case 'o': value += 10; break;
                case 'd': value += 11; break;
                case 'c': value += 12; break;
                case 'p': value += 13; break;
                case 'm': value += 13; break;
                case 'v': value += 14; break;
                case 'q': value += 15; break;
                case 'f': value += 16; break;
                case 'b': value += 17; break;
                case 'g': value += 18; break;
                case 'h': value += 19; break;
                case 'j': value += 20; break;
                case 'x': value += 21; break;
                case 'y': value += 22; break;
                case 'z': value += 23; break;
                case 'w': value += 24; break;
                case 'k': value += 25; break;
                case '1': value += 26; break;
                case '2': value += 27; break;
                case '3': value += 28; break;
                case '4': value += 29; break;
                case '5': value += 30; break;
                case '6': value += 31; break;
                case '7': value += 32; break;
                case '8': value += 33; break;
                case '9': value += 34; break;
                case '0': value += 35; break;
                default: return -1;
            }
        }

        return value;
    }
    
}
