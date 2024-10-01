package ReadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Prueba3 {

    public static void main(String[] args) {
        File file = new File("./prueba.jpg");
        try {
            InputStream input = new FileInputStream("./prueba.jpg");
            OutputStream output = new FileOutputStream("./prueba.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        }
    }
}
