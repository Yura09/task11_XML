package com.epam.app.parser;


import com.epam.app.model.Gem;
import com.epam.app.model.Visual;
import com.epam.app.validator.XmlValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DOMExample {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        File xsdFile = new File("src\\main\\resources\\gem\\gemsXSD.xsd");
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.parse(new File("src\\main\\resources\\gem\\gems.xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        if (XmlValidator.validate(document, xsdFile)) {
            List<Gem> gems = new LinkedList<>();
            NodeList nodeList = document.getElementsByTagName("gem");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Gem gem = new Gem();
                Visual visual = new Visual();
                Node node = nodeList.item(i);
                Element element = (Element) node;
                gem.setId(Integer.parseInt(element.getAttribute("id")));
                gem.setName(element.getElementsByTagName("name").item(0).getTextContent());
                gem.setPreciousness(element.getElementsByTagName("preciousness").item(0).getTextContent());
                gem.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                visual.setColor(element.getElementsByTagName("color").item(0).getTextContent());
                visual.setTransparency(Double.parseDouble(element.getElementsByTagName("transparency").item(0).getTextContent()));
                visual.setEngraving(Integer.parseInt(element.getElementsByTagName("engraving").item(0).getTextContent()));
                gem.setVisual(visual);
                gem.setValue(Double.parseDouble(element.getElementsByTagName("value").item(0).getTextContent()));
                gems.add(gem);

            }
            gems.forEach(System.out::println);
        } else {
            System.out.println("XML document failed validation.");
        }
    }
}
