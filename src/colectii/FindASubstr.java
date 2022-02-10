package colectii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindASubstr {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        Path p = Paths.get("stire.txt");
        try {
            String content = new String(Files.readAllBytes(p));
            content=content.toLowerCase();
            String lookFor="dumnezeu";

            // classic
            int counter=0;
            int lastIndex = 0;
            while (lastIndex != -1) {
                lastIndex = content.indexOf(lookFor, lastIndex);
                if (lastIndex != -1) {
                    counter++;
                    lastIndex += lookFor.length();
                }
            }
            System.out.println(counter);

            // regular expression
            Pattern pattern = Pattern.compile(lookFor);
            Matcher m = pattern.matcher(content);
            int count = 0;
            while (m.find()){
                count +=1;
            }
            System.out.println(count);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {


        }
    }




}
