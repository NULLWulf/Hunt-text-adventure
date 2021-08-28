package com.company;
import java.util.*;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;


// Meant to serve as main positioning system for game,
class ChangePosition {

    Scanner scan = new Scanner(System.in);
    TextPrompts coord = new TextPrompts();


    // Calls method and referenced character object 'c' into function as well direct updated coordinates
    public void ChangePos(Character c, int xNew, int yNew)  // takes reffed Character object 'c', and X and Y variable to change position within the Character class
    {
        int x = c.getPosX(); // Gets X axis value
        int y = c.getPosY(); // Gets Y axis value

        c.setPosX(xNew);
        c.setPosY(yNew);

        boolean outOfBounds = false;

    }

    public void mapMovement(@NotNull Character c) {
        int x = c.getPosX();
        int y = c.getPosY();

        TextPrompts coord = new TextPrompts();
        boolean outOfBounds = true;

        do {
            coord.moveMsg();
            int cardinal = scan.nextInt();  // takes a value and stores as cardinal selection 1:N,2:S,3:W,4:E


            // N / S / W / E
            switch (--cardinal) {  // Traversing North
                case 0:
                    y--;
                    if (y < 0) {
                        y = 0;
                        System.out.println("Error out of bounds traversing\nShifting Back");
                        outOfBounds = true;
                    } else {
                        outOfBounds = false;
                    }
                    break;

                case 1:  // Traversing South
                    y++;
                    if (y > 3) {
                        y = 3;
                        System.out.println("Error out of bounds traversing South\nShifting Back");
                        outOfBounds = true;
                    } else {
                        outOfBounds = false;
                    }
                    break;

                case 2:  // Traversing West
                    x--;
                    if (x < 0) {
                        x = 0;
                        System.out.println("Error out of bounds traversing West\nShifting back");
                        outOfBounds = true;
                    } else {
                        outOfBounds = false;
                    }
                    break;
                case 3:
                    x++;  // Traversing East
                    if (x > 3) {
                        x = 3;
                        System.out.println("Error out of bounds traversing East\nShifting back");
                        outOfBounds = true;

                    } else {
                        outOfBounds = false;
                    }
                    break;
                default:
                    System.out.println("Wrong value detected");
                    coord.choiceValue1_4();
                    break;
            }
        } while (outOfBounds == true);

        c.setPosX(x);
        c.setPosY(y);

    }

    public void boundsCheckerMap(Player c, int movIndex) {
        int cardinal = movIndex;
        int x = c.getPosX();
        int y = c.getPosY();

        // N / S / W / E
        switch (--cardinal) {  // Traversing North
            case 0:
                y--;
                if (y < 0) {
                    y = 0;
                    System.out.println("Error out of bounds traversing\nShifting Back");
                    c.setvalidMapLocation(false);
                } else {
                    c.setvalidMapLocation(true);
                }
                break;

            case 1:  // Traversing South
                y++;
                if (y > 3) {
                    y = 3;
                    System.out.println("Error out of bounds traversing South\nShifting Back");
                    c.setvalidMapLocation(false);
                } else {
                    c.setvalidMapLocation(true);
                }
                break;

            case 2:  // Traversing West
                x--;
                if (x < 0) {
                    x = 0;
                    System.out.println("Error out of bounds traversing West\nShifting back");
                    c.setvalidMapLocation(false);
                } else {
                    c.setvalidMapLocation(true);
                }
                break;
            case 3:
                x++;  // Traversing East
                if (x > 3) {
                    x = 3;
                    System.out.println("Error out of bounds traversing East\nShifting back");
                    c.setvalidMapLocation(false);

                } else {
                    c.setvalidMapLocation(true);
                }
                break;
            default:
                System.out.println("Wrong value detected");
                coord.choiceValue1_4();
                break;
        }

        c.setPosX(x);
        c.setPosY(y);

    }

    // Not utilized too miuch atm, mostly a function to copy and paste from
    public boolean checkIfAtSameLocation(Player p, Character e) {
        if ((p.getPosY() == e.getPosY()) && (p.getPosX() == e.getPosX())) {
            return true;
        } else {
            return false;
        }
    }

        public void randomEdgePosition(Player p)  // Takes object p and sets y and x position accordingly
        {
            boolean validEdge = false;  // set valid edge to false by default

            int r = 0;
            int c = 0;

            // array that holds consistent values for edge, true meaning true that this is an edge
            final boolean[][] edges = new boolean[][]{
                    {true, true, true, true},
                    {true, false, false, true},
                    {true, false, false, true},
                    {true, true, true, true}};
            do {
                r = TextPrompts.randInt(0, 3); // random to find int index in row
                c = TextPrompts.randInt(0, 3);  // random ot find int index in column

                if (edges[r][c] == true)  // determines if edges is true
                {
                    validEdge = true; // sets valid edge to true to exit loop
                }
            } while (validEdge == false);  // when true will exit roop

            p.setPosY(r); //sets character p position directly
            p.setPosX(c);
        }

}
