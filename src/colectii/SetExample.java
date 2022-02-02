package colectii;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        java.util.Set<String> mySet = new HashSet<>();
        mySet.add("ana");
        mySet.add("are");
        mySet.add("ana");
        mySet.add("mere");


        for(String value:mySet) {
            System.out.println(value);
        }


      //  System.out.println(mySet);

        }
    }

