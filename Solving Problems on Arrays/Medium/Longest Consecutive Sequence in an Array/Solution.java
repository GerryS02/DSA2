import java.util.HashSet;

public class Solution {
    public static int longestConsecutive(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int n : arr){
            set.add(n);
        }

        int maxLen = 0;
        for(int val : set){
            if(!set.contains(val-1)){
                int currLen = 1;
                int currNum = val;

                while(set.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }

                maxLen = Math.max(currLen, maxLen);
            }
        }

        return maxLen;
    }
}
