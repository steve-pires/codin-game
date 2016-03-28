import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt(); // the total number of nodes in the level, including the gateways
        int links = in.nextInt(); // the number of links
        int exits = in.nextInt(); // the number of exit gateways
        for (int i = 0; i < links; i++) {
            int currentNode1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int currentNode2 = in.nextInt();
        }
        for (int i = 0; i < exits; i++) {
            int currentExit = in.nextInt(); // the index of a gateway node
        }

        // game loop
        while (true) {
            int agentPosition = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("1 2"); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
}