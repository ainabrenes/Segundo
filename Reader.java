
import java.io.File;
import java.io.FileReader;

public class Reader {

    public static void main(String[] args) {
          File file = new File("./prueba.txt");
        try {
            FileReader fileReader = new FileReader("./prueba.txt");

            int data = fileReader.read();
            while (data != -1) {
                data = fileReader.read();
                System.out.println(data);
                
            }
            fileReader.close();

        } catch (Exception e) {
        
        }
    }
}
