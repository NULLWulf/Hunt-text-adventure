package com.company;

import java.util.Arrays;

public class Boss extends Character {

        static final double[] bossHealthValues = {300,600,400,550};
        static final String[] bossName = {"Spider","Butcher","Assassin","Scrapbeak"};
        private int gatheredClues;

        boolean[][] clueLocationBool = new boolean[4][4];  // clues by t/f
        int[][] clueLocationSeq = new int[4][4];  // clues in sequence of random

        Boss(int characterKey)
        {
            for (boolean[] row: this.clueLocationBool)  // for loop that fills boolean array with false values l1
            {
                Arrays.fill(row, false);
            }

            int key = characterKey;  // holds character key
            key--;  // decrements to match arrays
            setName(bossName[key]);
            setHealth(bossHealthValues[key]);
            this.gatheredClues = 0;
        }

    public void clueSystem()
    {


        int r;  // holds random int through 3 to store clues
        int c;  // holds random in through 3 to store clues

        for (int clues = 1; clues <= 3; clues++) {  // Loop to find 3 clues and boss
            boolean pClueValidLocation = true;  // clueValid location to default so loop runs once
            do{
                r = TextPrompts.randInt(0,3); // random to find int index iin row
                c = TextPrompts.randInt(0,3);  // random ot find int index in column

                if(clueLocationBool[r][c])
                {
                    pClueValidLocation = false;
                }
                else
                {
                    this.clueLocationBool[r][c] = true;  // if location is valid sets array state to true
                    this.clueLocationSeq[r][c] = clues;  // indexes the clue
                    pClueValidLocation = true;
                }

            } while (!pClueValidLocation);  // valid location indicates it move onto to finding next clue 1, 2, 3
        }
    }

        public int getGatheredClues() {
            return gatheredClues;
        }

        public void setGatheredClues(int gatheredClues) {
            this.gatheredClues = gatheredClues;
        }

}
