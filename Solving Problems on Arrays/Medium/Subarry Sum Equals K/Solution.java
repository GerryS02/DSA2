// Given an array of integers nums and an integer k, return the total number of subarrays 
// whose sum equals to k.

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k){
        //hashMap to store prefix sums and their freq
        HashMap<Integer, Integer> m = new HashMap<>();
        //add the sum 0 with its freq = 1
        m.put(0,1);

        int ans = 0;
        int sum = 0;

        //loop every element in the nums
        for(int i = 0; i<nums.length; i++){
            //add current number to cumulative sum
            sum += nums[i];

            int remSum = sum - k; //calculate the remaining sum we need to get target(sum - k)

            //if remSum exists in the map, it means there is a subarray ending at index i with sum k
            if(m.containsKey(remSum)){
                ans += m.get(remSum); //add the number of such subarrays to the answer
            }

            //update the count of current sum in the map
            m.put(sum, m.getOrDefault(sum, 0)+1);
        }

        return ans;
    }
}
