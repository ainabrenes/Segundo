package com.example;

import org.json.JSONObject;
import org.json.XML;

public class Xml2Json {

    public static JSONObject convertirXmlAJson(String xmlString) throws Exception {
        try {
            return XML.toJSONObject(xmlString);
        } catch (Exception e) {
            throw new Exception("El texto proporcionado no es un XML válido: " + e.getMessage());
        }
    }
}
