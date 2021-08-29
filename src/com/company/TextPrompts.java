package com.company;
import java.util.Random;

class TextPrompts {

    // Starting screen text
   void intro() {
        System.out.println("Hunt: The Text Adventure - from the bayou a new tales came...");
    }

    // Generic Enter selection menu
    void enterSelection1() {
        System.out.println("Enter a number for a selection: ");
    }

    // For selections between 1 and 2
    void choiceValue1_2() {
        System.out.println("Choice must be a value between 1 and 2");
    }

    // For selections between 1 and 3
    void choiceValue1_3() {
        System.out.println("Choice must be a value between 1 and 3");
    }

    // For selections between 1 and 4
    void choiceValue1_4() {
        System.out.println("Choice must be a value between 1 and 4");
    }

    void mainMenu() {
        System.out.println("Enter a number for a selection, choice must be a value between 1 and 3");
        System.out.println("1: Start Game");
        System.out.println("2: Resume Game");
        System.out.println("3: Exit Game");

    }

    void moveMsg() {
        System.out.println("Enter a number for direction ");
        System.out.println("1: North");
        System.out.println("2: South");
        System.out.println("3: West");
        System.out.println("4: East");
    }

    void compoundDisplay (World w, Character c) {
        if (w.mapKey == 0) {
            System.out.println("You are currently located at " + w.BAYOU[c.getPosY()][c.getPosX()]);
        } else if (w.mapKey == 1) {
            System.out.println("You are currently located at "  + w.LAWSON[c.getPosY()][c.getPosX()]);
        } else if (w.mapKey == 2) {
            System.out.println("You are currently located at " + w.DESALLE[c.getPosY()][c.getPosX()]);
        }
    }

    void clueFund(String boss)
    {
        System.out.println("Clue found at location!");
    }

    void compoundDeclare(String compound)
    {
        System.out.println("You are currently in Lawson Delta at the " + compound + " compound.");
    }

    void coordTest(int y, int x)
    {
        System.out.println("x,y in array: (" + y + "," + x + ")");
    }

    void printArrayContents(boolean[][] booleanArrayMap)
    {
        System.out.println("");
        for (int rCtr = 0; rCtr  <= 3; rCtr++) {
            System.out.println("| " + booleanArrayMap[rCtr][0] + " " + booleanArrayMap[rCtr][1] + " " + booleanArrayMap[rCtr][2] + " " + booleanArrayMap[rCtr][3] + " |");
        }
        System.out.println("");

    }

    void printArrayContents(int[][] intArrayMap)
    {
        System.out.println("");
        for (int rCtr = 0; rCtr  <= 3; rCtr++) {
            System.out.println("| " + intArrayMap[rCtr][0] + " " + intArrayMap[rCtr][1] + " " + intArrayMap[rCtr][2] + " " + intArrayMap[rCtr][3] + " |");
        }
        System.out.println("");
    }

    public static int randInt(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    void prntPostCompoundHunterData(Player p, World w)
    {
        if (w.numberBosses == 2)
        {
            if((w.boss1.getGatheredClues() != 3) && (w.boss2.getGatheredClues() != 3))
            {
                System.out.println("You have "  +  w.boss1.getGatheredClues() + " of the 3 " + w.boss1.getName() +
                        " clues, and " + w.boss2.getGatheredClues() + " of the 3 " + w.boss2.getName() + " clues");
            }
            if((w.boss1.getGatheredClues() == 3) && (w.boss2.getGatheredClues() == 3))
            {
                System.out.println("You have found all clues for both bosses.");
                w.mapDisplay(w.mapKey, w.boss1);
                w.mapDisplay(w.mapKey, w.boss2);
            }
            if((w.boss1.getGatheredClues() == 3) && (w.boss2.getGatheredClues() != 3))
            {
                System.out.println("You have "  +  w.boss2.getGatheredClues() + " of the 3 " + w.boss2.getName() + " clues.");
                System.out.println("You have found all the clues for " + w.boss1.getName() + ".");
                w.mapDisplay(w.mapKey, w.boss1);
            }
            if((w.boss2.getGatheredClues() == 3) && (w.boss1.getGatheredClues() != 3))
            {
                System.out.println("You have "  +  w.boss1.getGatheredClues() + " of the 3 " + w.boss1.getName() + " clues.");
                System.out.println("You have found all the clues for " + w.boss2.getName() + ".");
                w.mapDisplay(w.mapKey, w.boss2);
            }

        }
        else
        {
            if(w.boss1.getGatheredClues() == 3)
            {
                System.out.print("All clues found! ");
                w.mapDisplay(w.mapKey, w.boss1);
            }
            else
            {
                System.out.println("You have "  +  w.boss1.getGatheredClues() + " of the 3 " + w.boss1.getName() + " clues.");
            }
        }
    }

}
