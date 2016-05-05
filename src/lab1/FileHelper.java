package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	
	/**
	 * Code de lecture dans le fichier pris sur http://stackoverflow.com/questions/7413830/java-read-line-from-file
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> getWordsFromFile(String path) throws IOException {
		
		List<String> words = new ArrayList<String>();
		
		String line;
		try (
		    InputStream fis = new FileInputStream(path);
		    InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
		    BufferedReader br = new BufferedReader(isr);
		) {
		    while ((line = br.readLine()) != null) {
		        words.add(line.replaceAll("\\s+", ""));
		    }
		}
		
		return words; 
	}
}
