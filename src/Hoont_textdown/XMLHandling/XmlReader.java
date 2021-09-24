package Hoont_textdown.XMLHandling;
import Hoont_textdown.Items.Weapon;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

// No changes are required for this class

public class XmlReader {
    private final String inputFileName;
    private WeaponXmlHandler weaponXmlHandler;
    private Weapon[] weapons;

    public XmlReader(String inputFileName) {
        this.inputFileName = inputFileName;

        try {
            // Declare a File object
            File inputFile = new File(inputFileName);

            // Create a SAX parser factory and parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            if (inputFileName.equals("weapons.xml")){
                weaponXmlHandler = new WeaponXmlHandler();
                saxParser.parse(inputFile, weaponXmlHandler);
            }

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());

        }
    }

    public Weapon[] getWeapons(){
        // Get the ArrayList of Orders built by the handler and return an array
        Weapon[] list = new Weapon[weaponXmlHandler.getWeaponsLibrary().size()];
        list = weaponXmlHandler.getWeaponsLibrary().toArray(list);
        return list;
    }
}
