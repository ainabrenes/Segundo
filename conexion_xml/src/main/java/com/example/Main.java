package com.example;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Paso 1: Leer el archivo XML
            String xmlFilePath = "entrada.xml";
            String xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));

            // Imprimir el contenido original del archivo XML
            System.out.println("Contenido del archivo XML:");
            System.out.println(xmlContent);

            // Paso 2: Convertir el XML a JSON usando la clase Xml2Json
            JSONObject jsonObject = Xml2Json.convertirXmlAJson(xmlContent);

            // Imprimir el JSON convertido
            System.out.println("\nContenido del archivo JSON:");
            System.out.println(jsonObject.toString(4));  // La opción '4' es para una salida formateada

            // Paso 3: Guardar el JSON en un archivo
            String jsonFilePath = "salida.json";
            try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
                fileWriter.write(jsonObject.toString(4));  // Guardar el JSON con formato bonito
            }

            // Paso 4: Leer el archivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Convertir el JSON de vuelta a un JSONObject
            JSONObject jsonFromFile = new JSONObject(jsonContent);

            // Paso 5: Convertir el JSON a XML usando la clase Json2Xml
            String xmlConverted = Json2Xml.convertirJsonAXml(jsonFromFile);

            // Imprimir el XML convertido
            System.out.println("\nContenido del archivo XML convertido desde JSON:");
            System.out.println(xmlConverted);

            // Paso 6: Guardar el XML convertido en un nuevo archivo
            String xmlOutputPath = "salida_convertida.xml";
            try (FileWriter fileWriter = new FileWriter(xmlOutputPath)) {
                fileWriter.write(xmlConverted);
            }

        } catch (Exception e) {
            // Si ocurre cualquier error, lo imprimimos
            e.printStackTrace();
        }
    }
}
