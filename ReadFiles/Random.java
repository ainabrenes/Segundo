package ReadFiles;
import java.io.File;
import  java.io.RandomAccessFile;
public class Random{
    public static void main(String[] args) {
        //crea el archivo
        File file = new File("./prueba.txt");
        //comprueba si existe
        boolean fileExists = file.exists();
        //if (file=(*.))
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.write(69);
            long length = file.length();
            System.out.println("Tamaño del archivo " + length);
            raf.seek(5);
            raf.writeUTF("Buenas");
            raf.seek(15);
            byte[] bytes = "Hello World".getBytes("UTF-8");
            raf.write(bytes);
            raf.read();
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}