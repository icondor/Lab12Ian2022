package colectii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CountNrOfOcc {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        Path p = Paths.get("stire.txt");
        try {
            List<String> lista = Files.readAllLines(p);
            for (int i = 0; i < lista.size(); i++) {
                String currentLine = lista.get(i);

                StringTokenizer st = new StringTokenizer(currentLine, " ");
                int counter = 0;

                while (st.hasMoreTokens()) {
                    String currentToken = st.nextToken();

                    currentToken = currentToken.toLowerCase().trim();


                    int index = currentToken.lastIndexOf(',');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);


                    index = currentToken.lastIndexOf('.');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf(';');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf(':');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf('!');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf('?');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf(')');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);

                    index = currentToken.lastIndexOf('”');
                    if (index != -1)
                        currentToken = currentToken.substring(0, index);


                    if (currentToken.startsWith("„"))
                        currentToken = currentToken.substring(1, currentToken.length());


                    // currentToken = currentToken.replaceAll("[\n\r ” !:;.,?1234567890\n „ ]$", "");

                    // currentToken = currentToken.replaceAll("^(|^)„ ” ", "");


                    if (currentToken.length() <= 3)
                        continue;


                    if (!myMap.containsKey(currentToken)) {
                        myMap.put(currentToken, 1);
                    } else {
                        myMap.put(currentToken, myMap.get(currentToken) + 1);
                    }

                }
            }

//
//            for (Map.Entry<String,Integer> entry : myMap.entrySet()) {
//                System.out.println( entry.getKey() +
//                        ":"+ entry.getValue());
//            }


            //   sorting the HashMap based on values
            Map<String, Integer> sortedMap = sortByValueDesc(myMap);

            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                System.out.println(entry.getKey() +
                        ":" + entry.getValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {


        }
    }


    // code adapted from https://www.geeksforgeeks.org/java-program-to-sort-a-hashmap-by-keys-and-values/?ref=rp
    public static HashMap<String, Integer> sortByValueDesc(Map<String, Integer> hm) {
        // Creating a list from elements of HashMap
        List<Map.Entry<String, Integer>> list
                = new LinkedList<Map.Entry<String, Integer>>(
                hm.entrySet());

        // Sorting the list using Collections.sort() method
        // using Comparator
        Collections.sort(
                list,
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(
                            Map.Entry<String, Integer> object1,
                            Map.Entry<String, Integer> object2) {
                        return (object2.getValue())
                                .compareTo(object1.getValue());
                    }
                });

        // putting the  data from sorted list back to hashmap
        HashMap<String, Integer> result
                = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }

        // returning the sorted HashMap
        return result;
    }

}
