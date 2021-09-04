package com.company;
import java.util.*;


/*
Range:  0 - melee, 1 - very close (shot guns mostly), 2 - close (compact ammo),

*/

public class Weapon extends Item {

     private ArrayList<Boolean> ammunition;
     private String weaponName;
     private int minRange;
     private int maxRange;
     private int currentRange;
     private double damage;
     private boolean meleeWeapon;

     public Weapon(){

     }

     public String getWeaponName() {
          return weaponName;
     }

     public void setWeaponName(String weaponName) {
          this.weaponName = weaponName;
     }

     public int getMinRange() {
          return minRange;
     }

     public void setMinRange(int minRange) {
          this.minRange = minRange;
     }

     public int getMaxRange() {
          return maxRange;
     }

     public void setMaxRange(int maxRange) {
          this.maxRange = maxRange;
     }

     public int getCurrentRange() {
          return currentRange;
     }

     public void setCurrentRange(int currentRange) {
          this.currentRange = currentRange;
     }

     public double getDamage() {
          return damage;
     }

     public void setDamage(double damage) {
          this.damage = damage;
     }

     public boolean isMeleeWeapon() {
          return meleeWeapon;
     }

     public void setMeleeWeapon(boolean meleeWeapon) {
          this.meleeWeapon = meleeWeapon;
     }


}

class PrimaryWeapon extends Weapon{

     static final String weaponNameList[]={"Windal Lever Action Repeater", "Burnings GaugeMan Double Barrell",
             "Sarah's Sure Shot Rifle","Bernie's Action Bolter","Windal Quickshot Poker"};
     static final int maxRange[]={3, 1, 5, 5, 2};
     static final double damage[]={65.0,150.00,140.00,120,80.00};
     static final double largeWpnBunt = 40.00;
     static final double meleeWeapon[]={largeWpnBunt,largeWpnBunt,largeWpnBunt,largeWpnBunt,150.00};

     public PrimaryWeapon() {
          for (int i = 0; i < maxRange.length; i++)
          {
               System.out.println("Selection: 1");
               System.out.println("Model: " + this.weaponNameList[i]);
               System.out.println("Max Range " + this.maxRange[i]);
               System.out.println("Damage: " + this.damage[i]);
               System.out.println("Melee Damage: " + this.meleeWeapon[i]);
          }
     }

}

class SecondaryWeapon extends Weapon{

     public SecondaryWeapon(){

     }
}
