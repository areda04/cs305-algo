package Quiz_4;

/*
 * CS305 - Quiz 4 - Q1 - Spring 2026
 * using the Divide and Conquer approach & Dynamic Programming approach
 * Implement the factorial method in both approaches then,
 * compare the time complexity between them (Don't prove anything)
 *
 * Example 1:
 * Input: 5 -----> Output = 120
 *
 * Example 2:
 * Input: 6 -----> Output = 720
 */
public class Quiz4_Q1 {

    /*
     * About Time Complexity of factDAC(int n):
     * -- Time Formula of factDAC(int n): T(n) = T(n - 1) + 1
     * -- Time Complexity of factDAC(int n): O(n) [Linear Time]
     */

    /**
     * Computes the factorial of a given non-negative integer using
     * the Divide and Conquer (recursive) approach.
     *
     * The function calls itself with (n - 1) until it reaches
     * the base case (0 or 1), where the factorial is 1.
     *
     * @param n the input integer (must be >= 0)
     * @return the factorial of n, or -1 if n is negative
     * @implNote Time Complexity: O(n)
     */
    public static int factDAC(int n) {
        if (n < 0) return -1; // Invalid Inputs
        if (n == 0 || n == 1) return 1; // Base Cases (0! = 1, 1! = 1)
        return n * factDAC(n - 1); // Recursive Call
    }

    /*
     * About Time Complexity of factDP(int n):
     * -- Time Formula of factDP(int n): T(n) = n
     * -- Time Complexity of factDP(int n): θ(n) [Linear Time]
     */

    /**
     * Computes the factorial of a given non-negative integer using
     * the Dynamic Programming (bottom-up) approach.
     *
     * This method builds an array where each element represents
     * a number from 0 to n, then multiplies all elements to compute the factorial.
     *
     * @param n the input integer (must be >= 0)
     * @return the factorial of n, or -1 if n is negative
     * @implNote Time Complexity: Θ(n)
     */
    public static int factDP(int n) {
        if (n < 0) return -1; // Invalid Inputs
        if (n == 0 || n == 1) return 1; // Base Cases (0! = 1, 1! = 1)
        int[] dp = new int[n + 1]; // n + 1 to include index 0 through n (we need dp[0] up to dp[n])
        dp[0] = 1;
        dp[1] = 1;
        // convert the array dp[] to [0, 1, 2, 3, 4, ....., n]
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
        }
        int resultOfFact = 1; // NOT 0 due to we multiply NOT add
        // Executes the result by multiplying dp[] elements
        for (int i = 0; i < dp.length; i++) {
            resultOfFact = resultOfFact * dp[i];
        }
        // Returns the factorial of n
        return resultOfFact;
    }

    public static void main(String[] args) {
        System.out.println("5! DAC = " + factDAC(5));
        System.out.println("5! DP = " + factDP(5));
        System.out.println("6! DAC = " + factDAC(6));
        System.out.println("6! DP = " + factDP(6));
    }
}
