package com.company;

public class Inventory {

    Weapon primary;  // declares slot 1 weapon
    Weapon secondary;  // declares slot 2 weapon
    Character character; // any kind of character object


    public Inventory(Player player){
        this.character = player;
        primary = new PrimaryWeapon();
        secondary = new SecondaryWeapon();
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
