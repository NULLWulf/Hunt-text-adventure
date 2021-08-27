package com.company;
import java.util.*;
import java.io.*;



public class Main {


    public static void main(String[] args) {


        Scanner scan = new Scanner (System.in);
        int entry;  // holds main menu selection entries

        TextPrompts textPrompts = new TextPrompts();  // Creates text prompts object
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        textPrompts.intro();  // calls into method text

        // Do while loop for the bulk of the main menu looping system
        do {
            textPrompts.mainMenu();  // calls main menu prompts
            entry = scan.nextInt();  // gets menu selection int

            // Switch statements to traverse the menu
            switch (entry) {
                case 1:  // Starts main game
                    System.out.println("Start a new game? Enter 1 for Yes, 2 for No");
                    entry = scan.nextInt();
                    if (entry == 1) {
                        System.out.println("Starting game\n");
                        System.out.println("Creating world\n");
                        World instance = new World();
                        Player hunter = new Player(instance);
                        ChangePosition hunterPosition = new ChangePosition();  // creates ChancePosition object aka navigation system for characters

                        boolean gamestate = true;
                        boolean clueFound = false;
                        do {
                            do
                            {
                                hunter.actionMoveCompound(instance);
                            }
                            while (clueFound == false);
                                hunter.passiveActCluePickup(instance);
                        }while (gamestate);
                        /*
                        do {
                            instance.mapDisplay(instance.mapKey, hunter);
                            hunterPosition.mapMovement(hunter);

                        } while (hunter.isvalidMapLocation());
                        System.out.println("Returning to main menu");
                        */


                    } else {
                        // If other number than 1 will return to main menu
                        System.out.println("Returning to main menu");
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Resuming game");
                    break;

                case 3:
                    System.out.println("Lol had enough?\nBye Bitch!");
                    break;

                default:
                    textPrompts.choiceValue1_3();
                    break;
                }
            } while (entry != 3) ;

        }
}

