package ActvidadLibros;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Llibres {

    public static void main(String[] args) {
        try {
            File inputFile = new File("./llibres.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("llibre");
            System.out.println("Numero de libros" + nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    System.out.println("Titol: "
                            + element.getElementsByTagName("titol").item(0).getTextContent());
                    System.out.println("Autor: "
                            + element.getElementsByTagName("autor").item(0).getTextContent());
                    System.out.println("Any: "
                            + element.getElementsByTagName("any").item(0).getTextContent());
                    System.out.println("Resum: "
                            + element.getElementsByTagName("resum").item(0).getTextContent());
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
