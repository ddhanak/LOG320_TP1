package lab1.test;

import static org.junit.Assert.*;
import lab1.AnagramAnalyzer;

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
	public void betterThanFastest_Anagram_ReturnsTrue() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		int isAnagram = analyzer.estUnAnagrammeRapide("allo".toCharArray(), "olal".toCharArray());
		
		assertEquals(1, isAnagram);
	}
	
	@Test
	public void betterThanFastest_Anagram_ReturnsTrue_NotAnagram_ReturnsFalse() {
		AnagramAnalyzer analyzer = getAnalyzer();
		int isAnagram = analyzer.estUnAnagrammeRapide("hello".toCharArray(), "allo23".toCharArray());
		assertEquals(0, isAnagram);
	}
	
	// BENCHMARKS
	
	@Test
	public void betterThanFastest_Benchmark() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		System.out.println("Benchmark de notre algorithme");
		
		for (char[] string : benchmarkTestCases) {		
			double startTime = System.nanoTime();
			
			analyzer.estUnAnagrammeRapide(string, string);
			
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
	
	static char[] length5 = "qwert".toCharArray();
	static char[] length25 = "qwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] length50 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] length250 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] length500 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	static char[] length2500 = "qwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbnqwertyuiopasdfghjklzxcvbn".toCharArray();
	
	static char[][] benchmarkTestCases = {length5, length25, length50, length250, length500, length2500};
}
