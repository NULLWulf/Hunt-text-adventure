package com.company;

class World {

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void checkForClue(Player player) {
        if (this.numberBosses == 2)  // checks to see if 2 boss map
        {
            if (this.boss1.clueLocationBool[player.getPosY()][player.getPosX()]) {
                this.boss1.clueLocationBool[player.getPosY()][player.getPosX()] = false;
                player.text.clueFund(boss1.getName());
                boss1.setGatheredClues(boss1.getGatheredClues() + 1);

            }
            if (this.boss2.clueLocationBool[player.getPosY()][player.getPosX()]) {
                this.boss2.clueLocationBool[player.getPosY()][player.getPosX()] = false;
                player.text.clueFund(boss2.getName());
                boss2.setGatheredClues(boss2.getGatheredClues() + 1);
            }
        } else  // if only 1 very simple only need to increment one clue
        {
            if (this.boss1.clueLocationBool[player.getPosY()][player.getPosX()]) {
                this.boss1.clueLocationBool[player.getPosY()][player.getPosX()] = false;
                player.text.clueFund(boss1.getName());
                boss1.setGatheredClues(boss1.getGatheredClues() + 1);
            }
        }
    }
    public enum Map{   // Mao Data type
        BAYOU, LAWSON, DESALLE
    }
    Map map;  // Map object named map

    public enum Time_of_day{  // Time of day data type
        DUSK, DAWN, NIGHT, DAY
    }

    Time_of_day timeDay;  // Time of day object named timeDay

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

    int numberBosses;
    int mapKey;

    private String mapName;


    World() {
        TextPrompts textPrompts = new TextPrompts();  // text prompts object

        // NOTE!  Sets to 1 so as to only select stillwater or lawson until i populate map names
        int randWorld = TextPrompts.randInt(0,1);  // Scans for random map
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
        }

        randWorld = TextPrompts.randInt(0,3);  // Scans for random time of day, WIP feature
        switch (randWorld) {
            case 0 -> timeDay = Time_of_day.DUSK;
            case 1 -> timeDay = Time_of_day.DAWN;
            case 2 -> timeDay = Time_of_day.NIGHT;
            case 3 -> timeDay = Time_of_day.DAY;
        }

        bossGenerator();  // Generates bosses and number of bosses

        switch (numberBosses) {  //Number of bosses indicates number of clue sets

            case 1:
                mapDisplay(mapKey, boss1);
                boss1.clueSystem();
                textPrompts.printArrayContents(boss1.clueLocationSeq);
                break;
            case 2:
                mapDisplay(mapKey, boss1);
                boss1.clueSystem();
                textPrompts.printArrayContents(boss1.clueLocationSeq);

                mapDisplay(mapKey, boss2);
                boss2.clueSystem();
                textPrompts.printArrayContents(boss2.clueLocationSeq);
                break;
        }
    }

    public void bossGenerator()
    {
        numberBosses = TextPrompts.randInt(1, 2);//TextPrompts.randInt(1,2);
        System.out.println(numberBosses);

        int boss1TypeKey;  // initializes boss type for 1st boss
        int boss2TypeKey;  // initializes boss type for 2nd boss
        System.out.println(numberBosses);

        switch (numberBosses){

            case 1:

                boss1TypeKey = TextPrompts.randInt(1, 4);  // 4 bosses 0-3
                boss1 = new Boss(boss1TypeKey);  // creates only boss1 object
                positionRandomizer(boss1);
                break;
            case 2:

                boolean iSduplicateKey = false; // sets duplicate to false by default
                 do {
                    boss1TypeKey = TextPrompts.randInt(1, 4);
                     // 4 bosses 0-3
                    boss2TypeKey = TextPrompts.randInt(1, 4);
                     // 4 bosses 0-3
                    if (boss1TypeKey == boss2TypeKey) {  // if random bosses are same key duplicate is true and
                        iSduplicateKey = true;                  // loop repeats until false
                        System.out.println("Duplicate Detected");
                        System.out.println("Duplicate in key");
                    }
                }   while (iSduplicateKey);
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
                } while (isDuplicatePosition);
                break;
        }
    }

    public void positionRandomizer(Character p)  /*Sets the position on the map where the character is, this will
    be a function that will be modified for map positions nad the like or a separate function for compound movement
    etc. */
    {
        int r = TextPrompts.randInt(0,3); // random to find int index in row
        int c = TextPrompts.randInt(0,3);  // random ot find int index in column

        p.setPosY(r);
        p.setPosX(c);
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
}