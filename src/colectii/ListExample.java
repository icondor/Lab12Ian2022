package colectii;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("ana");
        myList.add("are");
        myList.add("ana");
        myList.add("mere");

        for(String value:myList) {
            System.out.println(value);
        }

    }

}
