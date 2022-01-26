package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoClasicStreams {

    public static void main(String[] args) {
        Path p = Paths.get("ionel.docx");
        Path pd = Paths.get("ionelcopy.docx");


        byte[] b = new byte [1024];
        try {
            InputStream is = Files.newInputStream(p);
            OutputStream os = Files.newOutputStream(pd);
            while(is.read(b)!=-1) {
                os.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("gata ");

    }
}
