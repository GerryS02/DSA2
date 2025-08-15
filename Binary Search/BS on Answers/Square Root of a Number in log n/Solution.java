// Given a positive integer n. Find and return its square root. If n is not a perfect square, 
// then return the floor value of sqrt(n).

class Solution {
    public static long floorSqrt(long n) {
        long lo = 1;
        long hi = n;
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (mid * mid <= n) {
                ans = mid;     // store possible answer
                lo = mid + 1;  // try for a bigger mid
            } else {
                hi = mid - 1;  // try for a smaller mid
            }
        }

        return ans; 
    }

    public static void main(String[] args){
        System.out.println(floorSqrt(28));
    }
}


