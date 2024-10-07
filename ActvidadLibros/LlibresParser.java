package ActvidadLibros;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class LlibresParser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("./ActvidadLibros/llibres.xml"); 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("llibre");
            List<Llibre> llibres = new ArrayList<>();

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    String autor = element.getElementsByTagName("autor").item(0).getTextContent();
                    String titol = element.getElementsByTagName("titol").item(0).getTextContent();
                    int any = Integer.parseInt(element.getElementsByTagName("any").item(0).getTextContent());
                    String resum = element.getElementsByTagName("resum").item(0).getTextContent();

                    llibres.add(new Llibre(autor, titol, any, resum));
                }
            }

            for (Llibre llibre : llibres) {
                System.out.println(llibre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
