package lab1.test;

import static org.junit.Assert.*;
import lab1.AnagramAnalyzer;

import lab1.Main;
import org.junit.Test;

/**
 * Convention de nommage des cas de test : 
 * 			méthodeTestée_Scénario_RésultatAttendu
 * 
 * @author VTrottier
 *
 */
public class AnagramAnalyzerTest {

	@Test
	public void isAnagram_Anagram_ReturnsTrue() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		boolean isAnagram = analyzer.isAnagram("allo".toCharArray(), "olal".toCharArray());
		
		assertEquals(true, isAnagram);
	}
	
	@Test
	public void isAnagram_NotAnagram_ReturnsFalse() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		boolean isAnagram = analyzer.isAnagram("hello".toCharArray(), "allo23".toCharArray());
		
		assertEquals(false, isAnagram);
	}
	
	@Test
	public void betterThanFastest_Anagram_ReturnsTrue() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		int isAnagram = analyzer.betterThanFastest("allo".toCharArray(), "olal".toCharArray());
		
		assertEquals(1, isAnagram);
	}
	
	@Test
	public void betterThanFastest_Anagram_ReturnsTrue_NotAnagram_ReturnsFalse() {
		AnagramAnalyzer analyzer = getAnalyzer();
		int isAnagram = analyzer.betterThanFastest("hello".toCharArray(), "allo23".toCharArray());
		assertEquals(0, isAnagram);
	}
	
	// BENCHMARKS
	
	@Test
	public void betterThanFastest_Benchmark() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		System.out.println("Benchmark de notre algorithme");
		
		for (char[] string : benchmarkTestCases) {		
			double startTime = System.nanoTime();
			
			analyzer.betterThanFastest(string, string);
			
			double endTime = System.nanoTime();
			
			double elapsedTime = (endTime - startTime) / 1000000000;
			
			System.out.println("Temps exec pour "+ string.length +" caractères : "+ elapsedTime +" s.");
		}
		
	}
	
	@Test
	public void estUneAnagramme_Benchmark() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		System.out.println("Benchmark de l'algorithme de base");
		
		for (char[] string : benchmarkTestCases) {		
			double startTime = System.nanoTime();
			
			analyzer.estUneAnagramme(string, string);
			
			double endTime = System.nanoTime();
			
			double elapsedTime = (endTime - startTime) / 1000000000;
			
			System.out.println("Temps exec pour "+ string.length +" caractères : "+ elapsedTime +" s.");
		}
		
	}
	
	
	public AnagramAnalyzer getAnalyzer() {
		return new AnagramAnalyzer();
	}
	
	static char[] lenght5 = "qwert".toCharArray();
	static char[] lenght25 = "qwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] lenght50 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] lenght250 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] lenght500 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] lenght2500 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	
	static char[][] benchmarkTestCases = {lenght5, lenght25, lenght50, lenght250, lenght500, lenght2500};
}
