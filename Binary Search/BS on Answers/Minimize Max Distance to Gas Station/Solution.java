// Given a sorted array arr of size n, containing integer positions of n gas stations on the 
// X-axis, and an integer k, place k new gas stations on the X-axis.

// The new gas stations can be placed anywhere on the non-negative side of the X-axis, 
// including non-integer positions.

// Let dist be the maximum distance between adjacent gas stations after adding the k new gas 
// stations.

// Find the minimum value of dist.

class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        double lo = 0;
        double hi = arr[arr.length-1] - arr[0];

        // Precision value
        double diff = 10e-6;

        while (hi - lo > diff) {
            double mid = lo + (hi - lo) / 2;

            // Check if it's possible to place k stations with max distance `mid`
            if (isPossible(arr, mid, k)) {
                hi = mid; // Try to minimize the max distance
            } else {
                lo = mid; // Increase the distance
            }
        }

        return (lo + hi) / 2.0;
    }

    public boolean isPossible(int[] arr, double mid, int k) {
        int station = 0; // Counter for new stations
        double lastPos = arr[0]; // Starting position is the first station

        for (int i = 1; i < arr.length; i++) {
            double dis = arr[i] - lastPos;

            // If the distance between two stations exceeds `mid`, we need to add new stations
            if (dis > mid) {
                // Calculate how many new stations are required between lastPos and arr[i]
                station += Math.ceil(dis / mid) - 1; // Math.ceil ensures we round up the number of stations
            }

            lastPos = arr[i]; // Update the position of the last station
        }

        // Check if we can place at most `k` new stations
        return station <= k;
    }
}
