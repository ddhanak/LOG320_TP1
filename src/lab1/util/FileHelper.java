package lab1.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    /**
     * CODE EMPRUNTÉ :
     * Les lignes suivantes sont basées sur le code source disponible à l'adresse suivante:
     * http://stackoverflow.com/questions/7413830/java-read-line-from-file
     * @param path
     * @return
     * @throws IOException
     */
    public static List<char[]> getWordsFromFile(String path) throws IOException {

        List<char[]> words = new ArrayList<>();

        String line;

        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                words.add(line.replaceAll("\\s+","").toCharArray());
            }
        }

        return words;
    }

    /* FIN DU CODE EMPRUNTÉ */
}
