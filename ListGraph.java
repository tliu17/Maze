import java.util.*;


/**
 * A simple implementation of a graph using an adjacency list.  This is an undirected, unweighted
 * graph, with no information associated with nodes in the graph.
 */
class ListGraph {
    protected List<List> adjList;  // the adjacency matrix
    protected int numNodes;    // the number of nodes in the graph

    /**
     * Constructor takes in the number of nodes, and initializes the adjacency matrix
     */
    public ListGraph(int nums) {
        numNodes = nums;
        adjList = new ArrayList<List>();
        for (int i = 0; i < numNodes; i++) {
            List newList = new ArrayList<Integer>();
            adjList.add(newList);
        }
    }

    /**
     * Takes in two nodes, and adds an undirected edge between them.  It sets the corresponding positions
     * to 1.  It ignores bad input, doesn't raise an exception or tell anyone that the input was bad.
     */
    public void addEdge(int fromNode, int toNode) {
        if ((0 <= fromNode) && (fromNode < numNodes) && (0 <= toNode) && (toNode < numNodes)) {
            List neighList = adjList.get(fromNode);
            neighList.add(toNode);
            neighList = adjList.get(toNode);
            neighList.add(fromNode);
        }
    }


    /**
     * Returns the graph's size
     */
    public int getSize() {
        return numNodes;
    }

    /**
     * Takes in a node number and returns the list of its neighbors
     */
    public List getNeighbors(int node) {
        return adjList.get(node);
    }


    /**
     * Takes in two nodes, and checks to see if an edge exists between them
     */
    public boolean areNeighbors(int node1, int node2) {
        if ((0 <= node1) && (node1 < numNodes) && (0 <= node2) && (node2 < numNodes)) {
            List neighs = adjList.get(node1);
            return neighs.contains(node2);
        }
        return false;
    }



    public static void main(String[] args) {
        // A test example
        ListGraph sg = new ListGraph(4);
        sg.addEdge(0, 1);
        sg.addEdge(0, 2);
        sg.addEdge(0, 3);
        sg.addEdge(1, 2);
        // sg.addEdge(1, 3);
        sg.addEdge(2, 3);

        int n = sg.getSize();
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ":");
            System.out.println("is a neighbor of node 3:" + sg.areNeighbors(i, 3));
            List neighbors = sg.getNeighbors(i);
            for (int j = 0; j < neighbors.size(); j++) {
                System.out.print(neighbors.get(j) + " ");
            }
            System.out.println();
        }
    }
};


    
