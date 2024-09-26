import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Prueba2 {
    public static void main(String[] args) {
         File file = new File("./prueba.txt");
        try {
            InputStream input = new FileInputStream("./prueba.txt");
            input.read();
        }
         catch (Exception e) {
        }
    }
}
