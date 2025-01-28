package com.example;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        try {
            String xmlFilePath = "./entrada.xml";

            String xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));

            System.out.println("");
            System.out.println("Contenido del archivo XML:");
            System.out.println(xmlContent);

            JSONObject jsonObject = Xml2Json.convertirXmlAJson(xmlContent);
            System.out.println("");
            System.out.println("\nContenido del archivo JSON:");
            System.out.println(jsonObject.toString(4));
            String jsonFilePath = "salida.json";
            try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
                fileWriter.write(jsonObject.toString(4));
            }

            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            JSONObject jsonFromFile = new JSONObject(jsonContent);
            String xmlConverted = Json2Xml.convertirJsonAXml(jsonFromFile);
            System.out.println("");
            System.out.println("\nContenido del archivo XML convertido desde JSON:");
            System.out.println(xmlConverted);
            String xmlOutputPath = "salida_convertida.xml";
            try (FileWriter fileWriter = new FileWriter(xmlOutputPath)) {
                fileWriter.write(xmlConverted);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
