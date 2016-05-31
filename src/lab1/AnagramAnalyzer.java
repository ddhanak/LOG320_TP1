package lab1;

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

    /*

    CODE EMPRUNTÉ :
    Les lignes suivantes ont été inspirées de l'algorithme partagé sur les sites suivant par l'utilisateur jb. & Scott Wegner:
    http://stackoverflow.com/questions/15045640/how-to-check-if-two-words-are-anagrams
    http://codereview.stackexchange.com/questions/1690/optimizing-java-anagram-checker-compare-2-strings

    */

	/**
     * Meilleure algorithme - O(N)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public int estUnAnagrammeRapide(char[] string1, char[] string2) {
		if (string1.length != string2.length) {
            return 0;
        }
		
		int[] lettersCount = new int[37];
    	
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

    /* FIN DU CODE EMPRUNTÉ */

    public static int getCharIndex(char c) {
        switch (c) {
            // Les lettres sont classées en ordre de popularité selon:
            // https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
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

}
