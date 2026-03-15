package Task_3;
import java.util.Arrays;
/*
 * CS305 - Task 3 - Spring 2026
 * Write a Java method that takes a sorted int array (may contain duplicates) and a target value
 * and returns the first and last position of the target in int array
 * implement it using binary search and (divide & conquer) technique.
 *
 * Example 1:
 * Input: arr = [1, 2, 3, 3], target = 3
 * Output: [2, 3]
 *
 * Example 2:
 * Input: arr = [1, 2, 3, 4], target = 3
 * Output: [2, 2]
 *
 * Example 3:
 * Input: arr = [1, 1, 1], target = 1
 * Output: [0, 2]
 * SEE THE END OF FILE TO UNDERSTAND HOW THIS METHOD IMPLEMENTED !!!!!!
 */

public class Task3 {
    /**
     * Returns the first and last position of target in sorted array using divide & conquer technique.
     *
     * @param arr    the input sorted array (may contain duplicates)
     * @param target the value to search for
     * @param low    starting index
     * @param high   ending index
     * @return array [first_index, last_index] or [-1, -1] if not found
     */
    public static int[] findFirstAndLastPosition(int[] arr, int target, int low, int high) {
        // Handle invalid inputs
        if (arr == null || arr.length == 0 || low > high) return new int[]{-1, -1};

        // Base case: single element
        if (low == high) {
            if (target == arr[low]) return new int[]{low, low};
            else return new int[]{-1, -1};
        }

        int mid = low + (high - low) / 2;

        // Binary Search logic: If target found at mid
        if (target == arr[mid]) {
            int[] leftArr = findFirstAndLastPosition(arr, target, low, mid - 1); // Search left half for more occurrences
            int[] rightArr = findFirstAndLastPosition(arr, target, mid + 1, high); // Search right half for more occurrences
            // Determine start index
            int start;
            if (leftArr[0] != -1) start = leftArr[0];
            else start = mid;
            // Determine end index
            int end;
            if (rightArr[1] != -1) end = rightArr[1];
            else end = mid;

            return new int[]{start, end};
        }

        // Binary search logic: If target not found at mid
        if (target > arr[mid])
            return findFirstAndLastPosition(arr, target, mid + 1, high);
        else
            return findFirstAndLastPosition(arr, target, low, mid - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1, 2, 3, 3}, 3, 0, 3)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1, 2, 3, 4}, 3, 0, 3)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1, 1, 1}, 1, 0, 2)));
        // More Test Cases
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1, 2, 3, 3, 4}, 3, 0, 4)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1, 2, 3, 4, 4}, 3, 0, 4)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{}, 1, 0, -1)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(null, 3, 0, 2)));
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{1}, 3, 0, 0)));
    }
    /* For Example: [1,2,3,3,3,4,5], target=3     . Test Case 1: [1,2,3,3], target=3
        Level 1:         [1,2,3,3,3,4,5]          . Level 1:               [1,2,3,3]
                                |                 .                             |
                       (found 3 at index 3)       .                   (found 3 at index 2)
                                |                 .                             |
        Level 2:    [1,2,3]     |       [3,4,5]   . Level 2:            [1,2]   |       [3,4]
                      |         |        |        .                     |       |        |
                    (found     (mid)   (found     .                  (found   (mid)   (found
                     3 at       |      3 at       .                    none)    |      3 at
                    index 2)    |     index 4)    .                     |       |     index 3)
                       |        |       |         .                     |       |      |
        Level 3:      [2,2]   [3,3]   [4,4]       . Level 3:         [-1,-1]  [2,2]  [3,3]
                          \     |     /           .                             |   /
                           \    |    /            .                             |  /
                            \   |   /             .                             | /
                             \  |  /              .                             |/
                      Final:  [2,4] -> ANSWER!    .                    Final: [2,3] -> ANSWER!
    ==============================================================================================
     Test Case 2: [1,2,3,4], target=3             . Test Case 3: [1,1,1], target=1
         Level 1:               [1,2,3,4]         . Level 1:                  [1,1,1]
                                     |            .                              |
                          (found 3 at index 2)    .                   (found 1 at index 1)
                                     |            .                              |
         Level 2:          [1,2]     |     [3,4]  . Level 2:             [1]     |      [1]
                            |        |         |  .                       |      |       |
                          (found   (mid)  (found  .                  (found    (mid)   (found
                           none)     |       none).                     1 at     |       1 at
                             |       |       |    .                   index 0)   |      index 2)
                             |       |       |    .                       |      |      |
         Level 3:        [-1,-1]  [2,2]  [-1,-1]  . Level 3:            [0,0]  [1,1]  [2,2]
                                    |             .                         \    |    /
                                    |             .                          \   |   /
                                    |             .                           \  |  /
                                    |             .                            \ | /
                          Final: [2,2] -> ANSWER! .                     Final: [0,2] -> ANSWER!
    */
}
