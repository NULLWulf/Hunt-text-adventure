package com.company;

import com.company.Weapons_Package.*;

public class Inventory {

    Weapon primary;  // declares slot 1 weapon
    Weapon secondary;  // declares slot 2 weapon
    Character character; // any kind of character object

    public Inventory(Player player){
        this.character = player;

    }

    public Inventory(Character NPC){
    }
    public void equipPrimary(Weapon weapon){
        this.primary = weapon;
    }
    public void equipSecondary(Weapon weapon){
        this.secondary = weapon;
    }
}
