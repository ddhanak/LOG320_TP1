package lab1;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class AnagramAnalyzer {

    public int getAnagramCountFromDictionary(String word, List<String> dict) {
        int count = 0;

        for (String dictWord : dict) {
            boolean isAnagram = isAnagramSorted(word, dictWord);

            if (isAnagram)
                ++count;
        }

        return count;
    }

    // O(n2)
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
    public boolean isAnagramSorted(String string1, String string2) {
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
    // ?? O(n)
    public boolean isAnagramHash(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < string1.length(); i++){
            char charString1 = string1.charAt(i);
            int nbCharString1 = map.containsKey(charString1) ? map.get(charString1) : 0;
            map.put(charString1, ++nbCharString1);
            char charString2 = string2.charAt(i);
            int nbCharString2 = map.containsKey(charString2) ? map.get(charString2) : 0;
            map.put(charString2, --nbCharString2);
        }

        for(int nbOccurrences : map.values()){
            if(nbOccurrences != 0){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramHashTest(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();
        char[] c1 = string1.toCharArray();
        char[] c2 = string2.toCharArray();
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for (char element : c1) {
            int count = 1;
            if (myMap.containsKey(element)) {
                count = myMap.get(element) + 1;
            }
            myMap.put(element, count);
        }
        for (char element : c2) {
            int count = -1;
            if (myMap.containsKey(element)) {
                count = myMap.get(element) - 1;
            }
            myMap.put(element, count);
        }

        for (char element : myMap.keySet()) {
            if (myMap.get(element) != 0) {
                return false;
            }
        }

        return true;
    }

}
