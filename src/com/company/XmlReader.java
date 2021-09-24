package com.company;
import com.company.Weapons_Package.*;

import com.company.WeaponXmlHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

// No changes are required for this class

public class XmlReader {
    private final String inputFileName;
    private WeaponXmlHandler myXmlHandler = null;
    private Weapon[] weapons;

    public XmlReader(String inputFileName) {
        this.inputFileName = inputFileName;

        try {
            // Declare a File object
            File inputFile = new File(inputFileName);

            // Create a SAX parser factory and parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create an XML handler
            myXmlHandler = new WeaponXmlHandler();

            // Parse the file
            saxParser.parse(inputFile, myXmlHandler);

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());

        }
    }

    public Weapon[] getWeapons(){
        // Get the ArrayList of Orders built by the handler and return an array
        Weapon[] orderArray = new Weapon[myXmlHandler.getWeaponsLibrary().size()];
        orderArray = myXmlHandler.getWeaponsLibrary().toArray(orderArray);
        return orderArray;
    }


}
