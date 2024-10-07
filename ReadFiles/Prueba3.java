package ReadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Prueba3 {

    public static void main(String[] args) {
        File file = new File("./Ejemplo2.txt");
        
        try {
            if (file.getName().endsWith(".txt")) {

                System.out.println("El archivo es un .txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);

                String data1 = " Ejemplo 1 ";
                String data2 = " Ejemplo 2 ";
                String data3 = " Ejemplo 3 ";

                // Convertir las cadenas en bytes y escribirlas en el archivo
                fileOutputStream.write(data1.getBytes());
                fileOutputStream.write(data2.getBytes());
                fileOutputStream.write(data3.getBytes());
                fileOutputStream.close();
                System.out.println("Se han escrito los datos en el archivo.");

                // Lectura del archivo
                FileInputStream fileInputStream = new FileInputStream(file);
                int content;
                while ((content = fileInputStream.read()) != -1) {
                    // Convertir los bytes leídos a caracteres
                    System.out.print((char) content);
                }

                fileInputStream.close();
                
            } else {

                System.out.println("El archivo no es un .txt");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
