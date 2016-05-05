package lab1.tests;

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
	public void isAnagram_Anagram_ReturnsTrue() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		boolean isAnagram = analyzer.isAnagram("allo", "olal");
		
		assertEquals(true, isAnagram);
	}
	
	@Test
	public void isAnagram_NotAnagram_ReturnsFalse() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		boolean isAnagram = analyzer.isAnagram("hello", "allo23");
		
		assertEquals(false, isAnagram);
	}
	
	
	
	
	public AnagramAnalyzer getAnalyzer() {
		return new AnagramAnalyzer();
	} 

}
