import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] ans = new int[2]; //array to store the result (indices of two numbers that add up to the target)

        for(int i=0; i<nums.length; i++){
            int first = nums[0]; //current number
            int sec = target - first; //number we need to find to reach the target

            //if the required number (sec) is already in the map
            if(m.containsKey(sec)){
                //store the indices of the two numbers in the answer array
                ans[0] = i;
                ans[1] = m.get(sec);
                break;
            }

            //store the current number and its index in the map
            m.put(first, i);
        }
        
        return ans;
    }
}
