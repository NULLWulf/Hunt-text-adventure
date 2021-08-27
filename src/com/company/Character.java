package com.company;

import java.util.Scanner;

class Character {

    Scanner scan = new Scanner(System.in);
    ChangePosition positionSys = new ChangePosition();
    TextPrompts text = new TextPrompts();

    private String name;  // Name of character in question bne it player, boss etc
    private int posX;  // Map Grid Position System, in this instance columns
    private int posY;  // Map grid position system, in this instance rows
    private double health;

    private boolean validCompoundGrid = true;

    public void setName(String s) {
        name = s;
    }

    String getName()
    {
        return name;
    }

    public void setPosX(int x) {
        posX = x;
    }  // Map Grid Position System, in this instance columns

    public void setPosY(int y) {
        posY = y;
    }  // Map grid position system, in this instance rows

    int getPosX() {
        return posX;
    }  // Map Grid Position System, in this instance columns

    int getPosY() {
        return posY;
    }  // Map grid position system, in this instance rows

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

}

class Boss extends Character{

    static final double[] bossHealthValues = {300,600,400,550};
    static final String[] bossName = {"Spider","Butcher","Assassin","Scrapbeak"};
    private int gatheredClues;

    Boss(int characterKey)
    {
        int key = characterKey;  // holds character key
        key--;  // decrements to match arrays
        setName(bossName[key]);
        setHealth(bossHealthValues[key]);
    }

    public int getGatheredClues() {
        return gatheredClues;
    }

    public void setGatheredClues(int gatheredClues) {
        this.gatheredClues = gatheredClues;
    }
}

class Player extends Character{

    private int weaponInventory = 4;
    private boolean validMapLocation = true;

    Player(World w){
        System.out.println("New Character Menu");
        System.out.println("Enter a name for your character:");
        setName(scan.nextLine()); // Sets character name from scanner
        // positionSys.randomEdgePosition(Player.this);  // this player at random edge position, commented out for time being
        System.out.println("Hunter placed on edge of map\n");
        System.out.println("Hunter Created\n" + "Get ready to hunt in " + w.getMapName() + ", " + this.getName() +".");

    }
    public void actionMoveCompound(World w)
    {
        validMapLocation = false;
        do {
            text.moveMsg();
            text.compoundDisplay(w,this);
            int entry = scan.nextInt();
            positionSys.boundsCheckerMap(Player.this, entry);
        }        while (!validMapLocation);

    }

    public void passiveActCluePickup(World w)
    {
        positionSys.checkForClue(Player.this, w);
    }

    public boolean isvalidMapLocation() {
        return validMapLocation;
    }

    public void setvalidMapLocation(boolean validLocation) {
        this.validMapLocation = validLocation;
    }


}
