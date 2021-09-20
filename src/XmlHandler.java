import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class XmlHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element");

        if (qName.equals("product")) {

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element");
        // check if this is a closing element for a product

        // If so, add product to array list
    }


}

