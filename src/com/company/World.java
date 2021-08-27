package com.company;

class World {

    public boolean[][] getClueLocationBool1() {
        return clueLocationBool1;
    }

    public int[][] getClueLocationSeq1() {
        return clueLocationSeq1;
    }

    public boolean[][] getClueLocationBool2() {
        return clueLocationBool2;
    }

    public int[][] getClueLocationSeq2() {
        return clueLocationSeq2;
    }

    void setClueLocationBool1(boolean[][] b){
        boolean[][] clueLocationBool1 = this.clueLocationBool1;}

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public enum Map{   // Mao Data type
        BAYOU, LAWSON, DESALLE;
    }
    Map map;  // Map object named map

    public enum Time_of_day{  // Time of day data type
        DUSK, DAWN, NIGHT, DAY
    }

    Time_of_day timeDay;  // Time of day objecft named timeDay

    TextPrompts textPrompts;

    String[][] BAYOU = { {"Alain & Son's Fish","Reynard Mill & Lumber","Port Reeker","Scupper Lake"},
            {"Blanchett Graves","Darrow Livestock","Alice Farm", "The Chapel of Madonna Noise"},
            {"Pitching Creamtorium","Lockbay Docks","Healing Waters","Stilwater Bend" },
            {"Cyprus Huts","Davant Ranch","The Slaughterhouse","Catfish Grove"} };

    String[][] LAWSON = { {"Godard Docks","Blanc Brinery","Golden Acres","Salter's Porc"},
            {"Maw Battery","Lawson Station","Arden Parish", "Windy Run"},
            {"Iron Works","Fort Carmick","Sweetbell Flour","Nicholls Prison" },
            {"Wolfshead Arsenal","Bradley & Craven Brickworks","C&A Lumber","Hemlock and Hide"} };

    String[][] DESALLE = { {"","","",""},
            {"","","", ""},
            {"","","","" },
            {"","","",""} };

    Boss boss1;
    Boss boss2;

    private final boolean[][] clueLocationBool1 = new boolean[4][4];  // clues by t/f
    private final int[][] clueLocationSeq1 = new int[4][4];  // clues in sequence of random

    private final boolean[][] clueLocationBool2 = new boolean[4][4];  // clues by t/f
    private final int[][] clueLocationSeq2 = new int[4][4];  // clues in sequence of random

    private final boolean[][] bossLocationBool = new boolean[4][4];  // holds t/f location of boss
    int numberBosses;
    int mapKey;

    private String mapName;


    World() {
        TextPrompts textPrompts = new TextPrompts();  // text prompts object

        int randWorld = TextPrompts.randInt(0,2);  // Scans for random map
        switch (randWorld) {
            case 0:
                map = Map.BAYOU;
                setMapName("Stillwater Bayou");
                mapKey = 0;
                break;
            case 1:
                map = Map.LAWSON;
                setMapName("Lawson Delta");
                mapKey = 1;
                break;
            case 2:
                map = Map.DESALLE;
                setMapName("DeSalle");
                mapKey = 2;
                break;
        };

        randWorld = TextPrompts.randInt(0,3);  // Scans for random time of day, WIP feature
        switch (randWorld) {
            case 0 -> timeDay = Time_of_day.DUSK;
            case 1 -> timeDay = Time_of_day.DAWN;
            case 2 -> timeDay = Time_of_day.NIGHT;
            case 3 -> timeDay = Time_of_day.DAY;
        };


        bossGenerator();  // Generates bosses and number of bosses

        switch (numberBosses) {  //Number of bosses indicates number of clue sets

            case 1:
                mapDisplay(mapKey, boss1);
                clueSystem(clueLocationBool1, clueLocationSeq1);
                textPrompts.printArrayContents(clueLocationSeq1);
                break;
            case 2:
                mapDisplay(mapKey, boss1);
                clueSystem(clueLocationBool1, clueLocationSeq1);
                textPrompts.printArrayContents(clueLocationSeq1);

                mapDisplay(mapKey, boss2);
                clueSystem(clueLocationBool2, clueLocationSeq2);
                textPrompts.printArrayContents(clueLocationSeq2);
                break;
        }

    }

