package ReadFiles;

import java.io.File;
import java.io.FileWriter;

public class Writer {

    public static void main(String[] args) {
        File file = new File("./prueba.txt");
        try {
            FileWriter fileWriter = new FileWriter("data\\filewriter.txt",true);

            fileWriter.write("data 1");
            fileWriter.write("data 2");
            fileWriter.write("data 3");

            fileWriter.close();
        
        } catch (Exception e) {
        }
    }
}
