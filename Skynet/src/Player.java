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
        // nodes value is not needed in this implementation, but it needs to be consumed
        int nodes = in.nextInt(); // the total number of nodes in the level, including the gateways
        int links = in.nextInt(); // the number of links
        int exits = in.nextInt(); // the number of exit gateways
        
        Player.collectLinks(links, in);
 
        Player.collectExitsList(exits, in);

        // game loop
        while (true) {
            int agentPosition = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            int linkToSeverEndNode = findLinkToSevereEndNode(agentPosition);

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
			System.out.println(agentPosition + " " + linkToSeverEndNode);
        }
    }

	private static void collectLinks(int links, Scanner in) {
        linksMap = new HashMap<>(links);
        
		for (int i = 0; i < links; i++) {
            int linkStartNode = in.nextInt(); // linkStartNode and linkEndNode defines a link between these nodes
            int linkEndNode = in.nextInt();
            Player.addNodeWithNewLink(linkStartNode, linkEndNode);
        }
	}

    private static void collectExitsList(int exits, Scanner in) {
        exitsList = new ArrayList<>(exits);
        
        for (int i = 0; i < exits; i++) {
            exitsList.add(in.nextInt()); // adding index of a gateway node to list
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

	private static int findLinkToSevereEndNode(int agentPosition) {
		int linkToSevereEndNode = -1;
		
		for (Integer exit : exitsList) {
			List<Integer> exitLinksList = linksMap.get(exit);
			
			// if there are registered links for the exit
			// and there is a direct link with agent's position
			if(exitLinksList!=null && exitLinksList.contains(agentPosition)){
				linkToSevereEndNode = exit;
				break;
			}
		}

		// If agent is not in direct link with exit, severe first linked node
        if(linkToSevereEndNode == -1){
        	linkToSevereEndNode = linksMap.get(agentPosition).get(0);
        }
		
		return linkToSevereEndNode;
	}

}