    public void bossGenerator()
    {
        numberBosses = TextPrompts.randInt(1, 2);//TextPrompts.randInt(1,2);
        System.out.println(numberBosses);

        int boss1TypeKey = 0;  // initializes boss type for 1st boss
        int boss2TypeKey = 0;  // initializes boss type for 2nd boss
        System.out.println(numberBosses);

        switch (numberBosses){

            case 1:
                boss1TypeKey = TextPrompts.randInt(1, 4);  // 4 bosses 0-3
                boss1 = new Boss(boss1TypeKey);  // creates only boss1 object
                positionRandomizer(boss1);

                break;
            case 2:
                boolean IsduplicateKey = false; // sets duplicate to false by default
                 do {
                    boss1TypeKey = TextPrompts.randInt(1, 4);
                    ;   // 4 bosses 0-3
                    boss2TypeKey = TextPrompts.randInt(1, 4);
                    ;   // 4 bosses 0-3
                    if (boss1TypeKey == boss2TypeKey) {  // if random bosses are same key duplicate is true and
                        IsduplicateKey = true;                  // loop repeats until false
                        System.out.println("Duplicate Detected");
                        System.out.println("Duplicate in key");
                    }
                }   while (IsduplicateKey == true);
                boss1 = new Boss(boss1TypeKey);  // creates new boss based on key
                boss2 = new Boss(boss2TypeKey); // creates new boss based on key

                boolean isDuplicatePosition = false;
                do {
                    positionRandomizer(boss1);
                    positionRandomizer(boss2);

                    if ( (boss1.getPosY() == boss2.getPosY() ) && ((boss1.getPosX() == boss2.getPosX())) ){  // if random bosses are same key duplicate is true and
                        isDuplicatePosition = true;                  // loop repeats until false
                        System.out.println("Duplicate Detected");
                        System.out.println("Position Randomizer");
                    }
                } while (isDuplicatePosition == true);
                break;
        }

    }
    public void positionRandomizer(Character p)
    {
        int r = TextPrompts.randInt(0,3); // random to find int index in row
        int c = TextPrompts.randInt(0,3);  // random ot find int index in column

        p.setPosY(r);
        p.setPosX(c);
    }

    public void clueSystem(boolean[][] isClueArray, int[][] cluesSequence)
    {
        int[][] cluesIndex = new int[4][4];  // Array to hold clue location, numbered by pick
        boolean[][] isClue = new boolean[4][4];  // Array to check if clue is at location

        int rCtr = 0;  // counter to scan through entire row
        int cCtr = 0;  // counter to scan through entire column

        boolean pClueValidLocation = false;  // clueValid location to default so loop runs once

        int r = 0;  // holds random int through 3 to store clues
        int c = 0;  // holds random in through 3 to store clues

        for (int clues = 1; clues <= 3; clues++) {  // Loop to find 3 clues and boss
            do{
                r = TextPrompts.randInt(0,3); // random to find int index iin row
                c = TextPrompts.randInt(0,3);  // random ot find int index in column

                // Steps through entire isClue array, true means there is a clue at yhe location
                for (rCtr = 0; rCtr  <= 3; rCtr++) {
                    for (cCtr = 0; cCtr <= 3; cCtr++) {
                        if(isClue[cCtr][rCtr] == true){  // if there is a clue at location not a valid place for clue (yet), doubles will be possible in the future
                            pClueValidLocation = false;
                        }
                        else{  // if there is no clue valid location to place
                            pClueValidLocation = true;
                        }
                    }
                }
            } while (pClueValidLocation == false);  // valid location indicates it move onto to finding next clue 1, 2, 3

            isClueArray[r][c] = true;  // if location is valid sets array state to true
            cluesSequence[r][c] = clues;  // indexes the clue
        }

    }
    void mapDisplay(int mapKey, Character c)
    {
        if (mapKey == 0) {
            System.out.println(c.getName()+ " is located at " + BAYOU[c.getPosY()][c.getPosX()]);
        }
        else if  (mapKey == 1){
            System.out.println(c.getName()+ " is located at " + LAWSON[c.getPosY()][c.getPosX()]);
        }
        else if  (mapKey == 2)
        {
            System.out.println(c.getName()+ " is located at " + DESALLE[c.getPosY()][c.getPosX()]);
        }
    }

    void compoundAnnounce(World w, Character c)
    {
        if (mapKey == 0) {
            System.out.println(c.getName()+ " is located at " + BAYOU[c.getPosY()][c.getPosX()]);
        }
        else if  (mapKey == 1){
            System.out.println(c.getName()+ " is located at " + LAWSON[c.getPosY()][c.getPosX()]);
        }
        else if  (mapKey == 2)
        {
            System.out.println(c.getName()+ " is located at " + DESALLE[c.getPosY()][c.getPosX()]);
        }
    }

    /*
    void comoundDisplay (World w, Character c) {
        if (w.mapKey == 0) {
            System.out.println("You are currently located at " + BAYOU[c.getPosY()][c.getPosX()]);
        } else if (w.mapKey == 1) {
            System.out.println("You are currently located at "  + LAWSON[c.getPosY()][c.getPosX()]);
        } else if (w.mapKey == 2) {
            System.out.println("You are currently located at " + DESALLE[c.getPosY()][c.getPosX()]);
        }
    }

     */
}

class Compound extends World{

}