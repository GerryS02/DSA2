// Given a non-empty array of integers nums, every element appears twice except for one.
// Find that single one.

public class Solution {
    public int singleNumber(int[] nums){
        int ans = 0;

        for(int val : nums){
            ans = ans^val; //use bitwise operator
        }

        return ans;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums = {1,2,3,4,4,2,1};

        System.out.println(sol.singleNumber(nums));
    }
}
