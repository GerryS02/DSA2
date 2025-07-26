// Given an array of integers nums and an integer k, return the total number of subarrays 
// whose XOR equals to k.

import java.util.HashMap;

public class Solution {
    public static int subarraysWithXorK(int[] nums, int k){
        int xr = 0; //store the prefix XOR up to the current index
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0,1); //initialize the map with XOR 0 occurring once (for subarrays starting from index 0)

        int count = 0;
        for(int i=0; i<nums.length; i++){
            xr = xr^nums[i]; //update prefix XOR with current element

            //we want to find how many times (xr ^ k) has occurred before
            int x = xr^k;

            //add the frequency of that XOR value to count
            count += m.getOrDefault(x, 0);

            //update the frequency of the current prefix XOR
            m.put(xr, m.getOrDefault(xr, 0)+1);
        }

        return count;
    }

    public static void main(String[] args){
        int[] input = {4,2,2,6,4};

        int ans = subarraysWithXorK(input, 6);

        System.out.println(ans);
    }
}
