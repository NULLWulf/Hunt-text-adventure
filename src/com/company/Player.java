package com.company;

class Player extends Character{

    private int weaponInventory;  // inventory based onw eapons sizes
    private boolean validMapLocation = true;

    Player(World w){  // passes world through to get mapname
        weaponInventory = 0;
        System.out.println("New Character Menu");
        System.out.println("Enter a name for your character:");
        setName(scan.nextLine()); // Sets character name from scanner
        // positionSys.randomEdgePosition(Player.this);  // this player at random edge position, commented out for time being
        System.out.println("Hunter placed on edge of map\n");
        System.out.println("Hunter Created\n" + "Get ready to hunt in " + w.getMapName() + ", " + this.getName() +".");
        // passed world name as well as this to referenced player

    }
    public void actionMoveCompound(World w)  // method to move player between compounds
    {
        validMapLocation = false;  // initially false so loop runs at least once
        do {
            text.moveMsg();  // shows cardinal move message
            text.compoundDisplay(w,this);  // shows compound you are currently using passed world and this character
            int entry = scan.nextInt();  // prompts for user input
            positionSys.boundsCheckerMap(Player.this, entry);  // function that checks ot make sure move is legal
        }        while (!validMapLocation);  // if move is legal will flag true to break the loop otherwise repeats
    }

    public void passiveActCluePickup(World w)  // WIP function check for clue pickup in compound, may need ot go into another class
    {
        w.checkForClue(Player.this);  // calls the check for clue function to check both boss 1 and/or boss 2 clues
        w.boss1.getGatheredClues();
    }

    public boolean isvalidMapLocation() {
        return validMapLocation;
    }

    public void setvalidMapLocation(boolean validLocation) {
        this.validMapLocation = validLocation;
    }


}

