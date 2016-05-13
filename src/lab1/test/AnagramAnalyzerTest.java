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
	
	
	public AnagramAnalyzer getAnalyzer() {
		return new AnagramAnalyzer();
	} 

}
