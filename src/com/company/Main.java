package com.company;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        int entry;  // holds main menu selection entries

        TextPrompts textPrompts = new TextPrompts();  // Creates text prompts object

        /*  Code for potential files
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
         */
        textPrompts.intro();  // calls into method text

        // Do while loop for the bulk of the main menu looping system
        do {
            textPrompts.mainMenu();  // calls main menu prompts
            entry = scan.nextInt();  // gets menu selection int

            // Switch statements to traverse the menu
            switch (entry) {
                case 1:  // Starts main game
                    System.out.println("Start a new game? Enter 1 for Yes, 2 for No");
                    entry = scan.nextInt(); // Scans input for menu selection
                    if (entry == 1) {
                        System.out.println("Starting game\n");
                        System.out.println("Creating world\n");
                        World instance = new World();  // Creates World the game will be played in
                        Player hunter = new Player(instance);  // Creates character the user will play

                        boolean gamestate = true;  // variable to keep game loop going
                        boolean clueFound = false;  // initializes clue found variable set to false, if true all clues have been found relative to game state
                        do {  // main game loop
                            do
                            {
                                hunter.actionMoveCompound(instance);  // calls method to move Hunter between compounds
                            }
                            while (hunter.isvalidMapLocation());  /* when true location of boss is disclosed, this will need
                            to thought of in more detail because there can be up to two bosses and if enough clues are
                            found on one that boss can be disclosed without the other. */
                            hunter.passiveActCluePickup(instance);
                        }while (gamestate);  // when false
                    } else {  /* more or less a placeholder now, something more sophisticated will be used when
                        going through the various menus, loop should be continous as a lot of factors have to go in
                         to potentially trigger gamestate to false*/
                        System.out.println("Returning to main menu");
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Resuming game"); /*This will involve a file system but otherwise will
                    classes that help recycle code from what will be in the new game functions */
                    break;

                case 3:
                    System.out.println("Lol had enough?\nBye");  // will close the application
                    break;

                default:
                    textPrompts.choiceValue1_3();  // tells must be a choice between 1 and 3
                    break;
                }
            } while (entry != 3) ;   // exits application when other than 3
        }
}

