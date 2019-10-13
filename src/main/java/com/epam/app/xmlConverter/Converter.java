package com.epam.app.xmlConverter;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Converter {

    public static void main(String args[]) {
        Source xml = new StreamSource(new File("src\\main\\resources\\gem\\gems.xml"));
        Source xslt = new StreamSource("src\\main\\resources\\gem\\gemsXSL.xsl");

        convertXMLToHTML(xml, xslt);
    }

    private static void convertXMLToHTML(Source xml, Source xslt) {
        StringWriter sw = new StringWriter();

        try {

            FileWriter fw = new FileWriter("src\\main\\resources\\gem\\gems.html");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transform = tFactory.newTransformer(xslt);

            transform.transform(xml, new StreamResult(sw));
            fw.write(sw.toString());
            fw.close();

            System.out.println("gems.html generated successfully.");

        } catch (IOException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
    }

}
