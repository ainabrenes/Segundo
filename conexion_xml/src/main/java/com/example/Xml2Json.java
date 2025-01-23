package com.example;

import org.json.JSONObject;
import org.json.XML;

public class Xml2Json {
    // Método para convertir XML a JSON
    public static JSONObject convertirXmlAJson(String xmlString) throws Exception {
        try {
            // Intentamos convertir el XML en un JSONObject
            return XML.toJSONObject(xmlString);
        } catch (Exception e) {
            // Si ocurre un error, lanzamos una excepción indicando que no es un XML válido
            throw new Exception("El texto proporcionado no es un XML válido: " + e.getMessage());
        }
    }
}
