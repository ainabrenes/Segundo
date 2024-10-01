package ReadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Input {

    public static void main(String[] args) {
        File file = new File("./prueba2.txt");
        try {
            if (file.exists()) {
                
                InputStream input = new FileInputStream("./prueba2.txt");

                int data = input.read();
                while (data != -1) {
                    data = input.read();
                    System.out.print(data);
                }
                input.close();
            }

        } catch (Exception e) {
        }

    }
}
