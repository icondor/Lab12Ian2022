package teme;


//teza 30
//ababei ion  7,7,8,4, 9t
//baciu cristian 6,7,9,9t
//bolojan stefana 10,10,7,8t
//chira clara 7,9,7, 10t


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tema1 {

    public static void main(String[] args) {

        Path p = Paths.get("clasa5B_2022.txt");
        Path pout = Paths.get("medii.txt");
        try {
            List<String> clasa = Files.readAllLines(p);



            String nume="";
            for(String linie: clasa) {

                StringTokenizer st = new StringTokenizer(linie, ",");
                double media = 0.0;
                int suma = 0;
                int nrNote=0;

                  int teza = 0;



                while (st.hasMoreTokens()) {

                    String currentToken = st.nextToken();
                    if (currentToken.endsWith("teza")) {
                        teza = Integer.parseInt(currentToken.substring(0, currentToken.lastIndexOf("teza")).trim());
                        System.out.println("teza" + teza);
                    }
                    else {


                        try {
                            int nota = Integer.parseInt(currentToken.trim());
                            //System.out.println("nota intermed:"+nota);
                            suma = suma + nota;
                            nrNote++;
                        } catch (NumberFormatException e) {
                            nume = currentToken;
                        }
                    }
                }

                if(nrNote!=0) {
                    media = Math.round((double)suma / nrNote);
                    double mediacuteza = Math.round((media+teza)/2);
//                    System.out.println(nume + ": media: " + media);
//                    System.out.println("---- urm elev---");

                    String toPrint=nume+" "+mediacuteza+"\n\r";

                    byte[] strToBytes = toPrint.getBytes();

                    Files.write(pout, strToBytes, StandardOpenOption.APPEND);

                }


                }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
