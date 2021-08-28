package com.company;

import java.util.Scanner;

class Character {

    Scanner scan = new Scanner(System.in);
    ChangePosition positionSys = new ChangePosition();
    TextPrompts text = new TextPrompts();

    private String name;  // Name of character in question bne it player, boss etc
    private int posX;  // Map Grid Position System, in this instance columns
    private int posY;  // Map grid position system, in this instance rows
    private double health;  // health value varies based on extended class

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
    }  // returns character health

    public void setHealth(double health) {
        this.health = health;
    }  // sets health

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