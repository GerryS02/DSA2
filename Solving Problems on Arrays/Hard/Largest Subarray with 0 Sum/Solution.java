// You are given an integer array arr of size n which contains both positive and negative 
// integers. Your task is to find the length of the longest contiguous subarray with sum equal
// to 0.

// Return the length of such a subarray. If no such subarray exists, return 0.

class Solution {
    public int maxLen(int[] arr){
        HashMap<Integer, Integer> m = new HashMap<>();

        int sum = 0; //this will store the running (prefix) sum
        int maxLen = 0;  //this keeps track of the maximum length of subarray with sum 0

        for(int i=0; i<arr.length; i++){
            sum += arr[i]; //add current element to the running sum

            //if sum is 0, then subarray from index 0 to i has sum 0
            if(sum == 0){
                maxLen = i+1;
            }

            //if this sum has been seen before
            if(m.containsKey(sum)){
                //subarray from previous index+1 to current index has sum 0
                int prevIdx = m.get(sum);
                int len = i - prevIdx;

                maxLen = Math.max(maxLen, len);
            } else{
                m.put(sum, i); //store the first occurrence of this sum
            }
        }

        return maxLen;
    }
}
