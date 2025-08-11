// You are given A painters and an array C of N integers where C[i] denotes the length of the 
// ith board. Each painter takes B units of time to paint 1 unit of board. You must assign 
// boards to painters such that:

//  1. Each painter paints only contiguous segments of boards.
//  2. No board can be split between painters.
//  3. The goal is to minimize the time to paint all boards.

class Solution{
    //A -> number of painters
    //B -> time taken by a painter to paint 1 unit of a board
    //C -> array with the length of boards
    public int paint(int[] C, int A, int B){
        int max = 0;
        int sum = 0;

        for(int val : C){
            sum += val;
            max = Math.max(max, val);
        }

        int lo = max; //minimum possible max length a painter can handle is the largest single board
        int hi = sum; //maximum possible is if one painter paints all boards

        int time = 0; //stores the answer

        while(lo <= hi){
            int mid = lo + (hi-lo)/2; //guess for the max length

            //if it's possible to paint with 'mid' as the max work per painter
            if(isPossible(C, mid, A)){
                time = mid; //store this as a possible answer
                hi = mid-1; //try to find a smaller max length
            } else{
                lo = mid+1; //need more length per painter
            }
        }

        return time*B; //multiply by B to convert length into actual time
    }

    public boolean isPossible(int[] arr, int mid, int A){
        int painter = 1;  // start with the first painter
        int time = 0;     // work assigned to current painter

        for (int i = 0; i < arr.length; i++) {
            time += arr[i];  // give the current board to the painter

            // If adding this board exceeds the allowed max length (mid)
            if (time > mid) {
                painter++;        // assign boards to the next painter
                time = arr[i];    // this board is the first for the new painter
            }
        }

        // Return true if painters used are within the limit A
        return painter <= A;
    }
}