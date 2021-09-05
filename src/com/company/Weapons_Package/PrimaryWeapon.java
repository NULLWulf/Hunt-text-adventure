package com.company.Weapons_Package;

public class PrimaryWeapon extends Weapon{

    static final String[] weaponNameList ={"Windal Lever Action Repeater", "Burnings GaugeMan Double Barrell",
            "Sarah's Sure Shot Rifle","Bernie's Action Bolter","Windal Quickshot Poker"};
    static final int[] maxRange ={3, 1, 5, 5, 2};
    static final double[] damage ={65.0,150.00,140.00,120,80.00};
    static final double largeWpnBunt = 40.00;
    static final double[] meleeWeapon ={largeWpnBunt,largeWpnBunt,largeWpnBunt,largeWpnBunt,150.00};

     /*
     public PrimaryWeapon() {


          int selection = -1;
          do {
               for (int i = 0; i < 5; i++) {
                    System.out.println("Model: " + weaponNameList[i]);
                    System.out.println("Max Range " + maxRange[i]);
                    System.out.println("Damage: " + damage[i]);
                    System.out.println("Melee Damage: " + meleeWeapon[i]);
                    int temp = i++;
                    System.out.println("Selection #" + temp);
               }
               System.out.println("Choose your weapon, using the Selection # to make your selection");
               selection = scan.nextInt();
               selection--;
          }while(selection < 1 || selection > 5);
     }
     */
}