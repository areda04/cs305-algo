package Quiz_4;

/*
 * CS305 - Quiz 4 - Q2 - Spring 2026
 * Using the Floyd's algorithm,
 * construct the matrices D_0, D_1, D_2, D_3, D_4
 * and the path matrix P for the given weighted graph
 * Given W (Adjacency Matrix):
                                { 0 , 2 , 3 , 4 }
                                { 3 , 0 , 5 , 3 }
                                { 3 ,INF, 0 , 10}
                                {INF, 4 ,INF, 0 }

 * Expected D_4 (Shortest-Path Matrix):
                                { 0 , 2 , 3 , 4 }
                                { 3 , 0 , 5 , 3 }
                                { 3 , 5 , 0 , 7 }
                                { 7 , 4 , 9 , 0 }
 * Expected P (Indices Matrix):
                                {   ,   ,   ,   }
                                {   ,   ,   ,   }
                                {   , 1 ,   , 1 }
                                { 2 ,   , 2 ,   }

 */
public class Quiz4_Q2 {

    static final int INF = (int) 1e6;

    public static void floyd(int n, int[][] W, int[][] D) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] != INF && D[k][j] != INF &&
                            D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }

    public static void printFloydWeights(int n, int[][] D) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (D[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] W = new int[][]{
                {0, 2, 3, 4},
                {3, 0, 5, 3},
                {3, INF, 0, 10},
                {INF, 4, INF, 0}
        };
        int[][] D = new int[n][n];
        floyd(n, W, D);
        printFloydWeights(n, D);
    }
}
