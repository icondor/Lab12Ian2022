package exceptii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CodCorectTratareCheckedExp {

    private static final Logger LOGGER = Logger.getLogger("exceptii");

    public static void main(String[] args){

        FileHandler fh = null;
        try {
            fh = new FileHandler("logaplicatie.%u.%g.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fh);
        LOGGER.setLevel(Level.SEVERE);

        LOGGER.info("intra in main, porneste programul");
        try {
            LOGGER.info("intra pe try");
            //tiparesteContinutCLosable();
            tiparesteContinutJava9Plus();
            LOGGER.info("iese de pe try");
        } catch (Exception e) {
            LOGGER.severe("o problema");
            LOGGER.severe("be pare rau, nu merge pt moment ");
        }

        LOGGER.info("iese din main, opreste programul");
    }

    private static void tiparesteContinut() throws Exception {
        // deschid un fisier
        // afisez continutul
        Scanner scanner = null;
        try {
             scanner = new Scanner(new File("u.txt"));
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
             throw new Exception("bag picioarele, nu stiu cum o rezolv");
        }
        finally {
            if(scanner!=null)
            scanner.close();
        }

        System.out.println("multumim ca ati tiparit la noi ");
    }

    private static void tiparesteContinutCLosable() throws Exception {
        // deschid un fisier
        // afisez continutul

        try
                (Scanner scanner = new Scanner(new File("u.txt")))

        {
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new Exception("bag picioarele, nu stiu cum o rezolv");
        }

        System.out.println("multumim ca ati tiparit la noi ");
    }

    private static void tiparesteContinutJava9Plus() throws Exception {
        LOGGER.config("debug metoda");
        // deschid un fisier
        // afisez continutul
        Scanner scanner = new Scanner(new File("u.txt"));
        PrintWriter pw = new PrintWriter(new File("gicu.txt"));
        try
                (scanner; pw)

        {
            while(scanner.hasNext()) {
                String s = scanner.nextLine();
                System.out.println(s);
                pw.println(s);
            }
        } catch (Exception e) {
            LOGGER.severe("bag picioarele, nu stiu cum o rezolv ");
            throw new Exception("bag picioarele, nu stiu cum o rezolv");
        }

        System.out.println("multumim ca ati tiparit la noi ");

        LOGGER.config("debug metoda iesire ");
    }


}
