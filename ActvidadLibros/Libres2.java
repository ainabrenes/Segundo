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
                private String[] llibreActual = new String[4]; // [autor, titol, any, resum]
                private StringBuilder contingut = new StringBuilder();
                private boolean llegintContingut = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("llibre")) {
                        llibreActual = new String[4]; // Reiniciar per a un nou llibre
                    } else if (qName.equalsIgnoreCase("autor") || 
                               qName.equalsIgnoreCase("titol") || 
                               qName.equalsIgnoreCase("any") || 
                               qName.equalsIgnoreCase("resum")) {
                        llegintContingut = true; // Començar a llegir contingut
                        contingut.setLength(0); // Netejar contingut anterior
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (llegintContingut) {
                        switch (qName.toLowerCase()) {
                            case "autor":
                                llibreActual[0] = contingut.toString();
                                break;
                            case "titol":
                                llibreActual[1] = contingut.toString();
                                break;
                            case "any":
                                llibreActual[2] = contingut.toString();
                                break;
                            case "resum":
                                llibreActual[3] = contingut.toString();
                                break;
                        }
                        llegintContingut = false; // Acabar de llegir contingut
                    } else if (qName.equalsIgnoreCase("llibre")) {
                        llibres.add(llibreActual); // Afegir llibre complet a la llista
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (llegintContingut) {
                        contingut.append(ch, start, length); // Afegir contingut llegit
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
