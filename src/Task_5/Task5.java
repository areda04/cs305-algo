package Task_5;
/*
 * CS305 - Task 5 - Spring 2026
 * Using Prim's algorithm for MST,
 * make it take a startVertex (which may be v1, v2, or any other vertex) and an adjacency matrix.
 * Then, return the MST and the total cost.
 *
 * Example:
 * Input: startVertex = any number from first node to last node
 *        W (Adjacency Matrix 1-indexed) =
 *                                  { 0 , 0 , 0 , 0 , 0 }
 *                                  { 0 , 0 , 1 , 1 , 1 }
 *                                  { 0 , 1 , 0 , 2 , 2 }
 *                                  { 0 , 1 , 2 , 0 , 3 }
 *                                  { 0 , 1 , 2 , 3 , 0 }
 *
 * if startVertex = 1
 * Output:
 *          Starting with v1
 *          v1 --> v2 = 1
 *          v1 --> v3 = 1
 *          v1 --> v4 = 1
 *          Total Weight = 3
 * if startVertex = 3
 * Output:
 *          Starting with v3
 *          v3 --> v1 = 1
 *          v1 --> v2 = 1
 *          v1 --> v4 = 1
 *          Total Weight = 3
 * and so on......
 */

import java.util.ArrayList;
import java.util.List;

public class Task5 {

    /**
     * Implements Prim's algorithm to find the Minimum Spanning Tree (MST) of a weighted undirected graph.
     *
     * The algorithm works by growing the MST one vertex at a time:
     * 1. Start with the startVertex in the MST
     * 2. At each step, add the closest vertex not yet in the MST
     * 3. Update distances to remaining vertices
     *
     * @param startVertex The starting vertex (1-indexed) for building the MST
     * @param W           The adjacency matrix representing the graph (1-indexed, square matrix).
     *                    W[i][j] represents the weight of edge between vertex i and vertex j.
     *                    W[i][j] = 0 if i == j (no self-loops)
     *                    For undirected graphs, W[i][j] should equal W[j][i]
     * @return A List of int arrays where:
     * - The first (n-1) arrays represent edges in the MST: [fromVertex, toVertex, weight]
     * - The last array contains only the total cost of MST: [totalCost]
     */
    public static List<int[]> prim(int startVertex, int[][] W) {
        // Number of vertices (excluding the dummy 0-index row/column)
        int n = W.length - 1;

        // nearest[i] = the vertex in MST that is closest to vertex i
        int[] nearest = new int[n + 1];

        // distance[i] = current minimum weight to connect vertex i to the MST
        // distance[i] = -1 means vertex i is already in the MST
        int[] distance = new int[n + 1];

        // Initialize: start with only the startVertex in the MST
        for (int i = 1; i <= n; i++) {
            if (i == startVertex) {
                // Mark startVertex as already in MST (distance = -1)
                distance[i] = -1;
            } else {
                // For vertices not in MST, the closest is startVertex
                nearest[i] = startVertex;
                // Initial distance is the direct edge from startVertex
                distance[i] = W[startVertex][i];
            }
        }

        // Store MST edges: each edge is [from, to, weight]
        List<int[]> mst = new ArrayList<>();
        int totalCost = 0; // Total cost for all weights in MST

        // Build MST: need to add (n-1) edges to connect all n vertices
        for (int iteration = 0; iteration < n - 1; iteration++) {
            int min = Integer.MAX_VALUE;  // Minimum distance found
            int vnear = -1;               // Vertex with minimum distance

            // Find the vertex (not in MST) with the smallest distance
            for (int i = 1; i <= n; i++) {
                if (distance[i] >= 0 && distance[i] < min) {
                    min = distance[i];
                    vnear = i;
                }
            }

            // If no vertex found, graph is disconnected
            if (vnear == -1) break;

            // Add the edge connecting vnear to the MST
            mst.add(new int[]{nearest[vnear], vnear, min});
            totalCost += min; // Adding costs edge by edge

            // Mark vnear as added to MST
            distance[vnear] = -1;

            // Update distances to remaining vertices
            // Check if going through vnear provides a shorter path to any vertex
            for (int i = 1; i <= n; i++) {
                if (distance[i] >= 0 && W[i][vnear] < distance[i]) {
                    distance[i] = W[i][vnear];
                    nearest[i] = vnear;
                }
            }
        }

        // Add total cost as the last element in the list
        mst.add(new int[]{totalCost});
        return mst;
    }

    /**
     * Prints the Minimum Spanning Tree (MST) in a human-readable format.
     *
     * @param startVertex The starting vertex used to build the MST
     * @param list        The MST result from the prim() method containing:
     *                    - MST edges as [from, to, weight] arrays
     *                    - Total cost as the last array [totalCost]
     */
    public static void printMSTByPrim(int startVertex, List<int[]> list) {
        System.out.printf("MST starting with v%d\n", startVertex);

        // Print each edge in the MST (all except the last element which is total cost)
        for (int i = 0; i < list.size() - 1; i++) {
            int[] arr = list.get(i);
            System.out.printf("v%d --> v%d = %d\n", arr[0], arr[1], arr[2]);
        }

        // Extract and print the total weight
        int[] weight = list.getLast();
        System.out.printf("Total Weight = %d\n", weight[0]);
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        // Adjacency matrix (1-indexed, row0/col0 are dummy zeros)
        int[][] W = {
             // c0,v1,v2,v3,v4 (such that column c0 is dummy)
                {0, 0, 0, 0, 0},  // Row 0 (dummy)
                {0, 0, 1, 1, 1},  // Vertex 1 connections
                {0, 1, 0, 2, 2},  // Vertex 2 connections
                {0, 1, 2, 0, 3},  // Vertex 3 connections
                {0, 1, 2, 3, 0}   // Vertex 4 connections
        };
        printMSTByPrim(1, prim(1, W));
        printMSTByPrim(2, prim(2, W));
        printMSTByPrim(3, prim(3, W));
        printMSTByPrim(4, prim(4, W));
    }
}
