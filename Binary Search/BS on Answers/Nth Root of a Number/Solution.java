// Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as
// a number X such that when X is raised to the power of N, it equals M. If the Nth root is 
// not an integer, return -1.

class Solution {
    public static int NthRoot(int N, int M) {
        int lo = 1;
        int hi = M;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long power = pow(mid, N, M); // pass M for early stopping

            if (power == M) {
                return mid; // found exact root
            } else if (power < M) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1; // no integer root
    }

    // Calculates base^exp but stops early if result > limit
    public static long pow(int base, int exp, int limit) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > limit) return result; // stop early
        }
        return result;
    }
    
    public static void main(String[] args){
        System.out.println(NthRoot(3, 8));
    }
}
