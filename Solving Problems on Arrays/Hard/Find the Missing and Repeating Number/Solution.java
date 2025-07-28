// Given an integer array nums of size n containing values from [1, n] and each value appears 
// exactly once in the array, except for A, which appears twice and B which is missing.

// Return the values A and B, as an array of size 2, where A appears in the 0-th index and B 
// in the 1st index.

import java.util.Arrays;

class Solution {
    public static int[] findMissingRepeatingNumbers(int[] nums){
        int xr = 0;

        for(int val : nums){
            xr = xr^val;
        }

        for(int i=1; i<=nums.length; i++){
            xr = xr^i;
        }
        //after these XOR operations, xr contains the XOR of the missing number (B) and the repeating number (A)

        //find the rightmost set bit (rsb) of xr to separate the numbers into two groups
        int rsb = xr & -xr; //

        //initialize variables to store the two numbers(either repeating or missing)
        int A = 0;
        int B = 0;

        //divide the numbers into two groups based on the rightmost set bit
        for(int val : nums){
            //if the rightmost bit of the current number is set (1)
            if((val & rsb) == 0){
                A = A^val; //XOR the number into A if the rightmost set bit is not set
            } else{
                B = B^val; //XOR the number into B if the rightmost set bit is set
            }
        }

        //now, XOR the numbers from 1 to n (inclusive) to separate them into the two groups
        for(int i=1; i<-nums.length; i++){
            if((i & rsb) == 0){
                A = A^i; //XOR the number into A if the rightmost set bit is not set
            } else{
                B = B^i;
            }
        }

         //now, we have two candidates: A and B
        //we need to find out which one is the repeating number and which one is the missing number

        int count = 0;
        //count how many times A appears in the array
        for(int val : nums){
            if(val == A){
                count++;
            }
        }

        //if `A` appears exactly twice, then A is the repeating number, and B is the missing number
        if(count == 2){
            return new int[]{A,B}; //A is repeating
        } else{
            return new int[]{B,A}; //A is missing
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,6,7,5,7};

        int [] ans = findMissingRepeatingNumbers(arr);

        System.out.println(Arrays.toString(ans)); //[repeating, missing]
    }
}
