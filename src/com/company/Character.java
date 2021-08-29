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

