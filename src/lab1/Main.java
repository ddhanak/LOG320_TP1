package lab1;

import lab1.model.WordAnagrams;
import lab1.util.FileHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static final String WORDS_FILE_PATH = "words.txt";
	static final String DICT_FILE_PATH = "dict4.txt";

    public static void main(String[] args) {

        try {
            List<char[]> words = FileHelper.getWordsFromFile(WORDS_FILE_PATH);
            List<char[]> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);
            
            AnagramAnalyzer analyzer = new AnagramAnalyzer();

            System.out.println("Processing...");

            double startTime = System.nanoTime();
            
            List<WordAnagrams> wordAnagrams = new ArrayList<>();
            long totalAnagramsCount = 0;
            
            for (char[] word : words) {												// M mots * C char
            	WordAnagrams wa = new WordAnagrams();
                wa.WordName = new String(word);
                
                for (char[] dictWord : dictionary) {	
                	wa.AnagramsCount += analyzer.betterThanFastest(word, dictWord);
                }
                
                wordAnagrams.add(wa);
                totalAnagramsCount += wa.AnagramsCount;
            }

            double endTime = System.nanoTime();

            for (WordAnagrams wa : wordAnagrams) {
                System.out.println("Il y a "+ wa.AnagramsCount +" anagrammes du mot "+ wa.WordName);
            }

            double elapsedTime = (endTime - startTime) / 1000000000;

            System.out.println("Il y a un total de "+ totalAnagramsCount +" anagrammes.");
            System.out.println("Temps d'exécution : " + elapsedTime + " secondes.");

        } catch (IOException e) {
            System.out.println("An error occured while reading the words file.");
        }
    }
	


}
