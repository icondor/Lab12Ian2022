package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class DemoTextFiles {

    public static void main(String[] args) {
        Path p = Paths.get("ionel.txt");
        try {
            String content = new String(Files.readAllBytes(p));
            //System.out.println(content);
            int maxlen =0;
            String maxW="";
            List<String> lista = Files.readAllLines(p);
            for(int i=0;i<lista.size();i++) {
                String currentLine = lista.get(i);
                StringTokenizer st = new StringTokenizer(currentLine);
                int counter = 0;

                while (st.hasMoreTokens()) {
                    String currentToken = st.nextToken();
                    if (currentToken.lastIndexOf('-') == -1) {
                        int len = currentToken.length();
                        if (len > maxlen) {
                            maxlen = len;
                            maxW = currentToken;
                        }
                        counter++;
                    }
                }
            }
            System.out.println(maxlen+":"+maxW);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {


        }
    }
}
