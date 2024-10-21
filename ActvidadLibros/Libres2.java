package ActvidadLibros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Libres2 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("llibres.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            List<String[]> llibres = new ArrayList<>();

            // Handler intern
            DefaultHandler handler = new DefaultHandler() {
                private String[] llibreActual = new String[4];
                private StringBuilder contenido = new StringBuilder();
                private boolean leyendoContenido = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("llibre")) {
                        llibreActual = new String[4]; // Reiniciar 
                    } else if (qName.equalsIgnoreCase("autor")){
                        leyendoContenido = true; // Començar a llegir contingut
                        contenido.setLength(0); 
                    }else if( qName.equalsIgnoreCase("titol")){
                        leyendoContenido = true; // Començar a llegir contingut
                        contenido.setLength(0); 
                    }else if( qName.equalsIgnoreCase("any")){
                        leyendoContenido = true; // Començar a llegir contingut
                        contenido.setLength(0); 
                    }else if(qName.equalsIgnoreCase("resum")){
                        leyendoContenido = true; // Començar a llegir contingut
                        contenido.setLength(0); 
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (leyendoContenido) {
                        switch (qName.toLowerCase()) {
                            case "autor":
                                llibreActual[0] = contenido.toString();
                                break;
                            case "titol":
                                llibreActual[1] = contenido.toString();
                                break;
                            case "any":
                                llibreActual[2] = contenido.toString();
                                break;
                            case "resum":
                                llibreActual[3] = contenido.toString();
                                break;
                        }
                        leyendoContenido = false; // Acabar de llegir contingut
                    } else if (qName.equalsIgnoreCase("llibre")) {
                        llibres.add(llibreActual); // Afegir llibre complet a la llista
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (leyendoContenido) {
                        contenido.append(ch, start, length); // Afegir contingut llegit
                    }
                }
            };

            parser.parse(inputFile, handler);

            // Imprimir els llibres
            for (String[] llibre : llibres) {
                System.out.printf("Autor: %s, Títol: %s, Any: %s, Resum: %s%n", llibre[0], llibre[1], llibre[2], llibre[3]);
                System.out.println("------------------------------------------------------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
