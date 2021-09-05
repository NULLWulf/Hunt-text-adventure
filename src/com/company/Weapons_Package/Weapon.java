package com.company.Weapons_Package;

import java.util.*;

public class Weapon{

     Scanner scan = new Scanner (System.in);
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





