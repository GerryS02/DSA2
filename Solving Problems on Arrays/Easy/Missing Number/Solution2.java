//Using math
// subtract the sum of numbers in the arr from the sum of natural numbers from 0 to n

public class Solution2 {
    public int missingNumber(int[] nums){
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

        for(int val : nums){
            actualSum += val;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args){
        Solution2 sol = new Solution2();

        int[] nums = {0,2,1,3,4};

        System.out.println("Missing numver: "+ sol.missingNumber(nums));
    }
}
