package ReadFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Output {

    public static void main(String[] args) {
        File file = new File("./prueba.txt");
        try {
            OutputStream output = new FileOutputStream("./prueba.txt");
            output.write(12345678);
            Writer outputStreamWriter = new OutputStreamWriter(output);
            outputStreamWriter.write("Hello World");
            output.close();
        } catch (Exception e) {

        }
    }
}
