package ActvidadLibros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.ArrayList;





public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("llibres.xml"); // Nom del fitxer XML
            JAXBContext jaxbContext = JAXBContext.newInstance(Llibres.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Llibres llibres = (Llibres) jaxbUnmarshaller.unmarshal(file);

            // Imprimir els llibres
            List<Llibre> llistaLlibres = llibres.getLlibres();
            for (Llibre llibre : llistaLlibres) {
                System.out.println("Autor: " + llibre.getAutor());
                System.out.println("Títol: " + llibre.getTitol());
                System.out.println("Any: " + llibre.getAny());
                System.out.println("Resum: " + llibre.getResum());
                System.out.println("-------------------------------------------------");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
