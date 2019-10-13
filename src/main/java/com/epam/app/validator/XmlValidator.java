package com.epam.app.validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public static boolean validate(Document xml, File xsd) {
        Schema schema = createSchema(xsd);
        Validator validator = schema.newValidator();
        try {
            validator.validate(new DOMSource(xml));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Schema createSchema(File xsd) {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(xsd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schema;
    }
}
