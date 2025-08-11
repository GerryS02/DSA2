// Given two sorted arrays 'a' and 'b' of size m and n respectively, return the median of 
// the two sorted arrays.

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // Ensure that 'a' is the smaller array to minimize binary search range
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int lo = 0;
        int hi = a.length;
        int total = a.length + b.length; // total number of elements

        // Binary search on the smaller array
        while(lo <= hi){
            // Partition 'a' at aLeft
            int aLeft = lo + (hi-lo)/2; // elements taken from 'a'
            // Partition 'b' so that left side has half of total elements
            int bLeft = (total+1)/2 - aLeft; // elements taken from 'b'

            // Left max of 'a'
            int aLm1 = (aLeft == 0) ? Integer.MIN_VALUE : a[aLeft-1];
            // Right min of 'a'
            int aL = (aLeft == a.length) ? Integer.MAX_VALUE : a[aLeft];
            // Left max of 'b'
            int bLm1 = (bLeft == 0) ? Integer.MIN_VALUE : b[bLeft-1];
            // Right min of 'b'
            int bL = (bLeft == b.length) ? Integer.MAX_VALUE : b[bLeft];

            // Check if we found correct partition
            if(aLm1 <= bL && bLm1 <= aL){
                double median = 0.0;

                if(total % 2 == 0){
                    // Even total → median is average of max left and min right
                    int lMax = Math.max(aLm1, bLm1);
                    int rMin = Math.min(bL, aL);
                    median = (lMax + rMin) / 2.0;
                } else{
                    // Odd total → median is max of left side
                    int lMax = Math.max(aLm1, bLm1);
                    median = lMax;
                }
                return median; // Return the median value
            }
            // Too many elements taken from 'a', move left
            else if(aLm1 > bL){
                hi = aLeft - 1;
            }
            // Too few elements taken from 'a', move right
            else{
                lo = aLeft + 1;
            }
        }
        return 0.0; 
    }
}
