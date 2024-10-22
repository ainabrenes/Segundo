package ActvidadLibros;
import javax.xml.bind.JAXBContext ;
import javax.xml.bind.JAXBException ;
import javax.xml.bind.Unmarshaller ;
import java.io.File ;
import java.util.List;
public class Libros3 {


    public static void main(String[] args) {
        try {
            File file = new File("llibres.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Llibres.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Llibres llibres = (Llibres) jaxbUnmarshaller.unmarshal(file);

            // Imprimir los resultados
            for (Llibre llibre : llibres.getLlibres()) {
                System.out.printf("Autor: %s, Títol: %s, Any: %s, Resum: %s%n",
                        llibre.getAutor(), llibre.getTitol(),
                        llibre.getAny(), llibre.getResum());
                System.out.println("------------------------------------------------------------------------------------------");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}


    // public static void main(String[] args) {
    //     try {
    //         File file = new File("llibres.xml");
    //         JAXBContext jaxbContext = JAXBContext.newInstance(Llibres.class);

    //         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    //         Llibres llibres = (Llibres) jaxbUnmarshaller.unmarshal(file);

    //         // Imprimir los resultados
    //         for (Llibre llibre : llibres.getLlibres()) {
    //             System.out.printf("Autor: %s, Títol: %s, Any: %s, Resum: %s%n", 
    //                               llibre.getAutor(), llibre.getTitol(), 
    //                               llibre.getAny(), llibre.getResum());
    //             System.out.println("------------------------------------------------------------------------------------------");
    //         }
    //     } catch (JAXBException e) {
    //         e.printStackTrace();
    //     }
    // }
}
