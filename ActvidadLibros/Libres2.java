package ActvidadLibros;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Libres2 {

    public static void main(String[] args) {
        try {
            // File inputFile = new File("./llibres.xml");
            // SAXParserFactory factory = SAXParserFactory.newInstance();
            // parser = factory.newSAXParser();
            // sh = new ManejadorSAX();
            // return 0;

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            LibroHandler handler = new LibroHandler();
            parser.parse("libros.xml", handler);

        } catch (Exception e) {
        }
    }
}
