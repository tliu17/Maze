import java.util.*;


/**
 * A simple implementation of a graph using an adjacency matrix.  This is an undirected, unweighted
 * graph, with no information associated with nodes in the graph.
 */
class DirectedMatrixGraph {
    protected int[][] matrix;  // the adjacency matrix
    protected int numNodes;    // the number of nodes in the graph

    /**
     * Constructor takes in the number of nodes, and initializes the adjacency matrix
     */
    public DirectedMatrixGraph(int nums) {
        numNodes = nums;
        matrix = new int[numNodes][];
        for (int i = 0; i < numNodes; i++) {
            matrix[i] = new int[numNodes];
        }
    }

    /**
     * Takes in two nodes, and adds an undirected edge between them.  It sets the corresponding positions
     * to 1.  It ignores bad input, doesn't raise an exception or tell anyone that the input was bad.
     */
    public void addEdge(int fromNode, int toNode) {
        if ((0 <= fromNode) && (fromNode < numNodes) && (0 <= toNode) && (toNode < numNodes)) {
            matrix[fromNode][toNode] = 1;
        }
    }


    /**
     * Returns the graph's size
     */
    public int getSize() {
        return numNodes;
    }

    /**
     *
     */
    public int[] getNeighbors(int node) {
        int[] neighs = new int[numNodes];

        for (int i = 0; i < numNodes; i++) {
            neighs[i] = -1;
        }

        int neighCount = 0;
        if ((0 <= node) && (node < numNodes)) {
            for (int i = 0; i < numNodes; i++) {
                if (matrix[node][i] == 1) {
                    neighs[neighCount++] = i;
                }
            }
        }
        return neighs;
    }

    /**
     * Takes in two nodes, and checks to see if an edge exists between them. The first node
     * is the from node, the second is the to node.
     */
    public boolean areNeighbors(int node1, int node2) {
        if ((0 <= node1) && (node1 < numNodes) && (0 <= node2) && (node2 < numNodes)) {
            return (matrix[node1][node2] == 1);
        }
        return false;
    }



    public static void main(String[] args) {
        // A test example
        // For an unweighted graph, just enter 0 for every weight value
        DirectedMatrixGraph sg = new DirectedMatrixGraph(4);
        sg.addEdge(0, 1);
        sg.addEdge(0, 2);
        sg.addEdge(0, 3);
        sg.addEdge(1, 2);
        sg.addEdge(1, 3);
        sg.addEdge(2, 3);

        int n = sg.getSize();
        for (int i = 0; i < n; i++) {
            System.out.println(sg.areNeighbors(i, 3));
            int[] neighbors = sg.getNeighbors(i);
            for (int j = 0; j < n; j++) {
                System.out.print(neighbors[j] + " ");
            }
            System.out.println();
        }
    }
}
