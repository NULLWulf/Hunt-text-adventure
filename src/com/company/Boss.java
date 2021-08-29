package com.company;

public class Boss extends Character {

        static final double[] bossHealthValues = {300,600,400,550};
        static final String[] bossName = {"Spider","Butcher","Assassin","Scrapbeak"};
        private int gatheredClues;

        boolean[][] clueLocationBool = new boolean[4][4];  // clues by t/f
        int[][] clueLocationSeq = new int[4][4];  // clues in sequence of random



        Boss(int characterKey)
        {
            int key = characterKey;  // holds character key
            key--;  // decrements to match arrays
            setName(bossName[key]);
            setHealth(bossHealthValues[key]);
            this.gatheredClues = 0;
        }

        public int getGatheredClues() {
            return gatheredClues;
        }

        public void setGatheredClues(int gatheredClues) {
            this.gatheredClues = gatheredClues;
        }

}
