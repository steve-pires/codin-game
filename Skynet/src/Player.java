import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

	private static HashMap<Integer, List<Integer>> linksMap;
	private static List<Integer> exitsList;
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt(); // the total number of nodes in the level, including the gateways
        int links = in.nextInt(); // the number of links
        int exits = in.nextInt(); // the number of exit gateways
        
        linksMap = new HashMap<>();
        for (int i = 0; i < links; i++) {
            int linkStartNode = in.nextInt(); // linkStartNode and linkEndNode defines a link between these nodes
            int linkEndNode = in.nextInt();
            Player.addNodeWithNewLink(linkStartNode, linkEndNode);
        }
        
        exitsList = new ArrayList<>(exits);
        for (int i = 0; i < exits; i++) {
            exitsList.add(in.nextInt()); // adding index of a gateway node to list
        }

        // game loop
        while (true) {
            int agentPosition = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn


            List<Integer> agentPositionLinkedNodes = linksMap.get(agentPosition);
            
            System.out.println(agentPosition + " " + agentPositionLinkedNodes.get(0));

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
         //   System.out.println("0 1"); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }

    /**
     * Stores each nodes and its links in a Map.
     * Each link is composed of two nodes which are passed in parameters.
     * @param linkStartNode
     * @param linkEndNode
     */
	private static void addNodeWithNewLink(int linkStartNode, int linkEndNode) {
        if(linksMap.containsKey(linkStartNode)) {
        	List<Integer> linkedNodes = linksMap.get(linkStartNode);
        	linkedNodes.add(linkEndNode);
        } else {
        	List<Integer> linkedNodes = new ArrayList<>();
        	linkedNodes.add(linkEndNode);
        	linksMap.put(linkStartNode, linkedNodes);
        }
	}
}