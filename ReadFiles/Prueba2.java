package ReadFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Prueba2 {

    public static void main(String[] args) {
        File file = new File("./prueba.txt");
        try {
            if (file.getName().endsWith(".txt")) {
                System.out.println("El archivo es un .txt");
                FileWriter fileWriter = new FileWriter("./prueba.txt", true);
                fileWriter.write(" data 1 ");
                fileWriter.write(" data 2 ");
                fileWriter.write(" data 3 ");
                fileWriter.close();
                if (file.setWritable(false)){
                    System.out.println("Se eliminaron los permisos de lectura");
                }else{
                    System.out.println("No se pudieron cambiar los permisos");
                }
                FileReader fileReader = new FileReader("./prueba.txt");
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
        }
    }
}
