package colectii;

import java.util.HashMap;
import java.util.Map;

public class Hashmapset {

    public static void main(String[] args) {

        Map<Integer, String> myMap = new HashMap<>();

        myMap.put(1,"ana");
        myMap.put(2,"are");
        myMap.put(3,"mere");
        myMap.put(1,"prune");
        myMap.put(2,"ana");

        // iterate, various modes

        // first one
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<Integer,String> entry : myMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }



         // second one
        // using keySet() for iteration over keys
        for (Integer k : myMap.keySet())
            System.out.println("key: " + k);

        // using values() for iteration over values
        for (String name : myMap.values())
            System.out.println("value: " + name);
    }


}
