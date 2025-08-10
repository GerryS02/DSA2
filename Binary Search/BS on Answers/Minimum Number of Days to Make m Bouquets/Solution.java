// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the
// garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can 
// be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the
// garden. If it is impossible to make m bouquets return -1.

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // If total flowers are less than needed (m bouquets × k flowers each), it's impossible
        if (bloomDay.length < (m * k)) return -1;

        int min = Integer.MAX_VALUE; // store smallest bloom day
        int max = Integer.MIN_VALUE; // store largest bloom day

        // Find the earliest and latest bloom day from the array
        for (int val : bloomDay) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int lo = min;   // search range start
        int hi = max;   // search range end
        int ans = -1;   // store answer

        // Binary search to find minimum days needed
        while (lo <= hi) {
            int mid = (lo + hi) / 2; // guess the day

            // If it's possible to make m bouquets by 'mid' day
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;      // store the possible answer
                hi = mid - 1;   // try to find smaller day
            } else {
                lo = mid + 1;   // need more days
            }
        }

        return ans; // return the smallest day found
    }

    public boolean isPossible(int[] arr, int mid, int m, int k) {
        int bouquet = 0;     // number of bouquets made
        int flowerCount = 0; // consecutive flowers ready

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                // Flower is bloomed by 'mid' day
                flowerCount++;
            } else {
                // Not bloomed → make bouquets from collected flowers
                bouquet += flowerCount / k;
                flowerCount = 0; // reset count
            }
        }

        // Add leftover bouquets after loop
        bouquet += flowerCount / k;

        // Return true if we can make at least m bouquets
        return bouquet >= m;
    }
}