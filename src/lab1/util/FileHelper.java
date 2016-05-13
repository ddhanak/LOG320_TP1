package lab1.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileHelper {

    /**
     * Code de lecture dans le fichier pris sur http://stackoverflow.com/questions/7413830/java-read-line-from-file
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> getWordsFromFile(String path) throws IOException {

        List<String> words = new ArrayList<>();

        String line;

        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                line = line.trim().replaceAll("\\s", "");
                words.add(line);
            }
        }

        return words;
    }
}
