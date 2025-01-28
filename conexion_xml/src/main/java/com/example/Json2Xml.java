package com.example;

import org.json.JSONObject;
import org.json.XML;

public class Json2Xml {

    public static String convertirJsonAXml(JSONObject jsonObject) throws Exception {
        try {
            return XML.toString(jsonObject);
        } catch (Exception e) {
            throw new Exception("El objeto JSON no es válido para convertir a XML: " + e.getMessage());
        }
    }
}
