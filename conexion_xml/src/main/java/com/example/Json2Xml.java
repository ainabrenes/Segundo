package com.example;

import org.json.JSONObject;
import org.json.XML;

public class Json2Xml {
    // Método para convertir JSON a XML
    public static String convertirJsonAXml(JSONObject jsonObject) throws Exception {
        try {
            // Convertimos el JSONObject a XML
            return XML.toString(jsonObject);
        } catch (Exception e) {
            // Si ocurre un error, lanzamos una excepción indicando que no se puede convertir a XML
            throw new Exception("El objeto JSON no es válido para convertir a XML: " + e.getMessage());
        }
    }
}
