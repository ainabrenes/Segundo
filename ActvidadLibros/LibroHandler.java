// package ActvidadLibros;

// import org.xml.sax.Attributes;
// import org.xml.sax.SAXException;
// import org.xml.sax.helpers.DefaultHandler;
 
// public class LibroHandler extends DefaultHandler {
 
//     private StringBuilder value;
 
//     public LibroHandler() {
//         this.value = new StringBuilder();
//     }
 
//     @Override
//     public void startElement(String uri, String localName,
//             String qName, Attributes attributes)
//             throws SAXException {
 
//         this.value.setLength(0);
 
//         if (qName.equals("libro")) {
//             String anio = attributes.getValue("año");
//             System.out.println("Atributo año: " + anio);
//         }
 
//     }
 
// }
