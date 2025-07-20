// Given an array nums containing n distinct numbers in the range [0, n], return the only 
// number in the range that is missing from the array.

//using hashset

import java.util.HashSet;

public class Solution1 {
    public int missingNumber(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }

        int n = nums.length;

        for(int i=0; i<=n; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Solution1 sol = new Solution1();

        int[] nums = {0,2,1,3,4};

        System.out.println("Missing numver: "+ sol.missingNumber(nums));
    }
}
