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
