package lab1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import lab1.AnagramAnalyzer;
import lab1.Main;

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
		
		boolean isAnagram = Main.isAnagram("allo".toCharArray(), "olal".toCharArray());
		
		assertEquals(true, isAnagram);
	}
	
	@Test
	public void isAnagram_NotAnagram_ReturnsFalse() {
		AnagramAnalyzer analyzer = getAnalyzer();
		
		boolean isAnagram = Main.isAnagram("hello".toCharArray(), "allo23".toCharArray());
		
		assertEquals(false, isAnagram);
	}
	
	
	
	
	public AnagramAnalyzer getAnalyzer() {
		return new AnagramAnalyzer();
	} 

}
