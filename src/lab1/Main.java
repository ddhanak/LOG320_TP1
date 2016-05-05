package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

	static final String WORDS_FILE_PATH = "words.txt";
	static final String DICT_FILE_PATH = "dict.txt";
	
	public static void main(String[] args) {
		
		try {	
			List<String> words = FileHelper.getWordsFromFile(WORDS_FILE_PATH);
			List<String> dictionary = FileHelper.getWordsFromFile(DICT_FILE_PATH);
			
			AnagramAnalyzer analyzer = new AnagramAnalyzer();
			
			System.out.println("Processing...");
			
			int totalAnagramCount = 0;
			List<WordAnagrams> wordAnagrams = new ArrayList<WordAnagrams>();		
			
			long startTime = System.nanoTime();
			
			for (String word : words) {
				int count = analyzer.getAnagramCountFromDictionary(word, dictionary);
				totalAnagramCount += count;
				wordAnagrams.add(new WordAnagrams(word, count));			
			}
	
			long endTime = System.nanoTime();
			
			for (WordAnagrams wa : wordAnagrams) {
				System.out.println("Il y a "+ wa.Count +" anagrammes du mot "+ wa.WordName);
			}
			
			long elapsedTime = TimeUnit.NANOSECONDS.toSeconds((endTime - startTime));
			
			System.out.println("Il y a un total de "+ totalAnagramCount +" anagrammes.");
			System.out.println("Temps d'exÃ©cution : " + elapsedTime + " s.");
			
		} catch (IOException e) {
			System.out.println("An error occured while reading the words file.");
		}
	}

}
