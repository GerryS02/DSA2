class solution {
    public static int findMedian(int[][] matrix) {
        // Get the number of rows (m) and columns (n)
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize 'lo' to a very high value and 'hi' to a very low value
        // These represent the current range in which the median might exist
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;

        // Find the smallest and largest elements in the matrix
        // Smallest value is the first element of each row, and largest is the last element of each row
        for (int i = 0; i < m; i++) {
            lo = Math.min(lo, matrix[i][0]);   // Check the first element of each row
            hi = Math.max(hi, matrix[i][n - 1]); // Check the last element of each row
        }

        // Find the position of the median in the sorted matrix (m * n) / 2
        int req = (m * n) / 2;

        // Perform binary search to find the median value
        while (lo <= hi) {
            int mid = (lo + hi) / 2;  // Find the middle element of the current range

            // Count how many elements in the matrix are <= mid
            int count = smallerOrEquals(matrix, m, mid);

            // If the count is less than or equal to the target position of the median,
            // then the median must be in the upper half, so we adjust 'lo'
            if (count <= req) {
                lo = mid + 1;  // Move the lower bound up
            } else {
                // If the count is greater than the target position of the median,
                // then the median must be in the lower half, so we adjust 'hi'
                hi = mid - 1;  // Move the upper bound down
            }
        }

        return lo;
    }

    public static int smallerOrEquals(int[][] matrix, int m, int x) {
        int count = 0;

        // For each row in the matrix, count how many elements are <= x
        for (int i = 0; i < m; i++) {
            count += upperBound(matrix[i], x); // Get count from each row
        }

        return count;
    }

    public static int upperBound(int[] row, int x) {
        int low = 0;
        int high = row.length - 1;
        int result = row.length;  

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] <= x) {
                low = mid + 1;  // Move the lower boundary up if the element is <= x
            } else {
                result = mid;   // Update the result to the current mid if it's greater than x
                high = mid - 1;  // Move the high boundary down
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test matrices
        int[][] m1 = {
            {1, 4, 9},
            {2, 5, 6},
            {3, 7, 8}
        };

        int[][] m2 = {
            {1, 3, 8},
            {2, 3, 4},
            {1, 2, 5}
        };

        System.out.println(findMedian(m1)); // 5
        System.out.println(findMedian(m2)); // 3
    }
}
