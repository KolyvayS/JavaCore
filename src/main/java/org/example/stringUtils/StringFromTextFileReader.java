package org.example.stringUtils;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

@AllArgsConstructor
public class StringFromTextFileReader{
    private String fileName;

    public String readFile() {
        try {
           String filePath = Paths.get(ClassLoader.getSystemResource("beatlesYellowSubmarine.txt").toURI()).toString();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                return sb.toString();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
