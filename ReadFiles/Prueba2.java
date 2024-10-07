package ReadFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Prueba2 {

    public static void main(String[] args) {
        File file = new File("./Ejemplo1.txt");

        try {
            if (file.getName().endsWith(".txt")) {

                System.out.println("El archivo es un .txt");
                FileWriter fileWriter = new FileWriter(file, true);

                fileWriter.write(" Ejemplo 1 ");
                fileWriter.write(" Ejemplo 2 ");
                fileWriter.write(" Ejemplo 3 ");
                fileWriter.close();
                System.out.println("Se han escrito los datos en el archivo.");

                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                fileReader.close();
                bufferedReader.close();

            }else{

                System.out.println("El archivo no es .txt");
            }
        } catch (Exception e) {

            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
