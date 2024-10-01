package ReadFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//aqui le paso un archivo de texto que me tiene que leer con el reader y me lo lee mal
public class Prueba2 {
    public static void main(String[] args) {
        File file = new File("./prueba.txt");
        try {
            // InputStream input = new FileInputStream("./prueba.txt");
            // input.read();
            FileReader fileReader = new FileReader("./prueba.txt");
            FileWriter fileWriter = new FileWriter("./prueba.txt", true);
            fileWriter.write("data 1");
            fileWriter.write("data 2");
            fileWriter.write("data 3");
            fileWriter.close();
            // int data = fileReader.read();
            // while (data != -1) {
            //     data = fileReader.read();
            //     System.out.println(data);
            // }
          
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
