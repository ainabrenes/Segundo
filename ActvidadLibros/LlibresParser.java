package ActvidadLibros;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.List;
import java.util.ArrayList;

public class LlibresParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("./llibres.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("llibre");
            System.out.println("Numero de libros" + nList.getLength());
            List<Llibre> llibres = new ArrayList<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    System.out.println("\nLibro id: " + element.getAttribute("id"));
                    System.out.println("Marca: "
                            + element.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: "
                            + element.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Cilindrada: "
                            + element.getElementsByTagName("cilindrada").item(0).getTextContent());
                // }
                        String autor = element.getElementsByTagName("autor").item(0).getTextContent();
                        String titol = element.getElementsByTagName("titol").item(0).getTextContent();
                        int any = Integer.parseInt(element.getElementsByTagName("any").item(0).getTextContent());
                        String resum = element.getElementsByTagName("resum").item(0).getTextContent();
                        llibres.add(new Llibre(autor, titol, any, resum));
                    
                    
                }
                for (Llibre llibre : llibres) {
                    System.out.println(llibre);
                }
                /*factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
                 */
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
