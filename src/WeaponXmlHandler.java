import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;
import com.company.Weapons_Package.*;

import java.util.ArrayList;
import java.util.Objects;

public class WeaponXmlHandler extends DefaultHandler {

    ArrayList<Weapon> weaponsLibrary = new ArrayList<Weapon>();
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

    public ArrayList<Weapon> getWeaponsLibrary(){
        return weaponsLibrary;
    }


}

