package exceptii;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DemoExceptii {
    private static final Logger LOGGER = Logger.getLogger("exceptii");
    /*

    Throwable

       Error    Exception
                           RuntimeExceptions
                                NullPont

                   <files, network, db, ...>


     */

    public static void main(String[] args) {



        int num =0;


            String s = null;
            if(s!=null)
            {String newS = s.toLowerCase();
            System.out.println("to lower"+ newS);}


        System.out.println("comunic nu stiu ce ");
///afiseaza(num);

        LOGGER.info("iese din main, opreste programul");

    }

    public static int afiseaza(int num)
    {
        System.out.println(num);
        num=num+1;
        return afiseaza(num);
    }

}
