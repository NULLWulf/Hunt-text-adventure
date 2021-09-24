package com.company.Weapons_Package;

import java.util.*;

public class Weapon{

     Scanner scan = new Scanner (System.in);
     private ArrayList<Boolean> ammunition;
     private String weaponName;
     private String weaponType;
     private String ammoType;
     private String fireMode;
     private int minRange;
     private int maxRange;
     private int currentRange;
     private int ammoCapacity;
     private double damage;
     private boolean meleeWeapon;
     private double rangeMultiplier;

     public Weapon(){

     }

     public Weapon(String weaponName, String weaponType){
          this.weaponName = weaponName;
          this.weaponType = weaponType;
     }

     public String getWeaponType() {return weaponType;}
     public void setWeaponType(String weaponType) {this.weaponType = weaponType;}
     public int getAmmoCapacity() {return ammoCapacity;}
     public void setAmmoCapacity(int ammoCapacity) {this.ammoCapacity = ammoCapacity;}
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
     public double getRangeMultiplier() {return rangeMultiplier;}
     public void setRangeMultiplier(double rangeMultiplier) {this.rangeMultiplier = rangeMultiplier;}
     public String getAmmoType() {return ammoType;}
     public void setAmmoType(String ammoType) {this.ammoType = ammoType;}
     public String getFireMode() {return fireMode;}
     public void setFireMode(String fireMode) {this.fireMode = fireMode;}
}






