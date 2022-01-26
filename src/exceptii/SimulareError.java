package exceptii;

import java.io.IOError;
import java.util.ArrayList;
import java.util.List;

public class SimulareError {

    static List<String> list = new ArrayList<>();

    public static void main(String args[]) throws Exception
    {


        Integer[] array = new Integer[0];
        try {
            array = new Integer[100000 * 100000]; // cod simplu
        }

        catch (Throwable e) {
            System.out.println("incerc sa o tratez");
           // e.printStackTrace(); //tratare
        }
        finally { ///se executa tot timpul
            System.out.println("tot timpul ");
        }

        System.out.println(array.length);

    }
}
