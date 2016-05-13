package lab1;

import lab1.util.FileHelper;

import java.io.IOException;
import java.util.*;

public class Main {

	static final String WORDS_FILE_PATH = "words.txt";
	static final String DICT_FILE_PATH = "dict5.txt";

    public static Map<String, Integer> findAnagrams(List<String> words, List<String> dictionary) {
        Map<String, Integer> listOfAnagrams = new HashMap<>();

        for(String s : dictionary) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String cString = String.valueOf(c);
            Integer anagramsCount = listOfAnagrams.get(String.valueOf(cString));
            if(anagramsCount != null) {
            	listOfAnagrams.put(cString, anagramsCount + 1);
            }
            else {
            	listOfAnagrams.put(cString, new Integer(1));
            }  
        }

        Map<String, Integer> anagrams = new HashMap<>();
        for(String e : words) {
            char[] c = e.toCharArray();
            Arrays.sort(c);
            if(listOfAnagrams.containsKey(String.valueOf(c)))
            {
                int count = listOfAnagrams.get(String.valueOf(c));
                anagrams.put(e, count);
            }
        }

        return anagrams;
    }

    public static void main(String[] args) {

        try {
            List<String> words = FileHelper.getWordsFromFile(WORDS_FILE_PATH);
            List<String> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);

            double startTime = System.nanoTime();

            Map<String, Integer> anagrams = findAnagrams(words, dictionary);

            double endTime = System.nanoTime();

            for (Map.Entry<String, Integer> a : anagrams.entrySet())
            {
                System.out.println("Il y a "+ a.getValue() + " anagrammes du mot " + a.getKey());
            }

            double elapsedTime = (endTime - startTime) / 1000000000;

            System.out.println("Temps d'exécution : " + elapsedTime + " secondes.");

        } catch (IOException e) {
            System.out.println("An error occured while reading the words file.");
        }
    }



}
