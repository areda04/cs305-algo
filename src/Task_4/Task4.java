package Task_4;
/*
 * CS305 - Task 4 - Spring 2026
 * Using Floyd's algorithm, update it to handle a graph that contains cycles
 * such that it computes the minimum cycle weight in the graph
 * (assuming all edge weights are positive).
 *
 * Arbitrary Example --> Floyd(1,1) = 2 NOT 0
 *                   --> Floyd(3,3) = 4 NOT 0
 *
 * Example 1:
 * Input: n (number of nodes) = 4, W1 (adjacency matrix) =
                                { 0 ,INF, 7 ,INF}
                                { 3 , 0 , 1 ,INF}
                                {INF, 2 , 0 ,INF}
                                { 3 , 6 ,INF, 0 }
 * Output: 3 (as cycle weights are [12,3,3,INF] & Min Cycle Weight are 3)
 * ----------------------------------------------------------------------
 * Example 2:
 * Input: n (number of nodes) = 5, W2 (adjacency matrix) =
                                { 0 ,INF, 7 ,INF, 8 }
                                { 8 , 0 , 1 ,INF, 5 }
                                {INF, 8 , 0 ,INF, 3 }
                                {INF, 6 ,INF, 0 ,INF}
                                { 6 ,INF, 8 ,INF, 0 }
 * Output: 3 (as cycle weights are [14,9,9,INF,11] & Min Cycle Weight are 9)
 * ----------------------------------------------------------------------
 * Example 3:
 * Input n (number of nodes) = 3, W3 (adjacency matrix) =
                                { 0 ,INF, 7 }
                                {INF, 0 ,INF}
                                {INF, 8 , 0 }
 * Output: -1 (as cycle weights are [INF,INF,INF] & no cycles appeared, so -1 = NOT FOUND)
 */

public class Task4 {
    /**
     * A large constant representing infinity (no direct edge between nodes).
     */
    static final int INFINITY = (int) 1e6; // 1e6 = 1 Million

    /**
     * Executes a modified Floyd's algorithm to compute shortest paths
     * between all pairs of vertices, while also enabling cycle detection.
     *
     * Key Modification:
     * - Diagonal elements D[i][i] are initialized to INFINITY instead of 0.
     * This allows the algorithm to compute the minimum cycle cost for each node.
     * as any path is shorter than INFINITY. (i.e. any cycled-path weight < INFINITY)
     *
     * @param n number of vertices in the graph
     * @param W adjacency matrix representing edge weights
     * @param D matrix to store shortest path distances
     */
    public static void floyd(int n, int[][] W, int[][] D) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }

        // enabling cycle detection
        for (int i = 0; i < n; i++) {
            D[i][i] = INFINITY;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] != INFINITY && D[k][j] != INFINITY &&
                            D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }

    /**
     * Computes the minimum cycle weight in a graph using the result
     * of the modified Floyd's algorithm.
     *
     * The method checks diagonal elements D[i][i], where each value
     * represents the shortest cycle starting and ending at node i.
     *
     * @param n number of vertices in the graph
     * @param D the distance matrix after running Floyd
     * @return the minimum cycle weight, or -1 if no cycle exists
     */
    public static int floydMinCycleWeight(int n, int[][] D) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = D[i][i];
        }
        int tempMin = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < tempMin) tempMin = dp[i];
        }
        return tempMin != INFINITY ? tempMin : -1;
    }

    /**
     * Prints the distance matrix after running Floyd.
     * This method is used for visualization and debugging purposes only.
     *
     * @param n number of vertices
     * @param D distance matrix
     */
    public static void printFloydWeights(int n, int[][] D) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (D[i][j] == INFINITY)
                    System.out.print("INF ");
                else
                    System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println("------------- Example 1 -------------");
        int n1 = 4;
        int[][] W1 = new int[][]{
                {0, INFINITY, 7, INFINITY},
                {3, 0, 1, INFINITY},
                {INFINITY, 2, 0, INFINITY},
                {3, 6, INFINITY, 0}
        };
        int[][] D1 = new int[n1][n1];
        floyd(n1, W1, D1);
        printFloydWeights(n1, D1); // For Illustration ONLY
        System.out.println("Min Cycled-path Weight in Graph : " + floydMinCycleWeight(n1, D1));

        // Example 2
        System.out.println("------------- Example 2 -------------");
        int n2 = 5;
        int[][] W2 = new int[][]{
                {0, INFINITY, 7, INFINITY, 8},
                {8, 0, 1, INFINITY, 5},
                {INFINITY, 8, 0, INFINITY, 3},
                {INFINITY, 6, INFINITY, 0, INFINITY},
                {6, INFINITY, 8, INFINITY, 0}
        };
        int[][] D2 = new int[n2][n2];
        floyd(n2, W2, D2);
        printFloydWeights(n2, D2); // For Illustration ONLY
        System.out.println("Min Cycled-path Weight in Graph : " + floydMinCycleWeight(n2, D2));

        // Example 3
        System.out.println("------------- Example 3 -------------");
        int n3 = 3;
        int[][] W3 = new int[][]{
                {0, INFINITY, 7},
                {INFINITY, 0, INFINITY},
                {INFINITY, 8, 0},
        };
        int[][] D3 = new int[n3][n3];
        floyd(n3, W3, D3);
        printFloydWeights(n3, D3); // For Illustration ONLY
        System.out.println("Min Cycled-path Weight in Graph : " + floydMinCycleWeight(n3, D3));
    }
}