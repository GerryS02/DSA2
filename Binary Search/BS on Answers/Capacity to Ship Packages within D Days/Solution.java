// A conveyor belt has packages that must be shipped from one port to another within days days

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship 
// with packages on the conveyor belt (in the order given by weights). We may not load more 
// weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the 
// conveyor belt being shipped within days days.

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0; // total weight of all packages
        int max = 0; // weight of the heaviest package

        // Find total sum and max weight
        for (int val : weights) {
            sum += val;
            max = Math.max(val, max);
        }

        // If there are as many days as packages,
        // we can ship one package per day
        if (weights.length == days) {
            return max; // capacity must be the heaviest package
        }

        // Search space for binary search
        int lo = max; // minimum possible capacity (at least the heaviest package)
        int hi = sum; // maximum possible capacity (ship all in one day)
        int ans = 0;  // store the smallest capacity found

        // Binary search to find minimum ship capacity
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // try this capacity

            // Check if we can ship within given days using this capacity
            if (isPossible(weights, mid, days)) {
                ans = mid;     // store as potential answer
                hi = mid - 1;  // try smaller capacity
            } else {
                lo = mid + 1;  // need more capacity
            }
        }

        return ans;
    }

    public boolean isPossible(int[] weights, int mid, int days) {
        int day = 1; // start from day 1
        int sum = 0; // weight for current day

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];

            // If adding this package exceeds capacity
            if (sum > mid) {
                day++;            // move to next day
                sum = weights[i]; // start with this package on new day
            }
        }

        // Return true if we can ship within allowed days
        return day <= days;
    }
}
