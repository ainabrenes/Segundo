
import java.io.FileReader;

public class Reader {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:\\data\\input-text.txt");

            int data = fileReader.read();
            while (data != -1) {

                data = fileReader.read();
            }
            fileReader.close();

        } catch (Exception e) {
        
        }
    }
}
