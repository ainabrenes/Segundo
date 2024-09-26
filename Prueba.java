
import java.io.File;
import java.io.RandomAccessFile;

public class Prueba {

    public static void main(String[] args) {
        File file = new File("./prueba.txt");
        // if () {

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "w");
            raf.write(80);
            raf.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error no se puede leer el archivo");
        }
        // }
    }
}
