package com.company;
import com.company.Weapons_Package.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;
import com.company.Weapons_Package.*;

import java.util.ArrayList;
import java.util.Objects;

public class WeaponXmlHandler extends DefaultHandler {

    ArrayList<Weapon> weaponsLibrary = new ArrayList<Weapon>();
    Weapon weaponForge;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if (qName.equals("weapon")) {
            weaponForge = new Weapon(attributes.getValue("name"),attributes.getValue("type"));
        }
        if (qName.equals("baseData")){
            weaponForge.setMinRange(Integer.parseInt(attributes.getValue("minRange")));
            weaponForge.setMaxRange(Integer.parseInt(attributes.getValue("maxRange")));
            weaponForge.setAmmoCapacity(Integer.parseInt(attributes.getValue("ammoCapacity")));
        }
        if (qName.equals("damageValues")){
            weaponForge.setDamage(Double.parseDouble(attributes.getValue("baseDamage")));
            weaponForge.setRangeMultiplier(Double.parseDouble(attributes.getValue("rangeMultiplier")));
        }
        if (qName.equals("trivialData")){
            weaponForge.setAmmoType(attributes.getValue("ammoType"));
            weaponForge.setFireMode(attributes.getValue("fireMode"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element");
        if (qName.equals("weapon")){
            weaponsLibrary.add(weaponForge);
        }
    }

    public ArrayList<Weapon> getWeaponsLibrary(){
        return weaponsLibrary;
    }


}

